<%-- 
    Document   : update
    Created on : Feb 14, 2015, 12:44:36 PM
    Author     : neilkenney
--%>

<%@page import="Hotel.Model.Entity.Hotel"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="CSS/newcss.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div class="container">
            
            
            <div class="jumbotron">
<h3>Update Hotel</h3>
                <form class="form-horizontal"id="updateRecords" name="updateRecords" method="POST" action="HotelController?crud=updateHotel&HotelId=${hotel.hotel_Id}"/>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="hotelName">Hotel Name</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="hotelName" name="hotelName" value="${hotel.hotel_Name}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="address">Address</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="address" name="address"value="${hotel.street_address}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="city">City</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="city" name="city" value="${hotel.city}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="state">State</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="state" name="state" value="${hotel.state}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="zipCode">Zip Code</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="zipCode" name="zipCode"value="${hotel.postalcode}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="notes">Notes</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="notes" name="notes" value="${hotel.notes}">
                        </div>
                    </div>
                    
                    <input type="submit" name="submit" value="Update Record"/>
                </form>
            </div>
         </div>
    </body>
</html>
