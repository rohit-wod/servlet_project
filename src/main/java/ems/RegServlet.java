package ems;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/reg")
public class RegServlet extends HttpServlet
{
   @Override
   public void service(ServletRequest req,ServletResponse res) throws IOException, ServletException
   {
	   HttpServletRequest request = (HttpServletRequest) req;
       HttpServletResponse response = (HttpServletResponse) res;
   
       int id = Integer.parseInt(req.getParameter("id"));
       String name = req.getParameter("nm");
       String email = req.getParameter("email");
       String phone= (req.getParameter("ph"));
       String password = req.getParameter("ps");  
        System.out.println(id);
        System.out.println(name);
        System.out.println(email);
        System.out.println(phone);
        System.out.println(password);
//      PrintWriter pw = res.getWriter();
//		pw.write("<html><body><h1>Id : "+id+" </h1> <h1>Name : "+name+"</h1><h1>Email : "+email+"</h1><h1>Phone : "+phone+"</h1><h1>Password : "+password+"</h1></body></html>");
//    	RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
//		rd.include(req, res); // It will Carry the html response to the next resource 
//      rd.forward(req, res);// It will not carry the html response to the next resource
	    try
		  {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","root");
			PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2,name);
			ps.setString(3,email);
			ps.setString(4,phone);
			ps.setString(5,password);
			
			int row = ps.executeUpdate();
			System.out.println(row);
			
			PrintWriter pw = res.getWriter();
			pw.write("<h1>Account created </h1>");
			
			ps.close();
			con.close();
			
		  } 
		 catch (ClassNotFoundException | SQLException e)
		  {
			
			e.printStackTrace();
		  }
       
//    try
//     {
//      response.sendRedirect("success.jsp"); 
//       } 
//   catch (Exception e)
//    {
//      e.printStackTrace();
//    }
  }
}
