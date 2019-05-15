public class CellDriver
{
	public static void main(String[] args)
	{
		Cell c=new Cell();
		c.setState(false);
		boolean[] neighbors={true,false,true,false,true,false,true,false};
		c.updateNeighbors(neighbors);
		c.updateState();
		System.out.println("Is alive: "+c.getState());
	}
}