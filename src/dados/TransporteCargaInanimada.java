package dados;

public class TransporteCargaInanimada extends Transporte {
    private boolean cargaPerigosa;

    public TransporteCargaInanimada(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, boolean cargaPerigosa) {
        super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
        this.cargaPerigosa = cargaPerigosa;
    }

    @Override
    public double calculaCusto() {
        double distancia = calcularDistancia();
        double custoVariado = getDrone().calcularCustoVariado();
        double acrescimo = cargaPerigosa ? 500.0 : 0.0;
        return (custoVariado * distancia) + acrescimo;
    }

    // Getters e setters omitidos para brevidade
}