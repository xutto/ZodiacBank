/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import bloques.peticionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author alumno
 */
public class logger_emp implements Controller{
     public Connection cn;

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModelAndView mv = new ModelAndView("wellcome-emp");
        String user = hsr.getParameter("user");
        String Ipass = hsr.getParameter("pass");

        peticionBD miBd = new peticionBD();
        cn = miBd.conexionbd(hsr, hsr1);
        String nom = "o";
        String ape1 = "p";
        String Opass = "q";
        String dni = "r";

        //EMPLEADOS==========================================================================
        PreparedStatement st = cn.prepareStatement("select * from zb_empleados where dni = '" + user + "'");
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            nom = rs.getString("nombre");
            ape1 = rs.getString("apellido1");
            Opass = rs.getString("password");
            dni = rs.getString("dni");
        }

        if (Ipass.equals(Opass) && user.equals(dni)) {
           
            mv = new ModelAndView("emp-logged"); 
            mv.addObject("nombre", nom);
            mv.addObject("ape1", ape1);
            
            cn.close();
            return mv;
        } else {
            mv.addObject("error", "error de autentificación");
        }

        return mv;
    }
}
