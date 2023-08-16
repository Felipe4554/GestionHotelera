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
public boolean Agregar(Type obj);
public boolean Actualizar(Type obj);
public boolean Eliminar(Type obj);
public boolean Buscar(Object id);
}
