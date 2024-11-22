package dados;

public class TransporteCargaInanimada extends Transporte {
    private boolean cargaPerigosa;
    private Drones drone;

    public TransporteCargaInanimada(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, boolean cargaPerigosa, Drones drone) {
        super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
        this.cargaPerigosa = cargaPerigosa;
        this.drone = drone;
    }

    @Override
    public double calculaCusto() {
        double distancia = calcularDistancia();
        double custoVariado = drone.calcularCustoVariado();
        double acrescimo = cargaPerigosa ? 500.0 : 0.0;
        return (custoVariado * distancia) + acrescimo;
    }
}