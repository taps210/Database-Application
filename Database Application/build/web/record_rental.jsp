<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, asset_mgt.*" %>


<html>
    <head>
        <title>Record Rental</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <form action="record_processing.jsp">
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
        Resident ID: <input type="text" id="resident_id" name="resident_id" required> <br>
        Reservation Date(Year-Month-Day, Ex. 2003-02-10): <input type="text" id="reservation_date" name="reservation_date" required> <br>
        Rental Date(Year-Month-Day, Ex. 2003-02-10): <input type="text" id="rental_date" name="rental_date" required> <br>
        Discount: <input type="number" id="discount" name="discount" required> <br>
        <input type="submit" value="Submit">
    </form>
    </body>
</html>

</html>
