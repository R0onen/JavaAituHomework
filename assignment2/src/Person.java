public class Person implements Payable, Comparable<Person>{
    private int id;
    private static int idNumber = 1;
    private String name;
    private String surname;

    String toStrng() {
        return id + ". " + name + " " + surname;
    }

    int getID() {
        return id;
    }

    void setName(String Name) {
        name = Name;
    }

    void setSurname(String Surname) {
        surname = Surname;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    Person() {
        this.id = idNumber;
        idNumber++;
    }

    Person(String Name, String Surname) {
        this.id = idNumber;
        idNumber++;
        setName(Name);
        setSurname(Surname);
    }

    String getPosition() {
        if (this.getClass() == Employee.class) {
            return this.getPosition();
        }
        return "Student";
    }
    public double getPaymentAmount() {
        return 0;
    }
    @Override
    public int compareTo(Person o) {
        if(this.getPaymentAmount() > o.getPaymentAmount()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
