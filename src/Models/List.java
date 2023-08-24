/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Models;

/**
 *
 * @author ´Felipe Chacón
 */
public interface List<Type> {
public boolean Agregar(Type obj);
public boolean Actualizar(Type obj);
public boolean Eliminar(Type obj);
public Type Buscar(Object id);
public Type[] toArray();
}
