
public class Person
{
  private String name;
  private int age;
  public Person(String name, int age)
  {
    setName(name);
    this.age=age;
  }
  public void setName(String name)
  {
    this.name=name;
  }
  public String toString()
  {
     return "Name: "+name+" Age: "+age;
  }
}