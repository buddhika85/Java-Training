class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String fName, String lName, int age) {
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Age: " + age;
    }
}