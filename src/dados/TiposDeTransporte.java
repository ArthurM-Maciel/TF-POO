package dados;

public class TiposDeTransporte extends Transporte {
    public TiposDeTransporte(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao) {
        super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
    }

    @Override
    public double calculaCusto() {
        return 0;
    }


    public double calculaAcrescimos() {
        // Implement logic to calculate additional costs based on the type of transport
        return 0; // Placeholder
    }
}

