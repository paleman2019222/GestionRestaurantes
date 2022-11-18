package Lógica;

/**
 *
 * @author 50236
 */
public class Producto {
private int idproducto;
private String nombreProducto;
private double costoProducto;
private int cantidadProducto;
private int idProveedor;

    public Producto(int idproducto, String nombreProducto, double costoProducto, int cantidadProducto) {
        this.idproducto = idproducto;
        this.nombreProducto = nombreProducto;
        this.costoProducto = costoProducto;
        this.cantidadProducto = cantidadProducto;
    }

    public Producto() {
    }


    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(double costoProducto) {
        this.costoProducto = costoProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idproducto=" + idproducto + ", nombreProducto=" + nombreProducto + ", costoProducto=" + costoProducto + ", cantidadProducto=" + cantidadProducto + ", idProveedor=" + idProveedor + '}';
    }
   // 
}
