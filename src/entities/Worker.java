package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private Department department;
	
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
		
	}
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.setDepartment(department);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public List<HourContract> getContracts() {
		return contracts;
	}
	
	
	//Methods
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(int month, int year) {
		Double totalIncome = baseSalary;
		
		for (HourContract contract : contracts) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(contract.getDate());
			int contractMonth = calendar.get(Calendar.MONTH) + 1;
			int contractYear = calendar.get(Calendar.YEAR);		
			
			if (month == contractMonth && year == contractYear) {
				totalIncome += contract.totalValue();
			}
					
		}
		
		return totalIncome;
	}



}