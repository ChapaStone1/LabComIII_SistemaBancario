package ar.edu.utn.frbb.tup.Input;
import java.time.LocalDateTime;
import java.util.Scanner;

import ar.edu.utn.frbb.tup.Modelos.Banco;
import ar.edu.utn.frbb.tup.Modelos.Cuentas.Cuenta;
import ar.edu.utn.frbb.tup.Modelos.Personas.Cliente;

public class CuentasInputProcessor extends ClienteInputProcessor{
    public static Cuenta crearCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre de cuenta");
        String nombre = scanner.nextLine();
        LocalDateTime fechaCreacion = LocalDateTime.now();
        System.out.println("Ingrese CBU");
        long CBU = scanner.nextLong();
        System.out.println("Ingrese balance");
        int balance = scanner.nextInt();
        Cuenta cuenta = new Cuenta().setNombre(nombre).setCBU(CBU).setfechaCreacion(fechaCreacion).setBalance(balance);
        return cuenta;
    }

    public static void retirarDinero(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el CBU de la cuenta desde la cual desea retirar dinero:");
        int cbu = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        for (Cuenta cuenta : cliente.getCuentas()) {
            if (cuenta.getCBU() == cbu) {
                System.out.println("Ingrese el monto a retirar:");
                int monto = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner
                cuenta.retiro(monto); // Realizar el retiro de dinero en la cuenta seleccionada
                return;
            }
        }
        // Si no se encuentra la cuenta con el CBU especificado
        System.out.println("No se encontró la cuenta con el CBU especificado.");
    }
    public static void depositarDinero(Cliente cliente){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el CBU de la cuenta desde la cual desea depositar dinero:");
        int cbu = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        for (Cuenta cuenta : cliente.getCuentas()) {
            if (cuenta.getCBU() == cbu) {
                System.out.println("Ingrese el monto a depositar:");
                int monto = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner
                cuenta.deposito(monto); // Realizar el retiro de dinero en la cuenta seleccionada
                return;
            }
        }
        // Si no se encuentra la cuenta con el CBU especificado
        System.out.println("No se encontró la cuenta con el CBU especificado.");
    }

    public static void getUltimosMovimientos(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente que desea consultar");
        long dni = scanner.nextLong();
        scanner.nextLine(); // Limpiar el buffer del scanner
        boolean clienteEncontrado = false;
        for (Cliente cliente : banco.getBanco()) {
            if (cliente.getDni() == dni) {
                clienteEncontrado = true;
                for (Cuenta cuenta : cliente.getCuentas()) { // Utiliza una variable para cada cuenta
                    cuenta.imprimirMovimientos();
                }
                break;
            }
        }
        if (!clienteEncontrado) {
            System.out.println("Cliente no encontrado.");
        }
    }

}