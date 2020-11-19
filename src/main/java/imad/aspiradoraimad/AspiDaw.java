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
        boolean eleccionSwitch2 = true;

        //Cracion de los arrays que vamos a utilizar
        //dependeciasCasa no tiene valor ya que se va a meter más tardes
        int[] dependenciasCasa = null;
        //array de 5 posiciones con el valor introducido ya
        String[] dependenciasVilla = new String[5];
        dependenciasVilla[0] = "salon";
        dependenciasVilla[1] = "dormitorio";
        dependenciasVilla[2] = "dormitorio2";
        dependenciasVilla[3] = "cocina";
        dependenciasVilla[4] = "Baño";

        // Login para acceder, se va a repetir hasta que se cumpla la condicion del while
        // al entrar en el if se sale
        do {
            //declaración de dos constantes de tipo String
            final String USUARIO = JOptionPane.showInputDialog(" Dime tu usuario ");
            final String PASSWORD = JOptionPane.showInputDialog(" Dime tu contraseña ");
            // Condicion 
            if (USUARIO.equals("usuario") && PASSWORD.equals("usuario")) {

                JOptionPane.showMessageDialog(null, "Bienvenido\n"
                        + "Has ingresado satisfactoriamente al sistema", "Mensaje de bienvenida",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            } else {

                JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                        + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
                        JOptionPane.ERROR_MESSAGE);
                //Al poner el else en true la condición del while se repite
                acceso = true;

            }
        } while (acceso);
        //
        do {
            String opcionPrincipal = JOptionPane.showInputDialog("Opciones del programa\n"
                    + "1.- Configurar el sistema\n"
                    + "2.- Carga\n"
            );
            //switch creado para meter los datos obligatorios iniciales., esta dentro de un un do while
            //por lo tanto se va a repetir hasta que la condicion se cumpla
            eleccionPrincipal = Integer.parseInt(opcionPrincipal);
            switch (eleccionPrincipal) {

                case 1:
                    JOptionPane.showMessageDialog(null, "Usted acaba de seleccionar configuración del sistema");
                    String CantidadDependencias = JOptionPane.showInputDialog(" Introduza el número de dependencias de la casa");
                    int CantDepen = Integer.parseInt(CantidadDependencias);

                    dependenciasCasa = new int[CantDepen];
                    //creación del bucle for que nos va a permitir meter los metros de cada dependencia 

                    for (int i = 0; i < dependenciasCasa.length; i++) {

                        String dependenciasMetros = JOptionPane.showInputDialog(" Introduzca los metros de la dependencia " + (i + 1));
                        int cantidMetros = Integer.parseInt(dependenciasMetros);
                        //Si los metros no entran en el if le sale un mensaje de aviso
                        //se realiza el break y sale al menu
                        if (cantidMetros < 0 || cantidMetros > 100) {
                            JOptionPane.showMessageDialog(null, " Los metros deben de ser mayores que 0 y menores de 43");
                           eleccionSwitch = true;
                            break;
                        }
                        //los valores introducidos por teclado "cantidmetros" 
                        //se almacenan en la posición del array
                        dependenciasCasa[i] = cantidMetros;
                        eleccionSwitch2 = false;
                    }

                    
                    break;

                case 2:
                    
                    String nivelBateriaIntroducido = JOptionPane.showInputDialog(" Introduza la carga actual del robot");
                    nivelBateria = Double.parseDouble(nivelBateriaIntroducido);
                    //condicion para que el nivel de carga sea entre 0 y 100
                    if (nivelBateria >= 0 && nivelBateria <= 100) {  
                        eleccionSwitch = false;
                        break;
                        
                    } else {
                        JOptionPane.showMessageDialog(null, " La carga introducida no puede ser menor que 0 o mayor que 100");
                        //Si la condicion no se cumple se vuelve a repetir el bucle
                        eleccionSwitch = true;
                        break;
                    }
            }

        } while (eleccionSwitch || eleccionSwitch2);

    }
}
