interface ComputeEmpWageInterface
{
	 public void addCompany(String companyName, int empRatePerHr, int numOfWorkingDays, int maxWorkingHrs);
	 public void ComputeWage();
}

class CompanyEmpWage
{
        public final String companyName;
        public final int empRatePerHr;
        public final int numOfWorkingDays;
        public final int maxWorkingHrs;
        public int empTotalWage;

        public CompanyEmpWage(String companyName, int empRatePerHr, int numOfWorkingDays, int maxWorkingHrs)
        {
                this.companyName = companyName;
                this.empRatePerHr = empRatePerHr;
                this.numOfWorkingDays = numOfWorkingDays;
                this.maxWorkingHrs = maxWorkingHrs;
        }

        public void setTotalEmpWage(int empTotalWage)
        {
                this.empTotalWage = empTotalWage;
        }
}

public class Day23EmpWageBuilder implements ComputeEmpWageInterface
{
        public static final int IS_FULL_TIME = 1;
        public static final int IS_PART_TIME = 2;

        public CompanyEmpWage[] companyEmpWageArray;
        public int numberOfCompany;


        public Day23EmpWageBuilder()
        {
                companyEmpWageArray = new CompanyEmpWage[4];
        }


        public void addCompany(String companyName, int empRatePerHr, int numOfWorkingDays, int maxWorkingHrs)
        {
                companyEmpWageArray[numberOfCompany]=new CompanyEmpWage(companyName, empRatePerHr, numOfWorkingDays, maxWorkingHrs);
                numberOfCompany++;
        }


        public void ComputeWage()
        {
                for(int i=0;i<numberOfCompany;i++)
                {
                        companyEmpWageArray[i].setTotalEmpWage(this.ComputeWage(companyEmpWageArray[i]));
                }
        }


        public int ComputeWage(CompanyEmpWage companyEmpWage)
        {
                int DailyHrs = 0;
                int TotalHrs = 0;

                int DailyWage;
                int TotalWage = 0;

                int totalWorkingDays=0;

                while(TotalHrs < companyEmpWage.maxWorkingHrs && totalWorkingDays < companyEmpWage.numOfWorkingDays)
                {
                        totalWorkingDays++;

                        int attendanceCheck=(int)(Math.floor(Math.random()*10)%3);

                        switch(attendanceCheck)
                        {
                                case IS_FULL_TIME:
                                {
                                        DailyHrs=8;
                                        break;
                                }
                                case IS_PART_TIME:
                                {
                                        DailyHrs=4;
                                        break;
                                }
                        }

                        TotalHrs = TotalHrs + DailyHrs;

                        DailyWage = companyEmpWage.empRatePerHr * DailyHrs;
                        TotalWage = TotalWage + DailyWage;

                        System.out.println("Employee Hours for Day " + totalWorkingDays + " in " + companyEmpWage.companyName + ": " + DailyHrs);
                        System.out.println("Employee Wage for Day " + totalWorkingDays + " in " + companyEmpWage.companyName + ": " + DailyWage);

                        System.out.println();
                }

                System.out.println();
                System.out.println();
                System.out.println("Employee Total Hours in " + companyEmpWage.companyName + ": "  + TotalHrs);
                System.out.println("Employee Total Wage in " + companyEmpWage.companyName + ": "  + TotalWage);
                System.out.println();
                System.out.println();

                return TotalWage;
        }



        public static void main(String[] args)
        {
                ComputeEmpWageInterface array = new Day23EmpWageBuilder();

                array.addCompany("Reliance", 20, 24, 100);
                array.addCompany("D-Mart", 25, 27, 98);

                array.ComputeWage();
        }
}
