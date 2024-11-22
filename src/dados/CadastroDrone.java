package dados;

public class CadastroDrone {
    private String codigo;
    private String custo;
    private String autonomia;
    private String peso;
    private String protecao;
    private String tipoCarga;

    public CadastroDrone(String codigo, String custo, String autonomia, String peso, String protecao, String tipoCarga) {
        this.codigo = codigo;
        this.custo = custo;
        this.autonomia = autonomia;
        this.peso = peso;
        this.protecao = protecao;
        this.tipoCarga = tipoCarga;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "CadastroDrone{" +
                "codigo='" + codigo + '\'' +
                ", custo='" + custo + '\'' +
                ", autonomia='" + autonomia + '\'' +
                ", peso='" + peso + '\'' +
                ", protecao='" + protecao + '\'' +
                ", tipoCarga='" + tipoCarga + '\'' +
                '}';
    }
}