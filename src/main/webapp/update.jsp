<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: pink;
        }

        .reg {
            border: 1px solid #ccc;
            padding: 20px;
            text-align: center;
            width: 300px;
            display: flex;
            justify-content: center;
            align-items: center;
            
            
          }
    </style>


</head>



<body>
<center>
<fieldset>
<h1>Update Account</h1>
<%
  ResultSet rs = (ResultSet)request.getAttribute("rs");
%>
 <form action="update" >
    <label for="Id">Id:</label>
        <input type="text" id="Id" name="id"  readonly="readonly" value=<%= rs.getInt(1)%>  ><br><br>

        <label for="Name">Name:</label>
        <input type="text" id="Name" name="nm"  value=<%=rs.getString(2) %>> <br><br>
        
        <label for="Email"> Email:</label>
        <input type="text" id="Email" name="email"  value=<%=rs.getString(3) %> ><br><br>
        
        <label for="Phone">Phone:</label>
        <input type="text" id="Phone" name="ph" value=<%=rs.getString(4) %> ><br><br>
        
        <label for="password"> password:</label>
        <input type="password" id="Password" name="ps" value=<%=rs.getString(5) %> ><br><br>

        <button type="Submit"> Update </button>
  </form>
 
</fieldset>
</center>
</body>
</html>