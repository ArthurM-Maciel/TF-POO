package dados;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CadastroTransporte {
    private List<Transporte> transportesCadastrados;
    private Queue<Transporte> transportesPendentes;
    private List<Drone> dronesDisponiveis;

    public CadastroTransporte() {
        transportesPendentes = new LinkedList<>();
        dronesDisponiveis = new ArrayList<>();
        transportesCadastrados = new ArrayList<>();
    }

    public String processarTransportesPendentes() {
        if (transportesPendentes.isEmpty()) {
            return "Não há transportes na fila de transportes pendentes.";
        }


        Queue<Transporte> naoAlocados = new LinkedList<>();
        while (!transportesPendentes.isEmpty()) {
            Transporte transporte = transportesPendentes.poll();
            boolean alocado = false;

            for (Drone drone : dronesDisponiveis) {
                if (drone.podeAtender(transporte)) {
                    transporte.setSituacao(Estado.ALOCADO);
                    alocado = true;
                    break;
                }
            }

            if (!alocado) {
                naoAlocados.add(transporte);
            }
        }

        transportesPendentes = naoAlocados;
        return "Processamento de transportes pendentes concluído.";
    }

    public String cadastrarTransporte(String nomeCliente, String numero, String descricao, String peso) {
        if (nomeCliente == null || nomeCliente.isEmpty() || !nomeCliente.matches("[a-zA-Z\\s]+")) {
            return "Erro: Nome do cliente inválido.";
        }

        try {
            int numeroInt = Integer.parseInt(numero);
            double pesoDouble = Double.parseDouble(peso);
            Transporte transporte = new TiposDeTransporte(numeroInt, nomeCliente, descricao, pesoDouble, 0, 0, 0, 0, Estado.PENDENTE);
            transportesPendentes.add(transporte);
            return "Transporte cadastrado com sucesso!";
        } catch (NumberFormatException e) {
            return "Erro: Número ou peso inválido.";
        }
    }
    public String mostrarTransportesPendentes() {
        if (transportesPendentes.isEmpty()) {
            return "Não há transportes pendentes.";
        }
        StringBuilder sb = new StringBuilder("Transportes Pendentes:\n");
        for (Transporte t : transportesPendentes) {
            sb.append(t).append("\n");
        }
        return sb.toString();
    }

    public String mostrarTransportes() {
        if (transportesCadastrados.isEmpty()) {
            return "Não há transportes cadastrados.";
        }
        StringBuilder sb = new StringBuilder("Transportes Cadastrados:\n");
        for (Transporte t : transportesCadastrados) {
            sb.append(t).append("\n");
        }
        return sb.toString();
    }

    public void confirmarTransporte(int numero) {
        Transporte transporte = null;
        for (Transporte t : transportesPendentes) {
            if (t.getNumero() == numero) {
                transporte = t;
                break;
            }
        }
        if (transporte != null) {
            transportesPendentes.remove(transporte);
            transportesCadastrados.add(transporte);
        }
    }

    public void cancelarTransporte(int numero) {
        transportesCadastrados.removeIf(t -> t.getNumero() == numero);
    }

    public void terminarTransporte(int numero) {
        for (Transporte t : transportesCadastrados) {
            if (t.getNumero() == numero) {
                t.setSituacao(Estado.TERMINADO);
                break;
            }
        }
    }
    public List<Drone> getDronesDisponiveis() {
        return new ArrayList<>(dronesDisponiveis);
    }

    public List<Transporte> getTransportesCadastrados() {
        return new ArrayList<>(transportesCadastrados);
    }

    // In CadastroTransporte.java

    public Transporte buscarTransporte(int numero) {
        for (Transporte t : transportesCadastrados) {
            if (t.getNumero() == numero) {
                return t;
            }
        }
        for (Transporte t : transportesPendentes) {
            if (t.getNumero() == numero) {
                return t;
            }
        }
        return null;
    }

    public void alterarSituacaoTransporte(int numero, String novaSituacao) {
        Transporte transporte = buscarTransporte(numero);
        if (transporte != null) {
            transporte.setSituacao(Estado.valueOf(novaSituacao));
        }
    }



    private class TransporteConcreto extends Transporte {
        public TransporteConcreto(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao) {
            super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
        }

        @Override
        public double calculaCusto() {
            return 0;
        }

        // In CadastroTransporte.java


    }
}