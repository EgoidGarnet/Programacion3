/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.progra03.lab04.entidad;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Entidad {
    private String nombre;
    protected ArrayList<Columna> listaColumnas;
    protected ArrayList<Fila>listaFilas;
    
    public Entidad(String nombre, ArrayList<Columna> listaColumnas){
        this.nombre = nombre;
        this.listaColumnas = new ArrayList<>(listaColumnas);
        this.listaFilas  = new ArrayList<>();
    }
    
    public void insertarFila(){
        Fila filanueva  =  new Fila();
        this.listaFilas.add(filanueva);
    }
    
    public void agregarEnteroEnFila(Integer entero){
        if(!listaFilas.isEmpty()){
            Fila ultimaFila = listaFilas.get(listaFilas.size() - 1);
            ultimaFila.insertarEntero(entero);
        } else {
            System.out.println("No hay filas para agregar el entero.");
        }
    }
    
    public void agregarCadenaEnFila(String cadena){
        if(!listaFilas.isEmpty()){
            Fila ultimaFila = listaFilas.get(listaFilas.size() - 1);
            ultimaFila.insertarCadena(cadena);
        } else {
            System.out.println("No hay filas para agregar la cadena.");
        }
    }
    
    @Override
        public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Entidad: ").append(nombre).append("\n");

        // Cabecera
        for(Columna col : listaColumnas){
            sb.append(col.getNombre()).append("\t");
        }
        sb.append("\n");

        // Filas
        for(Fila fila : listaFilas){
            for(int i=0; i<listaColumnas.size(); i++){
                sb.append(fila.obtenerDato(i)).append("\t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
