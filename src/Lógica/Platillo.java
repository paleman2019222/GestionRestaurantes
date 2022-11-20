package Lógica;

import Persistencia.Conexion;
import GUI.PlatilloView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 50236
 */
public class Platillo {
    private int idplatillo;
    private String nombrePlatillo;
    private double precioPlatillo;
    Conexion cnn = new Conexion ();
    Connection cn = cnn.conectar();
    
    public Platillo() {
    }
    
    public Platillo(int idplatillo, String nombrePlatillo, double precioPlatillo) {
        this.idplatillo = idplatillo;
        this.nombrePlatillo = nombrePlatillo;
        this.precioPlatillo = precioPlatillo;
    }

    public int getIdplatillo() {
        return idplatillo;
    }

    public void setIdplatillo(int idplatillo) {
        this.idplatillo = idplatillo;
    }

    public String getNombrePlatillo() {
        return nombrePlatillo;
    }

    public void setNombrePlatillo(String nombrePlatillo) {
        this.nombrePlatillo = nombrePlatillo;
    }

    public double getPrecioPlatillo() {
        return precioPlatillo;
    }

    public void setPrecioPlatillo(double precioPlatillo) {
        this.precioPlatillo = precioPlatillo;
    }

    @Override
    public String toString() {
        return "Platillo{" + "idplatillo=" + idplatillo + ", nombrePlatillo=" + nombrePlatillo + ", precioPlatillo=" + precioPlatillo + ", cnn=" + cnn + ", cn=" + cn + '}';
    }

    public void mostrar(JTable TablePlatillo){
        DefaultTableModel modelPlatillo = new DefaultTableModel ();
        String []datos = new String [3]; 
        
        
        String sql = "select * from platillo";
        Statement st;
        modelPlatillo.addColumn("ID");
        modelPlatillo.addColumn("Nombre");
        modelPlatillo.addColumn("Precio");
        TablePlatillo.setModel(modelPlatillo);
        
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                modelPlatillo.addRow(datos);
            }
            
            TablePlatillo.setModel(modelPlatillo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al mostrar los datos: "+e.toString());
        }
    }
    
    public void nuevoRegistro(JTextField txtNombrePlatillo, JTextField txtPrecioPlatillo){
        Platillo plat = new Platillo ();
        plat.setNombrePlatillo(txtNombrePlatillo.getText());
        plat.setPrecioPlatillo(Double.parseDouble(txtPrecioPlatillo.getText()));
        String sql= "INSERT INTO platillo (nombrePlatillo, precioPlatillo) values (?,?)";
        
        try {
            PreparedStatement consulta = cn.prepareStatement(sql);
            consulta.setString(1, plat.getNombrePlatillo());
            consulta.setDouble(2, plat.getPrecioPlatillo());
            
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han guardado los datos");
            consulta.close();
        }                                       
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: "+ex.toString());
            Logger.getLogger(PlatilloView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarRegistro(JTextField txtidplatillo, JTextField txtnombrePlatillo, JTextField precioPlatillo){
        Platillo plat = new Platillo ();
        plat.setIdplatillo(Integer.parseInt(txtidplatillo.getText()));
        plat.setNombrePlatillo(txtnombrePlatillo.getText());
        plat.setPrecioPlatillo(Double.parseDouble(precioPlatillo.getText()));
        String sql= "UPDATE platillo SET platillo.nombrePlatillo = ?, platillo.precioPlatillo = ? WHERE platillo.idplatillo = ?";
        
        try {
            PreparedStatement consulta = cn.prepareStatement(sql);
            
            consulta.setString(1, plat.getNombrePlatillo());
            consulta.setDouble(2, plat.getPrecioPlatillo());
            consulta.setInt(3, plat.getIdplatillo());
            
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han modificado los datos");
            consulta.close();
        }                                       
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos: "+ex.toString());
            Logger.getLogger(PlatilloView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarRegistro(JTable TablePlatillo){
        DefaultTableModel modelPlatillo = new DefaultTableModel ();
        int fila = TablePlatillo.getSelectedRow();
        String valor = TablePlatillo.getValueAt(fila, 0).toString();
        
        if( fila >= 0){
            try{
                PreparedStatement ps = cn.prepareStatement("Delete FROM platillo Where idplatillo = '"+valor+"'");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Se han eliminado los datos");
                modelPlatillo.removeTableModelListener(TablePlatillo);
                modelPlatillo.getDataVector().removeAllElements();
                TablePlatillo.updateUI();
                
            } catch (SQLException ex) { 
                Logger.getLogger(PlatilloView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null,"Seleccionar fila");
        }
    }
}
