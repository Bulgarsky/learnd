public class U {
    private String login;
    private String password;
    private String email;
    private String lastName;
    private String firstName;
    private String middleName;
    private boolean adminRights;
    {
        //init Visitor
        boolean adminRights = false;
    }

    public U(String login, String password, String email, String lastName, String firstName, String middleName) {
        // role - visitor, adminRights is false
        this.login = login;
        this.password = password;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }
    public U(String login, String password, String email, String lastName, String firstName, String middleName, boolean adminRights) {
        // role - admin, adminRights is true
        this.login = login;
        this.password = password;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.adminRights = adminRights;
    }
    //setters
    public void setEmail(String email) {this.email = email;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setMiddleName(String middleName) {this.middleName = middleName;}

    public void setAdminRights (boolean adminRights) {
        if (isAdminRights()) {this.adminRights = adminRights;}
    }

    //getters
    public boolean isAdminRights() {return adminRights;}
    public String getLogin() {return login;}
    public String getPassword() {return password;}
    public String getEmail() {return email;}
    public String getLastName() {return lastName;}
    public String getFirstName() {return firstName;}
    public String getMiddleName() {return middleName;}
}
