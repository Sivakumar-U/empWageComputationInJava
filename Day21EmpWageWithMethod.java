public class Day21EmpWageWithMethod
{
	private static final int FULL_TIME = 1;
	private static final int PART_TIME = 0;
	private static final int WORKING_DAYS_PER_MONTH = 20;
	private static final int WAGE_PER_HOUR = 20;
	private static final int TOTAL_HOURS = 100;

	public static void computeEmpWage()
	{
		int monthlyWage = 0;
		int totalWorkingDays = 0;
		int empHours = 0;
		int totalEmpHours = 0;

		while (totalWorkingDays < WORKING_DAYS_PER_MONTH && totalEmpHours < TOTAL_HOURS)
		{
			totalWorkingDays++;
			int randomCheck = (int) (Math.random() * 3);
			switch (randomCheck)
			{
				case FULL_TIME:
					empHours = 8;
					break;
				case PART_TIME:
					empHours = 4;
					break;
				default:
					empHours = 0;
			}
			totalEmpHours=totalEmpHours+empHours;
		}

		monthlyWage = (WAGE_PER_HOUR * totalEmpHours);
		System.out.println("Total Employee Hours:" + totalEmpHours);
		System.out.println("Monthly Employee Wage :" + monthlyWage);
	}

	public static void main(String[] args)
	{
		computeEmpWage();
	}
}
