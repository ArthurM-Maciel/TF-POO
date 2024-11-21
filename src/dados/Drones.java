import java.util.ArrayList;
import java.util.Comparator;

public class Drones {
    private final ArrayList<DronePessoal> drones = new ArrayList<>();

    public boolean cadastrarDrone(DronePessoal novoDrone) {
        for (DronePessoal drone : drones) {
            if (drone.getCodigo() == novoDrone.getCodigo()) {
                return false;
            }
        }
        drones.add(novoDrone);
        drones.sort(Comparator.comparingInt(DronePessoal::getCodigo));
        return true;
    }

    public ArrayList<DronePessoal> listarDrones() {
        return new ArrayList<DronePessoal>(drones);
    }

    public boolean isVazio() {
        return drones.isEmpty();
    }
}
