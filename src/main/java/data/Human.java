package data;

public class Human {
    private String name, email, password, id;

    public Human(String name, String email, String password, String id){
        this.name=name;
        this.email=email;
        this.password=password;
        this.id=id;
    }
    public  String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
