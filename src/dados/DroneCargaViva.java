package dados;

public class DroneCargaViva extends DroneCarga {

    private boolean climatizado;

    public DroneCargaViva(String codigo, double custoFixo, double autonomia, double pesoMaximo, boolean climatizado) {
        super(codigo, custoFixo, autonomia, pesoMaximo);
        this.climatizado = climatizado;
    }

    public boolean isClimatizado() {
        return climatizado;
    }

    @Override
    public double calculaCustoKm() {
        if(climatizado)
            return getCustoFixo() +  20;
        else
            return getCustoFixo() +  10;
    }
}