package dados;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CadastroTransporte {
    private ArrayList<Transporte> transportesCadastrados;
    private Queue<Transporte> transportesPendentes;


    public CadastroTransporte() {
        transportesCadastrados = new ArrayList<>();
        transportesPendentes = new LinkedList<>();
    }

    public String processarTransportesPendentes() {
        if (transportesPendentes.isEmpty()) {
            return "Não há transportes na fila de transportes pendentes.";
        }


        Queue<Transporte> naoAlocados = new LinkedList<>();
        while (!transportesPendentes.isEmpty()) {
            Transporte transporte = transportesPendentes.poll();
            boolean alocado = false;

            for (Transporte transporte1 : transportesCadastrados) {
                if (transporte1.podeAtender(transporte1)) {
                    transporte1.setSituacao(Estado.ALOCADO);
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

    public String cadastrarTransporte(Transporte transporte) {
        for (Transporte t : transportesCadastrados) {
            if (t.getNumero() == transporte.getNumero()) {
                return "Erro: Transporte com o número indicado já existe.";
            }
        }
        transportesCadastrados.add(transporte);
        return "Transporte cadastrado com sucesso!";
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

    public List<Transporte> getTransportesCadastrados() {
        return transportesCadastrados;
    }


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

}