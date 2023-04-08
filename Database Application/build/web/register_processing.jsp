<%-- 
    Document   : register_processing
    Created on : 04 8, 23, 2:38:20 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, asset_mgt.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Asset Processing</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id="A" class="asset_mgt.assets" scope="session" />
            <% 
                A.assetName = request.getParameter("asset_name");
                A.assetDescription = request.getParameter("asset_description");
                A.acquisitionDate = request.getParameter("acquisition_date");
                A.forRent = request.getParameter("forrent");
                A.assetValue = request.getParameter("asset_value");
                A.assetType = request.getParameter("type_asset");
                A.assetStatus = request.getParameter("status");
                A.lattitudeLoc = request.getParameter("loc_lattitude");
                A.longitureLoc = request.getParameter("loc_longiture");
                A.hoaName = request.getParameter("hoa_name");
                A.enclosingAsset = request.getParameter("enclosing_asset");
                
                int status = A.registerAsset();
            
                if (status == 1) {
                    
            %>
                    <h1>Asset Successfully Registered!</h1>
            <%
                }
                else {
            %>
                    <h1>Asset Registration Failed</h1>
            <% 
                }
            %>
                    <input type="submit" value="Return to Menu" >
        </form>
    </body>
</html>
