/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flujo;

import bloques.FullSentencia;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.getSet_cuentas;
import modelos.getSet_vista;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 *
 * @author xutto
 */
public class nav1 extends MultiActionController {

    //navegacion para empleados y algunas cosas mas
    public ModelAndView alta(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {
        ModelAndView mv = new ModelAndView("alta_cliente");

        return mv;

    }

    public ModelAndView baja(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {
        ModelAndView mv = new ModelAndView("baja_cliente");

        return mv;

    }

    public ModelAndView cuentas(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {
        ModelAndView mv = new ModelAndView("alta_cuentas");
        FullSentencia fs = new FullSentencia();
        ArrayList<getSet_vista> gs = new ArrayList<>();
        ResultSet rs = fs.rsList("zb_clientes", hsr, response);
        while (rs.next()) {
            getSet_vista gset = new getSet_vista();
            gset.setDni(rs.getString("dni"));
            gset.setId(rs.getString("id_cliente"));
            gs.add(gset);
        }
        mv.addObject("L", gs);
        return mv;

    }

    public ModelAndView lcuentas(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {
        ModelAndView mv = new ModelAndView("cuentas");
        FullSentencia fs = new FullSentencia();
        ArrayList<getSet_cuentas> gs = new ArrayList<>();
        ResultSet rs = fs.rsList("zb_cuentas", hsr, response);
        while (rs.next()) {
            getSet_cuentas gset = new getSet_cuentas();
            gset.setCnom(rs.getString("nombre"));
            gset.setCnum(rs.getString("NUM_CUENTA"));
            gset.setId(rs.getString("ID_CLIENTE"));
            gset.setSaldo(rs.getInt("SALDO"));

            gs.add(gset);
        }
        mv.addObject("L", gs);
        return mv;

    }

    public ModelAndView bcuentas(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {
        ModelAndView mv = new ModelAndView("baja_cuentas");

        return mv;

    }

    public ModelAndView vista(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {
        ModelAndView mv = new ModelAndView("vista_cliente");
        FullSentencia fs = new FullSentencia();
        ArrayList<getSet_vista> gs = new ArrayList<>();
        ResultSet rs = fs.rsList("zb_clientes", hsr, response);
        while (rs.next()) {
            getSet_vista gset = new getSet_vista();
            gset.setNombre(rs.getString("nombre"));
            gset.setApellido1(rs.getString("apellido1"));
            gset.setDni(rs.getString("dni"));
            gs.add(gset);
        }
        mv.addObject("L", gs);
        return mv;

    }

    public ModelAndView wellcome(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {
        ModelAndView mv = new ModelAndView("wellcome");
        HttpSession sesion = hsr.getSession();
        sesion.invalidate();

        return mv;

    }

    public ModelAndView empleados(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {
        ModelAndView mv = new ModelAndView("wellcome-emp");
        HttpSession sesion = hsr.getSession();
        sesion.invalidate();
        return mv;

    }

}
