package com.gis.booking.app.controller;

import com.gis.booking.app.model.Database;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Booking extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher  requestDispacher= req.getRequestDispatcher("views/booking.jsp");
        requestDispacher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        Connection conn= null;
        Database database= null;
        try {
            String cinema= req.getParameter("cinema");       
            String hall= req.getParameter("hall");
            String row= req.getParameter("row");
            String sit= req.getParameter("sit");
            

            req.setAttribute("cinema", cinema);
            req.setAttribute("row", row);
            req.setAttribute("sit", sit);
            req.setAttribute("hall", hall);
            
            String url="select "+"sit"+sit+" from app."+cinema+" where hall="+hall+" AND row="+row;
            String urlupdate= "update app."+cinema+" set sit"+sit+"= true where hall="+hall+" AND row="+row;
            database= Database.getinstance();
            conn= database.getConnection();           
            Statement st= conn.createStatement();
            st.executeQuery(url);
            ResultSet rs= st.getResultSet();
            
            while (rs.next())
            {
                boolean check = rs.getBoolean("sit"+sit);
                if(check)
                    req.setAttribute("check", "занято");
                else
                {
                    req.setAttribute("check", "успешно забронировано");
                    st.executeUpdate(urlupdate);
                }
            }            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            doGet(req, resp);
        }
        
    }
}
