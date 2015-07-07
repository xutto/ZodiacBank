package bloques;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xutto
 */
public class FullSentencia {

    Connection cn;

    public ResultSet rsList(String st, HttpServletRequest hsr, HttpServletResponse response) throws Exception {

         peticionBD BD = new peticionBD();
        cn = BD.conexionbd(hsr, response);
        PreparedStatement pst = cn.prepareStatement("Select * from "+st);
        ResultSet rs = pst.executeQuery();
        
        return rs;
    }

}
