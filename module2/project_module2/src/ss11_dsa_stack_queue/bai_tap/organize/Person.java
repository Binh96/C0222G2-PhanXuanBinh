package ss11_dsa_stack_queue.bai_tap.organize;

public class Person {
    private String gender;
    private String name;

    public Person(){

    }

    public Person(String name, String gender){
        this.name = name;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                ", name='" + name + '\'' +
                "gender='" + gender + '\''  +
                '}';
    }
}
