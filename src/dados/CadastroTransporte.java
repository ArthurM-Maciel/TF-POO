package dados;

import java.util.ArrayList;
import java.util.List;

public class CadastroTransporte {
    private List<Transporte> transportesPendentes;
    private List<Transporte> transportesCadastrados;
    private List<DronePessoal> drones;

    public CadastroTransporte() {
        transportesPendentes = new ArrayList<>();
        transportesCadastrados = new ArrayList<>();
        drones = new ArrayList<>();
    }

    public String cadastrarTransporte(String nomeCliente, String numero, String descricao, String peso) {
        if (nomeCliente == null || nomeCliente.isEmpty() || !nomeCliente.matches("[a-zA-Z\\s]+")) {
            return "Erro: Nome do cliente inválido.";
        }

        try {
            int num = Integer.parseInt(numero);
            double pesoDouble = Double.parseDouble(peso);

            for (Transporte t : transportesPendentes) {
                if (t.getNumero() == num) {
                    return "Erro: Número do transporte já existe.";
                }
            }

            Transporte transporte = new TransporteConcreto(num, nomeCliente, descricao, pesoDouble, 0, 0, 0, 0, Estado.PENDENTE);
            transportesPendentes.add(transporte);
            return "Transporte cadastrado com sucesso!";
        } catch (NumberFormatException e) {
            return "Erro ao cadastrar transporte: número ou peso inválido.";
        }
    }

    public String mostrarTransportesPendentes() {
        if (transportesPendentes.isEmpty()) {
            return "Nenhum transporte pendente.";
        }
        StringBuilder sb = new StringBuilder("Transportes Pendentes:\n");
        for (Transporte t : transportesPendentes) {
            sb.append(t.getNumero()).append(" - ").append(t.getNomeCliente()).append(" - ").append(t.getDescricao()).append("\n");
        }
        return sb.toString();
    }

    public String mostrarTransportes() {
        if (transportesCadastrados.isEmpty()) {
            return "Nenhum transporte cadastrado.";
        }
        StringBuilder sb = new StringBuilder("Transportes Cadastrados:\n");
        for (Transporte t : transportesCadastrados) {
            sb.append(t.getNumero()).append(" - ").append(t.getNomeCliente()).append(" - ").append(t.getDescricao()).append("\n");
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
        for (Transporte t : transportesCadastrados) {
            if (t.getNumero() == numero && (t.getSituacao() == Estado.PENDENTE || t.getSituacao() == Estado.ALOCADO)) {
                t.cancelar();
                transportesCadastrados.remove(t);
                break;
            }
        }
    }

    public void terminarTransporte(int numero) {
        for (Transporte t : transportesCadastrados) {
            if (t.getNumero() == numero && t.getSituacao() == Estado.ALOCADO) {
                t.terminar();
                break;
            }
        }
    }

    public boolean cadastrarDrone(DronePessoal drone) {
        for (DronePessoal d : drones) {
            if (d.getCodigo() == drone.getCodigo()) {
                return false;
            }
        }
        int posicao = 0;
        while (posicao<drones.size() && drones.get(posicao).getCodigo() < drone.getCodigo()){
            posicao++;
        }
        drones.add(drone);
        return true;
    }

    public boolean isVazio() {
        return drones.isEmpty();
    }

    public List<DronePessoal> listarDrones() {
        return new ArrayList<>(drones);
    }

    private class TransporteConcreto extends Transporte {
        public TransporteConcreto(int numero, String nomeCliente, String descricao, double peso, double latitudeOrigem, double latitudeDestino, double longitudeOrigem, double longitudeDestino, Estado situacao) {
            super(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao);
        }

        @Override
        public double calculaCusto() {
            return getPeso() * 5; // Simple example calculation based on weight
        }
    }
}