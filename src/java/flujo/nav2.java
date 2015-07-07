/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flujo;

import bloques.FullSentencia;
import bloques.peticionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.getSet_cuentas;
import modelos.getSet_vista;
import modelos.setGet_operaciones;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author xutto
 */
public class nav2 extends MultiActionController {

    Connection cn;

    //navegacion para clientes
    public ModelAndView pGlobal(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {

        peticionBD miBd = new peticionBD();
        cn = miBd.conexionbd(hsr, response);
        ModelAndView mv = new ModelAndView("posicion_global");

        HttpSession sesion = hsr.getSession();
        String idClient = sesion.getAttribute("id").toString();
        PreparedStatement stc = cn.prepareStatement("select * from zb_cuentas where id_cliente = " + idClient);
        ResultSet crs = stc.executeQuery();
        ArrayList<getSet_cuentas> cl = new ArrayList();

        String id;
        String num;
        int saldo;
        String cnom;

        while (crs.next()) {
            getSet_cuentas cgs = new getSet_cuentas();

            cgs.setCnom(crs.getString("nombre"));
            cgs.setCnum(crs.getString("num_cuenta"));
            cgs.setId(crs.getString("id_cliente"));
            cgs.setSaldo(crs.getInt("saldo"));

            cl.add(cgs);
        }
        mv.addObject("sClist", cl);

        return mv;

    }

    public ModelAndView operaciones(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {
        ModelAndView mv = new ModelAndView("operaciones");

        ///////////paso 1 extraemos el id de la variable de session//////////
        peticionBD BD = new peticionBD();
        cn = BD.conexionbd(hsr, response);
        HttpSession sesion = hsr.getSession();
        String idClient = sesion.getAttribute("id").toString();

        //extraemos los datos de las cuentas del idclient
        PreparedStatement stc = cn.prepareStatement("select * from zb_cuentas where id_cliente = " + idClient);
        ResultSet crs = stc.executeQuery();
        ArrayList<getSet_cuentas> acl = new ArrayList();

        String id;
        String num;
        int saldo;
        String cnom;

        //extraemos los nuemros de cuenta
        while (crs.next()) {
            getSet_cuentas cgs = new getSet_cuentas();

            cgs.setCnom(crs.getString("nombre"));
            cgs.setCnum(crs.getString("num_cuenta"));
            cgs.setId(crs.getString("id_cliente"));
            cgs.setSaldo(crs.getInt("saldo"));

            acl.add(cgs);
        }

        mv.addObject("cuentas", acl);
        return mv;

//
////        String cuenta;
////        HttpSession sesion = hsr.getSession();
////        cuenta = sesion.getAttribute("ahorro").toString();
//        //encapsular esto en un for        
//        ArrayList<setGet_operaciones> opl = new ArrayList();
//        int tsaldo = 0;
//        int rtsaldo = 0;
//
//            String nml = "1036107";
//            PreparedStatement st = cn.prepareStatement("select * from zb_operaciones where NUM_CUENTA = ?");
//            PreparedStatement stsa = cn.prepareStatement("select saldo from zb_cuentas where NUM_CUENTA = ?");
//
//            st.setString(1, nml);
//            stsa.setString(1, nml);
//            ResultSet rsc = stsa.executeQuery();
//            while (rsc.next()) {
//                tsaldo = rsc.getInt("saldo");
//            }
//            
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//       
//                setGet_operaciones g = new setGet_operaciones();
//                g.setCuenta_local(rs.getString("NUM_CUENTA"));
//                g.setCuenta_externa(rs.getString("NUM_CUENTA_EXTERNA"));
//                g.setFecha(rs.getString("FECHA"));
//                g.setHora(rs.getString("HORA"));
//                g.setImporte(rs.getInt("IMPORTE"));
//                g.setSaldo(rtsaldo);
//                opl.add(g);
//            }
//        
//        mv.addObject("lop", opl);
//        return mv;
    }

    public ModelAndView transferencias(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {

        ModelAndView mv = new ModelAndView("transferencias");
        peticionBD BD = new peticionBD();
        cn = BD.conexionbd(hsr, response);
        HttpSession sesion = hsr.getSession();
        ArrayList acl = (ArrayList) sesion.getAttribute("cuentas");

        mv.addObject("cuentas", acl);
        return mv;

        //extraemos los datos de las cuentas del idclient
//        PreparedStatement stc = cn.prepareStatement("select * from zb_cuentas where id_cliente = " + idClient);
//        ResultSet crs = stc.executeQuery();
//
//        //extraemos los nuemros de cuenta
//        while (crs.next()) {
//            getSet_cuentas cgs = new getSet_cuentas();
//
//            cgs.setCnom(crs.getString("nombre"));
//            cgs.setCnum(crs.getString("num_cuenta"));
//            cgs.setId(crs.getString("id_cliente"));
//            cgs.setSaldo(crs.getInt("saldo"));
//
//            acl.add(cgs);
//        }
    }

    public ModelAndView mod_datos(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {
        ModelAndView mv = new ModelAndView("mod_datos");

        ///////////paso 1 extraemos el id de la variable de session//////////
        peticionBD BD = new peticionBD();
        cn = BD.conexionbd(hsr, response);
        HttpSession sesion = hsr.getSession();
        String idClient = sesion.getAttribute("id").toString();

        if (hsr.getParameter("modu") != null) {
            String modu = hsr.getParameter("modu");
            String el_mod = hsr.getParameter("el_mod");
            if (modu.equals("a")){
            PreparedStatement modst = cn.prepareStatement("update zb_clientes set email =  '"+el_mod+"' where id_cliente = '"+idClient+"'");
            modst.executeUpdate();
            }else if (modu.equals("b")){
            PreparedStatement modst = cn.prepareStatement("update zb_clientes set telefono =  '"+el_mod+"' where id_cliente = '"+idClient+"'");
            modst.executeUpdate();
            }else if (modu.equals("c")){
            PreparedStatement modst = cn.prepareStatement("update zb_clientes set password =  '"+el_mod+"' where id_cliente = '"+idClient+"'");
            modst.executeUpdate();
            }
        }
//update usuarios set clave='Boca'
//  where nombre='Federicolopez';
        PreparedStatement stpid = cn.prepareStatement("select * from zb_clientes where id_cliente = '" + idClient + "'");
        ResultSet rs = stpid.executeQuery();
        ArrayList<getSet_vista> gs = new ArrayList<>();

        while (rs.next()) {
            getSet_vista gset = new getSet_vista();
            gset.setId(rs.getString("id_cliente"));
            gset.setNombre(rs.getString("nombre"));
            gset.setApellido1(rs.getString("apellido1"));
            gset.setDireccion(rs.getString("direccion"));
            gset.setDni(rs.getString("dni"));
            gset.setTelefono(rs.getString("telefono"));
            gset.setEmail(rs.getString("email"));
            gset.setFecha_alta(rs.getString("fecha_alta"));
            gset.setApellido2(rs.getString("apellido2"));
            gset.setPassword(rs.getString("password"));
            gs.add(gset);
        }

        if (hsr.getParameter("subform") != null) {
            String sub = hsr.getParameter("subform");
            if (sub.equals("a")) {
                mv = new ModelAndView("mod_datos/mod1");
                mv.addObject("ultra", gs);
                return mv;
            } else if (sub.equals("b")) {
                mv = new ModelAndView("mod_datos/mod2");
                mv.addObject("ultra", gs);
                return mv;
            } else if (sub.equals("c")) {
                mv = new ModelAndView("mod_datos/mod3");
                mv.addObject("ultra", gs);
                return mv;
            }

        }

        mv.addObject("ultra", gs);

        return mv;
    }
}
