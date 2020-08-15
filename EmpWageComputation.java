public class EmpWageComputation
{
	public static void main(String[] args)
	{
		final int FULLTIME = 1;
		final int PARTTIME = 0;
		int WORKINGDAYS_PER_MONTH = 20;
       		int WAGE_PER_HOUR = 20;
       		int workingHours = 8;
       		int monthlyWage = 0;
		int totalDays = 0;
		int totalHours = 0;

		while (totalDays < WORKINGDAYS_PER_MONTH) {
			totalDays++;

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

			totalHours = totalHours+workingHours;
		}

		monthlyWage = (WAGE_PER_HOUR * totalHours);
		System.out.println("Monthly Employee Wage:" + monthlyWage);
    	}
}
