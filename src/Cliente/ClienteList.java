/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Models.List;
import java.util.HashSet;

public class ClienteList implements List<Cliente> {
    private static ClienteList clienteList;
    private HashSet<Cliente> clientes;

    // Método estático para obtener la instancia única de la lista de clientes
    public static ClienteList getInstance() {
        if (clienteList == null) {
            clienteList = new ClienteList();
        }
        return clienteList;
    }

    private ClienteList() {
        clientes = new HashSet<>();
    }

    @Override
    public boolean Agregar(Cliente cliente) {
        if (cliente != null && cliente.getIdentificacion() != 0) {
            return clientes.add(cliente);
        }
        return false;
    }

    @Override
    public boolean Actualizar(Cliente cliente) {
        // Para actualizar, primero eliminamos el cliente existente (si existe)
        // y luego agregamos el cliente actualizado
        Eliminar(cliente);
        return Agregar(cliente);
    }

    @Override
    public boolean Eliminar(Cliente cliente) {
        return clientes.remove(cliente);
    }
    
    @Override
    public Cliente Buscar(Object identificacion) {
        if (identificacion instanceof Integer) {
            int id = (int) identificacion;
            for (Cliente cliente : clientes) {
                if (cliente.getIdentificacion() == id) {
                    return cliente;
                }
            }
        }
        return null;
    }

    @Override
    public Cliente[] toArray() {
        return clientes.toArray(new Cliente[0]);
    }

}
