package dados;

public class DroneCargaViva extends Drone {
    public DroneCargaViva(String codigo, double custoFixo, double autonomia, double pesoMaximo, boolean climatizado) {
        super(codigo, custoFixo, autonomia, pesoMaximo, climatizado);
    }

    @Override
    public double calculaCustoVariado() {
        return isClimatizado() ? 20.0 : 10.0;
    }

}