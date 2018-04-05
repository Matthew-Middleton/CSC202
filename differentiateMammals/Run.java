package animalsHash;
import java.util.Scanner;

public class Run
{
	public Run()
	{
		
	}
	/**To be called in the main; runs the program.
	 */
	public void run()
	{
		System.out.println(greeting());
		runner();
	}
	/**Greeting/instructions; implemented in run()
	 * @return
	 */
	private String greeting()
	{
		return "Hello. Type in the name of the animal that you wish to determine whether it is a mammal or not.\nEnter \"exit\" to exit the program";
	}
	/**Holds the routines for the program; implemented in run()
	 */
	private void runner()
	{
		DifferentiateMammal diff = new DifferentiateMammal();
		//modify code below for where file is located on YOUR computer
		diff.readAndSetFile("C:\\Users\\Matthew Middleton\\workspace\\CSC_202\\src\\animalsHash\\animals.txt");
		Scanner input = new Scanner(System.in);
		String key = input.nextLine();
		if(key.equalsIgnoreCase("exit"))
		{
			System.out.println("ENDING PROGRAM");
			System.exit(0);
		}
		System.out.println(diff.determine(key));
		System.out.println("Enter another animal.");
		runner();
		input.close();
	}
}
