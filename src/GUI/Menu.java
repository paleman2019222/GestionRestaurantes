package GUI;
import Lógica.Empleado;
import Persistencia.Conexion;
import javax.swing.JOptionPane;
public class Menu extends javax.swing.JFrame {
    Login lg = new Login();
    Empleado mod;
    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    //Constructor que obtiene los datos del usuario en sesión
    public Menu(Empleado mod){
        initComponents();
        setLocationRelativeTo(null);
        this.mod = mod;
        labelNombre.setText(mod.getNombreEmpleado());
        labelPuesto.setText(mod.getPuesto());
        if(mod.getPuesto().equals("Administrador")){
            btnEmpleadoView.setEnabled(true);
            btnProveedorView.setEnabled(true);
            btnProductoview.setEnabled(true);
            btnPlatilloView.setEnabled(true);
            btnPuestoView.setEnabled(true);
        }else if(mod.getPuesto().equals("Mesero")){
            btnEmpleadoView.setEnabled(false);
            btnProveedorView.setEnabled(false);
            btnProductoview.setEnabled(false);
            btnPlatilloView.setEnabled(true);
            btnPuestoView.setEnabled(false);
        }else if(mod.getPuesto().equals("Cocinero")){
            btnEmpleadoView.setEnabled(false);
            btnProveedorView.setEnabled(false);
            btnProductoview.setEnabled(true);
            btnPlatilloView.setEnabled(true);
            btnPuestoView.setEnabled(false); 
        }else{
            btnEmpleadoView.setEnabled(false);
            btnProveedorView.setEnabled(false);
            btnProductoview.setEnabled(false);
            btnPlatilloView.setEnabled(false);
            btnPuestoView.setEnabled(false); 
        }              
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnPuestoView = new javax.swing.JButton();
        btnEmpleadoView = new javax.swing.JButton();
        btnPlatilloView = new javax.swing.JButton();
        btnProveedorView = new javax.swing.JButton();
        btnProductoview = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();
        labelPuesto = new javax.swing.JLabel();
        btnMenuAbrir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 88, 378, -1));

        pnlMenu.setBackground(new java.awt.Color(0, 0, 0));
        pnlMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlMenu.setForeground(new java.awt.Color(0, 0, 0));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario (7).png"))); // NOI18N
        pnlMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 100));

        btnLogout.setBackground(new java.awt.Color(201, 34, 34));
        btnLogout.setFont(new java.awt.Font("Raleway", 1, 12)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Cerrar Sesión");
        btnLogout.setBorder(null);
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        pnlMenu.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 170, 30));

        btnPuestoView.setBackground(new java.awt.Color(255, 255, 255));
        btnPuestoView.setFont(new java.awt.Font("Raleway", 1, 12)); // NOI18N
        btnPuestoView.setForeground(new java.awt.Color(0, 0, 0));
        btnPuestoView.setText("Puestos");
        btnPuestoView.setBorder(null);
        btnPuestoView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPuestoView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuestoViewActionPerformed(evt);
            }
        });
        pnlMenu.add(btnPuestoView, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 170, 30));

        btnEmpleadoView.setBackground(new java.awt.Color(255, 255, 255));
        btnEmpleadoView.setFont(new java.awt.Font("Raleway", 1, 12)); // NOI18N
        btnEmpleadoView.setForeground(new java.awt.Color(0, 0, 0));
        btnEmpleadoView.setText("Empleados");
        btnEmpleadoView.setBorder(null);
        btnEmpleadoView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpleadoView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadoViewActionPerformed(evt);
            }
        });
        pnlMenu.add(btnEmpleadoView, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 170, 30));

        btnPlatilloView.setBackground(new java.awt.Color(255, 255, 255));
        btnPlatilloView.setFont(new java.awt.Font("Raleway", 1, 12)); // NOI18N
        btnPlatilloView.setForeground(new java.awt.Color(0, 0, 0));
        btnPlatilloView.setText("Platillos");
        btnPlatilloView.setBorder(null);
        btnPlatilloView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlatilloView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlatilloViewActionPerformed(evt);
            }
        });
        pnlMenu.add(btnPlatilloView, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 170, 30));

        btnProveedorView.setBackground(new java.awt.Color(255, 255, 255));
        btnProveedorView.setFont(new java.awt.Font("Raleway", 1, 12)); // NOI18N
        btnProveedorView.setForeground(new java.awt.Color(0, 0, 0));
        btnProveedorView.setText("Proveedores");
        btnProveedorView.setBorder(null);
        btnProveedorView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedorView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProveedorViewMouseClicked(evt);
            }
        });
        pnlMenu.add(btnProveedorView, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 170, 30));

        btnProductoview.setBackground(new java.awt.Color(255, 255, 255));
        btnProductoview.setFont(new java.awt.Font("Raleway", 1, 12)); // NOI18N
        btnProductoview.setForeground(new java.awt.Color(0, 0, 0));
        btnProductoview.setText("Productos");
        btnProductoview.setBorder(null);
        btnProductoview.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductoview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductoviewMouseClicked(evt);
            }
        });
        pnlMenu.add(btnProductoview, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 170, 30));

        labelNombre.setFont(new java.awt.Font("Raleway", 1, 14)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlMenu.add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 210, 20));

        labelPuesto.setFont(new java.awt.Font("Raleway", 0, 12)); // NOI18N
        labelPuesto.setForeground(new java.awt.Color(255, 255, 255));
        labelPuesto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlMenu.add(labelPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 210, -1));

        jPanel3.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-210, 5, 210, 520));

        btnMenuAbrir.setBackground(new java.awt.Color(255, 255, 255));
        btnMenuAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        btnMenuAbrir.setBorder(null);
        btnMenuAbrir.setBorderPainted(false);
        btnMenuAbrir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        btnMenuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuAbrirActionPerformed(evt);
            }
        });
        jPanel3.add(btnMenuAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 50, 50));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo boca2.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 690, 450));

        jLabel2.setFont(new java.awt.Font("Raleway", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inicio");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 570, 80));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Dirige a la vista de Puestos
    private void btnPuestoViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuestoViewActionPerformed
        PuestoView mn = new PuestoView(mod);
        mn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPuestoViewActionPerformed

    //Función que hace que el menú se mueva
    private void btnMenuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuAbrirActionPerformed
        int position = btnMenuAbrir.getX();
        if(position > 5){
            Animacion.Animacion.mover_izquierda(211, 5, 1, 1, btnMenuAbrir);
            Animacion.Animacion.mover_izquierda(5, -200, 1, 1, pnlMenu);
        }else{
            Animacion.Animacion.mover_derecha(5, 210, 1, 1, btnMenuAbrir);
            Animacion.Animacion.mover_derecha(-200, 5, 1, 1, pnlMenu);
        }
    }//GEN-LAST:event_btnMenuAbrirActionPerformed

    //Método que cierra la sesión activa
    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        int p = JOptionPane.showConfirmDialog(null, "¿Desea cerrar la sesión?");
        if(p ==0){
            lg.setVisible(true);
            this.setVisible(false);
        }       
    }//GEN-LAST:event_btnLogoutMouseClicked

    //Dirige a la vista de empleado
    private void btnEmpleadoViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadoViewActionPerformed
        EmpleadoView mn = new EmpleadoView(mod);
        mn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnEmpleadoViewActionPerformed

    //Dirige a la vista de Platillo
    private void btnPlatilloViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlatilloViewActionPerformed
        PlatilloView mn = new PlatilloView(mod);
        mn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPlatilloViewActionPerformed

    //Dirige a la vista de proveedor
    private void btnProveedorViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProveedorViewMouseClicked
        ProveedorView mn = new ProveedorView(mod);
        mn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnProveedorViewMouseClicked

    //Dirigie ala vista de Prductos
    private void btnProductoviewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductoviewMouseClicked
        ViewProducto mn = new ViewProducto(mod);
        mn.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnProductoviewMouseClicked


    public static void main(String args[]) {    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmpleadoView;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMenuAbrir;
    private javax.swing.JButton btnPlatilloView;
    private javax.swing.JButton btnProductoview;
    private javax.swing.JButton btnProveedorView;
    private javax.swing.JButton btnPuestoView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPuesto;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
