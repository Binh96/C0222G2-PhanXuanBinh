package ss5_access_modifier_static_method.bai_tap.class_only_read;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();

        student.setClasses("C03");
        student.setName("Check");

        System.out.print(student);
    }
}
