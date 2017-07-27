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
