package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	private final Map<String, Student> Data;
	
	public UniversityDatabase() {
		Data = new HashMap<>();
	}
	
	public void addStudent(String accountName, Student student) {
		Data.put(accountName, student);
	}

	public int getStudentCount() {
		return Data.size();
	}

	public String lookupFullName(String accountName) {
		if (Data.get(accountName) != null)
			return Data.get(accountName).getFullName();
		else
			return null;
	}

	public double getTotalBearBucks() {
		double Balance= 0;
		for(String name : Data.keySet()) {
			Balance += Data.get(name).getBearBucksBalance();
		}
		return Balance;
	}
}
