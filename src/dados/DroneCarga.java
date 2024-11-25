package dados;

public abstract class DroneCarga extends Drone {
    private double pesoMaximo;

    public DroneCarga(String codigo, double custoFixo, double autonomia, double pesoMaximo) {
        super(codigo, custoFixo, autonomia);
        this.pesoMaximo = pesoMaximo;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    @Override
    public double calculaCustoVariado() {
        return 0.0;
    }
    public boolean podeAtender(Transporte transporte) {
        if (transporte.getPeso() > this.pesoMaximo) {
            return false;
        }

        double distancia = calcularDistancia(transporte.getLatitudeOrigem(), transporte.getLongitudeOrigem(), transporte.getLatitudeDestino(), transporte.getLongitudeDestino());
        if (distancia > this.getAutonomia()) {
            return false;
        }

        return true;
    }

}
