/****************************************************************************************************\
 * Purpose: To find the path through a triangle of numbers in a text file that gives the maximum sum.
 * Algorithm: Set a multi-dimensional array. Take said array and from the bottom of
 * the array up and sum the corresponding value that it would link to.
 ****************************************************************************************************/
package maxPathSum;
import java.util.Random;

public class MaxPathSum
{
	private int matrix[][] = null;
	
	public MaxPathSum()
	{
		
	}
	/**Returns the sum of the maximum path sum
	 * @param array
	 * @return
	 */
	public int maxPathSumAnswer(int array[][])
	{
		this.matrix = array;
		for(int z=matrix.length-2; z>=0; z--)
			for(int y=matrix[z].length-1; y>=0; y--)
				for(int x=0; x<y; x++)
					//checks the two possible sums
					if(matrix[y+1][x]>matrix[y+1][x+1])
						matrix[y][x] += matrix[y+1][x];//choice 1
					else
						matrix[y][x] += matrix[y+1][x+1];//choice 2
		return matrix[0][0];
	}
	/**Creates a randomly generated number array
	 * @return
	 */
	public int[][] randArray()
	{
		matrix = new int[100][];
		Random rand = new Random();
		int randVal = 0;
		for(int i=0; i<matrix.length; i++)
			matrix[i] = new int[i+1];
		for(int i=0; i<matrix.length; i++)
			for(int j=0; j<matrix[i].length; j++)
			{
				randVal = rand.nextInt(100)+1;
				matrix[i][j] = randVal;
			}
		return matrix;
	}
	/**Returns the 2d array that was previously passed or generated to the class
	 * @return
	 */
	public int[][] getArray()
	{
		return matrix;
	}
}
