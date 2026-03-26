import java.util.List;
import java.util.ArrayList;

public class Auth {

    List<User> users;
    static int id = 0;
    User currentUser;

    public Auth() {
        this.users = new ArrayList<>();
    }

    public Auth(List<User> users) {
        this.users = users;
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                return user;
            }
        }
        return null;
    }

    public User getUser() {
        return currentUser;
    }

    public User register(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return null;
            }
        }

        String role;

        if (users.size() == 0) {
            role = "Admin";
        } else {
            role = "User";
        }

        User user = new User(String.valueOf(id++), username, password, role);
        users.add(user);

        return user;
    }

    public void logout() {
        currentUser = null;
    }

}
