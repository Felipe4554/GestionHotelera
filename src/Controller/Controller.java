/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller;

/**
 *
 * @author ´Felipe Chacón
 */
public interface Controller<Type> {
public void Agregar(Type obj);
public void Actualizar(Type obj);
public void Eliminar(Type obj);
public void Buscar(Object id);
public void buscarTodo();
}