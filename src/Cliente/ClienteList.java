/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Models.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ClienteList implements List<Cliente> {
    private static ClienteList clienteList;
    private ArrayList<Cliente> clientes;

    // Método estático para obtener la instancia única de la lista de clientes
    public static ClienteList getInstance() {
        if (clienteList == null) {
            clienteList = new ClienteList();
        }
        return clienteList;
    }

    public ClienteList() {
        clientes = new ArrayList<>();
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
        Eliminar(cliente);
        return Agregar(cliente);
    }

    @Override
    public boolean Eliminar(Cliente cliente) {
        System.out.println("Eliminando cliente con identificación: " + cliente.getIdentificacion());
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente c = iterator.next();
            if (c.getIdentificacion() == cliente.getIdentificacion()) {
                iterator.remove();
                return true;
            }
        }
        return false;
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

    public Cliente BuscarPorCedula(String cedula) {
        int cedulaInt;
        try {
            cedulaInt = Integer.parseInt(cedula);
        } catch (NumberFormatException e) {
            return null;
        }

        for (Cliente cliente : clientes) {
            if (cliente.getIdentificacion() == cedulaInt) {
                return cliente;
            }
        }
        return null;
    }
}
