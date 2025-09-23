package pe.edu.pucp.progra03.lab04.entidad.persistencia;

import pe.edu.pucp.progra03.lab04.entidad.Entidad;
import pe.edu.pucp.progra03.lab04.entidad.Fila;
import pe.edu.pucp.progra03.lab04.entidad.Columna;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class EntidadPersistente extends Entidad {
    private String nombreArchivo;

    // Constructor
    public EntidadPersistente(String nombre, ArrayList<Columna> listaColumnas) {
        super(nombre, listaColumnas);
        this.nombreArchivo = nombre + ".csv"; // archivo asociado
    }

    // Método para guardar la entidad en un archivo CSV
    public void salvarEnArchivo() {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {

            // Escribir cabecera
            for (int i = 0; i < listaColumnas.size(); i++) {
                writer.write(listaColumnas.get(i).getNombre());
                if (i < listaColumnas.size() - 1) writer.write(",");
            }
            writer.write("\n");

            // Escribir filas
            for (Fila fila : listaFilas) {
                for (int i = 0; i < listaColumnas.size(); i++) {
                    Object dato = fila.obtenerDato(i);
                    writer.write(dato.toString());
                    if (i < listaColumnas.size() - 1) writer.write(",");
                }
                writer.write("\n");
            }

            writer.flush(); // asegurar que todo se escriba
        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }

    // Método para cargar la entidad desde un archivo CSV
    public void cargarDesdeArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            boolean primeraLinea = true;

            listaFilas.clear(); // limpiar filas antes de cargar

            while ((linea = br.readLine()) != null) {
                if (primeraLinea) { // saltar cabecera
                    primeraLinea = false;
                    continue;
                }

                String[] datos = linea.split(",");
                insertarFila(); // crear nueva fila
                for (int i = 0; i < datos.length; i++) {
                    Columna col = listaColumnas.get(i);
                    if (col.getTipoDeDato() == pe.edu.pucp.progra03.lab04.entidad.TipoDeDato.NUMERO) {
                        agregarEnteroEnFila(Integer.parseInt(datos[i]));
                    } else {
                        agregarCadenaEnFila(datos[i]);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar archivo: " + e.getMessage());
        }
    }
}
