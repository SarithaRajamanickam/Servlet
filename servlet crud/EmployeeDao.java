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

/////////list of datas are displayed by getting datas from the database and set to pojo class and view it
/*** display all values in adatabase* */
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
