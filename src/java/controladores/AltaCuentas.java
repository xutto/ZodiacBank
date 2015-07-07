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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author xutto
 */
public class AltaCuentas extends MultiActionController {

    Connection cn;

    public ModelAndView alta(HttpServletRequest hsr, HttpServletResponse response) {
        try {
            ModelAndView mv = new ModelAndView("alta_cuentas");

            String cli_asoc = hsr.getParameter("cli_asoc");
            String alias = hsr.getParameter("alias");
            int cNum = (int) (Math.random() * 99999 + 1000000);

            peticionBD miBd = new peticionBD();
            cn = miBd.conexionbd(hsr, response);
            CallableStatement cb = cn.prepareCall("{call alta_cuenta(?,?,?)}");

            cb.setString(1, cli_asoc);
            cb.setString(2, alias);
            cb.setInt(3, cNum);
            //////////////////////////////////    

            cb.executeUpdate();
            /////////////////////////////////   
            return mv;
        } catch (Exception ex) {
            Logger.getLogger(AltaCuentas.class.getName()).log(Level.SEVERE, null, ex);

            ModelAndView mv = new ModelAndView("alta_cuentas");
            String err1 = "Sucedió el siguiente error; " + ex;
            mv.addObject("error", err1);

            return mv;
        }

    }

    public ModelAndView baja(HttpServletRequest hsr, HttpServletResponse response) {

        try {
            ModelAndView mv = new ModelAndView("baja_cuentas");
            String suceso = "";

            String num_cuenta = hsr.getParameter("cuenta");
            String id_cliente = hsr.getParameter("id_cliente");

            peticionBD miBd = new peticionBD();
            cn = miBd.conexionbd(hsr, response);
            //CallableStatement cb = cn.prepareCall("{call baja_clientes('?','?')}");
            PreparedStatement cb = cn.prepareStatement("delete from zb_cuentas where num_cuenta = '" + num_cuenta + "' and id_cliente = '" + id_cliente + "'");

            int c = cb.executeUpdate();
            if (c > 0) {
                suceso = "La cuenta: " + num_cuenta + " con propietario: " + id_cliente + " ha sida dado de baja definiticamente. ";
            } else {
                suceso = "Ningun registro ha sido borrado";
            }

            //String success = "El cliente: " + apellido1 + " con número de DNI: " + dni + " Ha sido dado de baja definiticamente. ";
            mv.addObject("suceso", suceso);
            return mv;
        } catch (Exception ex) {
            Logger.getLogger(alta_cliente.class.getName()).log(Level.SEVERE, null, ex);

            ModelAndView mv = new ModelAndView("baja_cliente");
            String err1 = "Sucedió el siguiente error; " + ex;
            mv.addObject("error", err1);
            return mv;

        }
    }
}
