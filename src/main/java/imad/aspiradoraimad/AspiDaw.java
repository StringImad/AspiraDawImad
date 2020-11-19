/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.aspiradoraimad;

import java.util.Calendar;
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
                            JOptionPane.showMessageDialog(null, " Los metros deben de ser mayores que 0 y menores de 43", "Error al introducir datos",
                                    JOptionPane.ERROR_MESSAGE);
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
                        //si el nivel de bateria es mayor que 0 y menos que 100 se 
                        //guarda el valor false y sale
                        eleccionSwitch = false;
                        break;

                    } else {
                        JOptionPane.showMessageDialog(null, " La carga introducida no puede ser menor que 0 o mayor que 100", "Error al introducir datos",
                                JOptionPane.ERROR_MESSAGE);
                        //Si la condicion no se cumple se vuelve a repetir el bucle
                        eleccionSwitch = true;
                        break;
                    }
            }
            //condicion OR hasta que no se cumpla y el while sea false no sale
        } while (eleccionSwitch || eleccionSwitch2);

        //Aquí empieza otro bucle do while para el menu, hasta que no se pulse el case 6 que es salir
        //no sale
        do {
            //opciones del programa, he añadido la carga aquí tambien por si después quiere cambiarla
            //eso si, las dependencias no se pueden cambiar
            String opcion = JOptionPane.showInputDialog("Opciones del programa\n"
                    + "1.- Carga\n"
                    + "2.- Aspiración\n"
                    + "3.- Aspiración y Fregado\n"
                    + "4.- ESTADO GENERAL\n"
                    + "5.- BASE DE CARGA\n"
                    + "6.- Salir");
            int j = 0;
            int k = 0;
            int Acumulador = 0;
            int Acumulador2 = 0;
            opcionElegida = Integer.parseInt(opcion);
            //Switch en el que va cada opcion del menu
            switch (opcionElegida) {

                case 1:
                    //Es exactamente igual que el de antes
                    //Si la carga es erronea da un aviso y sale al menu principal
                    String nivelBateriaIntroducido = JOptionPane.showInputDialog(" Introduza la carga actual del robot");
                    nivelBateria = Double.parseDouble(nivelBateriaIntroducido);
                    if (nivelBateria >= 0 && nivelBateria <= 100) {

                        JOptionPane.showMessageDialog(null, " La carga actual es " + nivelBateria);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, " La carga introducida no puede ser menor que 0 o mayor que 100", "Error al introducir datos",
                                JOptionPane.ERROR_MESSAGE);

                        break;
                    }
                case 2:

                    String eleccion = JOptionPane.showInputDialog("Opciones del programa\n"
                            + "1.- Modo Completo\n"
                            + "2.- Modo dependencias\n");
                    opcionAspirar = Integer.parseInt(eleccion);
                    switch (opcionAspirar) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Ha seleccionado el modo completo");
                            //bucle for que recorre todas las dependencias creadas
                            for (int i = 0; i < dependenciasCasa.length; i++) {

                                //calculo que realiza el programa a la hora de limpiar las habitaciones
                                //Si tenemos un hab de 10m y nose consume 1.5 el metro
                                //el gastoBateriaActual = 15%
                                //si la bateria esta al 100%, le restamos los 15% que ha gastado al limpiar una habitacion
                                //si el resultado es mayor que, en este caso lo es, la marca como limpiada.
                                double gastoBateriaActual = (dependenciasCasa[i] * MODOASPIRACION);
                                nivelBateria = (nivelBateria - gastoBateriaActual);
                                //condicion si la bateria es menor o igual que 3
                                if (nivelBateria <= bateriInferior) {
                                    //mensaje informativo que no se puede limpiar
                                    JOptionPane.showMessageDialog(null, "La bateria es insuficiente para seguir limpiando."
                                            + " Las habitaciones limpiadas son: ");
                                    //do while para que nos avise de las dependencias que ha podido limpiar
                                    do {
                                        //como esta planteada la aspiradora es imposible que limpie una hab de mas de 64 metros
                                        //entonces tengo puesto el if para que se salga y no muestre las habitaciones limpias
                                        //tambien si k es menor que 1 significa que no ha podido limpiar ninguna habitación por lo tanto se sale tambien
                                        if (dependenciasCasa[i] > 64 || k < 1) {
                                            JOptionPane.showMessageDialog(null, "No se ha podido limpiar.", "Batería insuficiente", JOptionPane.ERROR_MESSAGE);
                                            break;
                                        }
                                        //pinta por pantalla las habitaciones que ha limpiado
                                        JOptionPane.showMessageDialog(null, dependenciasVilla[j]);
                                        //guarda en posicion el ultimo sitio donde ha estado el aspirador
                                        posicion = dependenciasVilla[k];
                                        //aumentan su valor cada vez que se repite el bucle
                                        //para que nos muestren las habitaciones limpiadas
                                        j++;
                                        Acumulador++;

                                        nivelBateria = 3.0;
                                        //se mantiene el bucle hasta que la posición del array corresponde al numero de vueltas que 
                                        //ha hecho el bucle
                                    } while (i != Acumulador);
//                                
                                    break;
                                } else {
//                                  //Si la condicion no se cumple, es decir se puede limpiar entra en el else
                                    do {
                                        JOptionPane.showMessageDialog(null, "Se ha limpiado el "
                                                + dependenciasVilla[k] + " los metros limpiados son: "
                                                + dependenciasCasa[i] + "\n Nivel de bateria actual es " + nivelBateria);

                                        k++;
                                        Acumulador2++;

                                        //Condicion para cuando limpie todas las habitaciones vuelva a la base de carga
                                        if (k >= dependenciasCasa.length) {
                                            posicion = " Base de carga";
                                        } else {
                                            posicion = dependenciasVilla[k];
                                        }
                                    } while (k != Acumulador2);

                                }

                            }

                            break;
                        case 2:

                            JOptionPane.showMessageDialog(null, "Ha seleccionado el modo dependencias\n"
                                    + "Elige la habitación a limpiar");
                            //array que empieza desde 0 a 4 en este caso
                            //ya que son las dependencias de la casa
                            String[] botones = {"salon", "dormitorio", "dormitorio2", "cocina", "Baño "};
                            int ventana = JOptionPane.showOptionDialog(null,
                                    "Pulsa un boton:",
                                    " ",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null,
                                    botones, botones[0]);
                            switch (ventana) {
                                case 0: {
                                    //operacion del caluclo, intentar meter en un metodo
                                    double gastoBateriaActual = (dependenciasCasa[0] * MODOASPIRACION);
                                    nivelBateria = (nivelBateria - gastoBateriaActual);
                                    //si el nivel de bateria es inferior a 3, nos avisa de que no se puede limpiar
                                    if (nivelBateria < bateriInferior) {
                                        JOptionPane.showMessageDialog(null, "Modo dependencias\n"
                                                + "Batería insuficiente para aspirar", "Aspiración",
                                                JOptionPane.INFORMATION_MESSAGE);

                                        nivelBateria = 3.0;
                                        //si es mayor que 3 nos avisa de que se ha limpiado y se almacena la posicion
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Se ha limpiado con exito");
                                        posicion = dependenciasVilla[0];
                                    }
                                    break;
                                    //se repite lo mismo en las otras dependencias
                                }
                                case 1: {
                                    double gastoBateriaActual = (dependenciasCasa[1] * MODOASPIRACION);
                                    nivelBateria = (nivelBateria - gastoBateriaActual);

                                    if (nivelBateria < bateriInferior) {
                                        JOptionPane.showMessageDialog(null, "Modo dependencias\n"
                                                + "Batería insuficiente para aspirar", "Aspiración",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        nivelBateria = 3.0;

                                    } else {
                                        posicion = dependenciasVilla[1];
                                        JOptionPane.showMessageDialog(null, "Se ha limpiado con exito");
                                    }
                                    break;
                                }
                                case 2: {
                                    double gastoBateriaActual = (dependenciasCasa[2] * MODOASPIRACION);
                                    nivelBateria = (nivelBateria - gastoBateriaActual);

                                    if (nivelBateria < bateriInferior) {
                                        JOptionPane.showMessageDialog(null, "Modo dependencias\n"
                                                + "Batería insuficiente para aspirar", "Aspiración",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        nivelBateria = 3.0;
                                    } else {
                                        posicion = dependenciasVilla[2];
                                        JOptionPane.showMessageDialog(null, "Se ha limpiado con exito");
                                    }
                                    break;
                                }
                                case 3: {
                                    double gastoBateriaActual = (dependenciasCasa[3] * MODOASPIRACION);
                                    nivelBateria = (nivelBateria - gastoBateriaActual);

                                    if (nivelBateria < bateriInferior) {
                                        JOptionPane.showMessageDialog(null, "Modo dependencias\n"
                                                + "Batería insuficiente para aspirar", "Aspiración",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        nivelBateria = 3.0;
                                    } else {
                                        posicion = dependenciasVilla[3];
                                        JOptionPane.showMessageDialog(null, "Se ha limpiado con exito");
                                    }
                                    break;
                                }
                                case 4: {
                                    double gastoBateriaActual = (dependenciasCasa[4] * MODOASPIRACION);
                                    nivelBateria = (nivelBateria - gastoBateriaActual);

                                    if (nivelBateria < bateriInferior) {
                                        JOptionPane.showMessageDialog(null, "Modo dependencias\n"
                                                + "Batería insuficiente para aspirar", "Aspiración",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        nivelBateria = 3.0;
                                    } else {
                                        posicion = dependenciasVilla[4];
                                        JOptionPane.showMessageDialog(null, "Se ha limpiado con exito");
                                    }

                                    break;
                                }
                                default:
                                    break;
                            }
                            break;
                    }
                    break;
                case 3:
//Este case es exactamente igual que el anterior exceptuando el gasto de energía
//                    
                    String eleccion2 = JOptionPane.showInputDialog("Opciones del programa\n"
                            + "1.- Modo Completo\n"
                            + "2.- Modo dependencias\n"
                    );
                    opcionAspirar = Integer.parseInt(eleccion2);
                    switch (opcionAspirar) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Ha seleccionado el modo completo");

                            for (int i = 0; i < dependenciasCasa.length; i++) {

                                double gastoBateriaActual = (dependenciasCasa[i] * MODOFREGADO);
                                nivelBateria = (nivelBateria - gastoBateriaActual);
                                if (nivelBateria <= bateriInferior) {

                                    JOptionPane.showMessageDialog(null, "La bateria es insuficiente para seguir limpiando."
                                            + " Las habitaciones limpiadas son: ");

                                    do {
                                        if (dependenciasCasa[i] > 64 || k < 1) {
                                            JOptionPane.showMessageDialog(null, "No se ha podido limpiar.", "Batería insuficiente", JOptionPane.ERROR_MESSAGE);
                                            break;
                                        }
                                        JOptionPane.showMessageDialog(null, dependenciasVilla[j]);

                                        posicion = dependenciasVilla[k];
                                        j++;
                                        Acumulador++;

                                        nivelBateria = 3.0;
                                    } while (i != Acumulador);

                                    break;
                                } else {

                                    do {
                                        JOptionPane.showMessageDialog(null, "Se ha limpiado el " + dependenciasVilla[k] + " los metros limpiados son: " + dependenciasCasa[i] + "\n Nivel de bateria actual es " + nivelBateria);
                                        k++;
                                        Acumulador2++;
                                        //Condicion para cuando limpie todas las habitaciones vuelva a la base de carga
                                        if (k >= dependenciasCasa.length) {
                                            posicion = " Base de carga";
                                        } else {
                                            posicion = dependenciasVilla[k];
                                        }
                                    } while (k != Acumulador2);
                                }
                            }

                            break;

                        case 2:

                            JOptionPane.showMessageDialog(null, "Ha seleccionado el modo dependencias\n"
                                    + "Elige la habitación a limpiar");
                            String[] botones = {"salon", "dormitorio", "dormitorio2", "cocina", "Baño "};
                            int ventana = JOptionPane.showOptionDialog(null,
                                    "Pulsa un boton:",
                                    " ",
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null,
                                    botones, botones[0]);
                            switch (ventana) {
                                case 0: {
                                    double gastoBateriaActual = (dependenciasCasa[0] * MODOFREGADO);
                                    nivelBateria = (nivelBateria - gastoBateriaActual);

                                    if (nivelBateria < bateriInferior) {
                                        JOptionPane.showMessageDialog(null, "Modo dependencias\n"
                                                + "Batería insuficiente para aspirar", "Aspiración",
                                                JOptionPane.INFORMATION_MESSAGE);

                                        nivelBateria = 3.0;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Se ha limpiado con exito");
                                        posicion = dependenciasVilla[0];
                                    }
                                    break;
                                }
                                case 1: {
                                    double gastoBateriaActual = (dependenciasCasa[1] * MODOFREGADO);
                                    nivelBateria = (nivelBateria - gastoBateriaActual);

                                    if (nivelBateria < bateriInferior) {
                                        JOptionPane.showMessageDialog(null, "Modo dependencias\n"
                                                + "Batería insuficiente para aspirar", "Aspiración",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        nivelBateria = 3.0;

                                    } else {
                                        posicion = dependenciasVilla[1];
                                        JOptionPane.showMessageDialog(null, "Se ha limpiado con exito");
                                    }
                                    break;
                                }
                                case 2: {
                                    double gastoBateriaActual = (dependenciasCasa[2] * MODOFREGADO);
                                    nivelBateria = (nivelBateria - gastoBateriaActual);

                                    if (nivelBateria < bateriInferior) {
                                        JOptionPane.showMessageDialog(null, "Modo dependencias\n"
                                                + "Batería insuficiente para aspirar", "Aspiración",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        nivelBateria = 3.0;
                                    } else {
                                        posicion = dependenciasVilla[2];
                                        JOptionPane.showMessageDialog(null, "Se ha limpiado con exito");
                                    }
                                    break;
                                }
                                case 3: {
                                    double gastoBateriaActual = (dependenciasCasa[3] * MODOFREGADO);
                                    nivelBateria = (nivelBateria - gastoBateriaActual);

                                    if (nivelBateria < bateriInferior) {
                                        JOptionPane.showMessageDialog(null, "Modo dependencias\n"
                                                + "Batería insuficiente para aspirar", "Aspiración",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        nivelBateria = 3.0;
                                    } else {
                                        posicion = dependenciasVilla[3];
                                        JOptionPane.showMessageDialog(null, "Se ha limpiado con exito");
                                    }
                                    break;
                                }
                                case 4: {
                                    double gastoBateriaActual = (dependenciasCasa[4] * MODOFREGADO);
                                    nivelBateria = (nivelBateria - gastoBateriaActual);

                                    if (nivelBateria < bateriInferior) {
                                        JOptionPane.showMessageDialog(null, "Modo dependencias\n"
                                                + "Batería insuficiente para aspirar", "Aspiración",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        nivelBateria = 3.0;
                                    } else {
                                        posicion = dependenciasVilla[4];
                                        JOptionPane.showMessageDialog(null, "Se ha limpiado con exito");
                                    }

                                    break;
                                }
                                default:
                                    break;
                            }
                            break;

                    }

                    break;
                case 4:
                    //Pregunatr como era el calendario que dijo el profesor
                    System.out.println("Usted acaba de seleccionar -ESTADO GENERAL.");
                    hora = calendario.get(Calendar.HOUR_OF_DAY);
                    minutos = calendario.get(Calendar.MINUTE);
                    segundos = calendario.get(Calendar.SECOND);
                    for (int i = 0; i < dependenciasCasa.length; i++) {
                        metrosCuadrados += dependenciasCasa[i];
                    }
                    System.out.println(hora + ":" + minutos + ":" + segundos);
                    JOptionPane.showMessageDialog(null, "El nivel de carga actual es: " + nivelBateria
                    + "\n La hora actual es: " + hora + ":" + minutos + ":" + segundos
                    + "\n En el " + dependenciasVilla[0] + " hay " + dependenciasCasa[0] + " metros"
                    + "\n En el " + dependenciasVilla[1] + " hay " + dependenciasCasa[1] + " metros"
                    + "\n En el " + dependenciasVilla[2] + " hay " + dependenciasCasa[2] + " metros"
                    + "\n En el " + dependenciasVilla[3] + " hay " + dependenciasCasa[3] + " metros"
                    + "\n En el " + dependenciasVilla[4] + " hay " + dependenciasCasa[4] + " metros"
                    + "\n El aspirador se encuentra en: " + posicion
                    + "\n Los metros cuadrados totales: " + metrosCuadrados
                    );

                    break;
                case 5:

                case 6:

            }

        } while (repetir);

    }

}
