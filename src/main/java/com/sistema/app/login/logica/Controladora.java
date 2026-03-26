package com.sistema.app.login.logica;

import com.sistema.app.login.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    ControladoraPersistencia controlPersis;
    
    public Controladora() {
        controlPersis = new ControladoraPersistencia();
    }

    public void crearUsuario(String nombreUsuario, String contrasenia, String rolRecibido) {
        Usuario usu = new Usuario();
        usu.setNombreUsuario(nombreUsuario);
        usu.setContrasenia(contrasenia);
        
        Rol rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }
        controlPersis.crearUsuario(usu);
    }
    
    public Usuario validarUsuario(String usuario, String contrasenia) {
        List<Usuario> usuarios = controlPersis.traerUsuarios();
        
        for (Usuario usu : usuarios) {
            if (usu.getNombreUsuario().equals(usuario) &&
                usu.getContrasenia().equals(contrasenia)) {
                    return usu;
                }
        }
        return null;
    }

    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }
    
    public Usuario traerUsuario(int idUsuario) {
        return controlPersis.traerUsuario(idUsuario);
    }

    public void borrarUsuario(int idUsuario) {
        controlPersis.borrarUsuario(idUsuario);
    }

    public void editarUsuario(Usuario usu, String nombreUsuario, String contrasenia, String rolRecibido) {
        usu.setNombreUsuario(nombreUsuario);
        usu.setContrasenia(contrasenia);
        
        Rol rolEncontrado = this.traerRol(rolRecibido);
        if (rolEncontrado != null) {
            usu.setUnRol(rolEncontrado);
        }
        
        controlPersis.editarUsuario(usu);
    }
    
    // ROLES
    
    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }
    
    private Rol traerRol(String rolRecibido) {
        List<Rol> roles = controlPersis.traerRoles();
        
        for (Rol rol: roles) {
            if (rolRecibido.equals(rol.getNombreRol())) {
                return rol;
            }
        }
        return null;
    }
}
