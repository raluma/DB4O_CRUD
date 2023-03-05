package model;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;

public class Queries {
    private final String fileName;

    public Queries() {
        this.fileName = "user.db40";
    }

    public boolean createUser(String userName, String password, String email, String role) {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);

        if (this.readUserByUserName(userName) == null &&
                this.readUserByEmail(email) == null) {
            int id;

            try {
                ArrayList<User> users = this.readUsers();

                id = users.get(users.size() - 1).getId() + 1;
            } catch (Exception e) {
                id = 1;
            }

            db.store(new User(id, userName, password, email, role));
            return true;
        }

        return false;
    }

    public User readUserById(int id) {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);
        ObjectSet<User> result = db.queryByExample(new User(id, null, null,null, null));

        if (result.hasNext()) {
            return result.next();
        }

        return null;
    }

    public User readUserByUserName(String userName) {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);
        ObjectSet<User> result = db.queryByExample(new User(0, userName, null,null, null));

        if (result.hasNext()) {
            return result.next();
        }

        return null;
    }

    public User readUserByEmail(String email) {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);
        ObjectSet<User> result = db.queryByExample(new User(0, null, null, email, null));

        if (result.hasNext()) {
            return result.next();
        }

        return null;
    }

    public ArrayList<User> readUsers() {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);
        ObjectSet<User> result = db.queryByExample(new User());

        ArrayList<User> users = new ArrayList<>();

        while (result.hasNext()) {
             users.add(result.next());
        }

        return users;
    }

    public void updateUserName(int id, String userName) {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);
        ObjectSet<User> result = db.queryByExample(new User(id, null, null, null, null));

        if (result.hasNext()) {
            User user = result.next();
            user.setUsername(userName);

            db.store(user);
        }
    }

    public void updateEmail(int id, String email) {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);
        ObjectSet<User> result = db.queryByExample(new User(id, null, null, null, null));

        if (result.hasNext()) {
            User user = result.next();
            user.setEmail(email);

            db.store(user);
        }
    }

    public void updatePassword(int id, String password) {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);
        ObjectSet<User> result = db.queryByExample(new User(id, null, null, null, null));

        if (result.hasNext()) {
            User user = result.next();
            user.setPassword(password);

            db.store(user);
        }
    }

    public void updateRole(int id, String role) {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);
        ObjectSet<User> result = db.queryByExample(new User(id, null, null, null, null));

        if (result.hasNext()) {
            User user = result.next();
            user.setRole(role);

            db.store(user);
        }
    }

    public void deleteUser(int id) {
        ObjectContainer db = ConnectionPool.getConnection(this.fileName);
        ObjectSet<User> result = db.queryByExample(new User(id, null, null, null, null));

        if (result.hasNext()) {
            db.delete(result.next());
        }
    }
}
