public class EncapsulationExercise {
    public static void main(String[] args) {
        Company c = new Company();

        // Print last names of all employees
        for (String lastName : c.getLastNames()) {
            System.out.println(lastName);
        }

        Employee jane = c.findByFirstName("Jane");
        if (jane != null) {
            System.out.println("The company has somebody named " + jane.firstName);
        }

    }
}

class Employee {
    String firstName, lastName;
    int id;
    boolean isCasual; // Is 'true' if employee is casual (i.e. not full-time)

    Employee(String firstName, String lastName, int id, boolean isCasual) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.isCasual = isCasual;
    }
}

class Company {
    Employee[] employees;

    Company() {
        this.employees = new Employee[3];
        this.employees[0] = new Employee("Steve", "Jobs", 1, false);
        this.employees[1] = new Employee("Jane", "Austen", 2, false);
        this.employees[2] = new Employee("Gaius", "Octavius", 3, true);
    }

    public String toString() {
        // Note: '\n' is the so-called 'newline' character, which allows you to display
        // strings with
        // multiple lines.
        String s = "Company Inc: Employee list\n";
        for (Employee e : this.employees) {
            s += " - " + e.toString() + "\n";
        }

        return s;
    }

    // This method returns the last names of all employees in the company
    public String[] getLastNames() {
        String[] lastNames = new String[this.employees.length];
        int i = 0;
        for (Employee e : this.employees) {
            lastNames[i] = e.lastName;
            i++;
        }
        return lastNames;
    }

    // Returns the first Employee object with the given first name. If the name
    // can't be found, return null.
    public Employee findByFirstName(String firstName) {
        for (Employee e : this.employees) {
            if (e.firstName.equals(firstName)) {
                return e;
            }
        }

        return null;
    }

}