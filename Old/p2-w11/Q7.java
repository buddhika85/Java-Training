import java.util.ArrayList;

public class Q7 {
    
}


interface StudentFeatures 
{
// Method to get the student's name
String getName();
// Method to calculate the student's maximum grade
double calculateMaximumGrade();
}

class StudentQ7 implements StudentFeatures
{
	private String name;
	private ArrayList<Double> grades;

	public StudentQ7(String name, ArrayList<Double> grades)
	{
		this.name = name;
		this.grades = grades;
	}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calculateMaximumGrade() {
        double max = 0.0;
        for (Double grade : grades) {
            if (grade > max)
                max = grade;
        }
        return max;
    }

    
}
