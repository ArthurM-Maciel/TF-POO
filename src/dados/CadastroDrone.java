package dados;


import java.util.ArrayList;
import java.util.List;

public class CadastroDrone {
    private ArrayList<Drone> dronesDisponiveis;

    public CadastroDrone() {
        this.dronesDisponiveis = new ArrayList<>();
    }

    // Método para cadastrar um drone
    public String cadastrarDrone(Drone drone) {
        // Verifica se o drone já foi cadastrado
        for (Drone d : dronesDisponiveis) {
            if (d.getCodigo().equals(drone.getCodigo())) {
                return "Erro: Drone com esse código já cadastrado.";
            }
        }
        // Adiciona o drone à lista de drones
        dronesDisponiveis.add(drone);
        return "Drone cadastrado com sucesso!";
    }

    // Retorna a lista de drones disponíveis
    public List<Drone> getDronesDisponiveis() {
        return dronesDisponiveis;
    }

    public ArrayList<Drone> getDronesCadastrados() {
        return dronesDisponiveis;
    }
}
