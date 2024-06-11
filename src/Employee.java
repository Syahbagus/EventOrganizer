public class Employee extends Person {
    private String department;

    public Employee(String name, String email, String department) {
        super(name, email);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
