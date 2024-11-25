package dados;

public class DronePessoal extends Drone {
    private int quantidadeMaximaPessoas;

    public DronePessoal(String codigo, double custoFixo, double autonomia, int quantidadeMaximaPessoas) {
        super(codigo, custoFixo, autonomia);
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