<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, asset_mgt.*" %>


<html>
    <head>
        <title>Return Rental</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <form action="return_processing.jsp">
        <jsp:useBean id="A_R" class="asset_mgt.asset_rental" scope="session" />
        Asset ID: <select id="asset_id" name="asset_id">
        <%  A_R.availableAssets();
            for(int i = 0;i < A_R.assetIdList.size(); i++) {
        %>
                <option value="<%=A_R.assetIdList.get(i)%>"> <%=A_R.assetNameList.get(i)%> - <%=A_R.assetIdList.get(i)%> </option>
        <%
            }
        %>

        </select><br>
       
        Inspection Details: <input type="text" id="inspection_details" name="inspection_details" required> <br>
        Assessed Value: <input type="text" id="assessed_value" name="assessed_value" required> <br>
        Return Date(Year-Month-Day, Ex. 2003-02-10): <input type="text" id="reservation_date" name="reservation_date" required> <br>
        
        <input type="submit" value="Submit">
    </form>
    </body>
</html>