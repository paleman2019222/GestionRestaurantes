package Lógica;

/**
 *
 * @author PABLO ALEMAN
 */
public class Empleado {

    //comentario pablo
    
    private int idEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String usuarioEmpleado;
    private int telefonoUsuario;
    private String direccionEmpleado;
    private double sueldoEmpleado;
    private int idPuesto;

    public Empleado() {
    }

    public Empleado(int idEmpleado, String nombreEmpleado, String apellidoEmpleado, String usuarioEmpleado, int telefonoUsuario, String direccionEmpleado, double sueldoEmpleado, int idPuesto) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.usuarioEmpleado = usuarioEmpleado;
        this.telefonoUsuario = telefonoUsuario;
        this.direccionEmpleado = direccionEmpleado;
        this.sueldoEmpleado = sueldoEmpleado;
        this.idPuesto = idPuesto;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public String getUsuarioEmpleado() {
        return usuarioEmpleado;
    }

    public void setUsuarioEmpleado(String usuarioEmpleado) {
        this.usuarioEmpleado = usuarioEmpleado;
    }

    public int getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(int telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getDireccionEmpleado() {
        return direccionEmpleado;
    }

    public void setDireccionEmpleado(String direccionEmpleado) {
        this.direccionEmpleado = direccionEmpleado;
    }

    public double getSueldoEmpleado() {
        return sueldoEmpleado;
    }

    public void setSueldoEmpleado(double sueldoEmpleado) {
        this.sueldoEmpleado = sueldoEmpleado;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", apellidoEmpleado=" + apellidoEmpleado + ", usuarioEmpleado=" + usuarioEmpleado + ", telefonoUsuario=" + telefonoUsuario + ", direccionEmpleado=" + direccionEmpleado + ", sueldoEmpleado=" + sueldoEmpleado + ", idPuesto=" + idPuesto + '}';
    }
    
    
    
    
}
