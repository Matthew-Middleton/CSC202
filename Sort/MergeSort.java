package sortAndSearch;

public class MergeSort extends Sorts
{
	/**Where the merge sort will split, sort, and then merge the array
	 * @param leftFirst
	 * @param leftLast
	 * @param rightFirst
	 * @param rightLast
	 */
	public void merge(int leftFirst, int leftLast, int rightFirst, int rightLast)
	{
		int tempArray[] = new int[size];
		int index = leftFirst;
		int saveFirst = leftFirst;//where to copy back
		while(leftFirst<=leftLast&&rightFirst<=rightLast)
		{
			if(values[leftFirst]<values[rightFirst])
			{
				tempArray[index] = values[leftFirst];
				leftFirst++;
			}
			else
			{
				tempArray[index] = values[rightFirst];
				rightFirst++;
			}
			index++;
		}
		while(leftFirst<=leftLast)
		{
			tempArray[index] = values[leftFirst];
			leftFirst++;
			index++;
		}
		while(rightFirst<=rightLast)
		{
			tempArray[index] = values[rightFirst];
			rightFirst++;
			index++;
		}
		for(index=saveFirst; index<=rightLast; index++)
			values[index] = tempArray[index];
	}
	/**Sorts the array by the merge sort algorithm
	 * @param first
	 * @param last
	 */
	public void mergeSort(int first, int last)
	{
		if(first<last)
		{
			int middle = (first+last)/2;
			mergeSort(first,middle);
			mergeSort(middle+1,last);
			merge(first,middle,middle+1,last);
		}
	}
}
