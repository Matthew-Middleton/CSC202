package sortAndSearch;

public class InsertionSort extends Sorts
{
	/**Sorts from start to finish, starting at index 1
	 * @param startIndex
	 * @param endIndex
	 */
	public void insertElement(int startIndex, int endIndex)
	{
		boolean finished = false;
		int current = endIndex;
		boolean moreToSearch = true;
		while(moreToSearch&&!finished)
		{
			if(values[current]<values[current-1])
			{
				swap(current,current-1);
				current--;
				moreToSearch = current!=startIndex;
			}
			else
				finished = true;
		}
	}
	/**Sorts the array by the insertion sort algorithm
	 */
	public void insertionSort()
	{
		for(int count=1; count<size; count++)
			insertElement(0,count);
	}
}
