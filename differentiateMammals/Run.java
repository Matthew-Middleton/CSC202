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
		return "Hello. Type in the name of the animal that you wish to determine mammalian classification.\nEnter \"exit\" to exit the program";
	}
	/**Holds the routines for the program; implemented in run()
	 */
	private void runner()
	{
		DifferentiateMammal diff = new DifferentiateMammal();
		diff.readAndSetFile("animals.txt");
		Scanner input = new Scanner(System.in);
		String key = input.nextLine();
		if(key.equalsIgnoreCase("exit"))
		{
			System.out.println("ENDING PROGRAM");
			System.exit(0);
		}
		if(diff.isMammal(key))
			System.out.println(key + "is a mammal.");
		else
			System.out.println(key + "is not a mammal.");
		System.out.println("Continue?\nEnter: y/n");
		if(key.equalsIgnoreCase("y"))
			runner();
		input.close();
		System.exit(0);
		System.out.println("CLOSING");
	}
}
