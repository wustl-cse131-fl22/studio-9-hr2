package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.
public class Student {
	private String firstName;
	private String lastName;
	private int id;
	private double totalGradeQualityPoints;
	private int totalAttemptedCredits;
	private int totalPassingCredits;
	private double bearBucksBalance;


	// Constructors
	public Student(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.totalGradeQualityPoints = 0;
		this.totalAttemptedCredits = 0;
		this.totalPassingCredits = 0;
		this.bearBucksBalance = 0;
		//this.calculateGradePointAverage = calculateGradePointAverage;
	}
	
	// get Names
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	// Get id 
	public int getId () {
		return id;
	}
	
	// Calculate GPA
	public void submitGrade(double grade, int credits) {
		totalGradeQualityPoints += grade*credits;
		totalAttemptedCredits += credits;
		if (grade > 1.7)
			totalPassingCredits += credits;
			
	}
	public int getTotalAttemptedCredits() {
		return totalAttemptedCredits;
	}
	public double calculateGradePointAverage() {
		return totalGradeQualityPoints / totalAttemptedCredits;
	}
	
	// Passing Credits
	
	public String getClassStanding() {
		if (totalPassingCredits < 30)
			return "First Year";
		else if (totalPassingCredits >= 30 && totalPassingCredits < 60)
			return "Sophomore";
		else if (totalPassingCredits >= 60 && totalPassingCredits < 90)
			return "Junior";
		else
			return "Senior";
	}
	public int getTotalPassingCredits() {
		return totalPassingCredits;
	}
	
	// Phi Beta Kappa
	public boolean isEligibleForPhiBetaKappa() {
		if ((totalPassingCredits >= 98 && this.calculateGradePointAverage() >= 3.6)||(totalPassingCredits >= 75 && this.calculateGradePointAverage() >= 3.8))
			return true;	
		else
			return false;
	}
	
	// bear bucks balance
	public void depositBearBucks(double amount) {
		bearBucksBalance += amount;
	}
	public void deductBearBucks(double amount) {
		bearBucksBalance -= amount;
	}
	public double getBearBucksBalance() {
		return bearBucksBalance;
	}
	public double cashOutBearBucks() {
		if (bearBucksBalance >10) {
			double newbbb = bearBucksBalance; // we need to set up a new variable to store the balance and then change balance to 0
			bearBucksBalance = 0; 
			return newbbb - 10;
		}
		else
			bearBucksBalance = 0;
			return 0;
	}
	
	// Legacy
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		String cLastName = ""; // create a new string of child last name
		
		if (isHyphenated == true) {
				String mLastName = other.getLastName();
				cLastName = this.getLastName() + "-" + mLastName; // his last name should be father's last name + mother's last name
		}
		else {
			cLastName = this.getLastName(); //only father's last name
		}
		Student child = new Student(firstName,cLastName,id); // create a new child student so that we can transfer the balance 
		child.depositBearBucks(this.cashOutBearBucks() + other.cashOutBearBucks()); // deposit the balance in to child's account
		return child;
	}
	
	// 
	public String toString() {
		return this.getFullName() + " " + this.getId();
	}
	
// main method to test	
	public static void main(String[] args) {
		Student student1 = new Student("Shengyuan", "Luo", 504673);
		student1.submitGrade(3.8, 3);
		System.out.println(student1.getFullName());	
		System.out.println(student1.getId());
		System.out.println(student1.calculateGradePointAverage());
		System.out.println(student1.getClassStanding());
	}
}

