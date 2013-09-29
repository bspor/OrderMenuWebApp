<%-- 
    Document   : admin_portal
    Created on : Sep 28, 2013, 8:47:48 PM
    Author     : Quiquia
--%>

<%@page import="java.util.List"%>
<%@page import="Model.MenuService"%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.MenuItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Administrator Portal</title>
    </head>
</form>
<body>
    <form action="edit" method="get">
        <table width="200" border="3" cellspacing="1" cellpadding="1">
            <caption>
                Edit Menu
            </caption>
            <tr>
                <th scope="col">Item Name</th>
                <th scope="col">Item Price</th>
                <th scope="col">Item Category</th>
            </tr>
            <%
                MenuService ms = new MenuService();
                List recs = ms.getAllMenuItems();

                Iterator temp = recs.iterator();
                int i = 1;
                while (temp.hasNext()) {

                    MenuItem it = (MenuItem) temp.next();
                    out.print("<tr><td>"
                            + "<input name='checkbox' type='checkbox' value='"
                            + it.getItemPrice() + "'/> "
                            + it.getItemId() + " &nbsp; "
                            + "<td>" + it.getItemPrice() + "</td>" + "</td><tr>");
                    i++;
                }
            %>
        </table>    


</body>
</html>

