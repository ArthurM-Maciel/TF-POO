package dados;

public class DroneCargaInanimada extends Drone {
    private boolean protegido;

    public DroneCargaInanimada(String codigo, double custoFixo, double autonomia, double pesoMaximo, boolean protegido) {
        super(codigo, custoFixo, autonomia, pesoMaximo, false);
        this.protegido = protegido;
    }

    public boolean isProtegido() {
        return protegido;
    }

    @Override
    public double calculaCustoVariado() {
        return protegido ? 10.0 : 5.0;
    }

    public boolean podeAtender() {
        return true;
    }
}
