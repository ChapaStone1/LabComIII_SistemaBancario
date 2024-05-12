package ar.edu.utn.frbb.tup.Modelos.Personas;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellido;
    private long dni;
    private LocalDate fechaNacimiento;

    public String getNombre() {
        return nombre;
    }

    public Persona setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Persona setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public long getDni() {
        return dni;
    }

    public Persona setDni(long dni) {
        this.dni = dni;
        return this;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Persona setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }
    public void imprimir(){
        System.out.println("Nombre: " + nombre + " Apellido: " + apellido + " DNI: " + dni + " FechaNacimiento: " + fechaNacimiento);
    }

   
}

