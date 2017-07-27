import java.util.*;
import java.sql.*;
import java.io.*;
import java.lang.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException; 
@WebServlet("/Edit2")
public class Edit2 extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String name=request.getParameter("name");
        int id=Integer.parseInt(request.getParameter("id"));
        String date=request.getParameter("date");
        int salary=Integer.parseInt(request.getParameter("salary"));
        int phone=Integer.parseInt(request.getParameter("phone"));
        String email=request.getParameter("email");
        Pojo p=new Pojo();
        p.setName(name);
        p.setId(id);
        p.setDate(date);
        p.setSalary(salary);
        p.setPhone(phone);
        p.setEmail(email);
        int n=EmployeeDao.update2(p);
        if(n>0)
        {
            out.println("Successfully Updated");
        }
        else
        {
            out.println(" not Updated");
        }
         response.sendRedirect("DisplayAll");


    } 
}