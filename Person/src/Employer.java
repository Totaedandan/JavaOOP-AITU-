public class Employer extends Person {
    private  int id  ;
    private   static   int   id_gen = 1  ;
    private   String  position ;
    private   double  salary  ;

    public Employer(){
        id =  id_gen++;
    }
    public Employer(String  name  , String   surname , String  position , double salary ){
        super (name  , surname);
        setSalary(salary);
        setPosition(position);
    }

    public   String getPosition  (){
        return   position;
    }
    public  void setPosition  (String position ){
        this.position  =   position  ;
    }
    public   void setSalary  ( double salary ){
        this.salary = salary;
    }
    public  double getSalary (){
        return  salary;
    }

    @Override
    public String toString() {
        return   super.toString()  +  salary + " tenge" ;
    }
    @Override
    public double getPaymentAmount() {
        return salary;
    }
}