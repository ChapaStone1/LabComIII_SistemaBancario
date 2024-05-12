package ar.edu.utn.frbb.tup.Input;
import ar.edu.utn.frbb.tup.Modelos.Banco;
import java.util.Scanner;


public class MenuInputProcessor extends BaseInputProcessor {
        
    public static void mostrarMenu(Banco banco){

        // el menu es un selector de opciones con el switch donde voy llamando a los demas input processors
        int opcion;
        String continuar;
        do {
            Scanner scanner = new Scanner(System.in);
            clearConsole();
             // \u001B[34m esto es una secuencia para cambiar el color del texto
            System.out.println("\u001B[34m************************************************");
            System.out.println("*          TUP 2024 - Lab. Com. III            *");
            System.out.println("*          Alumno Juan Jose Chaparro           *");
            System.out.println("************************************************");
            System.out.println("*           Sistema Bancario v0.0.1            *");
            System.out.println("************************************************\u001B[0m");
            System.out.println("\u001B[93m* 1. Agregar cliente                           *");
            System.out.println("* 2. Borrar cliente                            *");
            System.out.println("* 3. Modificar cliente                         *");
            System.out.println("************************************************");
            System.out.println("* 4. Agregar cuenta a cliente                  *");
            System.out.println("************************************************");
            System.out.println("* 5. Realizar transferencia                    *");
            System.out.println("* 6. Realizar depósito                         *");
            System.out.println("* 7. Retirar dinero                            \u001B[0m*");
            System.out.println("\u001B[34m************************************************");
            System.out.println("* 8. Ver últimos movimientos de cuenta         *");
            System.out.println("* 9. Ver datos de Cliente                      *");
            System.out.println("* 0. Salir                                     *");
            System.out.println("************************************************\u001B[0m");
            System.out.print("\u001B[32mSeleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    clearConsole();
                    banco.addCliente(ClienteInputProcessor.agregarCliente(banco));
                    System.out.println("Pulse cualquier tecla para continuar");
                    continuar = scanner.nextLine();
                    clearConsole();
                    break;
                case 2:
                    clearConsole();
                    ClienteInputProcessor.borrarCliente(banco);
                    System.out.println("Pulse cualquier tecla para continuar");
                    continuar = scanner.nextLine();
                    clearConsole();
                    break;
                case 3:
                    clearConsole();
                    ClienteInputProcessor.buscarClienteyEditar(banco);
                    System.out.println("Pulse cualquier tecla para continuar");
                    continuar = scanner.nextLine();
                    clearConsole();
                    break;
                case 4:
                    clearConsole();
                    ClienteInputProcessor.agregarCuentaCliente(banco);
                    System.out.println("Pulse cualquier tecla para continuar");
                    continuar = scanner.nextLine();
                    clearConsole();
                    break;
                case 5:
                    clearConsole();
                    ClienteInputProcessor.transferirDineroClientes(banco);
                    System.out.println("Pulse cualquier tecla para continuar");
                    continuar = scanner.nextLine();
                    clearConsole();
                    break;
                case 6:
                    clearConsole();
                    ClienteInputProcessor.depositarDineroCliente(banco);
                    System.out.println("Pulse cualquier tecla para continuar");
                    continuar = scanner.nextLine();
                    clearConsole();
                    break;
                case 7:
                    clearConsole();
                    ClienteInputProcessor.retirarDineroCliente(banco);
                    System.out.println("Pulse cualquier tecla para continuar");
                    continuar = scanner.nextLine();
                    clearConsole();
                    break;
                case 8:
                    clearConsole();
                    CuentasInputProcessor.getUltimosMovimientos(banco);
                    System.out.println("Pulse cualquier tecla para continuar");
                    continuar = scanner.nextLine();
                    clearConsole();
                    break;
                case 9:
                    clearConsole();
                    ClienteInputProcessor.getDatosCliente(banco);
                    System.out.println("Pulse cualquier tecla para continuar");
                    continuar = scanner.nextLine();
                    clearConsole();
                    break;
                case 0:
                    System.out.println("Gracias por usar mi sistema bancario. ¡Hasta luego!");
                    System.out.println("Pulse cualquier tecla para cerrar.");
                    continuar = scanner.nextLine();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }
}
