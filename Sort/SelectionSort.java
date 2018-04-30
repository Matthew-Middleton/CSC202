package sortAndSearch;

public class SelectionSort extends Sorts
{
	/**Sets the minimum index to be used in sort()
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public int minIndex(int startIndex, int endIndex)
	{
		int indexOfMin = startIndex;
		for(int index = startIndex+1; index<=endIndex; index++)
			if(values[index]<values[indexOfMin])
				indexOfMin = index;
		return indexOfMin;
	}
	/**Sorts the array by means of selection sort
	 */
	public void selectionSort()
	{
		int endIndex = size-1;
		for(int current=0; current<endIndex; current++)
			swap(current,minIndex(current,endIndex));
	}
}
