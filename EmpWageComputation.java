public class EmpWageComputation
{
	public static void main(String[] args)
	{
		final int FULLTIME = 1;
		final int PARTTIME = 0;
       		int WAGE_PER_HOUR = 20;
       		int workingHours = 8;
       		int dailyWage = 0;

		int checkWorking = (int) (Math.random() * 3);

		switch (checkWorking) {
			case FULLTIME:
				workingHours = 8;
				break;
			case PARTTIME:
				workingHours = 4;
				break;
			default:
				workingHours = 0;
		}

		dailyWage = (WAGE_PER_HOUR * workingHours);
		System.out.println("Daily Employee Wage:" + dailyWage);
    	}
}
