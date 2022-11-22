package GUI;

import Persistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Lógica.Empleado;
import javax.swing.JComboBox;
/**
 *
 * @author Raquel
 */
public class EmpleadoView extends javax.swing.JFrame {
        Conexion connect = new Conexion();
        Empleado emp = new Empleado();
        Empleado mod;
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new EmpleadoView().setVisible(true);    
        }
    });
    }
      
      //Método para validar que los datos de un campo      
    private boolean isNumeric(String cadena) {
        boolean resultado;
        try{
        Integer.parseInt(cadena);
                resultado=true;
        }catch(NumberFormatException e){
        resultado=false;
        }
        return resultado;
    }
    
    //Mëtodo para validar si el valor de un campo es tipo double
    private boolean isDouble(String cadena) {
        boolean resultado;
        try{
        Double.parseDouble(cadena);
                resultado=true;
        }catch(NumberFormatException e){
        resultado=false;
        }
        return resultado;
    }
         
    //Método para validar si un dato ya existe en la base de datos (usuario)
    public boolean validarRegistros(){
        boolean bandera = false;
        Connection con = connect.conectar();        
        String user = txtUser.getText();
        String Consulta = "select empleado.usuarioEmpleado from empleado where usuarioEmpleado ='"+user+"'";        
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Consulta);
        if(rs.next()){
                bandera = true;
        }else{
                bandera = false;
            }
              
        }catch(Exception e){
            System.out.println(e);
        }
        return bandera;
    }
  
    //Método para validar si el numero telefonico se encuentra en la base de datos
    public boolean validarTelefono(){
        boolean bandera = false;
        Connection con = connect.conectar();       
        String telefono = txtTelefono.getText();
        String Consulta = "select empleado.teléfonoEmpleado from empleado where teléfonoEmpleado ='"+telefono+"'";        
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Consulta);
        if(rs.next()){
          bandera = true;
        }else{
          bandera = false;
            }             
        }catch(Exception e){
            System.out.println(e);
        }
        return bandera;
    }

    
    Connection cc; 
    public EmpleadoView() {
        initComponents();
        txtId.setEditable(false);
        emp.mostrar(TblEmpleado);
        emp.cargarComboBox(boxPuesto);
        btnEliminar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
    }
    
    //Segundo constructor que obtiene los datos del login
    public EmpleadoView(Empleado mod){
        initComponents();
        setLocationRelativeTo(null);
        txtId.setEditable(false);
        emp.mostrar(TblEmpleado);
        emp.cargarComboBox(boxPuesto);
        btnEliminar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnCancelar.setEnabled(true);
        this.mod = mod;
        mod.getPuesto();
        mod.getNombreEmpleado();
         System.out.println(mod.getNombreEmpleado());
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblEmpleado = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtUser8 = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        txtSueldo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        boxPuesto = new javax.swing.JComboBox<>();
        btnEditar = new javax.swing.JButton();
        Salir = new javax.swing.JLabel();
        Menu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setName("Empleados"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Empleado");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 600, 180));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trabajo-en-equipo (1).png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, 110));

        TblEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TblEmpleado.setGridColor(new java.awt.Color(204, 255, 255));
        TblEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblEmpleado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 890, 460));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ingreso de Datos");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 60));

        jLabel15.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Usuario");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 470, -1));

        txtUser8.setBackground(new java.awt.Color(0, 0, 0));
        txtUser8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtUser8.setForeground(new java.awt.Color(51, 51, 51));
        txtUser8.setToolTipText("User");
        txtUser8.setBorder(null);
        jPanel4.add(txtUser8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 190, 20));

        jSeparator9.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 190, 20));

        jLabel16.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Id");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 350, -1));

        txtId.setBackground(new java.awt.Color(0, 0, 0));
        txtId.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtId.setForeground(new java.awt.Color(255, 255, 255));
        txtId.setToolTipText("User");
        txtId.setBorder(null);
        jPanel4.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 190, 20));

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 210, 20));

        txtNombre.setBackground(new java.awt.Color(0, 0, 0));
        txtNombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setToolTipText("User");
        txtNombre.setBorder(null);
        jPanel4.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 190, 20));

        jSeparator11.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 210, 20));

        jLabel17.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Nombre(s)");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 350, -1));

        txtApellido.setBackground(new java.awt.Color(0, 0, 0));
        txtApellido.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(255, 255, 255));
        txtApellido.setToolTipText("User");
        txtApellido.setBorder(null);
        jPanel4.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 190, 20));

        jSeparator12.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 210, 20));

        jLabel18.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Apellido(s)");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 350, -1));

        txtUser.setBackground(new java.awt.Color(0, 0, 0));
        txtUser.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(255, 255, 255));
        txtUser.setToolTipText("User");
        txtUser.setBorder(null);
        jPanel4.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 190, 20));

        jSeparator13.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 210, 20));

        jLabel19.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Usuario");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 350, -1));

        txtTelefono.setBackground(new java.awt.Color(0, 0, 0));
        txtTelefono.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setToolTipText("User");
        txtTelefono.setBorder(null);
        jPanel4.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 190, 20));

        jSeparator14.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator14.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 210, 20));

        jLabel20.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Teléfono");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 350, -1));

        txtDireccion.setBackground(new java.awt.Color(0, 0, 0));
        txtDireccion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setToolTipText("User");
        txtDireccion.setBorder(null);
        jPanel4.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 190, 20));

        jSeparator15.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator15.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 210, 10));

        jLabel21.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Dirección");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 350, 20));

        jSeparator16.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator16.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 210, 10));

        txtSueldo.setBackground(new java.awt.Color(0, 0, 0));
        txtSueldo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtSueldo.setForeground(new java.awt.Color(255, 255, 255));
        txtSueldo.setToolTipText("User");
        txtSueldo.setBorder(null);
        jPanel4.add(txtSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 190, 20));

        jLabel22.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Sueldo");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 350, 20));

        jLabel23.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Puesto");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 350, 20));

        jSeparator18.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator18.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 630, 210, 10));

        jLabel24.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Contraseña");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 350, 20));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel4.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 650, 90, 30));

        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 100, 30));

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        jPanel4.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 690, 100, 30));

        txtPassword.setBackground(new java.awt.Color(0, 0, 0));
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setBorder(null);
        jPanel4.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 610, 190, -1));

        boxPuesto.setBackground(new java.awt.Color(0, 0, 0));
        boxPuesto.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(boxPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 550, 210, -1));

        btnEditar.setText("Actualizar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel4.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 650, 100, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 780));

        Salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion (27px).png"))); // NOI18N
        Salir.setText(" Salir");
        Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        jPanel1.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 660, 120, -1));

        Menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hogar (30px).png"))); // NOI18N
        Menu.setText("Menú");
        Menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuMouseClicked(evt);
            }
        });
        jPanel1.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 140, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Acción que realiza el botón guardar, llamando al método de la clase.
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if(txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtUser.getText().equals("") ||txtTelefono.getText().equals("")|| txtDireccion.getText().equals("") || txtSueldo.getText().equals("") || boxPuesto.getSelectedItem().equals("") || txtPassword.getPassword().equals("")){
        JOptionPane.showMessageDialog(null, "Uno o varios campos están vacios, verifique su información e inténtelo de nuevo");
        }else{
            String x = txtTelefono.getText();
            String y = txtSueldo.getText();
            int t = x.length();
            if(isNumeric(x)==false){
            JOptionPane.showMessageDialog(null, "El campo de número telefónico debe contener únicamente números, intentelo de nuevo por favor.");
            }else if(isDouble(y)==false){
             JOptionPane.showMessageDialog(null, "El campo de sueldo debe contener únicamente números, intentelo de nuevo por favor.");
            }else if(t==8){   
            if(validarRegistros()==false){
                if(validarTelefono()==false){         
                   emp.guardarEmpleado(txtNombre, txtApellido, txtUser, txtTelefono, txtDireccion, txtSueldo, boxPuesto, txtPassword);
                   emp.mostrar(TblEmpleado);
                   limpiar(); 
                }else{
                   JOptionPane.showMessageDialog(null, "El número de teléfono ya esta registrado");
                }
            }else{             
                JOptionPane.showMessageDialog(null, "El nombre de usuario ya esta registrado");
            }
            }else{
             JOptionPane.showMessageDialog(null, "El campo de número telefónico debe contener 8 dígitos");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    //Carga los datos de la tabla a los campos textField
    private void TblEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblEmpleadoMouseClicked
        int fila = TblEmpleado.getSelectedRow();
        txtId.setText(TblEmpleado.getValueAt(fila, 0).toString());
        txtNombre.setText(TblEmpleado.getValueAt(fila, 1).toString());
        txtApellido.setText(TblEmpleado.getValueAt(fila, 2).toString());
        txtUser.setText(TblEmpleado.getValueAt(fila, 3).toString());
        txtTelefono.setText(TblEmpleado.getValueAt(fila, 4).toString());
        txtDireccion.setText(TblEmpleado.getValueAt(fila, 5).toString());
        txtSueldo.setText(TblEmpleado.getValueAt(fila, 6).toString());
        boxPuesto.setSelectedItem(TblEmpleado.getValueAt(fila, 7).toString());
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnEditar.setEnabled(true);
    }//GEN-LAST:event_TblEmpleadoMouseClicked

    //Accion de eliminar llamando al metodo de la clase
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro seleccionado?");
        if(resp ==0){
            emp.eliminar(TblEmpleado);
            emp.mostrar(TblEmpleado);
            limpiar();
       }   
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    //Boton de salir
    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea Salir?");
        if(resp ==0){
           System.exit(0);
       }   
    }//GEN-LAST:event_SalirMouseClicked

    //Botón que regresa al menú inicial
    private void MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMouseClicked
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea regresar al menú principal?");
        if(resp ==0){
            Menu mn = new Menu(mod);
            mn.setVisible(true);
            this.setVisible(false); 
         }        
    }//GEN-LAST:event_MenuMouseClicked

    //Accion del botón Editar llamando al método de la clase
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String d = txtPassword.getText();
        if(txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtUser.getText().equals("") ||txtTelefono.getText().equals("")|| txtDireccion.getText().equals("") || txtSueldo.getText().equals("") || boxPuesto.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Uno o varios campos están vacios, verifique su información e inténtelo de nuevo");
        }else{
            if(d.equals("")){
            JOptionPane.showMessageDialog(null, "El campo de contraseña está vacío, Ingrese su contraseña actual o escriba una contraseña nueva e intentelo de nuevo");   
        }else{           
            String x = txtTelefono.getText();
            String y = txtSueldo.getText();
                if(isNumeric(x)==false){
                    JOptionPane.showMessageDialog(null, "El campo de número telefónico debe contener únicamente números, intentelo de nuevo por favor.");
                }else if(isDouble(y)==false){   
                    JOptionPane.showMessageDialog(null, "El campo de sueldo debe contener únicamente números, intentelo de nuevo por favor.");
                }else{
            if(txtTelefono.getText().equals(TblEmpleado.getValueAt(TblEmpleado.getSelectedRow(), 4))){
                if(txtUser.getText().equals(TblEmpleado.getValueAt(TblEmpleado.getSelectedRow(), 3))){
                    int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro seleccionado?");
                    if(resp ==0){
                        emp.editarEmpleado(txtId, txtNombre, txtApellido, txtUser, txtTelefono, txtDireccion, txtSueldo, boxPuesto, txtPassword);
                        emp.mostrar(TblEmpleado);
                        limpiar();
                        btnEliminar.setEnabled(false);
                        btnCancelar.setEnabled(false);
                        btnGuardar.setEnabled(true);
                    }else if(resp==1){
                        btnEliminar.setEnabled(false);
                        btnEditar.setEnabled(false);
                        btnGuardar.setEnabled(true);
                    } 
                }else if(validarRegistros()==true){
                    JOptionPane.showMessageDialog(null, "El usuario ya esta registrado");
                      }else{
                        emp.editarEmpleado(txtId, txtNombre, txtApellido, txtUser, txtTelefono, txtDireccion, txtSueldo, boxPuesto, txtPassword);
                        emp.mostrar(TblEmpleado);
                        limpiar();
                        btnEliminar.setEnabled(false);
                        btnEditar.setEnabled(false);
                        btnGuardar.setEnabled(true);
                       }
            }else if(validarTelefono()== true){
                JOptionPane.showMessageDialog(null, "El  número teléfonico ya esta registrado");
               }else{
                emp.editarEmpleado(txtId, txtNombre, txtApellido, txtUser, txtTelefono, txtDireccion, txtSueldo, boxPuesto, txtPassword);
                emp.mostrar(TblEmpleado);
                limpiar();
                btnEliminar.setEnabled(false);
                btnEditar.setEnabled(false);
                btnGuardar.setEnabled(true);
                }      
                }
        }
         }
        btnEliminar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    //Boton cancelar, limpia los campos y reestablece los botones
    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        limpiar();
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnEditar.setEnabled(false);
    }//GEN-LAST:event_btnCancelarMouseClicked
    
    //Método para limpiar los campos
    public  void limpiar(){
        boxPuesto.setSelectedItem(null);
        txtId.setText(null);
        txtNombre.setText(null);
        txtApellido.setText(null);
        txtTelefono.setText(null);
        txtUser.setText(null);
        txtDireccion.setText(null);
        txtPassword.setText(null);
        txtSueldo.setText(null);   
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Menu;
    private javax.swing.JLabel Salir;
    private javax.swing.JTable TblEmpleado;
    private javax.swing.JComboBox<String> boxPuesto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtUser8;
    // End of variables declaration//GEN-END:variables
}
