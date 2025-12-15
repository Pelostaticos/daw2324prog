
package tarea04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * Tarea Online 4. Ejercicio 1: Nivel de Seguridad de Contraseñas
 * @author Sergio García Butrón
 * @version 1.0
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // DEFINICIÓN DE CONSTANTES
        final String[] PATRONES = { "[0-9]+"/*Patrón si contiene números */,
                                    "[a-z]+" /*Patrón si contiene letras minúsculas */,
                                    "[A-Z]+" /*Patrón si contiene letras mayúsculas */,
                                    "[#?!@$%^&*-.,;:\\(\\)\\[\\]{\\}\\+]+"/*Patrón si contiene caracteres especiales */,
                                    "([^aeiou]|[^AEIOU]){4,}" /* Si contiene al menos cuatro consonantes juntas */,
                                    "(([A-Z][a-z][A-Z])|([a-z][A-Z][a-z])){2,}"/* Que tenga al menos dos alternancias entre mayúsculas y minúsculas*/}; 
        final String CONTRASENYAS_USADAS = "password;123456;123456789;guest;qwerty;12345678;111111;12345;col123456;123123;1234567;1234;1234567890;tequiero;555555;666666;123321;654321;7777777;123;D1lakiss;777777;110110jp;1111;987654321;121212;Gizli;abc123;112233;azerty;159753;1q2w3e4r;54321;pass@123;222222;qwertyuiop;qwerty123;qazwsx;vip;asdasd;123qwe;123654;iloveyou;a1b2c3;999999;Groupd2013;1q2w3e;usr;Liman1000;1111111;333333;123123123;9136668099;11111111;1qaz2wsx;password1;mar20lt;987654321;gfhjkm;159357;abcd1234;131313;789456;luzit2000;aaaaaa;zxcvbnm;asdfghjkl;1234qwer;88888888;dragon;987654;888888;qwe123;football;3601;asdfgh;master;samsung;12345678910;killer;1237895;1234561;12344321;daniel;00000;444444;101010;f--;you;qazwsxedc;789456123;super123;qwer1234;123456789a;823477aA;147258369;unknown;98765;q1w2e3r4;232323";
        final String[] DICCIONARIO_CONTRASENYAS;

        
        // DEFINICIÓN DE VARIABLES
        // Variable para almacenar la password introducida
        String passwordIntroducida;

        // Varaible para el nivel de seguridad
        float nivelSeguridadPassword = 0;

        // Variable para almacenar el objeto Scanner para la entrada de datos
        Scanner teclado = new Scanner(System.in);
        
        // Variable para almacenar el objeto Pattern para el patrón d ebúsqueda
        Pattern patron;
        
        // Vairable para almacenar el objeto Matcher para el acoplamiento del patrón
        Matcher acoplamiento;
                              
        // variable auxiliar como bandera de control de coincidencia de la contraseña con dicionario de contraseñas
        boolean sinCoincidenciaContrasenya = true;
        
        // Variable auxiliar para controlar si la contraseña introducida es comun
        boolean contrasenyaComun;
        
        // Variable auxiliar para contar cada vez que una palabra del diccionario se encuentra en contraseña
        int contadorVecesPalabras=0;
               
        /* ************************************************************************
         * ENTRADA DE DATOS
         * ***********************************************************************/
        
        System.out.println("PROGRAMA NIVEL DE SEGURIDAD DE CONTRASEÑAS");
        System.out.println("==========================================");
        System.out.println("ALUMNO: Sergio García Butrón\n");
        
        /* 1. Comprobamos que la contraseña tenga al menos 8 caracteres, no se debe 
         * seguir si la contraseña no presenta al menos 8 caracteres 
         */
       do {
           System.out.print("Introduzca una contraseña (NIVEL 0: La contraseña debe tener ḿinimo 8 caracteres): ");
           passwordIntroducida = teclado.nextLine();
       } while (passwordIntroducida.length() < 8);
        
        /* ************************************************************************
         * PROCESAMIENTO
         * ***********************************************************************/
        
        /* 2. Realizamos la comprobación de cada uno de los patrones, aumentando el nivel 
        de complejidad de la variable si va superando los patrones
         */
        //Bucle for para recorrer el array con los patrones de nivel de seguridad de contraseña
        for (int indicePatron=0;indicePatron< PATRONES.length;indicePatron++) {
            
                // Creo el objeto Pattern con el patrón de busqueda actual a comprobar
                patron = Pattern.compile(PATRONES[indicePatron]);
                
                // Creo el objeto Matcher con el texto donde acoplar el patrón deseado
                acoplamiento = patron.matcher(passwordIntroducida);
            
                /* 2.1 En el caso de que hayamos completado los cuatro primeros patrones 
                   y su validación haya sido positiva en todos ellos, se suma un punto
                   al nivel de seguridad
                */
                if (indicePatron == 4 && nivelSeguridadPassword == 2) {
                    // Notifico al usuario que se incremente un punto el nivel de seguridad de la contraseña
                    // Al ser positivo las cuatro primeros patrones en su validación.
                    System.out.println("Al completarse los cuatro patrones como positivos, añadimos un punto al nivel de seguridad");
                    //Incremento el nivel de seguridad en un punto al cumplir condicion deseada
                    nivelSeguridadPassword += 1;                    
                    // Muestro el nivel de seguridad actualizado
                    System.out.printf("Nivel Actual: %.2f\n", nivelSeguridadPassword);
                }
                
                /* 2.2 Si es uno de los cuatro primeros patrones suman 0.5
                * si el patron analizado es de los siguientes (a partir del cuarto) 
                * suman un punto
                */
                //Notifico al usuario el patron de seguridad comprobado
                System.out.printf("Comprobando patrón: %d\n", indicePatron + 1);                            
                // Si el patrón evalauado tiene encaja con la contraseña introducida
                if (acoplamiento.find()) {
                    //Incremento el nivel de seguridad conforme al patrón de seguridad comprobado
                    nivelSeguridadPassword = nivelSeguridadPassword + ((indicePatron >= 0 && indicePatron <=3) ? 0.5f : 1f);
                }
                // Muestro el nivel de seguridad actualizado
                System.out.printf("Nivel Actual: %.2f\n", nivelSeguridadPassword);                                    
                
        }                        

        // 3. Comprobación de que la palabra se encuentra en el diccionario.
        
        /* 3.1 A partir de la cadena de contraseñas separadas por ";" que tenemos 
         * en la constante CONTRASENYAS_USADAS, obtenemos un array de palabras que
         * guardamos en DICCIONARIO_CONTRASENYAS
         */
        DICCIONARIO_CONTRASENYAS = CONTRASENYAS_USADAS.split(";");

        /* En este bucle comprobamos si nuestra contraseña es igual que alguna 
           palabra del diccionario, y si nuestra contraseña contiene partes de 
           de contraseñas del diccionario. Una vez encuentra una, no es necesario 
           comprobar si es igual al resto,aunque sí pueden aparecer varias 
           contraseñas del diccionario como partes de la nuestra, por lo que debemos
           incrementar el contador y recorrer el bucle hasta el final
        */
        //Aquí hago la comprobación solicitada hasta encontrar una coincidencia exacta
        for (int indiceContrasenyasUsadas=0;indiceContrasenyasUsadas<DICCIONARIO_CONTRASENYAS.length;indiceContrasenyasUsadas++) {
            /* Compruebo si la contraseña introducida coincide con alguna palabra 
            del diccionario de contraseñas comunes. */
            contrasenyaComun = passwordIntroducida.equals(DICCIONARIO_CONTRASENYAS[indiceContrasenyasUsadas]) && sinCoincidenciaContrasenya;
            // Si la contraseña es común entonces debo ajustar el nivel de seguridad.
            if (contrasenyaComun) {
                //Decremento un punto el nivel de segurdad de la contraseña introducida
                nivelSeguridadPassword -= 1;
                // Cambio la bandera de control del bucle porque se ha encontrado una coincidencia exacta 
                sinCoincidenciaContrasenya = false;
            } else {
                /* Compruebo cuantas palabras del diccionario de contraseña usadas
                están incluidas en la contraseña introducida */
                contadorVecesPalabras += passwordIntroducida.contains(DICCIONARIO_CONTRASENYAS[indiceContrasenyasUsadas]) ? 1 : 0;
                    
            }
        }         
        
        /* ************************************************************************
         * SALIDA DE DATOS
         * ***********************************************************************/
        
        // Se muestra el nivel final de seguridad de nuestra contraseña
        System.out.printf("El nivel de seguridad de la contraseña %s es: %.2f\n",passwordIntroducida, nivelSeguridadPassword);
        
        // Se muestra la cantidad de contraseñas más utilizadas que forman parte de nuestro password
        System.out.printf("Tu contraseña tiene partes de contraseñas más utilizadas %d veces\n", contadorVecesPalabras);
        
    }

}
