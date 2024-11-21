package dados;

public class CadastroDrone {
    String codigo;
    String custo;
    String autonomia;
    String peso;
    String protecao;
    String tipoCarga;

    public CadastroDrone(String codigo, String custo, String autonomia, String peso, String protecao, String tipoCarga) {
        this.codigo = codigo;
        this.custo = custo;
        this.autonomia = autonomia;
        this.peso = peso;
        this.protecao = protecao;
        this.tipoCarga = tipoCarga;
    }

    public String toString() {
        return "Codigo:" + codigo + "\n" + "Custo:" + custo + "\n" + "Autonomia:" + autonomia + "\n" + "Peso:" + peso + "\n" + "Categoria:" + tipoCarga + "-" + protecao;
    }
}