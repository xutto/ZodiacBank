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
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.getSet_cuentas;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class logger implements Controller {

    public Connection cn;

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModelAndView mv = new ModelAndView("wellcome");
        String user = hsr.getParameter("user");
        String Ipass = hsr.getParameter("pass");

        peticionBD miBd = new peticionBD();
        cn = miBd.conexionbd(hsr, hsr1);
        String nom = "o";
        String ape1 = "p";
        String Opass = "q";
        String dni = "r";
        String idClient = null;

        //CLIENTES==========================================================================
        PreparedStatement st = cn.prepareStatement("select * from zb_clientes where dni = '" + user + "'");        
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            nom = rs.getString("nombre");
            ape1 = rs.getString("apellido1");
            Opass = rs.getString("password");
            dni = rs.getString("dni");
            idClient = rs.getString("id_cliente");
        }

        if (Ipass.equals(Opass) && user.equals(dni)) {
            mv = new ModelAndView("client-logged");
            mv.addObject("nombre", nom);
            mv.addObject("ape1", ape1);
            mv.addObject("Cid", idClient);

            
            
        //CUENTAS===========================================================================
        PreparedStatement stc = cn.prepareStatement("select * from zb_cuentas where id_cliente = "+idClient);
        ResultSet crs = stc.executeQuery();
        ArrayList<getSet_cuentas> cl = new ArrayList();

        String id;        
        String num;
        int saldo;
        String cnom;
        
        while(crs.next()){            
            getSet_cuentas cgs = new getSet_cuentas();  
            
            cgs.setCnom(crs.getString("nombre"));
            cgs.setCnum(crs.getString("num_cuenta"));
            cgs.setId(crs.getString("id_cliente"));
            cgs.setSaldo(crs.getInt("saldo"));
            
            cl.add(cgs);
        }
        mv.addObject("Clist", cl);
        
        
        
        //RETORNO POR DEFECTO ModelAndView("wellcome")
        cn.close();
            return mv;
            
        } else {
            mv.addObject("error", "error de autentificación");
        }

        return mv;
    }

}
