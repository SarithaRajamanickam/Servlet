
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.*;
import java.net.Authenticator;
import java.util.*;
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/SendToPojo")

public class SendToPojo extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  

//set values to variables get from user
String name=request.getParameter("name");
int id=Integer.parseInt(request.getParameter("id"));
String date=request.getParameter("date");
int salary=Integer.parseInt(request.getParameter("salary"));
int phone=Integer.parseInt(request.getParameter("phone"));
String email=request.getParameter("email");
System.out.println(email);
//set values to pojo class

Pojo p=new Pojo();

p.setName(name);
p.setId(id);
p.setDate(date);
p.setSalary(salary);
p.setPhone(phone);
p.setEmail(email);

int present=EmployeeDao.insert1(p);
if(present>0)
{
    out.println("inserted successfully");
    SendToPojo.sendEmail(email);
}
else
{
    out.println("insertion unsuccess");
     
}
out.println("<img src='/images/com.jpg' alt='success'/>");

}
public static void sendEmail(String to)
{
final String username = "saritha.m@kggroup.com";
final String password = "saritha@123";
Properties props = new Properties();
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "false");
props.put("mail.smtp.host", "webmail.kggroup.com");
props.put("mail.smtp.port", "25");
Session session = Session.getInstance(props,
new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(username, password);
}
});
try {
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress("saritha.r@kggroup.com"));
message.setRecipients(Message.RecipientType.TO,
InternetAddress.parse(to));
message.setSubject("A testing mail header !!!");
message.setText("Dear Employee,"
+ "\n\n your details have been saved successfully");
Transport.send(message);
}
catch (MessagingException e) 
{
throw new RuntimeException(e);
}
}}



       

      
