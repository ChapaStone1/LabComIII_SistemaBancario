package ar.edu.utn.frbb.tup.Modelos;
import ar.edu.utn.frbb.tup.Modelos.Personas.Cliente;
import java.util.HashSet;
import java.util.Set;


public class Banco {
    Set<Cliente> banco = new HashSet<>();

    public Set<Cliente> getBanco() {
        return banco;
    }
    public void setBanco(Set<Cliente> banco) {
        this.banco = banco;
    }
    
    public Banco addCliente(Cliente cliente){
        this.banco.add(cliente);
        return this;
    } 

    public Cliente buscarCliente(long dni){
        for (Cliente cliente : banco) {
            if (cliente.getDni() == dni) {
                return cliente;
            }
        }
        return null;
    }

    // metodos para borrar clientes
    public Banco removeCliente(Cliente cliente){
        this.banco.remove(cliente);
        return this;
    }

}
