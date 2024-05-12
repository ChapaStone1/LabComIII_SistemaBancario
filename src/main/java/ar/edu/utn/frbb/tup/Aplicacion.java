package ar.edu.utn.frbb.tup;
import ar.edu.utn.frbb.tup.Input.MenuInputProcessor;
import ar.edu.utn.frbb.tup.Modelos.Banco;
import ar.edu.utn.frbb.tup.Modelos.Cuentas.Cuenta;
import ar.edu.utn.frbb.tup.Modelos.Personas.Cliente;
import ar.edu.utn.frbb.tup.Modelos.Personas.TipoPersona;

import java.time.LocalDate;
import java.time.LocalDateTime;

class Aplicacion {

    public static void main(String args[]) {
        Banco banco = new Banco(); // creo el objeto banco

        // creo las cuentas y los clientes para probar y no crear objetos siempre que ejecuto
        Cuenta cuentaLuciano = new Cuenta().setNombre("1").setCBU(123456).setfechaCreacion(LocalDateTime.now()).setBalance(1835);
        Cuenta cuentaLuciano2 = new Cuenta().setNombre("2").setCBU(111111).setfechaCreacion(LocalDateTime.now()).setBalance(1500);
        Cliente cliente = new Cliente();
        cliente.setNombre("Luciano");
        cliente.setApellido("Salotto");
        cliente.setFechaNacimiento(LocalDate.of(1978, 2, 7));
        cliente.setBanco("Provincia");
        cliente.setDni(12345678);
        cliente.setTipoPersona(TipoPersona.PERSONA_FISICA);
        cliente.setFechaAlta(LocalDate.now());
        cliente.addCuenta(cuentaLuciano);
        cliente.addCuenta(cuentaLuciano2);
        banco.addCliente(cliente);
        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Juan Jose");
        cliente2.setApellido("Chaparro");
        cliente2.setFechaNacimiento(LocalDate.of(1993, 1, 16));
        cliente2.setBanco("Provincia");
        cliente2.setDni(37389808);
        cliente2.setTipoPersona(TipoPersona.PERSONA_FISICA);
        cliente2.setFechaAlta(LocalDate.now());
        banco.addCliente(cliente2);
        Cuenta cuentajuan = new Cuenta().setBalance(999999).setCBU(123123).setNombre("Cuenta sueldo").setfechaCreacion(LocalDateTime.now());
        cliente2.addCuenta(cuentajuan);
        
        // llamo al metodo del menu
        MenuInputProcessor.mostrarMenu(banco);
    }
   
}
