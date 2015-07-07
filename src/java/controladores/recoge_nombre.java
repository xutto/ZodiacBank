/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 *
 * @author xutto
 */
public class recoge_nombre {

    private Connection cn;

    private Object getBean(String nombrebean, ServletContext servlet) {
        ApplicationContext contexto = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet);
        Object beanobject = contexto.getBean(nombrebean);
        return beanobject;
    }

    public void conectBD(HttpServletRequest hsr, HttpServletResponse response) throws
            Exception, ServletException {

        DriverManagerDataSource dataSource;
        dataSource = (DriverManagerDataSource) this.getBean("dataSource", hsr.getServletContext());
        this.cn = dataSource.getConnection();

    }

    public String nombre(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {
        
        this.conectBD(hsr, response);
        PreparedStatement st = cn.prepareStatement("select nombre, apellido1 from ZB_EMPLEADOS where id_empleado=1");
        ResultSet rs = st.executeQuery();
        String nom = "";

        while (rs.next()) {
            nom = rs.getString("nombre");
        }
        
        return nom;
    }
    
        public String apellido(HttpServletRequest hsr, HttpServletResponse response) throws Exception, ServletException {
        
        this.conectBD(hsr, response);
        PreparedStatement st = cn.prepareStatement("select nombre, apellido1 from ZB_EMPLEADOS where id_empleado=1");
        ResultSet rs = st.executeQuery();
        String ape = "";

        while (rs.next()) {
            ape = rs.getString("apellido1");
        }
        
        return ape;
    }
        
        
    }

