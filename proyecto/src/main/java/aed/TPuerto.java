package aed;

public class TPuerto extends TVertice<TPuerto> {

    
    

    public TPuerto(String nombre) {
        super(nombre);

    }

    public TCaminos todosLosCaminosOrdenados(Comparable<String> etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        // Marcar el vértice actual como visitado
        setVisitado(true);
        // Iterar sobre todos los vértices adyacentes

        for (IAdyacencia<TPuerto> adyacente : this.getAdyacentes()) {
            
            IVertice<TPuerto> destino = adyacente.getDestino();
            // Si el vértice adyacente no ha sido visitado
            if (!destino.getVisitado()) {
                // Si el vértice adyacente es el destino
                if (adyacente.getDestino().getEtiqueta().equals(etVertDest)) {
                    // Copiar el camino previo y agregar la adyacencia actual a él
                    TCamino caminoCopia = caminoPrevio.copiar();
                    caminoCopia.agregarAdyacencia(adyacente);
                    // Agregar el nuevo camino a la colección de todos los caminos
                    todosLosCaminos.getCaminos().add(caminoCopia);
                } else {
                    // Si el vértice adyacente no es el destino, agregar la adyacencia al camino
                    // previo
                    caminoPrevio.agregarAdyacencia(adyacente);
                    // Llamar recursivamente al método para el vértice adyacente
                    destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    // Eliminar la adyacencia actual del camino previo
                    caminoPrevio.eliminarAdyacencia(adyacente);
                }
            }
        }
        // Marcar el vértice actual como no visitado
        setVisitado(false);
        // nunca los ordena
        TCamino[] listaCaminos = (TCamino[]) todosLosCaminos.getCaminos().toArray(new TCamino[todosLosCaminos.getCaminos().size()]);
        TClasificador clasificador = new TClasificador();
        clasificador.clasificarCaminos(listaCaminos, 6);
        TCaminos caminosOrdenados = new TCaminos();
        for (TCamino camino : listaCaminos) {
            caminosOrdenados.getCaminos().add(camino);
        }
        
        return caminosOrdenados;
    }

    
}



