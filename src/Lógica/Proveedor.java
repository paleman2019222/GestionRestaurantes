package Lógica;
import Persistencia.Conexion;
import GUI.ProveedorView;
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

public class Proveedor {
    private int idproveedor;
    private String nombreProveedor;
    
    //Conexión con la base de datos
    Conexion cnn = new Conexion ();
    Connection cn = cnn.conectar();

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
    
    //Función para mostrar los datos en la interfaz
    public void mostrar(JTable TableProveedor){
        DefaultTableModel modelProveedor = new DefaultTableModel ();
        String []datos = new String [2]; 
        String sql = "select * from proveedor";
        Statement st;
        modelProveedor.addColumn("ID");
        modelProveedor.addColumn("Nombre");
        TableProveedor.setModel(modelProveedor);
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                modelProveedor.addRow(datos);
            }
            TableProveedor.setModel(modelProveedor);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al mostrar los datos: "+e.toString());
        }
    }
    
    //Función para guardar datos en la base de datos
    public void nuevoRegistro(JTextField txtnombreproveedor){
        Proveedor prov = new Proveedor ();
        prov.setNombreProveedor(txtnombreproveedor.getText());
        String sql= "INSERT INTO proveedor (nombreProveedor) values (?)";
        try {
            PreparedStatement consulta = cn.prepareStatement(sql);
            consulta.setString(1, prov.getNombreProveedor());
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han registrado los datos");
            consulta.close();
        }                                       
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: "+ex.toString());
            Logger.getLogger(ProveedorView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Función para modificar datos existentes en la base de datos
    public void modificarRegistro(JTextField txtidproveedor, JTextField txtnombreproveedor){
        Proveedor prov = new Proveedor ();
        prov.setIdproveedor(Integer.parseInt(txtidproveedor.getText()));
        prov.setNombreProveedor(txtnombreproveedor.getText());
        String sql= "UPDATE proveedor SET proveedor.nombreProveedor = ? WHERE proveedor.idproveedor = ?";
        try {
            PreparedStatement consulta = cn.prepareStatement(sql);
            consulta.setString(1, prov.getNombreProveedor());
            consulta.setInt(2, prov.getIdproveedor());
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han modificado los datos");
            consulta.close();
        }                                       
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos: "+ex.toString());
            Logger.getLogger(ProveedorView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Función para borrar datos en la base de datos
    public void borrarRegistro(JTable TableProveedor){
        DefaultTableModel modelProveedor = new DefaultTableModel ();
        int fila = TableProveedor.getSelectedRow();
        String valor = TableProveedor.getValueAt(fila, 0).toString();
        if( fila >= 0){
            try{
                PreparedStatement ps = cn.prepareStatement("Delete FROM proveedor Where idproveedor = '"+valor+"'");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Dato Eliminado");
                modelProveedor.removeTableModelListener(TableProveedor);
                modelProveedor.getDataVector().removeAllElements();
                TableProveedor.updateUI();
            } catch (SQLException ex) { 
                Logger.getLogger(ProveedorView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null,"Seleccionar fila");
        }
    }
}
