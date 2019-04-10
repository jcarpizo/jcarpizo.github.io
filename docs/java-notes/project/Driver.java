public class Driver
{
  public static void main(String[] args)
  {
       try
       {
	int a=100;
	int b=a-100;
	int arrInt[]=new int[10];
	arrInt[11]=100;
	b=a/b;
	System.out.println(b);	
	}
       }
       catch (ArithmeticException exception)
       {
           System.out.println("Arithmetic exception encountered");
       }
       catch (ArrayIndexOutOfBoundsException exception)
       {
           System.out.println("Array Index Out of Bounds exception encountered");
	    exception.printStackTrace();
       }
       catch (Exception e)
       {
		System.out.println("Unidentified exception encountered");
       }
 	System.out.println("Try-catch block ended");
  }
}