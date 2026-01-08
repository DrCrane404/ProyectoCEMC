package Modelo;

import java.time.*;
import java.sql.*;

public class Usuario {

    // Atributos de clase Usuario
    private int idusuario;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private String correo;
    private String telefono;
    private String direccion;
    private String usuario;
    private String contrasena;
    private String pregunta_recuperacion;
    private String respuesta_recuperacion;
    private String rol;
    private String estatus;
    private LocalDate fecha_registro;
    private LocalDateTime ultimo_acceso;
    private int intentos_fallidos;

    // Constructores
    public Usuario() {
    }

    public Usuario(String nombre, String ap_paterno, String ap_materno, String correo, String telefono,
            String direccion, String usuario, String contrasena) {
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // Getters y setters
    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPregunta_recuperacion() {
        return pregunta_recuperacion;
    }

    public void setPregunta_recuperacion(String pregunta_recuperacion) {
        this.pregunta_recuperacion = pregunta_recuperacion;
    }

    public String getRespuesta_recuperacion() {
        return respuesta_recuperacion;
    }

    public void setRespuesta_recuperacion(String respuesta_recuperacion) {
        this.respuesta_recuperacion = respuesta_recuperacion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public LocalDateTime getUltimo_acceso() {
        return ultimo_acceso;
    }

    public void setUltimo_acceso(LocalDateTime ultimo_acceso) {
        this.ultimo_acceso = ultimo_acceso;
    }

    public int getIntentos_fallidos() {
        return intentos_fallidos;
    }

    public void setIntentos_fallidos(int intentos_fallidos) {
        this.intentos_fallidos = intentos_fallidos;
    }

    public void Guardar() throws SQLException {
        Connection CON = DriverManager.getConnection("jdbc:mysql://localhost:3306/centro_mental", "root", "");
        PreparedStatement Sen = CON.prepareStatement(
                "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);

        Sen.setInt(1, idusuario);
        Sen.setString(2, nombre);
        Sen.setString(3, ap_paterno);
        Sen.setString(4, ap_materno);
        Sen.setString(5, correo);
        Sen.setString(6, telefono);
        Sen.setString(7, direccion);
        Sen.setString(8, usuario);
        Sen.setString(9, contrasena);
        Sen.setString(10, pregunta_recuperacion);
        Sen.setString(11, respuesta_recuperacion);
        Sen.setString(12, rol);
        Sen.setString(13, estatus);
        Sen.setDate(14, Date.valueOf(fecha_registro));
        Sen.setTimestamp(15, Timestamp.valueOf(ultimo_acceso));
        Sen.setInt(16, intentos_fallidos);

        Sen.executeUpdate();

        ResultSet rs = Sen.getGeneratedKeys();
        if (rs.next()) {
            this.idusuario = rs.getInt(1);
        }

        // Sen.close();
        // CON.close();
    }

    public boolean Buscar() throws SQLException {
        Connection CON = DriverManager.getConnection("jdbc:mysql://localhost:3306/centro_mental", "root", "");
        PreparedStatement SQL = CON.prepareStatement("SELECT * FROM usuario WHERE usuario = ?");

        SQL.setString(1, usuario);
        ResultSet RS = SQL.executeQuery();

        if (RS.next()) {
            idusuario = RS.getInt("idusuario");
            nombre = RS.getString("nombre");
            ap_paterno = RS.getString("ap_paterno");
            ap_materno = RS.getString("ap_materno");
            correo = RS.getString("correo");
            telefono = RS.getString("telefono");
            direccion = RS.getString("direccion");
            usuario = RS.getString("usuario");
            contrasena = RS.getString("contrasena");
            pregunta_recuperacion = RS.getString("pregunta_recuperacion");
            respuesta_recuperacion = RS.getString("respuesta_recuperacion");
            rol = RS.getString("rol");
            estatus = RS.getString("estatus");
            fecha_registro = RS.getDate("fecha_registro").toLocalDate();
            ultimo_acceso = RS.getTimestamp("ultimo_acceso").toLocalDateTime();
            intentos_fallidos = RS.getInt("intentos_fallidos");

            return true;
        } else {
            return false;
        }
    }

    public void Actualizar() throws SQLException {
        Connection CON = DriverManager.getConnection("jdbc:mysql://localhost:3306/centro_mental", "root", "");
        PreparedStatement Sen = CON.prepareStatement(
                "UPDATE usuario SET nombre = ?, ap_paterno = ?, ap_materno = ?, correo = ?, telefono = ?, direccion = ?, contrasena = ?, estatus = ?, WHERE usuario = ?");

        Sen.setString(1, nombre);
        Sen.setString(2, ap_paterno);
        Sen.setString(3, ap_materno);
        Sen.setString(4, correo);
        Sen.setString(5, telefono);
        Sen.setString(6, direccion);
        Sen.setString(7, usuario);
        Sen.setString(8, estatus);

        Sen.executeUpdate();
    }

    public void Borrar() throws SQLException {
        Connection CON = DriverManager.getConnection("jdbc:mysql://localhost:3306/centro_mental", "root", "");
        PreparedStatement Sen = CON.prepareStatement("DELETE FROM usuario WHERE usuario = ?");

        Sen.setString(1, usuario);
        Sen.executeUpdate();
    }

    public ResultSet Mostrar() throws SQLException {
        Connection CON = DriverManager.getConnection("jdbc:mysql://localhost:3306/centro_mental", "root", "");
        PreparedStatement SQL = CON.prepareStatement("SELECT * FROM usuario");

        ResultSet Res = SQL.executeQuery();
        return Res;
    }
}