import java.util.*;

interface ComputeEmpWageInterface
{
	 public void addCompany(String companyName, int empRatePerHr, int numOfWorkingDays, int maxWorkingHrs);
	 public void ComputeWage();
	 public int getTotalWage(String companyName);
}

class CompanyEmpWage
{
        public final String companyName;
        public final int empRatePerHr;
        public final int numOfWorkingDays;
        public final int maxWorkingHrs;
        public int totalWage;

        public CompanyEmpWage(String companyName, int empRatePerHr, int numOfWorkingDays, int maxWorkingHrs)
        {
                this.companyName = companyName;
                this.empRatePerHr = empRatePerHr;
                this.numOfWorkingDays = numOfWorkingDays;
                this.maxWorkingHrs = maxWorkingHrs;
		totalWage = 0;
        }

        public void setTotalEmpWage(int totalWage)
        {
                this.totalWage = totalWage;
        }
}

public class Day23EmpWageBuilder implements ComputeEmpWageInterface
{
        public static final int IS_FULL_TIME = 1;
        public static final int IS_PART_TIME = 2;

        public LinkedList< CompanyEmpWage > companyEmpWageList;
	public Map< String,CompanyEmpWage > companyEmpWageMap;
        public int numberOfCompany=0;

	public Day23EmpWageBuilder()
	{
		companyEmpWageList = new LinkedList<>();
		companyEmpWageMap = new HashMap<>();
	}

        public void addCompany(String companyName, int empRatePerHr, int numOfWorkingDays, int maxWorkingHrs)
        {
                CompanyEmpWage companyEmpWage=new CompanyEmpWage(companyName, empRatePerHr, numOfWorkingDays, maxWorkingHrs);
                companyEmpWageList.add(companyEmpWage);
		companyEmpWageMap.put(companyName,companyEmpWage);
        }


        public void ComputeWage()
        {
                for(int i=0;i<companyEmpWageList.size();i++)
                {
			CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
                        companyEmpWage.setTotalEmpWage(this.ComputeWage(companyEmpWage));
                }
        }

	public int getTotalWage(String companyName)
	{
		return companyEmpWageMap.get(companyName).totalWage;
	}

        public int ComputeWage(CompanyEmpWage companyEmpWage)
        {
                int dailyHrs = 0;
                int totalHrs = 0;

                int dailyWage;
                int totalWage = 0;

                int totalWorkingDays=0;

                while(totalHrs < companyEmpWage.maxWorkingHrs && totalWorkingDays < companyEmpWage.numOfWorkingDays)
                {
                        totalWorkingDays++;

                        int attendanceCheck=(int)(Math.floor(Math.random()*10)%3);

                        switch(attendanceCheck)
                        {
                                case IS_FULL_TIME:
                                {
                                        dailyHrs=8;
                                        break;
                                }
                                case IS_PART_TIME:
                                {
                                        dailyHrs=4;
                                        break;
                                }
                        }

                        totalHrs = totalHrs + dailyHrs;

                        dailyWage = companyEmpWage.empRatePerHr * dailyHrs;
                        totalWage = totalWage + dailyWage;

			Dictionary storeEmpDailyWage = new Hashtable();

			String result = dailyWage + ":" + totalWage;

			storeEmpDailyWage.put(totalWorkingDays, result);

			for(Enumeration i = storeEmpDailyWage.elements();i.hasMoreElements();)
			{
                        	System.out.println("Value in Dictionary for Day" + totalWorkingDays + ": "+ i.nextElement());
                        	System.out.println();
			}

                        System.out.println("Employee Hours for Day " + totalWorkingDays + " in " + companyEmpWage.companyName + ": " + dailyHrs);
                        System.out.println("Employee Wage for Day " + totalWorkingDays + " in " + companyEmpWage.companyName + ": " + dailyWage);

                        System.out.println();
                }

                System.out.println();
                System.out.println();
                System.out.println("Employee Total Hours in " + companyEmpWage.companyName + ": "  + totalHrs);
                System.out.println("Employee Total Wage in " + companyEmpWage.companyName + ": "  + totalWage);
                System.out.println();
                System.out.println();

                return totalWage;
        }

        public static void main(String[] args)
        {
                ComputeEmpWageInterface list = new Day23EmpWageBuilder();

                list.addCompany("Reliance", 20, 24, 100);
                list.addCompany("D-Mart", 25, 27, 98);

                list.ComputeWage();
		System.out.println("Employee Total Wage for Reliance: " + list.getTotalWage("Reliance"));
        }
}
