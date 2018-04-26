/****************************************************************************************************\
 * Purpose: To find the path through a triangle of numbers in a text file that gives the maximum sum.
 * Algorithm: Read a file and set a multi-dimensional array. Take said array and from the bottom of
 * the array up and sum the corresponding value that it would link to.
 ****************************************************************************************************/
package maxPathSum;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class MaxPathSum
{
	private Integer matrix[][] = new Integer[100][100];
	private ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	
	public MaxPathSum()
	{
		
	}
	/**Reads a file and sets a 2-d array
	 * @param fileName
	 * @return
	 */
	public Integer[][] readFileAndSetArray(String fileName)
	{
		BufferedReader reader = null;
		Scanner inputStream = null;
		try
		{
			reader = new BufferedReader(new FileReader(fileName));
			inputStream = new Scanner(reader);
			inputStream.useDelimiter("\\s+");
			while(inputStream.hasNextLine())
			{
				int row[] = new int[matrix.length];
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for(int i=0; i<matrix.length; i++)
					row[i] = inputStream.nextInt();
				for(int i=0; i<row.length; i++)
					temp.add(row[i]);
				list.add(temp);
			}
			/*inputStream = new Scanner(new File(fileName));
			inputStream.useDelimiter("\\s+");*/
			inputStream.close();
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("Error with: " + fileName);
		}
		/*int size = list.size();
		for(int i=matrix.length-1; i>0; i--)
		{
			size -= count;
			for(int j=0; j<100; j++)
				matrix[i][j] = list.remove(size);
			count--;
		}*/
		matrix = toArray(list);
		return matrix;
	}
	/**Returns the sum of the maximum path sum
	 * @param array
	 * @return
	 */
	public int maxPathSumAnswer(Integer array[][])
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
	
	public Integer[][] toArray(ArrayList<ArrayList<Integer>> container)
	{
		Integer[][] array = new Integer[container.size()][];
		for (int i = 0; i < container.size(); i++)
		{
		    ArrayList<Integer> row = container.get(i);
		    array[i] = row.toArray(new Integer[row.size()]);
		}
		return array;
	}
}

