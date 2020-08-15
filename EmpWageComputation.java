public class EmpWageComputation
{
	public static void main(String[] args)
	{
    		int PRESENT = 1;

		int checkPresentOrAbsent = (int) (Math.random() * 2);

		if (checkPresentOrAbsent == PRESENT)
			System.out.print("Employee is present");
		else
			System.out.println("Employee is absent");
	}
}
