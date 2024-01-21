import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Employee("John", "Lehnon", "Scientist", 27045.78));
        persons.add(new Employee("George", "Harrison", "Physician", 50000.0));
        persons.add(new Student("Ringo", "Starr", 2.5));
        persons.add(new Student("Paul", "McCartney", 3.0));
        Collections.sort(persons);
        printData(persons);
    }
    public static void printData(Iterable<Person> persons){
        for(Person i: persons){
            System.out.println(i.toStrng() + "earns " + i.getPaymentAmount() + " tenge");
        }
    }
}

