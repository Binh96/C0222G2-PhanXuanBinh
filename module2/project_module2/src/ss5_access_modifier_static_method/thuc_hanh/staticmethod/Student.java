package ss5_access_modifier_static_method.thuc_hanh.staticmethod;

public class Student {
    private int rollno;
    private String name;
    private static String college = "BBTIT";

    Student(int r, String n){
        rollno = r;
        name = n;
    }

    static void change(){
        college = "Codegym";
    }

    void display(){
        System.out.println(rollno + " "+ name+ " "+ college);
    }
}
