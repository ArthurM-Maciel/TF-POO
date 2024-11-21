public class DronePessoal {
    private final int codigo;
    private final String modelo;

    public DronePessoal(int codigo, String modelo) {
        this.codigo = codigo;
        this.modelo = modelo;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Modelo: " + modelo;
    }
}
