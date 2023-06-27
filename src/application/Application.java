package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Application {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String dep = sc.next();
		
		Department department = new Department(dep); 
		
		System.out.println("Enter worker data:");
		
		System.out.print("Name: ");
		String name = sc.next();
		
		System.out.print("Level: ");
		String level = sc.next();
		
		System.out.print("Base salary: ");
		Double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, department);
		
		System.out.print("Home many contracts to this worker? ");
		Integer conQty = sc.nextInt();
		
		for (int i=0; i<conQty; i++) {
			System.out.printf("Enter contract #%d data:\n", i+1);
			System.out.print("Date (dd/mm/yyyy): ");
			Date date = sdf.parse(sc.next());
			
			System.out.print("Value per hour: ");
			Double vph = sc.nextDouble();
			
			System.out.print("Duration: ");
			Integer hours = sc.nextInt();
			
			HourContract contract = new HourContract(date, vph, hours);
			worker.addContract(contract);
		}
		
		System.out.print("Enter month and year to calculate total income (mm/yyyy): ");
		String monthYear = sc.next();
		
		int month = Integer.parseInt(monthYear.substring(0, 2));
		int year = Integer.parseInt(monthYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment());
		System.out.printf("Income for %s: %.2f", monthYear, worker.income(month, year));
		
		sc.close();
	}

}
