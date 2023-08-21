/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller;

import Models.HabitacionOcupadaException;

/**
 *
 * @author ´Felipe Chacón
 */
public interface MetodoEliminar<Type> {
    void Eliminar(Type obj) throws HabitacionOcupadaException;
}
