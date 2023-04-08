<%-- 
    Document   : update_asset
    Created on : 04 8, 23, 11:49:20 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, asset_mgt.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Asset</title>
    </head>
    <body>
        <form action="update_processing.jsp">
            <jsp:useBean id="A" class="asset_mgt.assets" scope="session" />
            Asset to update: <select id="asset_to_update" name="asset_to_update">
            <%
                A.availableAssets();
                for(int i = 0; i < A.assetIdList.size(); i++) {
            %>
                    <option value="<%=A.assetIdList.get(i)%>"> <%=A.assetNameList.get(i)%> - <%=A.assetIdList.get(i)%> </option>
            <%
                }
            %>
            </select><br><br>
            
            Values will remain unchanged in fields left blank <br>
            Asset Description: <input type="text" id="asset_description" name="asset_description"> <br>
            For renting or not (1 or 0): <input type="number" id="forrent" name="forrent"> <br>
            Asset Value: <input type="number" step="0.01" id="asset_value" name="asset_value"> <br>
            Status of Asset (W-Working Condition, D-Deteriorated, P-For Repair, S-For Disposal, or X-Disposed): <input type="text" id="status" name="status"> <br>
            Latitude Location of Asset: <input type="number" step="0.0001" id="loc_lattitude" name="loc_lattitude"> <br>
            Longitude Location of Asset: <input type="number" step="0.0001" id="loc_longiture" name="loc_longiture"> <br>
            HOA Name (SJH or SMH): <input type="text" id="hoa_name" name="hoa_name"> <br>
            Enclosing Asset (Optional): <input type="text" id="enclosing_asset" name="enclosing_asset"> <br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
