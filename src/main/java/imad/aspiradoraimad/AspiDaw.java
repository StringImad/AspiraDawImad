/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.aspiradoraimad;

import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class AspiDaw {
    public static void main(String[] args) {

	//Declaración de las variables que vamos a utilizar
        int opcionElegida;
        int eleccionPrincipal;
        int opcionAspirar;
        boolean repetir = true;
        boolean acceso = true;
        double nivelBateria = 0;
        double bateriInferior = 3.0;
        final double MODOASPIRACION = 1.5;
        final double MODOFREGADO = 2.25;
        int hora, minutos, segundos;
        String posicion = " Base de carga ";
        int metrosCuadrados = 0;
        boolean eleccionSwitch = true;
        
        //Cracion de los arrays que vamos a utilizar
        int[] dependenciasCasa = null;
        String[] dependenciasVilla = new String[5];
        dependenciasVilla[0] = "salon";
        dependenciasVilla[1] = "dormitorio";
        dependenciasVilla[2] = "dormitorio2";
        dependenciasVilla[3] = "cocina";
        dependenciasVilla[4] = "Baño";
        
         do {
            final String USUARIO = JOptionPane.showInputDialog(" Dime tu usuario ");
            final String PASSWORD = JOptionPane.showInputDialog(" Dime tu contraseña ");
            if (USUARIO.equals("usuario") && PASSWORD.equals("usuario")) {

                JOptionPane.showMessageDialog(null, "Bienvenido\n"
                        + "Has ingresado satisfactoriamente al sistema", "Mensaje de bienvenida",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            } else {

                JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                        + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
                        JOptionPane.ERROR_MESSAGE);
                acceso = true;

            }
        } while (acceso);
        
    }
}
