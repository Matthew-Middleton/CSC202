package sortAndSearch;
import java.util.*;
import java.text.DecimalFormat;

public class Sorts
{
	protected final int size = 50;
	protected int values[] = new int[size];
	/**Initialize array with random values
	 */
	public void initValues()
	{
		Random rand = new Random();
		for(int index=0; index<size; index++)
			values[index] = Math.abs(rand.nextInt())%100;
	}
	/**Checks if the array is sorted
	 * @return
	 */
	public boolean isSorted()
	{
		for(int index=0; index<size-1; index++)
			if(values[index]>values[index+1])
				return false;
		return true;
	}
	/**Swaps the positions of the indices
	 * @param index1
	 * @param index2
	 */
	public void swap(int index1, int index2)
	{
		int temp = values[index1];
		values[index1] = values[index2];
		values[index2] = temp;
	}
	/**Prints the values of the array
	 */
	public void printValues()
	{
		int value;
		DecimalFormat format = new DecimalFormat("00");
		System.out.println("Values:");
		for(int index=0; index<size; index++)
		{
			value = values[index];
			if((index+1)%10==0)
				System.out.println(format.format(value));
			else
				System.out.print(format.format(value) + " ");
		}
	}
}
