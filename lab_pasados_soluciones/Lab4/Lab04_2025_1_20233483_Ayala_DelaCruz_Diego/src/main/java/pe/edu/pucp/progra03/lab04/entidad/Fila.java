/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.progra03.lab04.entidad;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Fila {
    private ArrayList<Object> listaDatos;
    
    public Fila(){
        listaDatos = new ArrayList<>();          
    }
    
    public void insertarEntero(Integer dato){
        listaDatos.add(dato);
    }
    
    public void insertarCadena(String dato){
        listaDatos.add(dato);
    }
    
    public Object obtenerDato(Integer indice){
        return listaDatos.get(indice);
    }
}
