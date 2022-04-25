package com.example.registrounivalle_a1;

// Clases POJO plain old java object
public class Estudiante {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String nota;


    public Estudiante(String nombre, String apellido, String email, String telefono, String nota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.nota = nota;
    }
}
