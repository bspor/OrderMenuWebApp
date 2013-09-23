<%-- 
    Document   : order
    Created on : Sep 11, 2013, 9:29:40 PM
    Author     : bspor
--%>
<%@page import="Model.Menu"%>
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
        Menu menu = new Menu();
        List recs = menu.getMenuNames();
        Iterator it = recs.iterator();
        int i = 1;
        while(it.hasNext()) {
           // String temp = it.next().toString().trim();
            out.print("<tr><td><input name='checkbox' type='checkbox' value='" 
                    + menu.getMenuItemByID(i).get("item_price") + "' /> " 
                    + it.next() + " &nbsp; " 
                    +"<td>" 
                    + menu.getMenuItemByID(i).get("item_price")
                    +"</td>" 
                    + "</td><tr>");
            i++;
        }
    %>
    </table>

    <input name="order" type="submit" value="Submit order!" />
    <div name="output1" id="output1">
        <%
        
        
        //String temp = request.getAttribute("output1").toString();
        
        if (request.getAttribute("output1") != null) {
        String temp = request.getAttribute("output1").toString();
 
        out.print(temp.getClass());
 
        
 
        } else {
            out.print("WHAAT");
        
        }
    %>
    </div>
</form>
</body>
</html>