package Vista;

import Modelo.Usuario;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

public class Dashboard extends javax.swing.JFrame {
    private Usuario usuario;

    // Custom buttons list for simpler management
    private List<JButton> allButtons = new ArrayList<>();

    // Buttons (Manually declared to match typical NetBeans added components if they
    // were dropped in Design)
    // However, since we want dynamic addition, we'll keep the declaring separate or
    // simple.
    // For NetBeans consistency, usually components in the form are declared at
    // bottom.
    // My Form has 'menuPanel' as a container. I will dynamically add buttons to it.

    // Dynamic Buttons
    private JButton btnGestionUsuarios;
    private JButton btnGestionEntrenadores;
    private JButton btnMisPacientes;
    private JButton btnProgramas;
    private JButton btnAsignarPrograma;
    private JButton btnMiPerfil;
    private JButton btnMisProgramas;
    private JButton btnCerrarSesion;

    public Dashboard() {
        initComponents();
    }

    public Dashboard(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        initCustomButtons();
        configureRoleAccess();

        if (usuario != null) {
            lblWelcome.setText("Bienvenido, " + usuario.getNombre());
        }
    }

    private void initCustomButtons() {
        btnGestionUsuarios = createButton("Gestión Usuarios");
        btnGestionEntrenadores = createButton("Gestión Entrenadores");
        btnMisPacientes = createButton("Mis Pacientes");
        btnProgramas = createButton("Programas");
        btnAsignarPrograma = createButton("Asignar Programa");
        btnMiPerfil = createButton("Mi Perfil");
        btnMisProgramas = createButton("Mis Programas");
        btnCerrarSesion = createButton("Cerrar Sesión");

        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new Login().setVisible(true);
                dispose();
            }
        });

        btnMisPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (usuario != null) {
                    new MisPacientes(usuario).setVisible(true);
                }
            }
        });

        btnProgramas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // For now, assume we want to CREATE a program when clicking here,
                // or show a list. Since we just made Create, let's open that.
                // Ideally this would go to a CRUD list, but we are building incrementally.
                new CrearPrograma(usuario).setVisible(true);
            }
        });

        btnAsignarPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (usuario != null) {
                    new AsignarPrograma(usuario).setVisible(true);
                }
            }
        });
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(new Color(41, 51, 92));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("SansSerif", Font.PLAIN, 16));
        btn.setFocusPainted(false);
        return btn;
    }

    private void configureRoleAccess() {
        if (usuario == null)
            return;

        String role = usuario.getRol();
        if (role == null)
            role = "";

        menuPanel.removeAll();

        if ("Administrador".equalsIgnoreCase(role)) {
            menuPanel.add(btnGestionUsuarios);
            menuPanel.add(btnGestionEntrenadores);
            menuPanel.add(btnProgramas);
            menuPanel.add(btnMiPerfil);
        } else if ("Entrenador".equalsIgnoreCase(role)) {
            menuPanel.add(btnMisPacientes);
            menuPanel.add(btnProgramas);
            menuPanel.add(btnAsignarPrograma);
            menuPanel.add(btnMiPerfil);
        } else if ("Paciente".equalsIgnoreCase(role)) {
            menuPanel.add(btnMisProgramas);
            menuPanel.add(btnMiPerfil);
        } else {
            menuPanel.add(btnMiPerfil);
        }

        menuPanel.add(btnCerrarSesion);
        menuPanel.revalidate();
        menuPanel.repaint();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard - CEMC");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(41, 51, 92));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblWelcome.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("Bienvenido");
        jPanel2.add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 700, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 80));

        menuPanel.setOpaque(false);
        menuPanel.setLayout(new java.awt.GridLayout(0, 2, 20, 20));
        jPanel1.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 700, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel menuPanel;
    // End of variables declaration//GEN-END:variables
}
