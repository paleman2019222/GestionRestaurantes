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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
   //prueba


     public void mostrar(JTable TableProducto){
        DefaultTableModel modelProducto = new DefaultTableModel ();
       // String []datos = new String [4]; 
        
        String sql = "select * from producto";
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
     
        public void GuardarRegistro(JTextField nombreproduct, JTextField costoproduct, JTextField cantidadproduct, JTextField idproveedor){
        Producto producto = new Producto ();
        producto.setNombreProducto(nombreproduct.getText());
        String sql= "INSERT INTO producto (nombreProducto, costoProducto, cantidadProducto, idproveedor) values (?, ?, ?, ?)";
        
        try {
            PreparedStatement consulta = cn.prepareStatement(sql);
            double costo = Double.parseDouble(costoproduct.getText());
            int cantidad = Integer.parseInt (cantidadproduct.getText());
            int proveedor = Integer.parseInt (idproveedor.getText());    
                
                consulta.setString(1,nombreproduct.getText());
                consulta.setDouble(2,costo);
                consulta.setInt(3,cantidad);
                consulta.setInt(4, proveedor);
            
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se han registrado los datos");
            consulta.close();
        }                                       
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: "+ex.toString());
            Logger.getLogger(ViewProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
       public void modificarRegistro(JTextField idproducto, JTextField nombreproduct, JTextField costoproduct, JTextField cantidadproduct, JTextField idproveedor){
        Producto producto = new Producto ();
        producto.setIdproducto(Integer.parseInt(idproducto.getText()));
        double costo = Double.parseDouble(costoproduct.getText());
        int cantidad = Integer.parseInt (cantidadproduct.getText());
        int proveedor = Integer.parseInt (idproveedor.getText()); 
        
        producto.setNombreProducto(nombreproduct.getText());
        producto.setCostoProducto(costo);
        producto.setCantidadProducto(cantidad);
        producto.setIdProveedor(proveedor);

        String sql= "UPDATE producto SET producto.nombreProducto = ?, producto.costoProducto = ?, producto.cantidadProducto = ?, producto.idProveedor = ? WHERE producto.idproducto = ?";
        
        try {
            PreparedStatement consulta = cn.prepareStatement(sql);
            
            consulta.setString(1, producto.getNombreProducto());
            consulta.setDouble(2, producto.getCostoProducto());
            consulta.setInt(3,producto.getCantidadProducto());
            consulta.setInt(4, producto.getIdProveedor());
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