// package aed;

// import java.util.ArrayList;
// import java.util.List;

// public class RutaOptima {
//     private TGrafoNoDirigido grafo;
//     private List<Puerto> puertos;

//     public RutaOptima(TGrafoNoDirigido grafo, List<Puerto> puertos) {
//         this.grafo = grafo;
//         this.puertos = puertos;
//     }

//     public Puerto getPuerto(String nombre) {
//         for (Puerto puerto : puertos) {
//             if (puerto.getNombre().equals(nombre)) {
//                 return puerto;
//             }
//         }
//         return null;
//     }

//     public void calcularRutas(String inicio, String fin) {
//         Puerto puertoInicial = getPuerto(inicio);
//         Puerto puertoFinal = getPuerto(fin);
//         if (puertoInicial == null || puertoFinal == null) {
//             System.out.println("No se encontraron los puertos especificados");
//             return;
//         }
//         int[][] predecesores = new int[puertos.size()][puertos.size()];
//         // Obtener la matriz de distancias usando Floyd-Warshall con predecesores
//         Double[][] distancias = grafo.floyd_predecesores(predecesores);

//         // Encontrar la mejor ruta utilizando el algoritmo de Floyd-Warshall con
//         // predecesores
//         List<Puerto> mejorRuta = getMejorRuta(puertos.indexOf(puertoInicial), puertos.indexOf(puertoFinal),
//                 predecesores);
//         for (int i = 0; i<distancias.length; i++) {
//             for (int j = 0; j<distancias.length; j++) {
//                 System.out.print(distancias[i][j] + " ");
//             }
//             System.out.println();
//         }
        
//         // Imprimir la mejor ruta encontrada y su distancia total
//         System.out.println("Mejor ruta encontrada:");
//         imprimirRuta(puertoInicial, mejorRuta, puertoFinal);
//         System.out.println(puertoInicial.getNombre() + " " + puertoFinal.getNombre());
//         System.out.println(
//                 "Distancia total: " + distancias[puertos.indexOf(puertoInicial)][puertos.indexOf(puertoFinal)]);
//     }

//     public List<Puerto> getMejorRuta(int i, int j, int[][] predecesores) {
//         int k = predecesores[i][j];
//         if (k == -1) {
//             return new ArrayList<>();
//         } else {
//             List<Puerto> ruta = new ArrayList<>();
//             ruta.addAll(getMejorRuta(i, k, predecesores));
//             ruta.add(puertos.get(k));
//             ruta.addAll(getMejorRuta(k, j, predecesores));
//             return ruta;
//         }
//     }

//     private void imprimirRuta(Puerto inicial, List<Puerto> ruta, Puerto fin) {
//         StringBuilder sb = new StringBuilder();
//         sb.append(inicial.getNombre()).append(" -> ");
//         for (int i = 0; i < ruta.size(); i++) {
//             sb.append(ruta.get(i).getNombre());
//             if (i < ruta.size() - 1) {
//                 sb.append(" -> ");
//             }

//         }
//         sb.append(fin.getNombre());
//         System.out.println(sb.toString());
//     }
// }
