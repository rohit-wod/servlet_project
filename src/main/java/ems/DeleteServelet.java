package ems;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Scanner;

@WebServlet("/delete")
public class DeleteServelet extends HttpServlet
{
	public void service(ServletRequest req,ServletResponse res) throws IOException, ServletException
	   {
		   HttpServletRequest request = (HttpServletRequest) req;
	       HttpServletResponse response = (HttpServletResponse) res;
     int id =  Integer.parseInt(request.getParameter("id"));
	 try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");
         PreparedStatement ps = con.prepareStatement("DELETE FROM emp WHERE id = ?");

         System.out.print("Enter empolyee ID: ");
         ps.setInt(1,id);

         int rowsDeleted = ps.executeUpdate();
         System.out.println(rowsDeleted + " record(s) deleted successfully!");
         
         PrintWriter pw = res.getWriter();
         pw.write("<h1>Employee Deleted Successfully</h1>");

         ps.close();
         con.close();
     } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
     }
}
}