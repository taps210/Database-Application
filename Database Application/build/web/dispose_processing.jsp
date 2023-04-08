<%-- 
    Document   : dispose_processing
    Created on : 04 9, 23, 3:40:14 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, asset_mgt.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dispose Processing</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id="A" class="asset_mgt.assets" scope="session" />
            <% 
                A.assetId = Integer.parseInt(request.getParameter("asset_to_dispose"));
                
                int status = A.disposeAsset();
            
                if (status == 1) {
            %>
                    <h1>Asset Successfully Disposed!</h1>
            <%
                }
                else {
            %>
                    <h1>Failed to Dispose Asset</h1>
            <% 
                }
            %>
            <input type="submit" value="Return to Menu" >
    </body>
</html>
