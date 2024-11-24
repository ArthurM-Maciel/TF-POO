package dados;

public class DronePessoal extends Drone {
    private int quantidadeMaximaPessoas;

    public DronePessoal(String codigo, double custoFixo, double autonomia, double pesoMaximo, int quantidadeMaximaPessoas) {
        super(codigo, custoFixo, autonomia, pesoMaximo, false);
        this.quantidadeMaximaPessoas = quantidadeMaximaPessoas;
    }

    public int getQuantidadeMaximaPessoas() {
        return quantidadeMaximaPessoas;
    }

    @Override
    public double calculaCustoVariado() {
        return 2.0 * quantidadeMaximaPessoas;
    }
}