package diu.xm.example.com.financetracer;

public class Customer {

    private  String name;
    private  String password;
    private  String Addree;

    public Customer()
    {

    }


    public Customer(String name, String password, String addree) {
        this.name = name;
        this.password = password;
        this.Addree = addree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddree() {
        return Addree;
    }

    public void setAddree(String addree) {
        Addree = addree;
    }
}
