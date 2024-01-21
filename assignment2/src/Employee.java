public class Employee extends Person{
    private String position;
    private double salary;
    String toStrng()
    {
        return "Employee: " + getID() + ". " + getName() + " " + getSurname();
    }
    String getPosition()
    {
        return position;
    }
    void setPosition(String Position)
    {
        position = Position;
    }
    double getSalary()
    {
        return salary;
    }
    void setSalary(double Salary)
    {
        salary = Salary;
    }
    Employee(){

    }
    Employee(String Name, String Surname, String Position, double Salary){
        setName(Name);
        setSurname(Surname);
        setPosition(Position);
        setSalary(Salary);
    }
    public double getPaymentAmount() {
        return salary;
    }
}
