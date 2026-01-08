package Vista;

import Modelo.Asigna_ejecuta;
import Modelo.Pacientes;
import Modelo.Programa;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AsignarPrograma extends javax.swing.JFrame {

    private int idEntrenador;
    
    private ArrayList<Integer> pacienteIds = new ArrayList<>();
    private ArrayList<Integer> programaIds = new ArrayList<>();

    public AsignarPrograma(int idEntrenador) {
        this.idEntrenador = idEntrenador;
        initComponents();
        cargarPacientes();
        cargarProgramas();

        Btn_Asignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AsignarActionPerformed(evt);
            }
        });

        Lbl_Volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Lbl_VolverMouseClicked(evt);
            }
        });
    }

    private void Lbl_VolverMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
    }

    private void cargarPacientes() {
        Pacientes modeloPacientes = new Pacientes();
        try {
            ResultSet rs = modeloPacientes.MostrarPorEntrenador(this.idEntrenador);
            Cmb_Pacientes.removeAllItems();
            pacienteIds.clear();

            Cmb_Pacientes.addItem("Seleccionar Paciente...");
            pacienteIds.add(-1); // Dummy ID for index 0

            while (rs.next()) {
                int id = rs.getInt("idusuario");
                String nombre = rs.getString("nombre") + " " + rs.getString("ap_paterno");
                Cmb_Pacientes.addItem(nombre);
                pacienteIds.add(id);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar pacientes: " + ex.getMessage());
        }
    }

    private void cargarProgramas() {
        Programa modeloPrograma = new Programa();
        try {
            ResultSet rs = modeloPrograma.Mostrar();
            Cmb_Programas.removeAllItems();
            programaIds.clear();

            Cmb_Programas.addItem("Seleccionar Programa...");
            programaIds.add(-1);

            while (rs.next()) {
                int id = rs.getInt("idprogramas_cognitivos");
                String nombre = rs.getString("nombre");
                Cmb_Programas.addItem(nombre);
                programaIds.add(id);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar programas: " + ex.getMessage());
        }
    }

    private void Btn_AsignarActionPerformed(java.awt.event.ActionEvent evt) {
        int indexPaciente = Cmb_Pacientes.getSelectedIndex();
        int indexPrograma = Cmb_Programas.getSelectedIndex();

        if (indexPaciente <= 0 || indexPrograma <= 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un paciente y un programa.");
            return;
        }

        try {
            int idPaciente = pacienteIds.get(indexPaciente);
            int idPrograma = programaIds.get(indexPrograma);

            String fechaInicioStr = Txt_FechaInicio.getText(); 
            String fechaFinStr = Txt_FechaFin.getText();
            String observaciones = Txt_Observaciones.getText();
            String estatus = Txt_Estatus.getText();

            
            Date fechaInicio = Date
                    .valueOf(fechaInicioStr.equals("Fecha Inicio (YYYY-MM-DD)") ? java.time.LocalDate.now().toString()
                            : fechaInicioStr);
            Date fechaFin = Date.valueOf(
                    fechaFinStr.equals("Fecha Fin (YYYY-MM-DD)") ? java.time.LocalDate.now().plusMonths(1).toString()
                            : fechaFinStr);

            Asigna_ejecuta asignacion = new Asigna_ejecuta();
            asignacion.setPacientes_usuario_idusuario(idPaciente);
            asignacion.setProgramas_cognitivos_idprogramas_cognitivos(idPrograma);
            asignacion.setEntrenadores_usuario_idusuario(this.idEntrenador);
            asignacion.setFecha_inicio(fechaInicio);
            asignacion.setFecha_fin(fechaFin);
            asignacion.setObservaciones(observaciones.equals("Observaciones") ? "" : observaciones);
            asignacion.setEstatus(estatus.equals("Estatus (Activo/Pendiente)") ? "Asignado" : estatus);

            
            asignacion.setFecha_pago(Date.valueOf(java.time.LocalDate.now()));
            asignacion.setMonto_pago(0.0);
            asignacion.setMetodo_pago("Pendiente");
            asignacion.setEstatus_pago("Pendiente");
            asignacion.setFolio("N/A");

            asignacion.Guardar();
            JOptionPane.showMessageDialog(this, "Programa asignado exitosamente.");
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al asignar (Verifique fechas YYYY-MM-DD): " + ex.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        Cmb_Pacientes = new javax.swing.JComboBox<>();
        Cmb_Programas = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        Txt_FechaInicio = new javax.swing.JTextField();
        Txt_FechaFin = new javax.swing.JTextField();
        Txt_Observaciones = new javax.swing.JTextField();
        Txt_Estatus = new javax.swing.JTextField();
        Btn_Asignar = new javax.swing.JButton();
        Lbl_Volver = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asignar Programa");
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(41, 51, 92));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(250, 250, 250));
        jLabel1.setText("Asignar Programa");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 200, 50));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 50));

        jPanel3.setBackground(new java.awt.Color(177, 157, 104));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 270, 50));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(156, 156, 156)));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridLayout(2, 2, 10, 10));

        Cmb_Pacientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Paciente..." }));
        jPanel5.add(Cmb_Pacientes);

        Cmb_Programas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Programa..." }));
        jPanel5.add(Cmb_Programas);

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 740, 100));

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(156, 156, 156)));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(3, 2, 10, 10));

        Txt_FechaInicio.setText("Fecha Inicio (YYYY-MM-DD)");
        jPanel6.add(Txt_FechaInicio);

        Txt_FechaFin.setText("Fecha Fin (YYYY-MM-DD)");
        jPanel6.add(Txt_FechaFin);

        Txt_Observaciones.setText("Observaciones");
        jPanel6.add(Txt_Observaciones);

        Txt_Estatus.setText("Estatus (Activo/Pendiente)");
        jPanel6.add(Txt_Estatus);

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 740, 150));

        Btn_Asignar.setBackground(new java.awt.Color(41, 51, 92));
        Btn_Asignar.setForeground(new java.awt.Color(250, 250, 250));
        Btn_Asignar.setText("ASIGNAR PROGRAMA");
        jPanel2.add(Btn_Asignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 200, 40));

        Lbl_Volver.setForeground(new java.awt.Color(41, 51, 92));
        Lbl_Volver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Volver.setText("VOLVER");
        Lbl_Volver.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(Lbl_Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 800, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Asignar;
    private javax.swing.JComboBox<String> Cmb_Pacientes;
    private javax.swing.JComboBox<String> Cmb_Programas;
    private javax.swing.JLabel Lbl_Volver;
    private javax.swing.JTextField Txt_Estatus;
    private javax.swing.JTextField Txt_FechaFin;
    private javax.swing.JTextField Txt_FechaInicio;
    private javax.swing.JTextField Txt_Observaciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
