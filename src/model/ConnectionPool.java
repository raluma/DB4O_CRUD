package model;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;

public class ConnectionPool {
    private static ObjectContainer db;

    public static ObjectContainer getConnection(String fileName) {
        return db = Db4o.openFile(fileName);
    }

    public static void closeConnection() {
        db.close();
    }
}
