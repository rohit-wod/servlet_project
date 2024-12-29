<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employees Pages</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: pink;
        margin: 0;
        padding: 0;
    }
    h1 {
        text-align: center;
        padding: 20px;
        background-color: pink;
        color: black;
        margin: 0;
    }

  
    table {
        width: 50%;
        margin: 20px auto;
        border-collapse: collapse;   
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); 
    }

    
    th {
        background-color: ;  /
        color: white;               
        padding: 12px 15px;         
        text-align: left;         
        font-weight: bold;         
    }

 
    td {
        padding: 12px 15px;         
        text-align: left;           
        border-bottom: 1px solid #ddd;
    }

    tr:hover {
        background-color: ;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9; 
    }
    table, th, td {
        border: 1px solid #ddd;    
        border-radius: 5px;      
    }

    @media screen and (max-width: 768px) {
        table {
            width: 100%;   
        }
    } 
</style>



</head>


<body>
  <h1 style="text-align:center">All Employees</h1>
  <table  border="5" cellspacing="10" cellpading="10" style="borde-collapse; margin:auto">
   <tr>
   <th>Id</th>
   <th>Name</th>
   <th>Email</th>
   <th>Phone</th> 
   <th>Password</th>
   <th>Delete Details </th>
   <th >Update Details </th>
   </tr>
 <%
   ResultSet rs = (ResultSet) request.getAttribute("rs");
   while (rs.next()){
 %>
 <tr>
    <td><%= rs.getInt(1)%>    </td>
    <td><%=rs.getString(2) %> </td>
    <td><%=rs.getString(3) %> </td>
    <td><%=rs.getString(4) %> </td>
    <td><%=rs.getString(5) %> </td>
  <td> <a href="delete?id=<%=rs.getInt(1)%>"><button>Delete</button></a></td>
  <td> <a href="updatepage?id=<%=rs.getInt(1)%>"><button>Update</button></a></td>
  </tr>
<%
 }
%>

</table>
</body>
</html>