package dados;
public abstract class Drone implements Comparable<Drone> {
    private String codigo;
    private double custoFixo;
    private double autonomia;
    private double pesoMaximo;
    private boolean climatizado;

    public Drone(String codigo, double custoFixo, double autonomia, double pesoMaximo, boolean climatizado) {
        this.codigo = codigo;
        this.custoFixo = custoFixo;
        this.autonomia = autonomia;
        this.pesoMaximo = pesoMaximo;
        this.climatizado = climatizado;
    }

    public boolean isClimatizado() {
        return climatizado;
    }

    public abstract double calculaCustoVariado();

    public double calculaCustoPorQuilometro() {
        return custoFixo + calculaCustoVariado();
    }

    public String toString() {
        return "Código: " + codigo + "\nCusto fixo: " + custoFixo + "\nAutonomia: " + autonomia + "\nPeso máximo: " + pesoMaximo + "\nClimatizado: " + climatizado;
    }

    public String getCodigo() {
        return codigo;
    }

    public int compareTo(Drone drone) {
        return this.codigo.compareTo(drone.getCodigo());
    }
}