package ar.edu.utn.frbb.tup.Modelos.Cuentas;
import java.time.LocalDateTime;

public class Movimiento {
    private int id;
    private LocalDateTime fecha;
    private TipoMovimiento tipo;
    private int monto;
    private long cuentaOrigen;
    private long cuentaDestino;

    public Movimiento(int id, TipoMovimiento tipo, int monto, long cuentaOrigen, long cuentaDestino) {
        this.id = id;
        this.fecha = LocalDateTime.now();
        this.tipo = tipo;
        this.monto = monto;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
    }

    public void imprimirMovimiento(){
        System.out.println("Id: " + id + " Fecha: " + fecha + " Tipo: " + tipo + " Monto: " + monto + " CuentaOrigen: " + cuentaOrigen + " CuentaDestino: " + cuentaDestino);
    }

}
