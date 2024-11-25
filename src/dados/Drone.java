package dados;
public abstract class Drone implements Comparable<Drone> {
    private String codigo;
    private double custoFixo;
    private double autonomia;
    public Drone(String codigo, double custoFixo, double autonomia) {
        this.codigo = codigo;
        this.custoFixo = custoFixo;
        this.autonomia = autonomia;
    }

    public abstract double calculaCustoVariado();

    public double calculaCustoPorQuilometro() {
        return custoFixo + calculaCustoVariado();
    }

    public String toString() {
        return "Drone " + codigo + " - Custo por km: R$ " + calculaCustoPorQuilometro();
    }

    public String getCodigo() {
        return codigo;
    }

    public int compareTo(Drone drone) {
        return this.codigo.compareTo(drone.getCodigo());
    }

    public double getAutonomia() {
        return autonomia;
    }
    public double getCustoFixo() {
        return custoFixo;
    }

    public double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

}