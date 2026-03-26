package com.sistema.app.login.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Mensajes {
    
    public static void mostrar(String tipo, String title, String message, Component parent) {
        if ("info".equals(tipo)) {
            JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
        } else if ("error".equals(tipo)) {
            JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static boolean confirmarSalida(Component parent) {
        int opcion = JOptionPane.showConfirmDialog(parent,
                "¿Está seguro que desea salir?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION);

        return opcion == JOptionPane.YES_OPTION;
    }
}
