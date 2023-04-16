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
                A_R.asset_id = Integer.parseInt(request.getParameter("asset_id"));
                A_R.inspection_details = request.getParameter("inspection_details");
                A_R.assessed_value = Float.parseFloat(request.getParameter("assessed_value"));

                
                int status = A_R.returnRental();
            
                if (status == 1) {
            %>
                <h1>Returning of Rental Successful</h1>
            <%
                }
                else {
            %>
                    <h1>Returning of Rental Failed</h1>
            <% 
                }
            %>
    </body>
</html>