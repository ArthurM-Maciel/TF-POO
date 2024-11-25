package dados;

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

    public void setSituacao(Estado situacao) {
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

    public void cancelar() {
        this.situacao = Estado.CANCELADO;
    }

    public void terminar() {
        this.situacao = Estado.TERMINADO;
    }

    public abstract double calculaCusto();

    public boolean podeAtender(Transporte transporte) {
        return true;
    }

    protected double calcularDistancia() {
        // Implementar lógica de cálculo de distância
        return 0;
    }
    public String toString() {
        return "Número: " + numero + "\nNome do Cliente: " + nomeCliente + "\nDescrição: " + descricao + "\nPeso: " + peso + "\nLatitude Origem: " + latitudeOrigem + "\nLatitude Destino: " + latitudeDestino + "\nLongitude Origem: " + longitudeOrigem + "\nLongitude Destino: " + longitudeDestino + "\nSituação: " + situacao;
    }

}