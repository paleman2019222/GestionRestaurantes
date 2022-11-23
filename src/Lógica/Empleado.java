package Lógica;

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
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Empleado {
   private int idEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String usuarioEmpleado;
    private int telefonoUsuario;
    private String direccionEmpleado;
    private double sueldoEmpleado;
    private String idPuesto;
    private String password;
    private String puesto;
    Conexion cnn = new Conexion ();
    Connection cn = cnn.conectar();
    
    public Empleado() {
    }

    public Empleado(int idEmpleado, String nombreEmpleado, String apellidoEmpleado, String usuarioEmpleado, int telefonoUsuario, String direccionEmpleado, double sueldoEmpleado, String idPuesto, String password) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.usuarioEmpleado = usuarioEmpleado;
        this.telefonoUsuario = telefonoUsuario;
        this.direccionEmpleado = direccionEmpleado;
        this.sueldoEmpleado = sueldoEmpleado;
        this.idPuesto = idPuesto;
        this.password = password;
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

    public String getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(String idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    //Función para mostrar los datos en la la tabla de la interfaz
    public void mostrar(JTable TableEmpleado){
        DefaultTableModel modelEmpleado = new DefaultTableModel ();
        String []datos = new String [8]; 
        String sql = "Select empleado.idempleado, empleado.nombreempleado, empleado.apellidoEmpleado, empleado.usuarioEmpleado, empleado.teléfonoEmpleado, empleado.direccionEmpleado, empleado.sueldoEmpleado , puesto.puesto from empleado, puesto where empleado.idPuesto = puesto.idpuesto;";
        Statement st;
        modelEmpleado.addColumn("Id");
        modelEmpleado.addColumn("Nombre(s)");
        modelEmpleado.addColumn("Apellido(s)");
        modelEmpleado.addColumn("Usuario");
        modelEmpleado.addColumn("Teléfono");
        modelEmpleado.addColumn("Dirección");
        modelEmpleado.addColumn("Sueldo");
        modelEmpleado.addColumn("Puesto");   
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);           
            while (rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);               
                modelEmpleado.addRow(datos);
            }            
            TableEmpleado.setModel(modelEmpleado);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al mostrar los datos: "+e.toString());
        }
    }
    
    //Método para mostrar los puestos por medio de un ComboBox
    public void cargarComboBox(JComboBox puesto){
        try{
            Connection cn = cnn.conectar();
            PreparedStatement  consulta = cn.prepareStatement("SELECT puesto from puesto");
            ResultSet rs = consulta.executeQuery();   
            while(rs.next()){
            puesto.addItem(rs.getString("puesto"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }  
    }
    
    //Método para guardar a un nuevo empleado
    public void guardarEmpleado(JTextField txtNombre, JTextField txtApellido, JTextField txtUsuario, JTextField txtTelefono, JTextField txtDireccion, JTextField txtSueldo, JComboBox txtPuesto, JPasswordField txtPassword){
        cn = cnn.conectar();
        Empleado empleado = new Empleado();
        empleado.setNombreEmpleado(txtNombre.getText());
        empleado.setApellidoEmpleado(txtApellido.getText());
        empleado.setUsuarioEmpleado(txtUsuario.getText());
        empleado.setTelefonoUsuario(Integer.parseInt(txtTelefono.getText()));
        empleado.setDireccionEmpleado(txtDireccion.getText());
        empleado.setSueldoEmpleado(Double.parseDouble(txtSueldo.getText()));
        empleado.setPassword(String.valueOf(txtPassword.getPassword()));
        int g= 0;
        try {
            PreparedStatement  consulta = cn.prepareStatement("select idpuesto from puesto where puesto='"+txtPuesto.getSelectedItem()+"'");
            ResultSet p = consulta.executeQuery();                   
            while(p.next()){
                g=p.getInt(1);
            }       
        }catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
           PreparedStatement  consulta = cn.prepareStatement("INSERT INTO empleado (nombreEmpleado, apellidoEmpleado, usuarioEmpleado, teléfonoEmpleado, direccionEmpleado, sueldoEmpleado, idPuesto, passwordEmpleado) values (?,?,?,?,?,?,?,?)");        
            consulta.setString(1,empleado.getNombreEmpleado());
            consulta.setString(2,empleado.getApellidoEmpleado());
            consulta.setString(3,empleado.getUsuarioEmpleado());
            consulta.setInt(4,empleado.getTelefonoUsuario());
            consulta.setString(5,empleado.getDireccionEmpleado());
            consulta.setDouble(6,empleado.getSueldoEmpleado());
            consulta.setInt(7,g);
            consulta.setString(8, String.valueOf(empleado.getPassword()));    
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos guardados");// TODO add your handling code here:
            consulta.close();
        }                                       
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos ");
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
    
    //Método de actualizar
    public void editarEmpleado(JTextField txtidEmpleado, JTextField txtNombre, JTextField txtApellido, JTextField txtUsuario, JTextField txtTelefono, JTextField txtDireccion, JTextField txtSueldo, JComboBox txtPuesto, JPasswordField txtPassword){
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(Integer.parseInt(txtidEmpleado.getText()));
        empleado.setNombreEmpleado(txtNombre.getText());
        empleado.setApellidoEmpleado(txtApellido.getText());
        empleado.setUsuarioEmpleado(txtUsuario.getText());
        empleado.setTelefonoUsuario(Integer.parseInt(txtTelefono.getText()));
        empleado.setDireccionEmpleado(txtDireccion.getText());
        empleado.setSueldoEmpleado(Double.parseDouble(txtSueldo.getText()));
        empleado.setPassword(String.valueOf(txtPassword.getPassword()));
        int g= 0;
        try {
            PreparedStatement  consulta = cn.prepareStatement("select idpuesto from puesto where puesto='"+txtPuesto.getSelectedItem()+"'");
            ResultSet p = consulta.executeQuery();
            while(p.next()){
                g=p.getInt(1);
            }                  
        }catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }               
        String sql= "UPDATE empleado SET empleado.nombreEmpleado = ? , empleado.apellidoEmpleado = ? , empleado.usuarioEmpleado = ? , empleado.teléfonoEmpleado = ? , empleado.direccionEmpleado = ? , empleado.sueldoEmpleado = ? ,empleado.idPuesto = ? , empleado.passwordEmpleado = ? WHERE empleado.idEmpleado = ?";        
        try {
            PreparedStatement consulta = cn.prepareStatement(sql);
            consulta.setString(1,empleado.getNombreEmpleado());
            consulta.setString(2,empleado.getApellidoEmpleado());
            consulta.setString(3,empleado.getUsuarioEmpleado());
            consulta.setInt(4,empleado.getTelefonoUsuario());
            consulta.setString(5,empleado.getDireccionEmpleado());
            consulta.setDouble(6,empleado.getSueldoEmpleado());
            consulta.setInt(7,g);
            consulta.setString(8, empleado.getPassword());
            consulta.setInt(9, empleado.getIdEmpleado());
            consulta.executeLargeUpdate();
            JOptionPane.showMessageDialog(null, "Se han modificado los datos");
            consulta.close();
            System.out.println(empleado.getNombreEmpleado());
        }                                       
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar los datos: "+ex.toString());
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
    
    //Método de eliminar
    public void eliminar(JTable TableEmpleado){
        DefaultTableModel modelProducto= new DefaultTableModel ();
        int fila = TableEmpleado.getSelectedRow();
        String valor = TableEmpleado.getValueAt(fila, 0).toString();
        if( fila >= 0){
            try{
                PreparedStatement ps = cn.prepareStatement("Delete FROM empleado Where idempleado = '"+valor+"'");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Dato Eliminado");
                modelProducto.removeTableModelListener(TableEmpleado);
                modelProducto.getDataVector().removeAllElements();
                TableEmpleado.updateUI();     
            }catch (SQLException ex) { 
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
          JOptionPane.showMessageDialog(null,"Seleccionar fila");
        }
    }    
        
    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", apellidoEmpleado=" + apellidoEmpleado + ", usuarioEmpleado=" + usuarioEmpleado + ", telefonoUsuario=" + telefonoUsuario + ", direccionEmpleado=" + direccionEmpleado + ", sueldoEmpleado=" + sueldoEmpleado + ", idPuesto=" + idPuesto + '}';
    }
}
