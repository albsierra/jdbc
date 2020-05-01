
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Interfaz extends javax.swing.JFrame {

    private DefaultListModel lm;
    private Connection conexion;

    /*
     * Cadena de conexión a la base de datos
     *   tipo de conexión: jdbc
     *   driver: mysql
     *   host de la base de datos: localhost
     *   nombre de la base de datos: municipiosProvincias
     */
    private static final String URL = "jdbc:mysql://localhost/municipiosProvincias";

    // Nombre de usuario de acceso a la B.D.
    private static final String USERNAME = "root";

    // Contraseña de acceso a la B.D.
    private static final String PASSWORD = "alumno";

    final void abrirConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD); // a connection must be closed, so we use close() method

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    private boolean insertarCategoria(String _nombre, int _id_provincia) throws SQLException {
        Statement sentencia = conexion.createStatement();
        String sql = "INSERT INTO municipios(`id_provincia`, `cod_municipio`, `DC`, `nombre`)"
                + "VALUES (" + _id_provincia + ", 1, 1, '" + _nombre + "')";
        return (sentencia.executeUpdate(sql) > 0);

    }
    
    private void actualizarListaMunicipios() {
        lm.clear();
        String provin = String.valueOf(provincias.getSelectedItem());

        try {  //   Mostramos los municipios de la provincia seleccionada
            Statement s = conexion.createStatement();
            if (provincias.getSelectedIndex() != 0) {
                String sentencia
                        = "SELECT nombre"
                        + " FROM municipios JOIN provincias USING (id_provincia)"
                        + " WHERE provincia = '" + provin + "'";

                try (ResultSet rsMunicipios = s.executeQuery(sentencia)) {
                    while (rsMunicipios.next()) {
                        lm.addElement(rsMunicipios.getString("nombre"));
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public Interfaz() {
        initComponents();
        lm = new DefaultListModel();
        municipios.setModel(lm);
        abrirConexion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        provincias = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        municipios = new javax.swing.JList();
        salir = new javax.swing.JButton();
        jButtonInsertarMunicipio = new javax.swing.JButton();
        jTextNuevoMunicipio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        provincias.setMaximumRowCount(9);
        provincias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una provincia" }));
        provincias.setToolTipText("");
        provincias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        provincias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provinciasActionPerformed(evt);
            }
        });

        jLabel2.setText("Municipios de la provincia seleccionada:");

        jScrollPane1.setViewportView(municipios);

        salir.setText("Salir");
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });

        jButtonInsertarMunicipio.setText("Insertar");
        jButtonInsertarMunicipio.setName("jButtonInsertarMunicipio"); // NOI18N
        jButtonInsertarMunicipio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonInsertarMunicipioMouseClicked(evt);
            }
        });

        jTextNuevoMunicipio.setName("jTextNuevoMunicipio"); // NOI18N

        jLabel1.setText("Nuevo Municipio:");
        jLabel1.setName("jLabelNuevoMunicipio"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(7, 7, 7)
                        .addComponent(jTextNuevoMunicipio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonInsertarMunicipio))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(provincias, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 110, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(salir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(provincias, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInsertarMunicipio)
                    .addComponent(jTextNuevoMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
        try {   // Si cerramos la ventana, también la conexión con la BD
            if (conexion != null) {
                conexion.close();
                dispose();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.exit(0);
    }//GEN-LAST:event_salirMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            Statement s = conexion.createStatement();
            ResultSet rsProvincias = s.executeQuery("SELECT * FROM provincias");
            while (rsProvincias.next()) {
                provincias.addItem(rsProvincias.getString("provincia"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_formWindowOpened

    private void provinciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provinciasActionPerformed
        actualizarListaMunicipios();
    }//GEN-LAST:event_provinciasActionPerformed

    private void jButtonInsertarMunicipioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonInsertarMunicipioMouseClicked
        String provincia = String.valueOf(provincias.getSelectedItem());
        int _id_provincia = 0;

        try {  //   Mostramos los municipios de la provincia seleccionada
            Statement s = conexion.createStatement();
            if (provincias.getSelectedIndex() != 0) {
                String sentencia
                        = "SELECT id_provincia"
                        + " FROM provincias"
                        + " WHERE provincia = '" + provincia + "'";

                try (ResultSet rsProvincias = s.executeQuery(sentencia)) {
                    while (rsProvincias.next()) {
                        _id_provincia = rsProvincias.getInt("id_provincia");
                    }
                    if(_id_provincia > 0) {
                        insertarCategoria(jTextNuevoMunicipio.getText(), _id_provincia);
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        actualizarListaMunicipios();

    }//GEN-LAST:event_jButtonInsertarMunicipioMouseClicked

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInsertarMunicipio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextNuevoMunicipio;
    private javax.swing.JList municipios;
    private javax.swing.JComboBox provincias;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
