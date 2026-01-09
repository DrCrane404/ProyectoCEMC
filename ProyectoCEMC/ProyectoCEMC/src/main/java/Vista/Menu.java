package Vista;

import Modelo.Usuario;
import java.awt.Color;

// Cambiar Menu dependiendo tipo de usuario

public class Menu extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Menu.class.getName());
    private Usuario usuario;
    Color azul = new Color(41, 51, 92);
    Color hover = new Color(49, 69, 168);
        
    public Menu(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        Btn_Crear.setFocusPainted(false);
        Btn_Crear.setBorderPainted(false);
        Btn_Crear.setOpaque(true);
        Btn_Consulta.setFocusPainted(false);
        Btn_Consulta.setBorderPainted(false);
        Btn_Consulta.setOpaque(true);
        Btn_Actualizar.setFocusPainted(false);
        Btn_Actualizar.setBorderPainted(false);
        Btn_Actualizar.setOpaque(true);
        Btn_Borrar.setFocusPainted(false);
        Btn_Borrar.setBorderPainted(false);
        Btn_Borrar.setOpaque(true);
    }
    
    private void configurarRoleAccess() {
        if (usuario == null)
            return;

        String role = usuario.getRol();
        if (role == null)
            role = "";

        if ("Administrador".equalsIgnoreCase(role)) {
            
        } else if ("Entrenador".equalsIgnoreCase(role)) {
            
        } else if ("Paciente".equalsIgnoreCase(role)) {
            
        } else {
            
        }

        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Btn_Crear = new javax.swing.JButton();
        Btn_Consulta = new javax.swing.JButton();
        Btn_Actualizar = new javax.swing.JButton();
        Btn_Borrar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        Lbl_Salir = new javax.swing.JLabel();
        Lbl_Bienvenido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú");
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(177, 157, 104));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 140, 50));

        jPanel2.setBackground(new java.awt.Color(41, 51, 92));

        jLabel1.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 250, 250));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Menú - CEMC");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 50));

        jPanel4.setBackground(new java.awt.Color(226, 230, 230));

        Btn_Crear.setBackground(new java.awt.Color(41, 51, 92));
        Btn_Crear.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        Btn_Crear.setForeground(new java.awt.Color(250, 250, 250));
        Btn_Crear.setText("CREAR USUARIO");
        Btn_Crear.setBorder(null);
        Btn_Crear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Crear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_CrearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_CrearMouseExited(evt);
            }
        });

        Btn_Consulta.setBackground(new java.awt.Color(41, 51, 92));
        Btn_Consulta.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        Btn_Consulta.setForeground(new java.awt.Color(250, 250, 250));
        Btn_Consulta.setText("CONSULTA");
        Btn_Consulta.setBorder(null);
        Btn_Consulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_ConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_ConsultaMouseExited(evt);
            }
        });

        Btn_Actualizar.setBackground(new java.awt.Color(41, 51, 92));
        Btn_Actualizar.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        Btn_Actualizar.setForeground(new java.awt.Color(250, 250, 250));
        Btn_Actualizar.setText("ACTUALIZAR DATOS");
        Btn_Actualizar.setBorder(null);
        Btn_Actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_ActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_ActualizarMouseExited(evt);
            }
        });

        Btn_Borrar.setBackground(new java.awt.Color(41, 51, 92));
        Btn_Borrar.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        Btn_Borrar.setForeground(new java.awt.Color(250, 250, 250));
        Btn_Borrar.setText("BORRAR");
        Btn_Borrar.setBorder(null);
        Btn_Borrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_Borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_BorrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_BorrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Btn_Crear, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Btn_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Btn_Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Btn_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(Btn_Crear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btn_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btn_Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btn_Borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 300));

        jPanel5.setBackground(new java.awt.Color(226, 230, 230));
        jPanel5.setToolTipText("");

        Lbl_Salir.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        Lbl_Salir.setForeground(new java.awt.Color(41, 51, 92));
        Lbl_Salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Salir.setText("SALIR");
        Lbl_Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Lbl_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Lbl_SalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lbl_Salir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lbl_Salir, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 458, 460, -1));

        Lbl_Bienvenido.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        Lbl_Bienvenido.setForeground(new java.awt.Color(41, 51, 92));
        Lbl_Bienvenido.setText("Bienvenido!");
        jPanel1.add(Lbl_Bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_CrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_CrearMouseEntered
        Btn_Crear.setBackground(hover);
    }//GEN-LAST:event_Btn_CrearMouseEntered

    private void Btn_CrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_CrearMouseExited
        Btn_Crear.setBackground(azul);
    }//GEN-LAST:event_Btn_CrearMouseExited

    private void Btn_ConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ConsultaMouseEntered
        Btn_Consulta.setBackground(hover);
    }//GEN-LAST:event_Btn_ConsultaMouseEntered

    private void Btn_ConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ConsultaMouseExited
        Btn_Consulta.setBackground(azul);
    }//GEN-LAST:event_Btn_ConsultaMouseExited

    private void Btn_ActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ActualizarMouseEntered
        Btn_Actualizar.setBackground(hover);
    }//GEN-LAST:event_Btn_ActualizarMouseEntered

    private void Btn_ActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ActualizarMouseExited
        Btn_Actualizar.setBackground(azul);
    }//GEN-LAST:event_Btn_ActualizarMouseExited

    private void Btn_BorrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_BorrarMouseEntered
        Btn_Borrar.setBackground(hover);
    }//GEN-LAST:event_Btn_BorrarMouseEntered

    private void Btn_BorrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_BorrarMouseExited
        Btn_Borrar.setBackground(azul);
    }//GEN-LAST:event_Btn_BorrarMouseExited

    private void Lbl_SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lbl_SalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_Lbl_SalirMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Actualizar;
    private javax.swing.JButton Btn_Borrar;
    private javax.swing.JButton Btn_Consulta;
    private javax.swing.JButton Btn_Crear;
    private javax.swing.JLabel Lbl_Bienvenido;
    private javax.swing.JLabel Lbl_Salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}