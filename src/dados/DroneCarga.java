package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class DroneCarga extends Drones {
    private ArrayList<CadastroDrone> drones = new ArrayList<>();

    public DroneCarga(int codigo, String modelo) {
        super(codigo, modelo);
    }

    public ArrayList<CadastroDrone> getDrones() {
        return drones;
    }

    public void addDrone(CadastroDrone drone) {
        drones.add(drone);
        Collections.sort(drones, new Comparator<CadastroDrone>() {
            @Override
            public int compare(CadastroDrone drone1, CadastroDrone drone2) {
                return drone1.getCodigo().compareTo(drone2.getCodigo());
            }
        });
    }

    @Override
    public abstract double calcularCustoVariado();
}