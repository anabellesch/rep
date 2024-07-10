package aed;

public class TRuta extends TArista {
    
    private int topeDiario;
    private int usoActual;

    public TRuta(Comparable etiquetaOrigen, Comparable etiquetaDestino, double costo, int topeDiario) {
        super(etiquetaOrigen, etiquetaDestino, costo);
        this.topeDiario = topeDiario;
        this.usoActual = 0;
        
    }

    public int getTopeDiario() {
        return topeDiario;
    }

    public int getUsoActual() {
        return usoActual;
    }

    public void incrementarUso() {
        if (usoActual < topeDiario) {
            usoActual++;
        } else {
            throw new IllegalStateException("Se ha alcanzado el tope diario para esta ruta.");
        }
    }

    public boolean estaDisponible() {
        return usoActual < topeDiario;
    }

    public void reiniciarUso() {
        usoActual = 0;
    }

}
