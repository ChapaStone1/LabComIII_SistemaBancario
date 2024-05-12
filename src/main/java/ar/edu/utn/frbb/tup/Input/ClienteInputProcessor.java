package ar.edu.utn.frbb.tup.Input;
import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.utn.frbb.tup.Input.Validaciones.Validaciones;
import ar.edu.utn.frbb.tup.Modelos.Banco;
import ar.edu.utn.frbb.tup.Modelos.Cuentas.Cuenta;
import ar.edu.utn.frbb.tup.Modelos.Personas.Cliente;
import ar.edu.utn.frbb.tup.Modelos.Personas.TipoPersona;

public class ClienteInputProcessor extends MenuInputProcessor{

    public static void buscarClienteyEditar(Banco banco){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese dni del cliente");
        long dni = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer del scanner
        Cliente cliente = banco.buscarCliente(dni);
        if(cliente!= null){
            System.out.println("Ingrese nombre");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese apellido");
            String apellido = scanner.nextLine();
            System.out.println("Ingrese fecha de nacimiento en formato yyyy-MM-dd:");
            boolean validarfechaNacimiento = false;
            String fechaNacimientoString = "";
            while (!validarfechaNacimiento) {
                fechaNacimientoString = scanner.nextLine();
                validarfechaNacimiento = Validaciones.fechaNacValida(fechaNacimientoString);
            }
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString);
            System.out.println("Ingrese banco");
            String setbanco = scanner.nextLine();
            TipoPersona tipoPersona = null;
            while (tipoPersona == null) {
                
                System.out.println("Seleccione el tipo de persona:");
                System.out.println("1. Persona física");
                System.out.println("2. Persona jurídica");
                scanner = new Scanner(System.in);
                int opcion = scanner.nextInt();
                tipoPersona = Validaciones.tipoPersonaValida(opcion);
            }
            LocalDate fechaAlta = LocalDate.now();
            Cliente c = ((Cliente) new Cliente().setNombre(nombre).setApellido(apellido).setDni(dni).setFechaNacimiento(fechaNacimiento)).setBanco(setbanco).setTipoPersona(tipoPersona).setFechaAlta(fechaAlta);        
            
            banco.removeCliente(cliente);
            banco.addCliente(c);
            System.out.println("Cliente editado con exito");  
        }
        else{
            System.out.println("Cliente no encontrado");
        }
    }
    
    public static Cliente agregarCliente(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese dni del cliente");
        long dni = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer del scanner
        Cliente cliente = banco.buscarCliente(dni);
        if(cliente == null){
            System.out.println("Ingrese nombre");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese apellido");
            String apellido = scanner.nextLine();
            System.out.println("Ingrese fecha de nacimiento en formato yyyy-MM-dd:");
            boolean validarfechaNacimiento = false;
            String fechaNacimientoString = "";
            while (!validarfechaNacimiento) {
                fechaNacimientoString = scanner.nextLine();
                validarfechaNacimiento = Validaciones.fechaNacValida(fechaNacimientoString);
            }
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString);
            System.out.println("Ingrese banco");
            String setbanco = scanner.nextLine();
            
            TipoPersona tipoPersona = null;
            while (tipoPersona == null) {
                
                System.out.println("Seleccione el tipo de persona:");
                System.out.println("1. Persona física");
                System.out.println("2. Persona jurídica");
                scanner = new Scanner(System.in);
                int opcion = scanner.nextInt();
                tipoPersona = Validaciones.tipoPersonaValida(opcion);

            }
            LocalDate fechaAlta = LocalDate.now();
            Cliente c = ((Cliente) new Cliente().setNombre(nombre).setApellido(apellido).setDni(dni).setFechaNacimiento(fechaNacimiento)).setBanco(setbanco).setTipoPersona(tipoPersona).setFechaAlta(fechaAlta);        
            System.out.println("Cliente agregado con exito");    
            return c;
        }
        else{
            System.out.println("Cliente ya cargado en el banco");
            return null;
        }
        
    }

    public static void borrarCliente(Banco banco){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente que desea eliminar:");
        long dni = scanner.nextLong();
        Cliente cliente = banco.buscarCliente(dni);
        
        if(cliente!= null){
            banco.removeCliente(cliente);
            System.out.println("Cliente eliminado con exito");
        }
        else{
            System.out.println("Cliente no encontrado");
        }
    }

    public static void getDatosCliente(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente que desea consultar:");
        long dni = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer del scanner
        Cliente cliente = banco.buscarCliente(dni);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
        }
        else {
            cliente.imprimir();
        }
    }

    public static void agregarCuentaCliente(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente que desea agregar una cuenta");
        long dni = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer del scanner
        Cliente cliente = banco.buscarCliente(dni);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
        }
        else {
            cliente.addCuenta(CuentasInputProcessor.crearCuenta());
            System.out.println("Cuenta agregada con exito");
        }
    }

    public static void retirarDineroCliente(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente que desea retirar dinero");
        long dni = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer del scanner
        boolean clienteEncontrado = false;
        for (Cliente cliente : banco.getBanco()) {
            if (cliente.getDni() == dni) {
                clienteEncontrado = true;
                CuentasInputProcessor.retirarDinero(cliente);
                break;
            }
        }
        
    }

    public static void depositarDineroCliente(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente que desea depositar dinero");
        long dni = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer del scanner
        boolean clienteEncontrado = false;
        for (Cliente cliente : banco.getBanco()) {
            if (cliente.getDni() == dni) {
                clienteEncontrado = true;
                CuentasInputProcessor.depositarDinero(cliente);
                break;
            }
        }
    }

    public static void transferirDineroClientes(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente que desea transferir dinero");
        long dni = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer del scanner
        boolean cliente1Encontrado = false;
        boolean cliente2Encontrado = false;
        boolean cliente1CuentaEncontrada = false;
        boolean cliente2CuentaEncontrada = false;
        for (Cliente cliente1 : banco.getBanco()) {
            if (cliente1.getDni() == dni) {
                cliente1Encontrado = true;
                System.out.println("Ingrese el CBU del cliente: " + cliente1.getApellido() + " " + cliente1.getNombre() + ".");
                long CBU = scanner.nextLong();
                scanner.nextLine(); // Limpiar el buffer del scanner
                for (Cuenta cuenta1 : cliente1.getCuentas()) {
                    if (cuenta1.getCBU() == CBU) {
                        cliente1CuentaEncontrada = true;
                        System.out.println("Ingrese el DNI del cliente que recibira el dinero");
                        long dni2 = scanner.nextLong();
                        scanner.nextLine(); // Limpiar el buffer del scanner
                        for (Cliente cliente2 : banco.getBanco()) {
                            if (cliente2.getDni() == dni2) {
                                cliente2Encontrado = true;
                                System.out.println("Ingrese el CBU del cliente: " + cliente2.getApellido() + " " + cliente2.getNombre() + ".");
                                long CBU2 = scanner.nextLong();
                                scanner.nextLine(); // Limpiar el buffer del scanner
                                for (Cuenta cuenta2 : cliente2.getCuentas()) {
                                    if (cuenta2.getCBU() == CBU2) {
                                        cliente2CuentaEncontrada = true;
                                        System.out.println("Ingrese la cantidad de dinero a transferir");
                                        int cantidad = scanner.nextInt();
                                        scanner.nextLine(); // Limpiar el buffer del scanner
                                        
                                        cuenta1.transferirDineroHaciaOtraCuenta(cantidad, cuenta2);
                                        System.out.println("Se transfirió con exito " + cantidad + "$" + " a la cuenta de " + cliente2.getApellido() + " " + cliente2.getNombre() + "de la cuenta de: " + cliente1.getApellido() + " " + cliente1.getNombre());
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
            
        if (!cliente1Encontrado) {
            System.out.println("Cliente que desea transferir dinero no encontrado");
        }
        if (!cliente2Encontrado) {
            System.out.println("Cliente que recibira el dinero no encontrado");
        }
        if (!cliente1CuentaEncontrada) {
            System.out.println("Cuenta del cliente que desea transferir dinero no encontrada");
        }
        if (!cliente2CuentaEncontrada) {
            System.out.println("Cuenta del cliente que recibira el dinero no encontrada");
        }
    }
}
