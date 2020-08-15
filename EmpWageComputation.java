public class EmpWageComputation
{
	public static void main(String[] args)
   {
		int PRESENT = 1;
		int WAGE_PER_HOUR = 20;
      int WORKING_HOURS = 8;
      int dailyWage = 0;
		int checkPresentOrAbsent = (int) (Math.random() * 2); //check employee present or not using random function

      if (checkPresentOrAbsent == PRESENT)
		{
      	dailyWage = (WAGE_PER_HOUR * WORKING_HOURS);
      } else {
         dailyWage=0;
      }
      	System.out.println("Daily Employee Wage:" + dailyWage);
   }
}
