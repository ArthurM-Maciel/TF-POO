package dados;

public class TransporteCargaViva extends Transporte {
    private double intervaloTemperatura;

    public TransporteCargaViva(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, double intervaloTemperatura) {
        super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
        this.intervaloTemperatura = intervaloTemperatura;
    }

    @Override
    public double calculaCusto() {
        double distancia = calcularDistancia();
        double custoVariado = getDrone().calcularCustoVariado();
        double acrescimo = intervaloTemperatura > 10.0 ? 1000.0 : 0.0;
        return (custoVariado * distancia) + acrescimo;
    }

    // Getters e setters omitidos para brevidade
}