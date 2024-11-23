package dados;

public class DroneCargaInanimada extends DroneCarga {
    private boolean protecao;

    public DroneCargaInanimada(int codigo, String modelo, boolean protecao) {
        super(codigo, modelo);
        this.protecao = protecao;
    }

    @Override
    public double calcularCustoVariado() {
        return protecao ? 10.0 : 5.0;
    }
}