package dados;

public class DroneCargaViva extends DroneCarga {
    private boolean climatizado;

    public DroneCargaViva(int codigo, String modelo, boolean climatizado) {
        super(codigo, modelo);
        this.climatizado = climatizado;
    }

    @Override
    public double calcularCustoVariado() {
        return climatizado ? 20.0 : 10.0;
    }
}