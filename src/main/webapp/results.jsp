<%@page import="com.tuna.nic.NICDetails"%>
<%@page import="com.tuna.nic.NICInterpreter"%>
<%@page import="com.tuna.nic.exception.InvalidNICException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 
    Document   : results
    Created on : 11-Sep-2013, 16:45:24
    Author     : Janaka
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Results of the NIC Interpretation</title>
    </head>
    <body>
        <h1>Results of the NIC Interpretation</h1>
        <%
            try {
                String nic = request.getParameter("nic");
                NICInterpreter processor = new NICInterpreter();
                NICDetails result = processor.interpret(nic);

                out.print(result.toString());
            }
            catch(NullPointerException npe) {
                out.println("Please enter a valid NIC number.");
            }
            catch(InvalidNICException inc) {
                out.println(inc.getMessage());
            }
        %>
    </body>
</html>
