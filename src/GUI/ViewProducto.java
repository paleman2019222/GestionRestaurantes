package GUI;
import Lógica.Empleado;
import Persistencia.Conexion;
import Lógica.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
 
public class ViewProducto extends javax.swing.JFrame {      
    Producto op = new Producto();
    Empleado mod;
    DefaultTableModel model = new DefaultTableModel ();
    String []datos = new String[4];
   
   //Mëtodo para validar si el valor de un campo es tipo entero
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

    public ViewProducto() {
        initComponents();
        idproducto.setEditable(false);
        op.mostrar(TableProducto);
        op.cargarComboBox(Tboxidproveedor);
    }
    
    //Constructor que obtiene los datos del login
    public ViewProducto(Empleado mod){
        initComponents();
        setLocationRelativeTo(null);
        idproducto.setEditable(false);
        op.mostrar(TableProducto);
        op.cargarComboBox(Tboxidproveedor);
        btnEliminar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(true);
        this.mod = mod;
        mod.getPuesto();
        mod.getNombreEmpleado();
        System.out.println(mod.getNombreEmpleado());
        if(!mod.getPuesto().equals("Administrador")){
        btnEditar.setVisible(false);
        btnGuardar.setVisible(false);
        btnEliminar.setVisible(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        nombreproduct = new javax.swing.JTextField();
        costoproduct = new javax.swing.JTextField();
        idproducto = new javax.swing.JTextField();
        cantidadproduct = new javax.swing.JTextField();
        Tboxidproveedor = new javax.swing.JComboBox<>();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProducto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Salir = new javax.swing.JLabel();
        Menú = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("viewProducto"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ID del Producto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 78, 331, -1));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 250, 180, 14));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nombre del Producto");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 186, 317, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cantidad del Producto");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 380, 331, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Precio del Producto");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 286, 331, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Proveedor");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 476, 331, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, 90, 34));

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 148, 180, 14));

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 348, 180, 14));

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 444, 180, 14));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingreso de Datos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 17, 313, 49));

        nombreproduct.setBackground(new java.awt.Color(0, 0, 0));
        nombreproduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nombreproduct.setForeground(new java.awt.Color(255, 255, 255));
        nombreproduct.setBorder(null);
        nombreproduct.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(nombreproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 224, 170, -1));

        costoproduct.setBackground(new java.awt.Color(0, 0, 0));
        costoproduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        costoproduct.setForeground(new java.awt.Color(255, 255, 255));
        costoproduct.setBorder(null);
        costoproduct.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(costoproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 324, 170, 20));

        idproducto.setEditable(false);
        idproducto.setBackground(new java.awt.Color(0, 0, 0));
        idproducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idproducto.setForeground(new java.awt.Color(255, 255, 255));
        idproducto.setBorder(null);
        idproducto.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(idproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 122, 170, -1));

        cantidadproduct.setBackground(new java.awt.Color(0, 0, 0));
        cantidadproduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cantidadproduct.setForeground(new java.awt.Color(255, 255, 255));
        cantidadproduct.setBorder(null);
        cantidadproduct.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(cantidadproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 418, 170, 30));

        Tboxidproveedor.setBackground(new java.awt.Color(0, 0, 0));
        Tboxidproveedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Tboxidproveedor.setForeground(new java.awt.Color(255, 255, 255));
        Tboxidproveedor.setBorder(null);
        jPanel1.add(Tboxidproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 514, 180, -1));

        btnEditar.setText("Actualizar");
        btnEditar.setBorder(null);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 590, 90, 34));

        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 630, 90, 34));

        Cancelar.setText("Cancelar");
        Cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        jPanel1.add(Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 630, 90, 32));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 700));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        TableProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID ", "Nombre ", "Precio", "Cantidad", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableProducto);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Producto");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/comida (1).png"))); // NOI18N

        Salir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion (27px).png"))); // NOI18N
        Salir.setText("Salir");
        Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });

        Menú.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Menú.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hogar (30px).png"))); // NOI18N
        Menú.setText("Menú");
        Menú.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menú.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenúMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57)
                            .addComponent(Menú, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Menú)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Salir)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 0, 600, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Método para limpiar el contenido de los TextField
    void limpiar(){
        idproducto.setText(null);
        nombreproduct.setText(null);
        costoproduct.setText(null);
        cantidadproduct.setText(null);
    } 
    
    //Acción que realiza el botón editar, llamando al método modificarRegistro de la clase Producto.
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(nombreproduct.getText().equals("") || costoproduct.getText().equals("") || cantidadproduct.getText().equals("") ||Tboxidproveedor.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Uno o varios campos están vacíos, Intentelo de nuevo");
        }else{
            String x = costoproduct.getText();
            String y = cantidadproduct.getText();
            if(isDouble(x)==false){
                JOptionPane.showMessageDialog(null, "El campo Precio del producto debe contener únicamente números, intentelo de nuevo por favor.");
            }else if(isNumeric(y)==false){
                JOptionPane.showMessageDialog(null, "El campo cantidad el producto debe contener únicamente números enteros, intentelo de nuevo por favor.");
            }else{
                int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro seleccionado?");
                if(resp ==0){
                    op.modificarRegistro(idproducto, nombreproduct, costoproduct, cantidadproduct, Tboxidproveedor);
                    op.modificarRegistro(idproducto, nombreproduct, costoproduct, cantidadproduct, Tboxidproveedor);
                    op.mostrar(TableProducto);
                    limpiar();
                }
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    //Acción que realiza el botón eliminar, llamando al método borrarRegistro de la clase Producto.
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro seleccionado?");
        if(resp ==0){
            op.eliminar(TableProducto);
            op.mostrar(TableProducto);
        }
        btnEliminar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    //Acción que realiza el botón guardar, llamando al método nuevoRegistro de la clase Producto.
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(nombreproduct.getText().equals("") || costoproduct.getText().equals("") || cantidadproduct.getText().equals("") ||Tboxidproveedor.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Uno o varios campos están vacios, verifique su información e inténtelo de nuevo");
        }else{
            String x = costoproduct.getText();
            String y = cantidadproduct.getText();
            if(isDouble(x)==false){
                JOptionPane.showMessageDialog(null, "El campo precio del producto debe contener únicamente números, intentelo de nuevo por favor.");
            }else if(isNumeric(y)==false){
                JOptionPane.showMessageDialog(null, "El campo cantidad el producto debe contener únicamente números enteros, intentelo de nuevo por favor.");
            }else{
                op.GuardarRegistro(nombreproduct, costoproduct, cantidadproduct, Tboxidproveedor);
                op.mostrar(TableProducto);
                limpiar();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    //Acción que carga los datos de la tabla a los campos TextField
    private void TableProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProductoMouseClicked
        DefaultTableModel model = (DefaultTableModel) TableProducto.getModel();
        idproducto.setText(model.getValueAt(TableProducto.getSelectedRow(),0)+"");
        nombreproduct.setText(model.getValueAt(TableProducto.getSelectedRow(),1)+"");
        costoproduct.setText(model.getValueAt(TableProducto.getSelectedRow(),2)+"");
        cantidadproduct.setText(model.getValueAt(TableProducto.getSelectedRow(),3)+"");
        Tboxidproveedor.setSelectedItem(model.getValueAt(TableProducto.getSelectedRow(),4)+"");
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnEditar.setEnabled(true);
    }//GEN-LAST:event_TableProductoMouseClicked

    //Botón para regresar al menú principal
    private void MenúMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenúMouseClicked
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea regresar al menú principal?");   
        if(resp ==0){        
            Menu mn = new Menu(mod);
            mn.setVisible(true);
            this.setVisible(false); 
        }   
    }//GEN-LAST:event_MenúMouseClicked

    //Botón para salir del programa
    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea Salir?");
        if(resp ==0){
            System.exit(0);
        }  
    }//GEN-LAST:event_SalirMouseClicked

     //Boton cancelar, limpia los campos y reestablece los botones
    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        limpiar();
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnEditar.setEnabled(false);
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
            java.util.logging.Logger.getLogger(ViewProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel Menú;
    private javax.swing.JLabel Salir;
    private javax.swing.JTable TableProducto;
    private javax.swing.JComboBox<String> Tboxidproveedor;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField cantidadproduct;
    private javax.swing.JTextField costoproduct;
    private javax.swing.JTextField idproducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField nombreproduct;
    // End of variables declaration//GEN-END:variables
}
