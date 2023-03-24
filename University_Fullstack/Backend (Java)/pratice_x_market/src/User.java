import java.util.Objects;

public class User {
    private String login;
    private String password;

    //constructor
    public User (String login, String password) {
        this.login = login;
        this.password = password;
    }

    //getters
    public String getLogin(){return login;}
    public String getPassword() {return password;}

    //setters
    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
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
}
