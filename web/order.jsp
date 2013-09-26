<%-- 
    Document   : order
    Created on : Sep 11, 2013, 9:29:40 PM
    Author     : bspor
--%>

<%@page import="Model.MenuItem"%>
<%@page import="Model.MenuService"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Untitled Document</title>
    </head>

    <body>
    <title> Calculator </title>
</head>
<form method="POST" class="menu" id="menu" action="OrderController">
    <table width="300" border="1">
        <%
            MenuService ms = new MenuService();
            List recs = ms.getAllMenuItems();

            Iterator temp = recs.iterator();
            int i = 1;
            while (temp.hasNext()) {

                MenuItem it = (MenuItem) temp.next();
                out.print("<tr><td>"
                        + "<input name='checkbox' type='checkbox' value='"
                        + it.getItemId() + "'/> "
                        + it.getItemPrice() + " &nbsp; "
                        + "<td>" + it.getItemId() + "</td>" + "</td><tr>");
                i++;
            }
        %>
    </table>

    <input name="order" type="submit" value="Submit order!" />
    <div name="output1" id="output1">
        <%


            //String temp = request.getAttribute("output1").toString();

            if (request.getAttribute("output1") != null) {
                Object temp2 = request.getAttribute("output1");
                out.print(temp2);
            } else {
                out.print("Dude");
            }
        %>
    </div>
</form>
</body>
</html>