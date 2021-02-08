package cz.educanet.logreg;

public class User {

    private String fullname;
    private String username;
    private String email;
    private String password;

    public User(String fullname, String username, String email, String password) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;

    }
    public String getFullname(){
        return fullname;
    }

    public String getUsername(){

        return username;
    }
    public String getPassword(){
        return password;
    }

    public String changeUsername(String newUsername){
        return this.username = newUsername;

    }
    public String changePassword(String newPassword){
        return this.username = newPassword;

    }

    public String renameUser(String newUsername) { return username = newUsername;}
}
