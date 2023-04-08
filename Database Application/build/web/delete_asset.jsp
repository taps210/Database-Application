<%-- 
    Document   : delete_asset
    Created on : 04 9, 23, 2:56:38 AM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, asset_mgt.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Asset</title>
    </head>
    <body>
        <form action="delete_processing.jsp">
            <jsp:useBean id="A" class="asset_mgt.assets" scope="session" />
            Asset to delete: <select id="asset_to_delete" name="asset_to_delete">
            <%
                A.deletableAssets();
                for(int i = 0; i < A.assetIdList.size(); i++) {
            %>
                    <option value="<%=A.assetIdList.get(i)%>"> <%=A.assetNameList.get(i)%> - <%=A.assetIdList.get(i)%> </option>
            <%
                }
            %>
            </select><br><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
