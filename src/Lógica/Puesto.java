package Lógica;

/**
 *
 * @author 50236
 */
public class Puesto {
    private int idpuesto;
    private String puesto;

    public Puesto() {
    }

    public Puesto(int idpuesto, String puesto) {
        this.idpuesto = idpuesto;
        this.puesto = puesto;
    }

    public int getIdpuesto() {
        return idpuesto;
    }

    public void setIdpuesto(int idpuesto) {
        this.idpuesto = idpuesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Puesto{" + "idpuesto=" + idpuesto + ", puesto=" + puesto + '}';
    }
}
