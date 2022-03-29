//import java.time.localdatetime;

public class ExceptionMain
{
    public static void main(String[] args)
    {

        Students stuObj;
        Students stuObj1;
        Students stuObj2;
        try{
            stuObj = new Students("Tina",-32,'F');
            Thread t1 = new Thread(stuObj);
            t1.start();
            stuObj1 = new Students("John",35,'M');
            Thread t2 = new Thread(stuObj1);
            t2.start();
            stuObj2 = new Students("Hari",23,'M');
            Thread t3 = new Thread(stuObj2);
            t3.start();

           // System.out.println("details "+stuObj);
        }catch(nameIsEmpty e){
            System.out.println("name Empty "+e);
        }
        catch(nameCanOnlyBeAlphabets e)
        {

        }catch(ageCantbeNegative e)
        {
            System.out.println("Age cannot be negative "+e);
        }
    }
}

abstract class Person
{
    //abstract void giveExam()   ;       //ADMISSIONFORM
}
class Students extends Person implements Runnable
{
    String name;
    int age;
    char gender;

    Students(String name, int age, char gender) throws nameIsEmpty, nameCanOnlyBeAlphabets,ageCantbeNegative {
        try
        {
            System.out.println("Enter first Name "+name);


            if(name.matches("[a-zA-Z]+"))

                this.name = name;

            else if(name.isEmpty())
                  throw new nameIsEmpty("First name cannot be empty");
            else{
                throw new nameCanOnlyBeAlphabets("Enter alphabets ony");
            }
            if(age < 0){
                throw new ageCantbeNegative("Enter valid Age");
            }
            else{
                this.age = age;
            }

        }
        catch(nameIsEmpty  e)
        {
            System.out.println("Name Empty");
        }
        catch(nameCanOnlyBeAlphabets e)
        {
            System.out.println("only alphabet Exception");
        }
    }


    @Override
    public void run() {

        System.out.println(name +" has started the exam at ");

    }
}



class nameIsEmpty extends Exception
{
    nameIsEmpty(String str)
    {
        super(str);
    }
}

class nameCanOnlyBeAlphabets extends Exception
{
    nameCanOnlyBeAlphabets(String str)
    {
        super(str);
    }
}
class ageCantbeNegative extends  Exception
{
    ageCantbeNegative(String str)
    {
        super(str);
    }
}
class examTimeException extends Exception{
    examTimeException(String str)
    {
        super(str);
    }
}


