package pe.edu.pucp.progra03.lab04;

import java.util.ArrayList;
import pe.edu.pucp.progra03.lab04.entidad.Columna;
import pe.edu.pucp.progra03.lab04.entidad.TipoDeDato;
import pe.edu.pucp.progra03.lab04.entidad.persistencia.EntidadPersistente;

public class Lab04_2025_1_20233483_Ayala_DelaCruz_Diego {

    public static void main(String[] args) {
        ArrayList<Columna> listaColumnas = new ArrayList<>();
        listaColumnas.add(new Columna("id", TipoDeDato.NUMERO));
        listaColumnas.add(new Columna("nombre", TipoDeDato.CADENA));
        listaColumnas.add(new Columna("paterno", TipoDeDato.CADENA));
        listaColumnas.add(new Columna("materno", TipoDeDato.CADENA));
        
        EntidadPersistente entidad = new EntidadPersistente("Alumno", listaColumnas);
        entidad.insertarFila();
        entidad.agregarEnteroEnFila(19941146);
        entidad.agregarCadenaEnFila("Héctor Andrés");
        entidad.agregarCadenaEnFila("Melgar");
        entidad.agregarCadenaEnFila("Sasieta");
        entidad.insertarFila();
        entidad.agregarEnteroEnFila(20112728);
        entidad.agregarCadenaEnFila("Freddy Alberto");
        entidad.agregarCadenaEnFila("Paz");
        entidad.agregarCadenaEnFila("Espinoza");
        entidad.salvarEnArchivo();
        
        EntidadPersistente entidad2 = new EntidadPersistente("Alumno", listaColumnas);
        entidad2.cargarDesdeArchivo();
        System.out.println(entidad2);
        
         // =========================
        // CÓDIGO ADICIONAL PARA PRUEBA
        // =========================
        System.out.println("\n--- Probando agregar más datos y re-salvar ---");
        entidad2.insertarFila();
        entidad2.agregarEnteroEnFila(20250001);
        entidad2.agregarCadenaEnFila("Laura");
        entidad2.agregarCadenaEnFila("Gómez");
        entidad2.agregarCadenaEnFila("Torres");
        entidad2.salvarEnArchivo(); // vuelve a guardar incluyendo la nueva fila

        // Leer nuevamente
        EntidadPersistente entidad3 = new EntidadPersistente("Alumno", listaColumnas);
        entidad3.cargarDesdeArchivo();
        System.out.println(entidad3);
    }
}

