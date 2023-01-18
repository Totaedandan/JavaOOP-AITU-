import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Employer("Kim", "Taehyung", "Artist", 999999));
        people.add(new Employer("Tolebi", "Baitasov", "Startuper", 777));
        people.add(new Student("Saiaren", "GoodBoy", 4.0));
        people.add(new Employer("Arlen", "Sarymsak", "Student", 999999));
        people.add(new Student(  "Palenshe"  ,"Palensheev" , 3.999999));
        people.add(new Employer("Forest", "Gamp", "Employer", 2.1234));

        Collections.sort(people);
        printData(people);
    }
    public static void printData( Iterable <Person> people) {
        for (Person p:people){
            System.out.println(p );
        }
    }
    }

