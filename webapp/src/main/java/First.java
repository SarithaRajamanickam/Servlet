import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebServlet;
@WebServlet(name="First", urlPatterns="/First")

 public class First extends HttpServlet {

 public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
     {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("username");
        out.println("Welcome "+user);
        response.sendRedirect("Emp.html");
     }
}