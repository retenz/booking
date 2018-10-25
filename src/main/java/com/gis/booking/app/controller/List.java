/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gis.booking.app.controller;

import com.gis.booking.app.entities.Place;
import com.gis.booking.app.model.Database;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class List extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher  requestDispacher= req.getRequestDispatcher("views/list.jsp");
        requestDispacher.forward(req, resp);
        
    }
    
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database database=null;
        Connection conn=null;
       
        try {
            String cinema= req.getParameter("cinema");       
            String hall= req.getParameter("hall");            
            String url="select "+"*"+ " from app."+cinema+" where hall="+hall;
        
            database= Database.getinstance();
            conn= database.getConnection();           
            Statement st= conn.createStatement();
            st.executeQuery(url);
            ResultSet rs= st.getResultSet();
            req.setAttribute("rs", rs);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            doGet(req, resp);
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(List.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
   }
}
