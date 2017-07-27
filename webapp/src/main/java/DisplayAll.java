import java.io.*;
import java.sql.*;
import java.lang.*;
import java.util.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/DisplayAll")

public class DisplayAll extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        List<Pojo> l1=EmployeeDao.viewAll();
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Name</th><th>Id</th><th>Date</th><th>Salary</th><th>Phone</th><th>Email</th></tr>");  
       for(Pojo e:l1)
       {  
        out.println("<body bgcolor=lightblue>");
        
         out.print("<tr><td>"+e.getName()+"</td><td>"+e.getId()+"</td><td>"+e.getDate()+"</td><td>"+e.getSalary()+"</td><td>"+e.getPhone()+"</td><td>"+e.getEmail()+"</td><td></tr>");   
       }
       out.print("</table>");
       out.print("<a href='Emp.html'>BACK</a>");
}
}