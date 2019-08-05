public class Employee extends Person
{
  private String company;
  public Employee(String name, int age, 
		String company)
  {
     super(name,age);
     this.company=company;
  }
  
  public String toString()
  {
  	return super.toString()+" Company: "+company;
  }
}