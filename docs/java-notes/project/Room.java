public class Room
{
   private Person[] list=new Person[10];
   private itn personCount;
   public void add(Person p) throws RoomFullException
   {
      if(personCount>=10)
	throw new RoomFullExcpetion();
      list[personCount]=p;
      personCount++;
   }
}