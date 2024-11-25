package dados;


import java.util.ArrayList;
import java.util.List;

public class CadastroDrone {
    private ArrayList<Drone> dronesDisponiveis;

    public CadastroDrone() {
        this.dronesDisponiveis = new ArrayList<>();
    }

    public String cadastrarDrone(Drone drone) {
        for (Drone d : dronesDisponiveis) {
            if (d.getCodigo().equals(drone.getCodigo())) {
                return "Erro: Drone com esse código já cadastrado.";
            }
        }

        int index = 0;
        while (index < dronesDisponiveis.size() && dronesDisponiveis.get(index).getCodigo().compareTo(drone.getCodigo()) < 0) {
            index++;
        }
        dronesDisponiveis.add(index, drone);
        return "Drone cadastrado com sucesso!";
    }

    public List<Drone> getDronesDisponiveis() {
        return dronesDisponiveis;
    }

    public ArrayList<Drone> getDronesCadastrados() {
        return dronesDisponiveis;
    }
}
