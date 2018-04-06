/****************************************************************************\
 * Purpose: To be able differentiate between a mammal and another animal
 * Algorithm: Read a file line and make it a String. While reading the file
 * convert the string at a point to a char and determine if it is Alphabetic
 * or numerical; if alphabetical concatenate it, if numerical push it on a stack
 ****************************************************************************/
package animalsHash;
import dataStructure.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DifferentiateMammal
{
	private String name;
	/*array point is based on order according to the following for data: hair, feathers, eggs, milk, airborne, aquatic,
	 *  redator, toothed, backbone, breathes, venomous, fins, legs, tail, domestic, catsize, type; legs set:{0,2,4,5,6,8}, 
	 *  type range:[1,7];*/
	private String data[];
	private HashMap<String,String[]> animal;
	private ArrayList<String> list;
	
	public DifferentiateMammal()
	{
		name = "";
		data = new String[17];//size of data set
		animal = new HashMap<String,String[]>();
	}
	/**Takes a file name and scans through the file while setting the animal names into a 
	 * @param fileName
	 */
	public void readAndSetFile(String fileName)
	{
		Scanner inputStream = null;
		try
		{
			inputStream = new Scanner(new File(fileName));
			inputStream.useDelimiter("[\\,.\\n.]");
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("Error opening " + fileName);
			System.exit(1);
		}
		String temp = "";
		list = new ArrayList<String>();
		while(inputStream.hasNextLine())
		{
			temp = inputStream.next();
			list.add(temp);
			if(list.size()==18)
			{
				name = list.get(0);
				data = list.toArray(new String[0]);
				this.animal.put(name, data);
				list.clear();
				//issue with data being accessed
			}
		}
		inputStream.close();
	}
	/**Implements the isMammal method
	 * @param animal
	 * @return
	 */
	public String determine(String creature)
	{
		if(!animal.contains(creature))
			return "That animal is not in our system.";
		if(isMammal(creature))
			return creature + " is a mammal.";
		else
			return creature + " is not a mammal.";
	}
	/**Returns whether the animal is a mammal or not
	 * Operational definition: mammal = hair, milk, and backbone
	 * 	based of file parameters
	 * @return
	 */
	public boolean isMammal(String key)
	{
		data = animal.get(key);
		if(data[1].equals("1")&&data[4].equals("1")&&data[9].equals("1"))//data[1]=hair, data[4]=milk, data[9]=backbone
			return true;
		else
			return false;
	}
	/**Returns the hash map associated with this object
	 * @return
	 */
	public HashMap<String,String[]> getHashMap()
	{
		return animal;
	}
}










