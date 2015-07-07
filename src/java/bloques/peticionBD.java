/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bloques;

import java.sql.Connection;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author alumno
 */
public class peticionBD {
        public Connection cn;

    public Object getBean(String nombrebean, ServletContext servlet) {
        ApplicationContext contexto = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet);
        Object beanobject = contexto.getBean(nombrebean);
        return beanobject;
    }

    public Connection conexionbd(HttpServletRequest hsr, HttpServletResponse response) throws
            Exception, ServletException {

        DriverManagerDataSource dataSource;
        dataSource = (DriverManagerDataSource) this.getBean("dataSource", hsr.getServletContext());
        this.cn = dataSource.getConnection();
        return cn;
    }
    
}
