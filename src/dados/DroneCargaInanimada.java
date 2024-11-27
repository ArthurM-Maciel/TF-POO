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

    public boolean podeAtender() {
        return true;
    }

    public boolean isProtegido() {
        return protecao;
    }

    @Override
    public double calculaCustoKm() {
        if(protecao)
            return getCustoFixo() +  10;
        else
            return getCustoFixo() +  5;
    }
}

