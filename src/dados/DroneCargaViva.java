package dados;

public class DroneCargaViva extends Drone {
    private boolean climatizado;

    public DroneCargaViva(int codigo, String modelo, boolean climatizado) {
        super(codigo, modelo);
        this.climatizado = climatizado;
    }

    @Override
    public double calcularCustoVariado() {
        return climatizado ? 20.0 : 10.0;
    }

    // Getters and setters omitted for brevity
}