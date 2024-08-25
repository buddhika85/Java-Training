import java.util.ArrayList;
import java.util.Arrays;

public class Q7 
{
	public static void main(String[] args) 
	{
		Double[] grades = {95.0,85.0,89.0,96.0};
		ArrayList<Double> list = new ArrayList<>(Arrays.asList(grades));
		Student student = new Student("John", list);
		System.out.println(student.getName() + "'s highest grade is " + student.calculateMaximumGrade());
	}
}

interface StudentFeatures {
	// Method to get the student's name
	String getName();// Method to calculate the student's maximum grade

	double calculateMaximumGrade();
}

class Student implements StudentFeatures 
{
	private String name;
	private ArrayList<Double> grades;

	public Student(String name, ArrayList<Double> grades) 
	{
		this.name = name;
		this.grades = grades;
	}

	@Override
	public String getName() 
	{
		return this.name;
	}

	@Override
	public double calculateMaximumGrade() 
	{
		double maxGrade = -1; // indicates not found
		for (double grade : grades) 
		{
			if (grade > maxGrade) 
			{
				maxGrade = grade;
			}
		}
		return maxGrade;
	}
}
