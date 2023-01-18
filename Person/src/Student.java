public class Student extends Person {
    private double  gpa;

    public  Student (){
    }
    public   Student  (String   name  , String   surname  ,   double gpa ){
        super(name, surname );
        System.out.println(name);
        setGpa(gpa);
    }

    public  void setGpa  (double  gpa){
        this.gpa = gpa;
    }
    public double  getGpa (){
        return  gpa;
    }


    @Override
    public double getPaymentAmount() {
        return  gpa > 2.67   ?  36660 : 0 ;
    }

    @Override
    public String toString() {
        return super.toString()  + " earns: " +  getPaymentAmount() + " tenge";
    }
}