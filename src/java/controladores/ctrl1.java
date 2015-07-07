/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author xutto
 */
public class ctrl1 implements Controller {

    Connection cn;

    private Object getBean(String nombrebean, ServletContext servlet) {
        ApplicationContext contexto = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet);
        Object beanobject = contexto.getBean(nombrebean);
        return beanobject;
    }
    
    private void conectBD(HttpServletRequest hsr, HttpServletResponse response) throws
            Exception, ServletException {
        
        DriverManagerDataSource dataSource;
        dataSource = (DriverManagerDataSource) this.getBean("dataSource", hsr.getServletContext());
        this.cn = dataSource.getConnection();
    
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        ModelAndView mv = new ModelAndView("alta_cliente");

        recoge_nombre cadena = new recoge_nombre();

        String nom = cadena.nombre(hsr, hsr1);
        String ape = cadena.apellido(hsr, hsr1);
        mv.addObject("nombre", nom);
        mv.addObject("apellido", ape);
        return mv;
    }

}
