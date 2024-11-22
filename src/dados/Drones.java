package dados;

public abstract class Drones {
    private int codigo;
    private String modelo;

    public Drones(int codigo, String modelo) {
        this.codigo = codigo;
        this.modelo = modelo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public abstract double calcularCustoVariado();
}