/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import bloques.peticionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.getSet_cuentas;
import modelos.setGet_operaciones;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author xutto
 */
public class oper_control extends MultiActionController {

    private Connection cn;

    public ModelAndView oper_listado(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {
        ModelAndView mv = new ModelAndView("operaciones");
        String cuenta = "";

        if (hsr.getParameter("cus") != null) {
            cuenta = hsr.getParameter("cus");
        }

        peticionBD BD = new peticionBD();
        cn = BD.conexionbd(hsr, response);

        PreparedStatement st = cn.prepareStatement("select * from zb_operaciones where NUM_CUENTA = ? order by hora desc");
        st.setString(1, cuenta);

        ResultSet rs = st.executeQuery();
        ArrayList<setGet_operaciones> opl = new ArrayList();
        int tsaldo = 0;

        while (rs.next()) {

            setGet_operaciones g = new setGet_operaciones();
            g.setCuenta_local(rs.getString("NUM_CUENTA"));
            g.setCuenta_externa(rs.getString("NUM_CUENTA_EXTERNA"));
            g.setFecha(rs.getString("fecha"));
            g.setHora(rs.getString("HORA"));
            g.setImporte(rs.getInt("IMPORTE"));
            g.setSaldo(rs.getInt("SALDO"));
            opl.add(g);
        }

        mv.addObject("lop", opl);
        return mv;

    }

    public ModelAndView transferencias(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {
        HttpSession sesion = hsr.getSession();
        String cur = "";
        String cud = "";
        Integer imp = 0;

////////////// Recogemos el formulario si se han mandado datos\\\\\\\\\\\\\\\\\\\\\
        if (hsr.getParameter("importe") != "" && hsr.getParameter("cud") != "") {
            cur = hsr.getParameter("cum");
            cud = hsr.getParameter("cud");
            int importe = Integer.parseInt(hsr.getParameter("importe"));
            boolean interruptor = false;
            String cud2 = null;

            peticionBD BD = new peticionBD();
            cn = BD.conexionbd(hsr, response);

            PreparedStatement stc = cn.prepareStatement("Select * from zb_cuentas");
            ResultSet crs = stc.executeQuery();

////////////////////////extraemos los datos de las cuentas\\\\\\\\\\\\\\\\\\\\
////////////////////////COMPARAMOS SI EXISTE LA CUENTA DESTINO\\\\\\\\\\\\\\\\\\\\
            ArrayList acl = new ArrayList();

            while (crs.next()) {
                if (crs.getString("num_cuenta").equals(cud)) {
                    cud2 = crs.getString("num_cuenta");
                    interruptor = true;
                    break;
                }
                interruptor = false;
            }

///////////////EXTRAEMOS LOS SALDOS DE AMBAS CUENTAS\\\\\\\\\\
            Integer saldo_origen = 0;
            PreparedStatement sco = cn.prepareStatement("Select saldo from zb_cuentas where num_cuenta = " + cur);
            ResultSet rssco = sco.executeQuery();
            while (rssco.next()) {
                saldo_origen = rssco.getInt("saldo");
            }
            Integer ImporteTotalOrigen = saldo_origen - importe;

            Integer saldo_destino = 0;
            PreparedStatement scd = cn.prepareStatement("Select saldo from zb_cuentas where num_cuenta = " + cud2);
            ResultSet rsscd = scd.executeQuery();
            while (rsscd.next()) {
                saldo_destino = rsscd.getInt("saldo");
            }
            Integer ImporteTotalDestino = saldo_destino + importe;

///////////////EJECUTAR LA OPERACION EN BBDD\\\\\\\\\\\\\\\\\\\\\\
            try {
                int hora, minutos, fecha, dia, mes, ano;
                Calendar calendario = new GregorianCalendar();
                dia = calendario.get(Calendar.DAY_OF_MONTH);
                mes = calendario.get(Calendar.MONTH);
                ano = calendario.get(Calendar.YEAR);
                hora = calendario.get(Calendar.HOUR_OF_DAY);
                minutos = calendario.get(Calendar.MINUTE);
                

                ////////////sentencia cuenta ORIGEN\\\\\\\\\\\\\\\\\\\\\\\\            
                PreparedStatement real_opo = cn.prepareStatement("update zb_cuentas set saldo=? where NUM_CUENTA = ?");
                real_opo.setInt(1, ImporteTotalOrigen);
                real_opo.setString(2, cur);
                real_opo.executeUpdate();

                cn.setAutoCommit(false);
                ////////////sentencia cuenta DESTINO\\\\\\\\\\\\\\\\\\\\\\\\            
                PreparedStatement real_opd = cn.prepareStatement("update zb_cuentas set saldo=? where NUM_CUENTA = ?");
                real_opd.setInt(1, ImporteTotalDestino);
                real_opd.setString(2, cud2);
                real_opd.executeUpdate();
                ///////////REGISTRO OPERACION ORIGEN\\\\\\\\\\\
                CallableStatement opcbo = cn.prepareCall("{call operaciones('1'," + cud2 + ",TO_DATE('"+dia+"/"+mes+"/"+ano+"', 'DD/MM/YY') ,TO_DATE('" + hora + ":"+minutos+"', 'HH24:MI')," + importe + "," + cur + "," + ImporteTotalOrigen + ")}");
                opcbo.execute();

//                ///////////REGISTRO OPERACION DESTINO\\\\\\\\\\\
                CallableStatement opcbd = cn.prepareCall("{call operaciones('1'," + cur + ",TO_DATE('"+dia+"/"+mes+"/"+ano+"', 'DD/MM/YY') ,TO_DATE('" + hora + ":"+minutos+"', 'HH24:MI')," + importe + "," + cud2 + "," + ImporteTotalOrigen + ")}");
//                CallableStatement opcbd = cn.prepareCall("{call operaciones(?,?,?,?,?,?)}");cur
//                TO_DATE('01-03-2011 07:01','DD-MM-YYYY HH:MI'
                opcbd.execute();

                cn.commit();
                cn.setAutoCommit(true);
            } catch (Exception ex) {
                cn.rollback();
                cn.setAutoCommit(true);
                ModelAndView mv = new ModelAndView("transferencias");
                String error = "ha ocurrido el siguiente error: " + ex;
                mv.addObject("error", error);
                return mv;
            }

        } else {

            String error = "Por favor introduzca los datos";
            ModelAndView mv = new ModelAndView("transferencias");
            mv.addObject("error", error);
            return mv;
        }

////////////sentencia cuenta primera\\\\\\\\\\\\\\\\\\\\\\\\            
//            PreparedStatement real_op = cn.prepareStatement("update zb_cuentas set saldo=? where NUM_CUENTA = ?");
        //           real_op.setInt(1, ImporteTotal);
////////////sentencia cuenta primera\\\\\\\\\\\\\\\\\\\\\\\\       
////////////////PROCEDIMIENTO REGISTRO DE OPERACION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
///////////////CallableStatement cb = cn.prepareCall("{call operaciones(?,?,?,?,?,?,?,?)}");
        ///PROCEDIMIENTO REGISTRO DE OPERACION
        ////CallableStatement cb = cn.prepareCall("{call operaciones(?,?,?,?,?,?,?,?)}");
///////////// Mando a la vista las cuentas para seleccionarlas\\\\\\\\\\\\\\\\\\
        ModelAndView mv = new ModelAndView("transferencias");

        ArrayList cuentas = (ArrayList) sesion.getAttribute("cuentas");
        mv.addObject("cuentas", cuentas);

        return mv;

    }

}
