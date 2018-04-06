package dataStructure;
import java.util.Comparator;
import java.util.ArrayList;

public class HeapList<T>
{
	protected ArrayList<T> elements;
	protected int lastIndex, maxIndex;
	protected Comparator<T> comp;
	//Precondition: T implements Comparable
	public HeapList(int maxSize)
	{
		elements = new ArrayList<T>(maxSize);
		lastIndex = -1;
		maxIndex = maxSize-1;
		comp = new Comparator<T>()
		{
			@SuppressWarnings("unchecked")
			public int compare(T element1, T element2)
			{
				return ((Comparable<T>)element1).compareTo(element2);
			}
		};
	}
	//Precondition: T implements Comparable
	public HeapList(int maxSize, Comparator<T> comp)
	{
		elements = new ArrayList<T>(maxSize);
		lastIndex = -1;
		maxIndex = maxSize-1;
		this.comp = comp;
	}
	/**Returns true if the heap is empty
	 *  returns false otherwise
	 * @return
	 */
	public boolean isEmpty()
	{
		return lastIndex==-1;
	}
	/**Returns true if the heap is full
	 * 	returns false otherwise
	 * @return
	 */
	public boolean isFull()
	{
		return lastIndex==maxIndex;
	}
	/**Returns the number of elements within the heap
	 * @return
	 */
	public int size()
	{
		return lastIndex+1;
	}
	/**If the priority queue is full prints message, otherwise adds element to the priority queue
	 * @param element
	 */
	public void enqueue(T element)
	{
		if(lastIndex==maxIndex)
			System.out.println("Priority queue is full");
		lastIndex++;
		elements.add(lastIndex, element);
		reheapUp(element);
	}
	/**Inserts element into the tree and ensures shape and order properties.
	 * @param element
	 */
	private void reheapUp(T element)
	{
		int hole = lastIndex;
		while(hole>0&&comp.compare(element, elements.get((hole-1)/2))>0)
		{
			elements.set(hole, elements.get((hole-1)/2));
			hole = (hole-1)/2;
		}
		elements.set(hole, element);
	}
	/**Returns null if the priority queue is empty, otherwise removes element with highest priority form this
	 * priority queue and returns it
	 * @return
	 */
	public T dequeue()
	{
		T hold;//element to be returned
		T toMove;//element to reheap
		if(lastIndex==-1)
			return null;
		hold = elements.get(0);
		toMove = elements.remove(lastIndex);
		lastIndex--;
		if(lastIndex!=-1)
			reheapDown(toMove);//restore heap properties
		return hold;
	}
	/**Inserts element into the tree and ensures shape and order properties
	 * @param element
	 */
	private void reheapDown(T element)
	{
		int hole = 0;
		int next;
		next = newHole(hole,element);//find next
		while(next!=hole)
		{
			elements.set(hole, elements.get(next));//up
			hole = next;//down
			next = newHole(hole, element);//find next
		}
		elements.set(hole, element);
	}
	/**If either child of hole is larger than element, return the index of the larger child,
	 * otherwise return the index of hole
	 * @param hole
	 * @param element
	 * @return
	 */
	private int newHole(int hole, T element)
	{
		int left = hole*2+1;
		int right = hole*2+2;
		if(left>lastIndex)
			//hole has left child only
			return hole;
		else if(left==lastIndex)
			if(comp.compare(element, elements.get(left))<0)
				//element<left child
				return left;
			else
				//element>= left child
				return hole;
		else if(comp.compare(elements.get(left), elements.get(right))<0)
			//hole has two children
			if(comp.compare(elements.get(right), element)<=0)
				//right child<=element
				return hole;
			else
				//element<right child
				return right;
		else if(comp.compare(elements.get(left), element)<=0)
			//left child<=element
			return hole;
		else
			//element<left child
			return left;
	}
	/**Returns a string of all the elements in the list
	 * @return
	 */
	public String toString()
	{
		String heap = new String();
		for(int i=0; i<=lastIndex; i++)
			heap = heap + elements.get(i) + "\n";
		return heap;
	}
}





