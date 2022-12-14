package GUI;
import Lógica.Empleado;
import Persistencia.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Login extends javax.swing.JFrame {
    String user;   
    Conexion connect = new Conexion();   
    Connection con;
    public Login() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnIniciar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Boca2");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setName("Boca2"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(840, 560));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(141, 158, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 549));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 112, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("PenultimateLight", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Boca2");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 370, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/14UV.gif"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 370, 330));

        jLabel9.setFont(new java.awt.Font("PenultimateLight", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Restaurante");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 370, -1));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel8.setBackground(new java.awt.Color(51, 51, 255));
        jLabel8.setFont(new java.awt.Font("PenultimateLight", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Iniciar Sesión");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 370, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 560));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario (6) (1).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 470, -1));

        txtUser.setBackground(new java.awt.Color(255, 255, 255));
        txtUser.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(51, 51, 51));
        txtUser.setToolTipText("User");
        txtUser.setBorder(null);
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 190, 20));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 190, 20));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 190, 20));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Contraseña");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 470, -1));

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setBorder(null);
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 190, 30));

        btnIniciar.setBackground(new java.awt.Color(0, 0, 0));
        btnIniciar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("Iniciar");
        btnIniciar.setBorder(null);
        btnIniciar.setBorderPainted(false);
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 130, 40));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Usuario");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 470, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método de login busca usuario y contraseña
    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        con = connect.conectar();
        user = txtUser.getText();
        String password = String.valueOf(txtPassword.getPassword ());
        String Consulta = "SELECT empleado.nombreEmpleado, empleado.apellidoEmpleado, empleado.direccionEmpleado, empleado.direccionEmpleado, empleado.teléfonoEmpleado, puesto.puesto FROM empleado, puesto WHERE usuarioEmpleado = '"+user+"'and  passwordEmpleado = '"+password+ "' and empleado.idPuesto = puesto.idpuesto";         
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Consulta);
            if(rs.next()){
            JOptionPane.showMessageDialog(null, "Bienvenido(a): " + txtUser.getText());
                Empleado e = new Empleado();
                e.setPuesto(rs.getString(6));
                e.setNombreEmpleado(rs.getString(1));
                Menu mn = new Menu(e);
                System.out.println(e.getPuesto());
                mn.setVisible(true);
                this.setVisible(false);
            }else{
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");           
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

            
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
