public class Person implements Payment, Comparable<Person>{
    private int id;
    private static int id_loop = 1;
    private String name;
    private String surname;

    //_____________________________________________________________________________________________
    public  Person (){
        id = id_loop++;
    }
    //_____________________________________________________________________________________________
    public  Person (String name , String surname ){
        this();
        setName(name);
        setSurname(surname);
    }
    public  int  getId (){
        return  id  ;
    }

    //_____________________________________________________________________________________________
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    //_____________________________________________________________________________________________
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public  String  getPosition (){
        Employer empolyer  =  new Employer();
        String position = empolyer.getPosition();
        return   position == ""  ? position  : "Student";
    }
    //_____________________________________________________________________________________________
    @Override
    public String toString() {
        return '['+ getPosition()+ "]: "  + id +  " " + name + "  " + surname + " salary is : ";
    }
    //_____________________________________________________________________________________________
    @Override
    public double getPaymentAmount() {
        return 0;
    }

    @Override
    public int compareTo(Person o) {
        return Double.compare(o.getPaymentAmount(), getPaymentAmount());
    }
    //_____________________________________________________________________________________________




}
