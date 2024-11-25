package dados;

public class DroneCargaInanimada  extends DroneCarga{
    private boolean protecao;

    public DroneCargaInanimada(String codigo, double custoFixo, double autonomia, double pesoMaximo, boolean protecao) {
        super(codigo, custoFixo, autonomia, pesoMaximo);
        this.protecao = protecao;
    }

    public boolean isProtecao() {
        return protecao;
    }

    @Override
    public double calculaCustoVariado() {
        return protecao ? 10.0 : 5.0;
    }

    public boolean podeAtender() {
        return true;
    }

}
