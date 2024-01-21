public class Student extends Person{
    private double gpa;
    String Tostrng(){
        return "Student: " + getID() + ". " + getName() + " " + getSurname();
    }
    double getGPA(){
        return gpa;
    }
    void setGPA(double GPA){
        gpa = GPA;
    }
    Student(){

    }
    Student(String Name, String Surname, double GPA){
        setName(Name);
        setSurname(Surname);
        setGPA(GPA);
    }
    public double getPaymentAmount() {
        if(gpa > 2.67){
            return 36600;
        }

        return 0;
    }
}
