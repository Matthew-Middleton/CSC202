/****************************************************************************************************\
 * Purpose: To find the path through a triangle of numbers in a text file that gives the maximum sum.
 * Algorithm: 
 ****************************************************************************************************/
package maxPathSum;
import java.util.Scanner;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;

public class MaxPathSum
{
	private int matrix[][] = new int[100][100];
	private LinkedList<Integer> list = new LinkedList<Integer>();
	
	public MaxPathSum()
	{
		
	}
	/**Reads a file and sets a stack
	 * @param fileName
	 * @return
	 */
	public int[][] readFileAndSetArray(String fileName)
	{
		Scanner inputStream = null;
		try
		{
			inputStream = new Scanner(new File(fileName));
			inputStream.useDelimiter("\\s");
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("Error with: " + fileName);
		}
		@SuppressWarnings("unused")
		int temp = 0;
		while(inputStream.hasNextLine())
		{
			list.add(inputStream.nextInt());
			
		}
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		return matrix;
	}
}
