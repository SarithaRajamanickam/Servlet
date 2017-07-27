import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.Filter.*;
import javax.servlet.annotation.WebFilter;
@WebFilter(filterName="MyFilter", urlPatterns="/First")
 public class MyFilter implements Filter {
   
    public void init(FilterConfig fc) throws ServletException {}
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
                response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String user=request.getParameter("username");
        String pass = request.getParameter("password");
        if(user.equals("subi")&&pass.equals("1234"))
        {
         chain.doFilter(request, response);   
        }
        else
        {
            out.println("You have enter a wrong password");
            RequestDispatcher rs = request.getRequestDispatcher("login.html");
            rs.include(request, response);
        }
    }
   public void destroy() { }
}