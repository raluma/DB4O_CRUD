package model;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;

public class Queries {

    public void create(Persona persona) {
        ObjectContainer db = ConnectionPool.getConnection("test.db4o");

        db.store(persona);

        ConnectionPool.closeConnection();
    }

    public Persona read(int id) {
        ObjectContainer db = ConnectionPool.getConnection("test.db4o");
        ObjectSet<Persona> result = db.queryByExample(new Persona(id, null, 0, 0, 0));

        if (result.hasNext()) {
            return result.next();
        }

        ConnectionPool.closeConnection();
        return null;
    }

    public ArrayList<Persona> readAll() {
        ObjectContainer db = ConnectionPool.getConnection("test.db4o");
        ObjectSet<Persona> result = db.queryByExample(new Persona());
        ArrayList<Persona> personas = new ArrayList<>();

        while (result.hasNext()) {
             personas.add(result.next());
        }

        ConnectionPool.closeConnection();
        return personas;
    }

    public void update(int id, String name) {
        ObjectContainer db = ConnectionPool.getConnection("test.db4o");
        ObjectSet<Persona> result = db.queryByExample(new Persona(id, null, 0, 0, 0));

        if (result.hasNext()) {
            Persona persona = result.next();
            persona.setName(name);

            db.store(persona);
        }

        ConnectionPool.closeConnection();
    }

    public void delete(int id) {
        ObjectContainer db = ConnectionPool.getConnection("test.db4o");
        ObjectSet<Persona> result = db.queryByExample(new Persona(id, null, 0, 0, 0));

        if (result.hasNext()) {
            db.delete(result.next());
        }

        ConnectionPool.closeConnection();
    }
}
