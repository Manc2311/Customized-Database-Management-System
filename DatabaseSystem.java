import java.lang.*;
import java.util.*;


// create table query cant create here - bcoz dyanimacally we cant create class hence we cant able to work 
//query convert to lowercase and than compare it with only lowercase 
class Student
{
    public int RID;
    public String Name;
    public int Salary;

    private static int Generator;   //for create rid its own   use static bcoz it will be use for all object

    static 
    {
        Generator = 0;
    }
     

    public Student(String str, int Value)
    {
        this.RID =++Generator;  //preincrement bcoz want 1st rid as 1
        this.Name = str;
        this.Salary = Value;

    }

    public void DisplayData()
    {
        System.out.println(this.RID + "\t" + this.Name + "\t" + this.Salary);
    }
}

class DBMS 
{

        public LinkedList <Student> lobj;

        public DBMS()   //default constructor
        {
           lobj = new LinkedList<>();   //obj of linkedlist
        }

        public void startDBMS()
        {
            Scanner scanobj = new Scanner(System.in);

            System.out.println("my customized DBMS Started Successfully");
            String Query ="";

            while(true)
            {
                System.out.println("Marvellous DBMS console >");
                Query = scanobj.nextLine();
                
                String tokens[] = Query.split(" ");
                int QuerySize = tokens.length;

             // tokens mdhe jr help lihila tr tychi QuerySize 1 ahe bcoz to ek token ahe 
                if(QuerySize == 1)
                {

                    if("Help".equals(tokens[0]))
                    {
                        System.out.println("This application is used to demonstrates the customised DBMS");
                        System.out.println("Exit : Terminate DBMS");
                        System.out.println("Display all data : select * from student");
                        System.out.println("Insert data : Insert into student Name Salary");
                    }
                    else if("Exit".equals(tokens[0]))
                    {
                        System.out.println("Thank you for using Marvellous DBMS");
                        break;

                    }
                }
                else if(QuerySize == 4)
                {
                    if("select".equals(tokens[0]))
                    {
                       if("*".equals(tokens[1]))
                        {
                          DisplayAll();
                        }
                    }
                }
                else if(QuerySize == 5)
                {
                    if("Insert".equals(tokens[0]))
                    {     
                        // tokens[0]   tokens[1]   tokens[2]   tokens[3]   tokens[4]
                        // Insert      into        student     Piyush      1000;          
                        InsertData(tokens[3],Integer.parseInt(tokens[4]));  // insertdata la detoy mhnun tokens[3] ani tokens[4] ghetle ani 1000 la integer mdhe convert karaych hot mhnun parsInt use kel

                    }

                }
            }

        }

        public void InsertData(String str, int value)
        {
            Student sobj = new Student(str,value);
            lobj.add(sobj);
        }
        //display all
        public void DisplayAll()
        {
            for(Student sref : lobj)
            {
              sref.DisplayData();
            }

        }
        //display by RID
        public void DisplaySpecific(int rid)
        {
            for(Student sref:lobj)
            {
                if(sref.RID == rid)
                {
                    sref.DisplayData();
                    break;
                }
            }
        }

        //display by name
        public void DisplaySpecific(String name)
        {
            for(Student sref:lobj)
            {
                if(name.equals(sref.Name))
                {
                    sref.DisplayData();
                }
            }
        }

        public void DeleteSpecific(int rid)
        {
            int index = 0;

            for(Student sref:lobj)
            {
                if(sref.RID == rid)
                {
                   lobj.remove(index);
                   break;
                }               
                index++;
            }
        }

        public void DeleteSpecific(String name)
        {
            int index = 0;

            for(Student sref:lobj)
            {
                if(name.equals(sref.Name))
                {
                   lobj.remove(index);
                   break;
                }               
                index++;
            }
        }

        public void AggregateMax()
        {
            int iMax = 0;
            Student temp = null;

            for(Student sref:lobj)
            {
                if(sref.Salary > iMax)
                {
                    iMax = sref.Salary;
                    temp = sref;
                }
            }

            System.out.println("info of student having max salary is : ");
            temp.DisplayData();
        }

        public void AggregateMin()
        {
            int iMin =(lobj.getFirst()).Salary;  //store 1st's rid salary in imin
            Student temp = lobj.getFirst();

            for(Student sref:lobj)
            {
                if(sref.Salary < iMin)
                {
                    iMin = sref.Salary;
                    temp = sref;
                }
            }

            System.out.println("info of student having Min salary is : ");
            temp.DisplayData();
        }

        public void AggregateSum()
        {
            long iSum = 0;

            for(Student sref:lobj)
            {
                iSum = iSum + sref.Salary;
            }

            System.out.println("Summation of salaries is: " + iSum);
        }

        public void AggregateAvg()
        {
            long iSum = 0;

            for(Student sref:lobj)
            {
                iSum = iSum + sref.Salary;
            }

            System.out.println("Avg of salary is: " + iSum/(lobj.size()));
        }

        public void AggregateCount()
        {
            System.out.println("Count is : "+lobj.size());
        }
}

class pr1
{
    public static void main(String arg[])
    {

        DBMS bobj = new DBMS();
        bobj.startDBMS();

        /*
        bobj.InsertData("Sakshi",2000);
        bobj.InsertData("akash",5000);
        bobj.InsertData("vinay",1000);
        bobj.InsertData("Sachin",3000);

        bobj.DisplayAll();

        bobj.DisplaySpecific(2);
        bobj.DisplaySpecific("Sachin");

        bobj.DeleteSpecific(3);
        bobj.DeleteSpecific("Sakshi");

        bobj.AggregateMax();
        bobj.AggregateMin();
        bobj.AggregateSum();
        bobj.AggregateAvg();
        bobj.AggregateCount();
       */

    }
}