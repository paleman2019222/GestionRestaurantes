package Lógica;

import GUI.PuestoView;
import Persistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 50236
 */
public class Puesto {
    private int idpuesto;
    private String puesto;
    Conexion cnn = new Conexion ();
    Connection cn = cnn.conectar();

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
    
    public void mostrar(JTable TablePuesto){
        DefaultTableModel modelPuesto = new DefaultTableModel ();
        String []datos = new String [2]; 
        
        String sql = "select * from puesto";
        Statement st;
        modelPuesto.addColumn("ID");
        modelPuesto.addColumn("Puesto");
        TablePuesto.setModel(modelPuesto);
        
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                modelPuesto.addRow(datos);
            }
            
            TablePuesto.setModel(modelPuesto);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al mostrar los datos: "+e.toString());
        }
    }
    
    public void nuevoRegistro(JTextField txtpuesto){
        Puesto puesto = new Puesto ();
        puesto.setPuesto(txtpuesto.getText());
        String sql= "INSERT INTO puesto (puesto) values (?)";
        
        try {
            PreparedStatement consulta = cn.prepareStatement(sql);
            consulta.setString(1, puesto.getPuesto());
            
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han registrado los datos");
            consulta.close();
        }                                       
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: "+ex.toString());
            Logger.getLogger(PuestoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarRegistro(JTextField txtidpuesto, JTextField txtpuesto){
        Puesto puesto = new Puesto ();
        puesto.setIdpuesto(Integer.parseInt(txtidpuesto.getText()));
        puesto.setPuesto(txtpuesto.getText());
        String sql= "UPDATE puesto SET puesto.puesto = ? WHERE puesto.idpuesto = ?";
        
        try {
            PreparedStatement consulta = cn.prepareStatement(sql);
            
            consulta.setString(1, puesto.getPuesto());
            consulta.setInt(2, puesto.getIdpuesto());
            
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han modificado los datos");
            consulta.close();
        }                                       
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos: "+ex.toString());
            Logger.getLogger(PuestoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
