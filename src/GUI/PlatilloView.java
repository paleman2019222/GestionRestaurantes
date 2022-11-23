package GUI;
import Lógica.Empleado;
import Lógica.Platillo;
import Persistencia.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PlatilloView extends javax.swing.JFrame {
    Platillo op = new Platillo();
    Empleado mod;
    String platillo;
    Conexion connect = new Conexion();
    Connection con;
    
    public PlatilloView() {
        initComponents();
        txtIdPlatillo.setEditable(false);
        op.mostrar(TablePlatillo);
        Eliminar.setEnabled(false);
        Editar.setEnabled(false);
    }
    
    //Constructor que obtiene los datos del login
    public PlatilloView(Empleado mod) {
        initComponents();
        txtIdPlatillo.setEditable(false);
        op.mostrar(TablePlatillo);
        Eliminar.setEnabled(false);
        Editar.setEnabled(false);
        mod.getPuesto();
        mod.getNombreEmpleado();
        this.mod = mod;
        System.out.println(mod.getNombreEmpleado());    
    }
    
    //Método que limpia todos el contenido de los TextField
    void limpiar(){
        txtIdPlatillo.setText(null);
        txtNombrePlatillo.setText(null);
        txtPrecioPlatillo.setText(null);
    }
    
    //Método que valida si el contenido del campo es de tipo double
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
    
    //Método para verificar si ya existe el nombre del platillo a registrar
    public boolean validarRegistros(){
        boolean bandera = false;
        platillo = txtNombrePlatillo.getText();
        String Consulta = "select platillo.nombrePLatillo from platillo where nombrePlatillo ='"+platillo+"'";
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        txtIdPlatillo = new javax.swing.JTextField();
        txtNombrePlatillo = new javax.swing.JTextField();
        txtPrecioPlatillo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        Cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePlatillo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Menu = new javax.swing.JLabel();
        Salir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Platillos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(390, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ingreso de Datos");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, 350, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ID");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 350, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nombre");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 350, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Precio");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 350, -1));

        Guardar.setText("Guardar");
        Guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        jPanel2.add(Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 90, 30));

        Editar.setText("Actualizar");
        Editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jPanel2.add(Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 90, 30));

        Eliminar.setText("Eliminar");
        Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPanel2.add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 90, 30));

        txtIdPlatillo.setEditable(false);
        txtIdPlatillo.setBackground(new java.awt.Color(0, 0, 0));
        txtIdPlatillo.setForeground(new java.awt.Color(255, 255, 255));
        txtIdPlatillo.setBorder(null);
        txtIdPlatillo.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtIdPlatillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 170, 20));

        txtNombrePlatillo.setBackground(new java.awt.Color(0, 0, 0));
        txtNombrePlatillo.setForeground(new java.awt.Color(255, 255, 255));
        txtNombrePlatillo.setBorder(null);
        txtNombrePlatillo.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtNombrePlatillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 180, 20));

        txtPrecioPlatillo.setBackground(new java.awt.Color(0, 0, 0));
        txtPrecioPlatillo.setForeground(new java.awt.Color(255, 255, 255));
        txtPrecioPlatillo.setBorder(null);
        txtPrecioPlatillo.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtPrecioPlatillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 170, 20));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 190, 20));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 190, 20));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 190, 20));

        Cancelar.setText("Cancelar");
        Cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        jPanel2.add(Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, 90, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 550));

        TablePlatillo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablePlatillo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePlatilloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablePlatillo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 127, 450, 370));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Platillos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 430, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Platillo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 110, 90));

        Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hogar (30px).png"))); // NOI18N
        Menu.setText("Menú");
        Menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuMouseClicked(evt);
            }
        });
        jPanel1.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, -1, -1));

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion (27px).png"))); // NOI18N
        Salir.setText("Salir");
        Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        jPanel1.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 510, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Acción que realiza el botón guardar, llamando al método nuevoRegistro de la clase Platillo.
    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        if(txtNombrePlatillo.getText().equals("") || txtPrecioPlatillo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Uno o varios campos están vacios, verifique su información e inténtelo de nuevo");
        }else{
            String x = txtPrecioPlatillo.getText();
            if(isDouble(x)==false){
                JOptionPane.showMessageDialog(null, "El campo de precio debe contener únicamente números, intentelo de nuevo por favor.");
            }else if(validarRegistros()==false){  
                op.nuevoRegistro(txtNombrePlatillo, txtPrecioPlatillo);
                op.mostrar(TablePlatillo);
                limpiar();
            }else{             
                JOptionPane.showMessageDialog(null, "El platillo ya está registrado");
            }
        }
    }//GEN-LAST:event_GuardarActionPerformed
    
    //Acción que realiza el botón editar, llamando al método modificarRegistro de la clase Platillo.
    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        System.out.println(TablePlatillo.getValueAt(TablePlatillo.getSelectedRow(), 1));
        System.out.println(txtNombrePlatillo.getText());
        if(txtNombrePlatillo.getText().equals("") || txtPrecioPlatillo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Uno o varios campos están vacios, verifique su información e inténtelo de nuevo");
        } else{
            String x = txtPrecioPlatillo.getText();
            if(isDouble(x)==false){
                JOptionPane.showMessageDialog(null, "El campo de precio debe contener únicamente números, intentelo de nuevo por favor.");
            }else{  
                if(txtNombrePlatillo.getText().equals(TablePlatillo.getValueAt(TablePlatillo.getSelectedRow(), 1))){
                    int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro seleccionado?");
                    System.out.println(resp);
                    if(resp ==0){                    
                        op.modificarRegistro(txtIdPlatillo, txtNombrePlatillo, txtPrecioPlatillo);
                        op.mostrar(TablePlatillo);
                        limpiar();
                        Guardar.setEnabled(true); 
                        Eliminar.setEnabled(false);
                        Editar.setEnabled(false); 
                    }else if(resp==1){
                        Guardar.setEnabled(false);
                        Eliminar.setEnabled(true);
                        Editar.setEnabled(true);
                    }
                }else if(validarRegistros() == true){
                    JOptionPane.showMessageDialog(null, "El registro ya existe");      
                }else{
                    op.modificarRegistro(txtIdPlatillo, txtNombrePlatillo, txtPrecioPlatillo);
                    op.mostrar(TablePlatillo);
                    limpiar();
                    Guardar.setEnabled(true); 
                    Eliminar.setEnabled(false);
                    Editar.setEnabled(false); 
                }
            }
        }
    }//GEN-LAST:event_EditarActionPerformed

    //Acción que realiza el botón eliminar, llamando al método borrarRegistro de la clase Platillo.
    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro seleccionado?");
        if(resp ==0){
            op.borrarRegistro(TablePlatillo);
            op.mostrar(TablePlatillo);
            limpiar();
        } 
        Eliminar.setEnabled(false);
        Editar.setEnabled(false);
        Guardar.setEnabled(true);
    }//GEN-LAST:event_EliminarActionPerformed

    //Carga todos los campos de la tabla en los TextField correspondientes
    private void TablePlatilloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePlatilloMouseClicked
        DefaultTableModel modelPlatillo = (DefaultTableModel) TablePlatillo.getModel();
        txtIdPlatillo.setText(modelPlatillo.getValueAt(TablePlatillo.getSelectedRow(),0)+"");
        txtNombrePlatillo.setText(modelPlatillo.getValueAt(TablePlatillo.getSelectedRow(),1)+"");
        txtPrecioPlatillo.setText(modelPlatillo.getValueAt(TablePlatillo.getSelectedRow(),2)+"");
        Eliminar.setEnabled(true);
        Editar.setEnabled(true);
        Guardar.setEnabled(false);
    }//GEN-LAST:event_TablePlatilloMouseClicked

    //Permite salir completamente del programa
    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea Salir?");
        if(resp ==0){
           System.exit(0);
        }  
    }//GEN-LAST:event_SalirMouseClicked

    //Botón que permite regresar al menú
    private void MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMouseClicked
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea regresar al menú principal?");   
        if(resp ==0){        
            Menu mn = new Menu(mod);
            mn.setVisible(true);
            this.setVisible(false); 
       }
    }//GEN-LAST:event_MenuMouseClicked

    //Boton cancelar, limpia los campos y reestablece los botones
    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        limpiar();
        Guardar.setEnabled(true);
        Eliminar.setEnabled(false);
        Editar.setEnabled(false);
    }//GEN-LAST:event_CancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlatilloView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlatilloView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlatilloView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlatilloView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlatilloView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Guardar;
    private javax.swing.JLabel Menu;
    private javax.swing.JLabel Salir;
    private javax.swing.JTable TablePlatillo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txtIdPlatillo;
    private javax.swing.JTextField txtNombrePlatillo;
    private javax.swing.JTextField txtPrecioPlatillo;
    // End of variables declaration//GEN-END:variables
}
