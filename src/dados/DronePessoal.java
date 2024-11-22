package dados;

public class DronePessoal {
    private int codigo;
    private String modelo;

    public DronePessoal(int codigo, String modelo) {
        this.codigo = codigo;
        this.modelo = modelo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "DronePessoal{" +
                "codigo=" + codigo +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}