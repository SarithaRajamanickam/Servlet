import java.io.*;  
import java.sql.*; 
import java.sql.Date; 
import java.text.ParseException;
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
import java.text.SimpleDateFormat; 
import javax.servlet.annotation.*;
//import java.util.Date;


@WebServlet("/Register1")

public class Register1 extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
        
String fname=request.getParameter("fname");  
String lname=request.getParameter("lname");  
String email=request.getParameter("email");  
String date=request.getParameter("date");  
String time=request.getParameter("time");  
String topic=request.getParameter("topic");  
String location=request.getParameter("location");
//SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");
//Date dt =objSDF.parse(date);


try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "");
            
            PreparedStatement ps=conn.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
         //ps.executeUpdate("insert into regis values(?,?,?,?,?,?,?)");
        
ps.setString(1,fname);  
ps.setString(2,lname);  
ps.setString(3,email);  
ps.setString(4,date);
//ps.setDate(4, (java.sql.Date)dt);
ps.setString(5,time);  
ps.setString(6,topic);  
ps.setString(7,location);    
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered..."); 
      conn.close();

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
    }  
}