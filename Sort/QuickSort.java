package sortAndSearch;

public class QuickSort extends Sorts
{
	/**Determines the value for where the quick sort will split
	 * @param first
	 * @param last
	 * @return
	 */
	public int split(int first, int last)
	{
		int splitVal = values[first];
		int saveF = first;
		boolean onCorrectSide;
		first++;
		do
		{
			onCorrectSide = true;
			while(onCorrectSide)
			{
				if(values[first]>splitVal)
					onCorrectSide = false;
				else
				{
					first++;
					onCorrectSide = first<=last;
				}
			}
			onCorrectSide = first<=last;
			while(onCorrectSide)
			{
				if(values[last]<=splitVal)
					onCorrectSide = false;
				else
				{
					last--;
					onCorrectSide = first<=last;
				}
				if(first<last)
				{
					swap(first,last);
					first++;
					last--;
				}
			}
		}while(first<=last);
		swap(saveF,last);
		return last;
	}
	/**Implements the quick sort algorithm
	 * @param first
	 * @param last
	 */
	public void quickSort(int first, int last)
	{
		if(first<last)
		{
			int splitPoint;
			splitPoint = split(first,last);
			quickSort(first,splitPoint-1);
			quickSort(splitPoint+1,last);
		}
	}
}
