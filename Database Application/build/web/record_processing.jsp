<%-- 
    Document   : record_processing
    Created on : 04 10, 23, 12:28:25 PM
    Author     : ccslearner
--%>


<%-- 
    To do:
        - discuss conditions for this feature and the required attributes
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Record Rental Processing</title>
    </head>
    <body>
        <jsp:useBean id="A_R" class="asset_mgt.asset_rental" scope="session" />
            <% 
                A_R.renter_residentid = Integer.parseInt(request.getParameter("renter_residentid"));
                A_R.reservation_date = request.getParameter("reservation_date");
                A_R.rental_date = request.getParameter("rental_date");
                A_R.discount = Float.parseFloat(request.getParameter("discount"));
    
                
                int status = A_R.recordRental();
            
                if (status == 1) {
            %>
                <h1>Recording Rental Successful</h1>
            <%
                }
                else {
            %>
                    <h1>Record Rental Failed</h1>
            <% 
                }
            %>
    </body>
</html>
