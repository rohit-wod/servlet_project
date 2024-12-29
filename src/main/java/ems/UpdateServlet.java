package ems;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet
{
	public void service(ServletRequest req,ServletResponse res) throws IOException, ServletException
	   {
		 
	       int id =  Integer.parseInt(req.getParameter("id"));
	       String name = req.getParameter("nm");
	       String email = req.getParameter("email");
	       String phone= (req.getParameter("ph"));
	       String password = req.getParameter("ps");  
	       
	       
	 try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
         PreparedStatement ps = con.prepareStatement("update emp set name=?,email=?,phone=?,password=? where id=?");
         ps.setString(1,name);
         ps.setString(2,email);
         ps.setString(3,phone);
         ps.setString(4,password);
         ps.setInt(5,id);
         int row = ps.executeUpdate();
         PrintWriter pw = res.getWriter();
         pw.write("<h1>"+row+ ":Employee Updated Successfully</h1>");
         ps.close();
         con.close();
     } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
     }
 }

}
