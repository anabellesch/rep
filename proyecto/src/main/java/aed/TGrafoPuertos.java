package aed;

import java.util.Collection;

public class TGrafoPuertos extends TGrafoNoDirigido {

    public TGrafoPuertos(Collection<TPuerto> vertices, Collection<TRuta> aristas) {
        super(vertices, aristas);
    }

    public TCaminos todosLosCaminosOrdenados(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TPuerto origen = (TPuerto) this.buscarVertice(etiquetaOrigen);
        TPuerto destino = (TPuerto) this.buscarVertice(etiquetaDestino);
            
            
        if (origen != null && destino != null) {

            TCaminos caminos = new TCaminos();
            TCamino camino = new TCamino(origen);
            TCaminos caminosOrdenados = origen.todosLosCaminosOrdenados(etiquetaDestino, camino, caminos);
            return caminosOrdenados;
        }
        

        return null;
    }

    public TCamino noSeComoPonerle(TCaminos caminos){
        TCamino resultado = null;
        for(TCamino camino: caminos.getCaminos()){
            resultado = camino;
            for(TPuerto puerto: camino.getOtrosVertices()){
                TRuta ruta = getLasAristas().buscar(camino.getOrigen(), puerto);
                if (!ruta.estaDisponible()){
                    break;
                }   
            }
        }
        return resultado;
    }

}
