public class Cell
{
   private boolean isAlive;
   private boolean[] neighbors;
   public Cell()
   {
       neighbors=new boolean[8];
   }
   public void updateNeighbors(boolean[] neighbors)
   {
       this.neighbors=neighbors;
   }
   public void updateState()
   {
	int neighborCount=0;
            for(int i=0;i<8;i++)
		if(neighbors[i]==true)
                   neighborCount++;
	if(isAlive)
        {	    
            if(neighborCount==2 || neighborCount==3)
               isAlive=true;
            else
               isAlive=false;
        }
	else
        {
	    if(neighborCount==3)
		isAlive=true;
	}
   }
   public boolean getState()
   {
	return isAlive;
   }
   public void setState(boolean isAlive)
   {
	this.isAlive=isAlive;
   }
}