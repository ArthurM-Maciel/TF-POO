public abstract class Transporte {
    private int numero;
    private String nomeCliente;
    private String descricao;
    private double peso;
    private double latitudeOrigem;
    private double latitudeDestino;
    private double longitudeOrigem;
    private double longitudeDestino;
    private Estado situacao;

    public Transporte(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao) {
        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.descricao = descricao;
        this.peso = peso;
        this.latitudeOrigem = latitudeOrigem;
        this.latitudeDestino = latitudeDestino;
        this.longitudeOrigem = longitudeOrigem;
        this.longitudeDestino = longitudeDestino;
        this.situacao = situacao;
    }

    public int getNumero() {
        return numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPeso() {
        return peso;
    }

    public Estado getSituacao() {
        return situacao;
    }

    public void alocar() {
        if (situacao == Estado.PENDENTE) {
            situacao = Estado.ALOCADO;
        }
    }

    public void terminar() {
        if (situacao == Estado.ALOCADO) {
            situacao = Estado.TERMINADO;
        }
    }

    public void cancelar() {
        if (situacao == Estado.PENDENTE || situacao == Estado.ALOCADO) {
            situacao = Estado.CANCELADO;
        }
    }

    public abstract double calculaCusto();
}