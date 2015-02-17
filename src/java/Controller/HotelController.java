/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Hotel.Model.Entity.Hotel;
import Hotel.Model.Entity.HotelService;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author neilkenney
 */
@WebServlet(name = "HotelController", urlPatterns = {"/HotelController"})
public class HotelController extends HttpServlet {
    


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String crud = null;
        HotelService hotel = new HotelService();
        List<Hotel> hotels = hotel.returnAllRecords("hotel");
       
            
        crud = request.getParameter("crud");
            
        if (crud.equals("showAll")) {
            request.setAttribute("allRecords", hotels);
        }
        
        if (crud.equals("createRecord")) {
            String hotelName = request.getParameter("hotelName");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zipCode = request.getParameter("zipCode");
            String notes = request.getParameter("notes");
            hotel.createRecord(hotelName, address, city, state, zipCode, notes);
            hotels = hotel.returnAllRecords("hotel");
            request.setAttribute("allRecords", hotels);
        }
        if (crud.equals("updateHotel")) {
            List<String> updateList = new ArrayList<>();
            updateList.add(request.getParameter("hotelName"));
            updateList.add(request.getParameter("address"));
            updateList.add(request.getParameter("city"));
            updateList.add(request.getParameter("state"));
            updateList.add(request.getParameter("zipCode"));
            updateList.add(request.getParameter("notes"));
            
            hotel.updateHotel(request.getParameter("HotelId"), updateList);
            
            hotels = hotel.returnAllRecords("hotel");
            request.setAttribute("allRecords", hotels);
        }
        
        if (crud.equals("delete")){
            hotel.deleteRecordByName(request.getParameter("hotelId"));
            hotels = hotel.returnAllRecords("hotel");
            request.setAttribute("allRecords", hotels);
        }
        
        if (crud.equals("update")){
            request.setAttribute("hotel", hotel.returnHotelByID(request.getParameter("hotelId")));
            RequestDispatcher view = request.getRequestDispatcher("update.jsp");
            view.forward(request, response);
        }
            
        RequestDispatcher view = request.getRequestDispatcher("allrecords.jsp");
            view.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
