<%-- 
    Document   : allrecords
    Created on : Feb 9, 2015, 9:20:23 PM
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

                <table class="table table-striped table-hover ">
                    <c:forEach var="hot" items="${allRecords}">
                        <tr>

                            <td align="left">${hot.hotel_Name}</td>
                            <td align="left">${hot.street_address}</td>
                            <td align="left">${hot.city}</td>
                            <td align="left">${hot.state}</td>
                            <td align="left">${hot.postalcode}</td>
                            
                            <td align="left"><a href="HotelController?crud=delete&hotelId=${hot.hotel_Id}">Delete</a></td>
                            <td align="left"><a href="HotelController?crud=update&hotelId=${hot.hotel_Id}">Update</a></td>        
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <br>
            <h3>Create New Hotel</h3>
                <form class="form-horizontal"id="updateRecords" name="updateRecords" method="POST" action="HotelController?crud=createRecord"/>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="hotelName">Hotel Name</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="hotelName" name="hotelName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="address">Address</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="address" name="address">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="city">City</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="city" name="city">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="state">State</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="state" name="state">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="zipCode">Zipcode</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="zipCode" name="zipCode">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="notes">Notes</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="notes" name="notes">
                        </div>
                    </div>
                    
                    <input type="submit" name="submit" value="CreateRecord"/>
                </form>
            
           
               
        
        </div>
       
    </table>
</body>
</html>
