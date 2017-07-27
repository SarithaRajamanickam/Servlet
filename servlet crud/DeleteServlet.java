import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;  

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        
System.out.println("hello delete");
       //String sid=request.getParameter("id");
       //int id=Integer.parseInt(sid);
       response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
       String name=request.getParameter("name");
       System.out.print("hello delete"+name);
       
    int status= EmployeeDao.deleteMethod(name);
    /*if(status==0)
    {
        out.println("unsuccess");
    }
    else{
     out.println("successs");
    }*/

     response.sendRedirect("DisplayAll");

    }
}