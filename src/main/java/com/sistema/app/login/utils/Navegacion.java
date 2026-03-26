package com.sistema.app.login.utils;

import javax.swing.JFrame;

public class Navegacion {
    public static void cambiarVentana(JFrame actual, JFrame destino) {
        actual.dispose();
        destino.setVisible(true);
        destino.setLocationRelativeTo(null);
    }
}
