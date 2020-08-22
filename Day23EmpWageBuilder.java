public class Day23EmpWageBuilder
{
	//constant
   	final static int IS_FULL_TIME=1;
   	final static int IS_PART_TIME=2;

	//class variables
	public int empRate, numberOfDays, numberOfHrs, totalWages;
	public String company;

	//constructor
	public Day23EmpWageBuilder(String companyName,int rate,int days,int hrs)
	{
		this.company=companyName;
		this.empRate=rate;
		this.numberOfDays=days;
		this.numberOfHrs=hrs;
	}

   	//return empHrs
   	public int getHour()
   	{
		int attendence=(int)(Math.random()*10)%3;
      		int empHrs=0;

      		switch(attendence)
      		{
         		case IS_FULL_TIME:
            			empHrs=8;
            			break;
         		case IS_PART_TIME:
            			empHrs=4;
            			break;
         		default:
            			empHrs=0;
            			break;
      		}
      		return empHrs;
   	}

   	//return daily empWage
   	public int getDailyWage(int hrs)
   	{
      		return (hrs*empRate);
   	}

	//compute employ wage
	public void computeEmployWage()
	{
		int totalWorkingDay=0, totalWorkingHrs=0 , hours;

		//find totalWorkingHrs
		while(totalWorkingHrs<numberOfHrs && totalWorkingDay<numberOfDays)
      		{
			hours=getHour();
         		totalWorkingHrs=totalWorkingHrs+hours;
			System.out.println(company+" Employee Wage for day "+(++totalWorkingDay)+" : "+getDailyWage(hours));
      		}
		//calculate total wage
		totalWages=getDailyWage(totalWorkingHrs);
		System.out.println();
	}

	public void totalEmployWage()
	{
		System.out.println(company+" Total Employee Wage for month : "+ totalWages);
	}

	public static void main(String args[])
   	{
		//create instance
      		Day23EmpWageBuilder jio= new Day23EmpWageBuilder("Relance jio",20,10,100);
      		Day23EmpWageBuilder tcs= new Day23EmpWageBuilder("TCS",15,10,100);
      		jio.computeEmployWage();
      		tcs.computeEmployWage();
		jio.totalEmployWage();
		tcs.totalEmployWage();
   	}
}
