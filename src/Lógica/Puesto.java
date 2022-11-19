package Lógica;

import GUI.PuestoView;
import Persistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author 50236
 */
public class Puesto {
    private int idpuesto;
    private String puesto;
    Conexion cnn = new Conexion ();

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
    
    
    public void nuevoRegistro(JTextField txtidpuesto, JTextField txtpuesto){
        //Conexion cnn = new Conexion ();
        Connection cn = cnn.conectar();
        
        Puesto puesto = new Puesto ();
        puesto.setIdpuesto(Integer.parseInt(txtidpuesto.getText()));
        puesto.setPuesto(txtpuesto.getText());
        
        try {
            String sql = "CALL REGISTRAR_CLIENTE (?,?)";
            PreparedStatement consulta = cn.prepareStatement(sql);
            
            consulta.setInt(1, puesto.getIdpuesto());
            consulta.setString(2, puesto.getPuesto());
            
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han registrado los datos");
            consulta.close();
        }                                       
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos ");
            Logger.getLogger(PuestoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //mostrar("puesto");
    }
    public void modificarRegistro(JTextField txtidpuesto, JTextField txtpuesto){
        //Conexion cnn = new Conexion ();
        Connection cn = cnn.conectar();
        
        Puesto puesto = new Puesto ();
        puesto.setIdpuesto(Integer.parseInt(txtidpuesto.getText()));
        puesto.setPuesto(txtpuesto.getText());
        
        try {
            String sql = "CALL MODIFICAR_CLIENTE (?,?)";
            PreparedStatement consulta = cn.prepareStatement(sql);
            
            consulta.setInt(1, puesto.getIdpuesto());
            consulta.setString(2, puesto.getPuesto());
            
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han modificado los datos");
            consulta.close();
        }                                       
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos ");
            Logger.getLogger(PuestoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //mostrar("puesto");
    }
}
