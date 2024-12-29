<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
 <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color:pink;
        }

        .reg {
            border: 1px solid #ccc;
            padding: 20px;
            text-align: center;
            width: 300px;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;       
            margin : auto;
            
          }
          
         
    }

  
    </style>
</head>
<body>
<center>
<fieldset>
<h1>Create Account</h1>
 <form action="reg" >
    <label for="Id">Id:</label>
        <input type="text" id="Id" name="id"><br><br>

        <label for="Name">Name:</label>
        <input type="text" id="Name" name="nm"><br><br>
        
        <label for="Email"> Email:</label>
        <input type="text" id="Email" name="email"><br><br>
        
        <label for="Phone">Phone:</label>
        <input type="text" id="Phone" name="ph"><br><br>
        
        <label for="password"> password:</label>
        <input type="password" id="Password" name="ps"><br><br>

        <input type="submit" value="Submit">
  </form>
  <br>
     <a href="all"><button> Employee Details</button></a>
</fieldset>
</center>
</body>
</html>