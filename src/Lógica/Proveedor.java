package Lógica;

/**
 *
 * @author 50236
 */
public class Proveedor {
    private int idproveedor;
    private String nombreProveedor;

    public Proveedor() {
    }

    public Proveedor(int idproveedor, String nombreProveedor) {
        this.idproveedor = idproveedor;
        this.nombreProveedor = nombreProveedor;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idproveedor=" + idproveedor + ", nombreProveedor=" + nombreProveedor + '}';
    }
}
