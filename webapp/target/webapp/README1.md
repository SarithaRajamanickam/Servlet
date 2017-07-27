# Employee Details
# Login Form
## Description
A Login form is used to enter specific page.The login form contains a field for the username and another for the password. When the login form is submitted its checks that the fields are authentic,if the fields are authentic user can access the restricted page.
# Code
## login.html
```
<html>
    <head lang="en">
        <title>Crud operation</title>
   <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <div class="container">
  <style>
  .jumbotron {
  background-image:url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTD2hMc_WuZQmyn0QvwfObrGH2VtxqL5seyP5W-UlggtntlKpdN);
  height:800px;
  width:1120px;
  background-repeat: no-repeat;
  background-size: cover;
  border-bottom:1px solid #ff6a00
}
</style>
</div>
        </head>
        <body>
            <div class="container">
            <div class="jumbotron">
            <center>
              <h3><b>LOGIN</b></h3>
            <form action="First" method="post">
            <table>
            <tr><td>Username:</td><td><input type="text" name="username"></tr></td>
            <tr><td>Password:</td><td><input type="password" name="password"></tr></td>
            <tr><td><input type="submit" value="SUBMIT"></td>
            </form>
            <form action="cancel.html" method="post">
            <td><input type="submit" value="CANCEL"></td></tr>
            </form>
            </center>
        </table>
     </div>
    </div>
</body> 
</html>

```
## MyFilter.java
```
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
```
## First.java
```
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
```
## cancel.html
```
<html>
    <head>
        <title>
            cancel the request
            </title>
        </head>
        <body bgcolor=lightblue>
            <center>
            <h1>Your request has been cancelled</h1><br><br>
            <form action="login.html" method="post">
                <input type="submit" value="BACK">
            </form>
            </center>
        </body>
    </html>

```
# Employee Details Form
## Description
- A text box which asks for employee name,id,date,phone number,salary and email
- This form contains four buttons such as SUBMIT,DISPLAY,UPDATE,DELETE
- When submit button is clicked datas are inserted into the database and also mail is sent to the employee
- When display button is clicked datas are fetched from the database and displayed on the screen
- When update button is clicked datas are fetched from the database based on the given id and changes are made on that data,then updated on the database
- When delete button is clicked datas are deleted from the database 
# code
## Emp.html
```
<html>
    <head>
    <title>employee</title>
    <style>
        #form{
 background-color:lightskyblue;
 }
 body{
background-color:lemonchiffon;
background-image:url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTl6tlX_YcHUv_KkPQbRFihH1IEvIlvHjlUQzxL8lRwPpaM-iTK);
 height: 100%;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}
        </style>
    </head>
    <body>
        
    <h1 align="center">Employee details</h1>
    <form action="SendToPojo" method="get">
        
     <table cellspacing=5 cellpadding=5 id="form" align="center">
     <tr><td>Name:</td><td><input type="text" name="name"></td></tr>
     <tr><td>Id:</td><td><input type="text" name="id" /></td></tr>
    <tr><td>Date of Joining:</td><td><input type="text" name="date"/></td></tr>
    <tr><td>Salary:</td><td><input type="text" name="salary" /></td></tr>
    <tr><td>Phone:</td><td><input type="text" name="phone" /></td></tr>
     <tr><td>Email:</td><td><input type="text" name="email" /></td></tr>
    <tr><td><input type="submit" value="SUBMIT" ></td></tr>
        
    </form>
        <form action="DisplayAll" method="get">
            <tr><td><input type="submit" value="DISPLAY"></td></tr>
        </form>
      <form action="delete.html" method="GET">
        <tr><td><input type="submit" value="DELETE"></td></tr>
    </form>
    <form action="Update.html" method="GET">
      <tr><td><input type="submit" value="UPDATE"></td></tr>
    </form>

     </table>
        
    </body>
</html>
```
## Update.html
```
<html>
    <head>
        <title>hello</title>
        <style>
        body
        {
           background-color: lightseagreen; 
        }
        </style>
        </head>
        <body>
            <center>
            <h1>Enter the EmployeeId</h1>
            <form action="Edit1" method="get">
                Id:<input type="text" name="id"><br><br>
                <input type="submit" value="UPDATE"><br>
                </center>
                </form>
                </body>
                </html>

```
## delete.html
```
<html>
    <head>
        <title>hello</title>
        <style>
            body{
                background-color:lightgoldenrodyellow;
            }
            </style>
        </head>
        <body>
            <center>
            <h1 align="center">Enter the EmployeeName</h1>
            <form action="DeleteServlet" method="get">
                Name:<input type="text" name="name"><br><br>
                <input type="submit" value="DELETE"><br>
                </form>
            </center>
                </body>
                </html>

```
# Code for CRUD operation and Mail
## Pojo.java
```
public class Pojo
{
    private String name;
    private int id;
    private String date;
    private int salary;
    private int phone;
    private String email;
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()

       {   
           return name;      
       }
       public void setId(int id)
       {
          this.id=id;
        
       }
       public int getId()
       {
           return id;
       }
       public void setDate(String date)
       {
            this.date=date;
       }

       public String getDate()
       {
           return date;
       }
       public void setSalary(int salary)
       {
           this.salary=salary;
       }
        public int getSalary()
        {
            return salary;
        }

        public void setPhone(int phone)
        {
            this.phone=phone;
        }
        public int getPhone()
        {
            return phone;
        }
        public void setEmail(String email)
        {
            this.email=email;
        }
        public String getEmail()
        {
            return email;
        }
    }


```
## SendToPojo.java
```

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
}
}
```
## EmployeeDao.java
```
import java.util.*;
import java.sql.*;

public class EmployeeDao 
{
 public static Connection getConnection()
{ 
    Connection c=null;
    try{
    Class.forName("com.mysql.jdbc.Driver");
    c=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration1","root","");
}
catch(Exception e)
{
    System.out.println(e);}
    return c;
}
/***establish a connection,query***/

 public static int insert1(Pojo p)
{
    int present=0;

   try {
Connection c=EmployeeDao.getConnection();

PreparedStatement ps=c.prepareStatement("insert into employee(name,id,date,salary,phone,email)values(?,?,?,?,?,?)");
ps.setString(1,p.getName());
ps.setInt(2,p.getId());
ps.setString(3,p.getDate());
ps.setInt(4,p.getSalary());
ps.setInt(5,p.getPhone());
ps.setString(6,p.getEmail());
present=ps.executeUpdate();
c.close();
}
catch(Exception e){
    System.out.println(e);

}
return present;
}

/*list of datas are displayed by getting datas from the database and set to pojo class and view it
 display all values in a database */
public static List<Pojo> viewAll() //we need a list to display group of datas
{
List<Pojo> list=new ArrayList<Pojo>();//

try{
    Connection c=EmployeeDao.getConnection();
    PreparedStatement ps=c.prepareStatement("select * from employee");
    ResultSet rs=ps.executeQuery();
    while(rs.next())
    {
       Pojo e=new Pojo();
       e.setName(rs.getString(1));
       e.setId(rs.getInt(2));
       e.setDate(rs.getString(3));
       e.setSalary(rs.getInt(4));
       e.setPhone(rs.getInt(5));
       e.setEmail(rs.getString(6));
    list.add(e);    
  }
  c.close();
}
catch(Exception e){
    System.out.println(e);
}
return list;
}

/*****call the delete method from deleteservlet class */
/*
int processdone=0;
    try{
        establish a connection ,querystatement 
    Connection c=EmployeeDao.getConnection();
    PreparedStatement ps=c.prepareStatement("delete from employee where name=?");
    ps.setString(1,name);
    processdone=ps.executeUpdate();
    c.close();
}
catch(Exception e)
{
System.out.println(e);
}
    return processdone;
}***/public static int deleteMethod(String name)
{
 int status=0;  
        try{  
            Connection con=EmployeeDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from employee where name=?");  
            ps.setString(1,name);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    } 
      public static Pojo getUpdate1(int id)
{
    Pojo p=new Pojo();
 int n=0;  
        try{  
            Connection con=EmployeeDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from employee where id=?");  
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){

p.setName(rs.getString(1));
p.setId(rs.getInt(2));
p.setDate(rs.getString(3));
p.setSalary(rs.getInt(4));
p.setPhone(rs.getInt(5));
p.setEmail(rs.getString(6));
 }
            con.close(); 

        }catch(Exception e){e.printStackTrace();}  
          
        return p;  
    }


    public static int update2(Pojo p)
{
 int n=0;  
        try{  
            Connection con=EmployeeDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("update employee set name=?,date=?,salary=?,phone=?,email=? where id=?");  
            ps.setString(1,p.getName());
            ps.setString(2,p.getDate());
            ps.setInt(3,p.getSalary());
            ps.setInt(4,p.getPhone());
            ps.setString(5,p.getEmail()); 
            ps.setInt(6,p.getId());
            n=ps.executeUpdate();  
              
            con.close(); 

        }catch(Exception e){e.printStackTrace();}  
          
        return n;  
    } 

}

```
## DisplayAll.java
```
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
}
}
```
## Delete.java
```
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
```
## Edit1.java
```
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
```
## Edit2.java
```
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
```