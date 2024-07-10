package aed;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * documentar
 * monografia (4 carillas)
 * tests
 * diagrama
 * crear clase envio con origen, destino, prioridad
 * envios en un vector con sorting en base a la prioridad
 * recorrer los envios y llamar a mejor camino
 */
public class App {

    public static void main(String[] args) {

        //TGrafoPuertos grafo = (TGrafoPuertos) UtilGrafos.cargarGrafo("src//puertos.txt", "src//rutas.txt", false,
                //TGrafoPuertos.class);
                String[] puertos = ManejadorArchivosGenerico.leerArchivo("src//puertos.txt", false);
                String[] rutas = ManejadorArchivosGenerico.leerArchivo("src\\rutas.txt", false);
                List<TPuerto> puertos2 = new LinkedList<>();
                List<TRuta> rutas2 = new LinkedList<>();
                for (String puerto : puertos) {
                    puertos2.add(new TPuerto(puerto));
                }
                for (String ruta: rutas){
                    String[] datos = ruta.split(",");
                    rutas2.add(new TRuta(datos[0], datos[1], Double.parseDouble(datos[2]), Integer.parseInt(datos[3])));
                }
                
                TGrafoPuertos grafo = new TGrafoPuertos(puertos2, rutas2);
        // if (grafo == null) {
        //     System.out.println("Graph not loaded correctly.");
        //     return;
        // }
        TCaminos caminos = grafo.todosLosCaminosOrdenados("BSAS", "Santos");

        if (caminos == null) {
            System.out.println("No paths found between BSAS and Santos.");
        } else {
            caminos.imprimirCaminosConsola();
        }

        

    }
}
