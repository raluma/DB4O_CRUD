package model;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;

public class Queries {
    private final String fileName;

    public Queries(String fileName) {
        this.fileName = fileName;
    }

    public void createUser(User user) {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);

        db.store(user);

        ConnectionPool.closeConnection();
    }

    public User readUser(String userName) {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);
        ObjectSet<User> result = db.queryByExample(new User(userName, null,null, null));

        if (result.hasNext()) {
            return result.next();
        }

        ConnectionPool.closeConnection();
        return null;
    }

    public ArrayList<User> readUsers() {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);
        ObjectSet<User> result = db.queryByExample(new User());
        ArrayList<User> users = new ArrayList<>();

        while (result.hasNext()) {
             users.add(result.next());
        }

        ConnectionPool.closeConnection();
        return users;
    }

    public void updateUserName(String userName, String newUserName) {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);
        ObjectSet<User> result = db.queryByExample(new User(userName, null, null, null));

        if (result.hasNext()) {
            User user = result.next();
            user.setUsername(newUserName);

            db.store(user);
        }

        ConnectionPool.closeConnection();
    }

    public void updatePassword(String userName, String password) {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);
        ObjectSet<User> result = db.queryByExample(new User(userName, null, null, null));

        if (result.hasNext()) {
            User user = result.next();
            user.setPassword(password);

            db.store(user);
        }

        ConnectionPool.closeConnection();
    }

    public void updateEmail(String userName, String email) {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);
        ObjectSet<User> result = db.queryByExample(new User(userName, null, null, null));

        if (result.hasNext()) {
            User user = result.next();
            user.setEmail(email);

            db.store(user);
        }

        ConnectionPool.closeConnection();
    }

    public void deleteUser(String userName) {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);
        ObjectSet<User> result = db.queryByExample(new User(userName, null, null, null));

        if (result.hasNext()) {
            db.delete(result.next());
        }

        ConnectionPool.closeConnection();
    }
}
