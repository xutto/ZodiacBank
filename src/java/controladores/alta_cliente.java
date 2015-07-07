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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xutto
 */
public class alta_cliente extends MultiActionController {

    private Connection cn;

    public ModelAndView alta(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {
        try {
            ModelAndView mv = new ModelAndView("alta_cliente");

            String nombre = hsr.getParameter("nombre");
            String apellido1 = hsr.getParameter("apellido1");
            String apellido2 = hsr.getParameter("apellido2");
            String email = hsr.getParameter("email");
            String direccion = hsr.getParameter("direccion");
            String dni = hsr.getParameter("dni");
            String telefono = hsr.getParameter("telefono");

            peticionBD miBd = new peticionBD();
            cn = miBd.conexionbd(hsr, response);
            int password = (int) (Math.random() * 999999 + 100000);

            CallableStatement cb = cn.prepareCall("{call alta_clientes(?,?,?,?,?,?,?,?)}");

            cb.setString(1, nombre);
            cb.setString(2, apellido1);
            cb.setString(3, apellido2);
            cb.setString(4, direccion);
            cb.setString(5, dni);
            cb.setString(6, telefono);
            cb.setString(7, email);
            cb.setInt(8, password);
            cb.execute();

            recoge_nombre cadena = new recoge_nombre();

            String nom = cadena.nombre(hsr, response);
            String ape = cadena.apellido(hsr, response);
            mv.addObject("nombre", nom);
            mv.addObject("apellido", ape);
            cn.close();
            return mv;
        } catch (Exception ex) {
            Logger.getLogger(alta_cliente.class.getName()).log(Level.SEVERE, null, ex);

            ModelAndView mv = new ModelAndView("alta_cliente");
            String err1 = "Sucedió el siguiente error; " + ex;
            mv.addObject("error", err1);

            return mv;
        }

    }

    public ModelAndView baja(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {

        try {
            ModelAndView mv = new ModelAndView("baja_cliente");
            String suceso = "";

            String apellido1 = hsr.getParameter("apellido1");
            String dni = hsr.getParameter("dni");

            peticionBD miBd = new peticionBD();
            cn = miBd.conexionbd(hsr, response);
            //CallableStatement cb = cn.prepareCall("{call baja_clientes('?','?')}");
            PreparedStatement cb = cn.prepareStatement("delete from zb_clientes where apellido1 = '" + apellido1 + "' and dni = '" + dni + "'");
           
            int c = cb.executeUpdate();
            if (c > 0) {
                suceso = "El cliente: " + apellido1 + " con número de DNI: " + dni + " Ha sido dado de baja definiticamente. ";
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
