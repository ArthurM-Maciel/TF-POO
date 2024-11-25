package dados;

public class DroneCargaViva extends DroneCarga {

    private boolean climatizado;

    public DroneCargaViva(String codigo, double custoFixo, double autonomia, double pesoMaximo, boolean climatizado) {
        super(codigo, custoFixo, autonomia, pesoMaximo);
        this.climatizado = climatizado;
    }

    @Override
    public double calculaCustoVariado() {
        return this.climatizado ? 20.0 : 10.0;
    }


}