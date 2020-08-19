public class Day22EmployeeWageBuilder
{
	public static final int FULL_TIME = 1;
	public static final int PART_TIME = 2;

	public static void computeEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHours)
	{
		int empHours = 0;
		int totalWage = 0;
		int totalWorkingDays = 0;
		int totalEmpHrs = 0;

		while(totalWorkingDays < numOfWorkingDays && totalEmpHrs < maxHours)
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
			totalEmpHrs+= empHours;
		}
		totalWage = totalEmpHrs*empRatePerHour;
		System.out.println("Total Employee Hours:" + totalEmpHrs);
		System.out.println("Total Employee Wage for " + company + " is " + totalWage);
	}

	public static void main(String[] args)
	{
		computeEmpWage("Reliance", 20, 20, 50);
		computeEmpWage("Deloitte", 25, 20, 100);
	}
}
