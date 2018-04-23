/****************************************************************************************************\
 * Purpose: To find the path through a triangle of numbers in a text file that gives the maximum sum.
 * Algorithm: 
 ****************************************************************************************************/
package maxPathSum;
import java.util.Scanner;
import java.util.ArrayList;
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
			inputStream.useDelimiter("\\s+");
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("Error with: " + fileName);
		}
		int y = 0;
		while(inputStream.hasNextLine())
		{
			list.add(inputStream.nextInt());
			if(list.size()==y)
			{
				for(int i=0; i<list.size(); i++)
					matrix[y][i] = list.get(i);
				list.clear();
				y++;
			}
		}
		return matrix;
	}
	/**Returns the sum of the maximum path sum
	 * @param array
	 * @return
	 */
	public int maxPathSumAnswer(int array[][])
	{
		matrix = array;
		for(int y=matrix.length; y>=0; y--)
			for(int x=0; x<y; x++)
				//checks the two possible sums
				if(matrix[y+1][x]>matrix[y+1][x+1])
					matrix[y][x] += matrix[y+1][x];//choice 1
				else
					matrix[y][x] += matrix[y+1][x+1];//choice 2
		return matrix[0][0];
	}
}
