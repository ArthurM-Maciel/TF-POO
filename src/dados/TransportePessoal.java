package dados;

public class TransportePessoal extends Transporte {
    private int qtdPessoas;
    private Drone drone;

    public TransportePessoal(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, int qtdPessoas, Drone drone) {
        super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
        this.qtdPessoas = qtdPessoas;
        this.drone = drone;
    }

    @Override
    public double calculaCusto() {
        double distancia = calcularDistancia();
        double custoVariado = drone.calcularCustoVariado();
        double acrescimo = qtdPessoas * 10.0;
        return (custoVariado * distancia) + acrescimo;
    }

    // Getters and setters omitted for brevity
}