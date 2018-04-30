package sortAndSearch;

public class BubbleSort extends Sorts
{
	/**Swaps the pairs that are out of order from beginning to end starting at the end
	 * @param startIndex
	 * @param endIndex
	 */
	public void bubbleUp(int startIndex, int endIndex)
	{
		for(int index=endIndex; index>startIndex; index--)
			if(values[index]<values[index-1])
				swap(index,index-1);
	}
	/**Sorts the array by the bubble sort algorithm
	 */
	public void bubbleSort()
	{
		int current = 0;
		while(current<size-1)
		{
			bubbleUp(current, size-1);
			current++;
		}
	}
	/**Operates the same as bubbleUp(), except returns false if a swap was made
	 * otherwise returns true
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public boolean bubbleUp2(int startIndex, int endIndex)
	{
		boolean sorted = true;
		for(int index=endIndex; index>startIndex; index--)
			if(values[index]<values[index-1])
			{
				swap(index,index-1);
				sorted=false;
			}
		return sorted;
	}
	/**Sorts the array by the bubble sort algorithm, but stops as soon as it is finished
	 */
	public void shortBubble()
	{
		int current = 0;
		boolean sorted = false;
		while(current<size-1&&!sorted)
		{
			sorted = bubbleUp2(current,size-1);
			current++;
		}
	}
}
