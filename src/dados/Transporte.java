package dados;

import dados.Transporte;
import dados.Estado;

public class TransporteCargaViva extends Transporte {
    private double temperaturaMinima;
    private double temperaturaMaxima;

    public TransporteCargaViva(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao, double temperaturaMinima, double temperaturaMaxima) {
        super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    @Override
    public double calculaCusto() {
        // Implement the cost calculation logic here
        double custoBase = 100; // Example base cost
        double custoTemperatura = (temperaturaMaxima - temperaturaMinima) * 10; // Example temperature cost calculation
        return custoBase + custoTemperatura;
    }
}