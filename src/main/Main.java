package main;

import model.Persona;
import model.Queries;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona(1,"Raúl", 21, 56.5, 1.85);
        Persona persona1 = new Persona(2,"Raul", 22, 57, 2);

        Queries queries = new Queries();

        queries.create(persona);
        queries.create(persona1);

        queries.read(2);
    }
}
