public class Day23EmpWageBuilder
{
	private static final int FULL_TIME = 1;
	private static final int PART_TIME = 0;

    	private final String companyName;
    	private final int wagePerHour;
    	private final int workingDaysPerMonth;
    	private final int maxHours;

    	public Day23EmpWageBuilder(String companyName, int wagePerHour, int workingDaysPerMonth, int maxHours)
	{
        	this.companyName = companyName;
        	this.wagePerHour = wagePerHour;
        	this.workingDaysPerMonth = workingDaysPerMonth;
        	this.maxHours = maxHours;
    	}

    	public void get_EmployeeWageForCompany()
	{
        	int totalWage = 0;
        	int dailyWage = 0;
        	int totalDays = 0;
        	int totalHours = 0;
        	int workingHours = 0;

        	while (totalDays <= workingDaysPerMonth && totalHours < maxHours)
		{
            		totalDays++;
            		int checkWorking = (int) (Math.random() * 3);
            		switch (checkWorking)
			{
                		case FULL_TIME:
                    			workingHours = 8;
                    			break;
                		case PART_TIME:
                    			workingHours = 4;
                    			break;
                		default:
                    			workingHours = 0;
            		}
            		dailyWage = (wagePerHour * workingHours);
            		System.out.println("Day " + totalDays + " Employee Wage for Company " + companyName + " is " + dailyWage);
            		totalWage += dailyWage;
        	}
        	System.out.println("Total Employee Wage for " + companyName + " is " + totalWage);
    	}

    	public static void main(String[] args)
	{
        	System.out.println("Welcome to Employee Wage Computation");
       	 	Day23EmpWageBuilder employeeWageBuilder = new Day23EmpWageBuilder("Reliance", 20, 20, 50);
        	employeeWageBuilder.get_EmployeeWageForCompany();
    	}
}
