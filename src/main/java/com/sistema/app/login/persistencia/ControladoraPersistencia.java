package com.sistema.app.login.persistencia;

import com.sistema.app.login.logica.Rol;
import com.sistema.app.login.logica.Usuario;
import com.sistema.app.login.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    RolJpaController rolJpa = new RolJpaController();
    
    public void crearUsuario(Usuario usu) {
        usuarioJpa.create(usu);
    }
    
    public List<Usuario> traerUsuarios() {
        return usuarioJpa.findUsuarioEntities();
    }

    public Usuario traerUsuario(int idUsuario) {
        return usuarioJpa.findUsuario(idUsuario);
    }
    
    public void borrarUsuario(int idUsuario) {
        try {
            usuarioJpa.destroy(idUsuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuarioJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // ROLES 
    
    public List<Rol> traerRoles() {
        return rolJpa.findRolEntities();
    }
}
