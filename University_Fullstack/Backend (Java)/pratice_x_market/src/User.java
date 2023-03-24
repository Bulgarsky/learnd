import java.util.Objects;

public class User {
    private String login;
    private String password;
    private boolean adminRights;
    {//default user: Visitor
        boolean adminRights = false;
    }

    //constructor
    public User(String login, String password) {
        //default: visitor
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, boolean adminRights) {
        //admin
        this.login = login;
        this.password = password;
        this.adminRights = adminRights;
    }

    //getters
    public String getLogin() {        return login;    }
    public String getPassword() {        return password;    }
    public boolean isAdminRights() {        return adminRights;    }

    //setters
    public void setLogin(String login) {this.login = login;}
    public void setPassword(String password) {this.password = password;}

    public void setAdminRights(boolean adminRights) {this.adminRights = adminRights;}

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
        return "Пользователь {" +
                "Login: " + login +
                ", adminRights: " + adminRights +
                '}';
    }
}
