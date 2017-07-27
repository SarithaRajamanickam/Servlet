import java.sql.*;
import javax.servlet.*;
import java.util.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.*;
@WebServlet("/Edit1")
public class Edit1 extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
              response.setContentType("text/html");
              PrintWriter out=response.getWriter();
              int id=Integer.parseInt(request.getParameter("id"));
              Pojo p=EmployeeDao.getUpdate1(id);
              System.out.println(p);
              out.print("<body bgcolor=#E6E6FA>");
               out.print("<form action='Edit2' method='get'>");
              out.print("<table>");
               out.print(" <tr><td>Name:</td><td><input type='text' name='name' value='"+p.getName()+"'></td></tr>");
                out.print("<tr><td>Id:</td><td><input type='text' name='id' value='"+p.getId()+"'></td></tr>");
                out.print("<tr><td>Date:</td><td><input type='text' name='date' value='"+p.getDate()+"'></td></tr>");
                out.print("<tr><td>Salary:</td><td><input type='text'name='salary'value='"+p.getSalary()+"'></td></tr>");
                out.print("<tr><td>Phone:</td><td><input type='text'name='phone' value='"+p.getPhone()+"'></td></tr>");
                out.println("<tr><td>Email:</td><td><input type='text'name='email' value='"+p.getEmail()+"'></td></tr>");
                out.print("<tr><td><input type='submit' value='Update'><br></tr></td>");
                out.print("</table>");
                out.print("</form>");
                out.print("</body>");



    }

}

