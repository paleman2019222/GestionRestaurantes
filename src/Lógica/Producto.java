package Lógica;

import GUI.ViewProducto;
import Persistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
 
public class Producto {
    private int idproducto;
    private String nombreProducto;
    private double costoProducto;
    private int cantidadProducto;
    private int idProveedor;
    
    //Conexion con la base de datos
    Conexion cnn = new Conexion ();
    Connection cn = cnn.conectar();
    DefaultTableModel model = new DefaultTableModel (); 
    String []datos = new String [5]; 
   
    public Producto(int idproducto, String nombreProducto, double costoProducto, int cantidadProducto, int idProveedor) {
        this.idproducto = idproducto;
        this.nombreProducto = nombreProducto;
        this.costoProducto = costoProducto;
        this.cantidadProducto = cantidadProducto;
        this.idProveedor = idProveedor;
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
    
    //Método para mostrar los puestos por medio de un ComboBox
    public void cargarComboBox(JComboBox Tboxidproveedor){
        try{
            PreparedStatement  consulta = cn.prepareStatement("SELECT nombreProveedor from proveedor");
            ResultSet rs = consulta.executeQuery();
            while(rs.next()){
                Tboxidproveedor.addItem(rs.getString("nombreProveedor"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    //Función para mostrar los datos en la tabla de la interfaz
    public void mostrar(JTable TableProducto){
        DefaultTableModel modelProducto = new DefaultTableModel ();
        String sql = "SELECT producto.idproducto,producto.nombreProducto, producto.costoProducto, producto.cantidadProducto, proveedor.nombreProveedor FROM producto, proveedor where producto.idProveedor = proveedor.idProveedor";
        Statement st;
        modelProducto.addColumn("ID");
        modelProducto.addColumn("Nombre producto");
        modelProducto.addColumn("Costo");
        modelProducto.addColumn("Cantidad");
        modelProducto.addColumn("Proveedor");
        TableProducto.setModel(modelProducto);
        try{
            st = cn.createStatement();
            ResultSet result = st.executeQuery(sql);
            while (result.next()){
                datos[0]=result.getString(1);
                datos[1]=result.getString(2);
                datos[2]=result.getString(3);
                datos[3]=result.getString(4);
                datos[4]=result.getString(5);
                modelProducto.addRow(datos);
            }
            TableProducto.setModel(modelProducto);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al mostrar los datos: "+e.toString());
        }
    }
     
    //Función para guardar datos en la base de datos
    public void GuardarRegistro(JTextField nombreproduct, JTextField costoproduct, JTextField cantidadproduct, JComboBox Tboxidproveedor){
        cn = cnn.conectar();
        Producto producto = new Producto ();
        producto.setNombreProducto(nombreproduct.getText());
        producto.setCostoProducto(Double.parseDouble(costoproduct.getText()));
        producto.setCantidadProducto(Integer.parseInt (cantidadproduct.getText()));
        int g= 0;
            try {
                PreparedStatement  consulta = cn.prepareStatement("select idproveedor from proveedor where nombreProveedor ='"+Tboxidproveedor.getSelectedItem()+"'");
                ResultSet p = consulta.executeQuery();  
                while(p.next()){
                     g=p.getInt(1);
                    }                   
                } catch (SQLException ex) {
                    Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
                }
        String sql= "INSERT INTO producto (nombreProducto, costoProducto, cantidadProducto, idproveedor) values (?, ?, ?, ?)";
        try {
            PreparedStatement consulta = cn.prepareStatement(sql);
            double costo = Double.parseDouble(costoproduct.getText());
            int cantidad = Integer.parseInt (cantidadproduct.getText());
            consulta.setString(1,nombreproduct.getText());
            consulta.setDouble(2,costo);
            consulta.setInt(3,cantidad);
            consulta.setInt(4, g);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han registrado los datos");
            consulta.close();
        }                                       
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: "+ex.toString());
            Logger.getLogger(ViewProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Función para modificar datos existentes en la base de datos
    public void modificarRegistro(JTextField idproducto, JTextField nombreproduct, JTextField costoproduct, JTextField cantidadproduct, JComboBox Tboxidproveedor){
        Producto producto = new Producto ();
        producto.setIdproducto(Integer.parseInt(idproducto.getText()));        
        producto.setNombreProducto(nombreproduct.getText());
        producto.setCostoProducto(Double.parseDouble(costoproduct.getText()));
        producto.setCantidadProducto(Integer.parseInt (cantidadproduct.getText()));
        int g= 0;
        try {
            PreparedStatement  consulta = cn.prepareStatement("select idproveedor from proveedor where nombreProveedor ='"+Tboxidproveedor.getSelectedItem()+"'");
            ResultSet p = consulta.executeQuery();
            while(p.next()){
                g=p.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql= "UPDATE producto SET producto.nombreProducto = ?, producto.costoProducto = ?, producto.cantidadProducto = ?, producto.idProveedor = ? WHERE producto.idproducto = ?";
        try {
            PreparedStatement consulta = cn.prepareStatement(sql);
            consulta.setString(1, producto.getNombreProducto());
            consulta.setDouble(2, producto.getCostoProducto());
            consulta.setInt(3,producto.getCantidadProducto());
            consulta.setInt(4,g);
            consulta.setInt(5, producto.getIdproducto());
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han modificado los datos");
            consulta.close();
        }                                       
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos: "+ex.toString());
            Logger.getLogger(ViewProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    //Función para eliminar datos en la base de datos
    public void eliminar(JTable TableProducto){
        DefaultTableModel modelProducto= new DefaultTableModel ();
        int fila = TableProducto.getSelectedRow();
        String valor = TableProducto.getValueAt(fila, 0).toString();
        if( fila >= 0){
            try{
                PreparedStatement ps = cn.prepareStatement("Delete FROM producto Where idproducto = '"+valor+"'");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Dato Eliminado");
                modelProducto.removeTableModelListener(TableProducto);
                modelProducto.getDataVector().removeAllElements();
                TableProducto.updateUI();
            } catch (SQLException ex) { 
                Logger.getLogger(ViewProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null,"Seleccionar fila");
        }
    }
}