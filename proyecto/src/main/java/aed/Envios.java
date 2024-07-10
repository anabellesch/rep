package aed;

public class Envios {
    

    private String origen;
    private String destino;
    private int prioridad;

    

    public Envios(String origen, String destino, int prioridad) {
        this.origen = origen;
        this.destino = destino;
        this.prioridad = prioridad;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getPrioridad() {
        return prioridad;
    }


}
