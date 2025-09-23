/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.progra03.lab04.entidad;

/**
 *
 * @author USUARIO
 */
public class Columna {
    private String nombre;
    private TipoDeDato tipoDeDato;
    
    public Columna(String nombre, TipoDeDato tipoDeDato){
        this.nombre = nombre;
        this.tipoDeDato = tipoDeDato;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tipoDeDato
     */
    public TipoDeDato getTipoDeDato() {
        return tipoDeDato;
    }

    /**
     * @param tipoDeDato the tipoDeDato to set
     */
    public void setTipoDeDato(TipoDeDato tipoDeDato) {
        this.tipoDeDato = tipoDeDato;
    }
    
    
}
