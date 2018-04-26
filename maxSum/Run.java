package maxPathSum;

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
		return "Hello. This program will determine the maximum possible path sum out of the given file.";
	}
	/**The meat of the program(where everything occurs); implemented in run()
	 */
	private void runner()
	{
		MaxPathSum max = new MaxPathSum();
		System.out.println("The sum of the maximum path is: " + max.maxPathSumAnswer(max.randArray()));	
	}
}
