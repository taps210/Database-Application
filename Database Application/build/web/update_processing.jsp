<%-- 
    Document   : update_processing
    Created on : 04 9, 23, 12:46:03 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, asset_mgt.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Processing</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id="A" class="asset_mgt.assets" scope="session" />
            <% 
                A.assetId = Integer.parseInt(request.getParameter("asset_to_update"));
                A.assetDescription = request.getParameter("asset_description");
                A.forRent = request.getParameter("forrent");
                A.assetValue = request.getParameter("asset_value");
                A.assetStatus = request.getParameter("status");
                A.lattitudeLoc = request.getParameter("loc_lattitude");
                A.longitureLoc = request.getParameter("loc_longiture");
                A.hoaName = request.getParameter("hoa_name");
                A.enclosingAsset = request.getParameter("enclosing_asset");
                
                int status = A.updateAsset();
            
                if (status == 1) {
            %>
                    <h1>Asset Successfully Updated!</h1>
            <%
                }
                else {
            %>
                    <h1>Asset Update Failed</h1>
            <% 
                }
            %>
            <input type="submit" value="Return to Menu" >
        </form>
    </body>
</html>
