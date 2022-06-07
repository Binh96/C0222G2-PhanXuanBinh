package Model;

public class TypeOfCustomer {
    private int codeTypeOfCustomer;
    private String name;


    public TypeOfCustomer() {
    }

    public TypeOfCustomer(int codeTypeOfCustomer, String name) {
        this.codeTypeOfCustomer = codeTypeOfCustomer;
        this.name = name;
    }

    public int getCodeTypeOfCustomer() {
        return codeTypeOfCustomer;
    }

    public void setCodeTypeOfCustomer(int codeTypeOfCustomer) {
        this.codeTypeOfCustomer = codeTypeOfCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
