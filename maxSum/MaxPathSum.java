/****************************************************************************************************\
 * Purpose: To find the path through a triangle of numbers in a text file that gives the maximum sum.
 * Algorithm: Read a file and set a multi-dimensional array. Take said array and from the bottom of
 * the array up and sum the corresponding value that it would link to.
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
	/**Reads a file and sets a 2-d array
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
		
		while(inputStream.hasNext())
		{
			list.add(inputStream.nextInt());
		}
		int count = 100;
		int size = list.size();
		for(int i=matrix.length-1; i>0; i--)
		{
			size -= count;
			for(int j=0; j<100; j++)
				matrix[i][j] = list.remove(size);
			count--;
		}
		System.out.println(list.size());
		return matrix;
		//need to add list elements to array
	}
	/**Returns the sum of the maximum path sum
	 * @param array
	 * @return
	 */
	public int maxPathSumAnswer(int array[][])
	{
		matrix = array;
		for(int y=matrix.length-1; y>=0; y--)
			for(int x=0; x<y; x++)
				//checks the two possible sums
				if(matrix[y+1][x]>matrix[y+1][x+1])
					matrix[y][x] += matrix[y+1][x];//choice 1
				else
					matrix[y][x] += matrix[y+1][x+1];//choice 2
		return matrix[0][0];
	}
}
