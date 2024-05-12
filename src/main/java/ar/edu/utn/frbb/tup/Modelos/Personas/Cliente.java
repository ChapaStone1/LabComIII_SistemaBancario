package ar.edu.utn.frbb.tup.Modelos.Personas;
import ar.edu.utn.frbb.tup.Modelos.Cuentas.Cuenta;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class Cliente extends Persona{
    private TipoPersona tipoPersona;
    private String banco;
    private LocalDate fechaAlta;
    private Set<Cuenta> cuentas = new HashSet<>();

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public Cliente setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
        return this;
    }

    public String getBanco() {
        return banco;
    }

    public Cliente setBanco(String banco) {
        this.banco = banco;
        return this;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public Cliente setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
        return this;
    }

    public Set<Cuenta> getCuentas() {
        return cuentas;
    }

    public void addCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
    @Override
    public void imprimir(){
        System.out.println("* Nombre: " + this.getNombre());
        System.out.println("* Apellido: " + this.getApellido());
        System.out.println("* DNI: " + this.getDni());
        System.out.println("* Fecha de nacimiento: " + this.getFechaNacimiento());
        System.out.println("* Banco: " + this.getBanco());
        System.out.println("* Tipo de persona: " + this.getTipoPersona());
        System.out.println("* Fecha de alta: " + this.getFechaAlta());
        System.out.println("* Cuentas: ");
        for (Cuenta cuenta : this.getCuentas()) {
            cuenta.imprimirCuenta();
        }
    }
    
}
