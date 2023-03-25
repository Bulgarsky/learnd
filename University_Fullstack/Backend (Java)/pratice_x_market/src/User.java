import java.util.Objects;

public class User {
    private String login;
    private String password;
    private boolean adminRights;
    {//default user: Visitor
        boolean adminRights = false;
    }
    private String email;
    private String lastName;
    private String firstName;
    private String middleName;

    //constructor
    public User(String login, String password, String email, String lastName, String firstName, String middleName) {
        //user: Visitor
        this.login = login;
        this.password = password;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public User(String login, String password, boolean adminRights, String email, String lastName, String firstName, String middleName) {
        //user: Admin
        this.login = login;
        this.password = password;
        this.adminRights = adminRights;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    //getters
    public String getLogin() {return login;}
    public String getPassword() {return password;}
    public boolean isAdminRights() {return adminRights;}
    public String getEmail() {return email;}
    public String getLastName() {return lastName;}
    public String getFirstName() {return firstName;}
    public String getMiddleName() {return middleName;}

    //setters
    public void setLogin(String login) {this.login = login;}
    public void setPassword(String password) {this.password = password;}
    public void setAdminRights(boolean adminRights) {this.adminRights = adminRights;}
    public void setEmail(String email) {this.email = email;}

    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setMiddleName(String middleName) {this.middleName = middleName;}

    //@Override equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public String toString() {
        return "Пользователь | " +
                "Login: " + login  +
                ", adminRights: " + adminRights +
                ", email: " + email +
                ", " + lastName +
                " " + firstName +
                " " + middleName ;
    }
}
