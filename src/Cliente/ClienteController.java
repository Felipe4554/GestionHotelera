/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import Controller.Controller;
import Views.View;

/**
 * Controller class for managing clients.
 * Manages client information and interactions with the view.
 * Implements methods for adding, updating, deleting, searching, and listing clients.
 * Follows the MVC design pattern.
 * 
 * @author Felipe Chacón
 */
public class ClienteController implements Controller<Cliente> {

    private ClienteList clienteList;
    private View view;

    
    public ClienteController(View view) {
        clienteList = ClienteList.getInstance(); 
        this.view = view; 
    }

    @Override
    public void Agregar(Cliente cliente) {
        if (cliente.isComplete()) {
            clienteList.Agregar(cliente);
            view.displayMessaje("Cliente agregado exitosamente.");
            buscarTodo();
        } else {
            view.displayErrorMessaje("No se puede agregar el cliente. Faltan datos.");
        }
    }

    @Override
    public void Actualizar(Cliente cliente) {
        if (cliente.isComplete()) {
            clienteList.Actualizar(cliente);
            view.displayMessaje("Cliente actualizado exitosamente.");
            buscarTodo();
        } else {
            view.displayErrorMessaje("No se puede actualizar el cliente. Faltan datos.");
        }
    }

    @Override
    public void Eliminar(Cliente cliente) {
        System.out.println("Intentando eliminar cliente con identificación: " + cliente.getIdentificacion());


        if (clienteList.Eliminar(cliente)) {
            System.out.println("Cliente eliminado exitosamente.");
            view.displayMessaje("Cliente eliminado exitosamente.");
            buscarTodo();
        } else {
            System.out.println("No se puede eliminar el cliente. No se encontró en la lista.");
            view.displayErrorMessaje("No se puede eliminar el cliente. No se encontró en la lista.");
        }
    }

    @Override
    public void Buscar(Object id) {
        Cliente cliente = clienteList.Buscar(id);
        if (cliente != null) {
            view.display(cliente);
        } else {
            view.displayErrorMessaje("No se encontró el cliente con el ID proporcionado.");
        }
    }

    @Override
    public void buscarTodo() {
        Cliente[] clientes = clienteList.toArray();
        if (clientes.length > 0) {
            view.displayAll(clientes);
        } else {
            view.displayMessaje("No hay clientes registrados.");
        }
    }
}

