package dados;

public class DroneCargaInanimada extends Drone {
    private boolean protecao;

    public DroneCargaInanimada(int codigo, String modelo, boolean protecao) {
        super(codigo, modelo);
        this.protecao = protecao;
    }

    @Override
    public double calcularCustoVariado() {
        return protecao ? 10.0 : 5.0;
    }

    // Getters and setters omitted for brevity
}