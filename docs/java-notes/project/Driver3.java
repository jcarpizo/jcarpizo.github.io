public class Driver
{
  public static void main(String[] args)
  {
    Person p=new Person("Joe", 13);
    System.out.println(p.toString());
    p=new Employee("Jane", 15,"Jolibee");
    System.out.println(p.toString());

    Person arrPerson[]=new Person[10];
    arrPerson[0]=p;
    System.out.println(arrPerson[0].toString());
  }
}