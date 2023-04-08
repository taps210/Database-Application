<%-- 
    Document   : delete_processing
    Created on : 04 9, 23, 3:20:36 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, asset_mgt.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Processing</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id="A" class="asset_mgt.assets" scope="session" />
            <% 
                A.assetId = Integer.parseInt(request.getParameter("asset_to_delete"));
                
                int status = A.deleteAsset();
            
                if (status == 1) {
            %>
                    <h1>Asset Successfully Updated!</h1>
            <%
                }
                else {
            %>
                    <h1>Asset Deletion Failed</h1>
            <% 
                }
            %>
            <input type="submit" value="Return to Menu" >
        </form>
    </body>
</html>
