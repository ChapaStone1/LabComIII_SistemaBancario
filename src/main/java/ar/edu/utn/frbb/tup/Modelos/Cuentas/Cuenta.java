package ar.edu.utn.frbb.tup.Modelos.Cuentas;
import ar.edu.utn.frbb.tup.Modelos.Personas.Cliente;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Cuenta extends Cliente{
    private String nombre;
    private long CBU;
    private LocalDateTime fechaCreacion;
    private int balance;
    private List<Movimiento> movimientos;
    private static int contadorMovimientos = 0;

    public Cuenta() {
        this.movimientos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public long getCBU() {
        return CBU;
    }
    public Cuenta setCBU(long CBU) {
        this.CBU = CBU;
        return this;
    }
    public Cuenta setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Cuenta setfechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public int getBalance() {
        return balance;
    }

    public Cuenta setBalance(int balance) {
        this.balance = balance;
        return this;
    }

    public void retiro(int monto) {
        if (monto > this.balance) {
            System.out.println("Saldo insuficiente para realizar el retiro.");
        } else {
            this.balance -= monto;
            System.out.println("Se retiraron " + monto + " unidades monetarias de la cuenta " + nombre);
            registrarMovimiento(new Movimiento(generarIdMovimiento(), TipoMovimiento.RETIRO, monto, this.CBU, this.CBU));
        }
    }

    public void deposito(int cantidad) {
        this.balance += cantidad;
        registrarMovimiento(new Movimiento(generarIdMovimiento(), TipoMovimiento.DEPOSITO, cantidad, this.CBU, this.CBU));
    }

    public void transferirDineroHaciaOtraCuenta(int cantidad, Cuenta cuentaDestino) {
        if (cantidad > 0 && cantidad <= getBalance()) {
            this.balance -= cantidad;
            cuentaDestino.deposito(cantidad);
            registrarMovimiento(new Movimiento(generarIdMovimiento(), TipoMovimiento.TRANSFERENCIA, cantidad, this.CBU, cuentaDestino.getCBU()));
        } else {
            System.out.println("No se puede realizar la transferencia.");
        }
    }


    // metodos de movimientos de cuenta
    private void registrarMovimiento(Movimiento movimiento) {
        this.movimientos.add(movimiento);
    }

    private int generarIdMovimiento() {
        return contadorMovimientos++;
    }

    public void imprimirMovimientos() {
        for (Movimiento movimiento : movimientos) {
            movimiento.imprimirMovimiento();
        }
    }

    // metodo de imprimir

    public void imprimirCuenta() {
        System.out.println("     Nombre: " + this.nombre);
        System.out.println("        Fecha de creacion: " + this.fechaCreacion);
        System.out.println("        Balance: " + this.balance);
        System.out.println("        CBU: " + this.CBU);
    }
}
