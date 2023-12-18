/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package enclase.t5adanielnavarro;

import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class Ej1 {

    public static void main(String[] args) {
        //menu a para preguntar
        final String menu = """
                          Cuantas palabras vas a introducir?
                          """;
        //llamo a metodo para pedir 
        int numeroPalabras = cuantasPalabras(menu);
        String[] palabras = new String[numeroPalabras];
        palabras = leerPalabras(numeroPalabras);
        mostrarPalabras(palabras);
        tresVocales(palabras);

        mostrarPalabras(tresVocales(palabras));
        mostrarPalabras(dosVocales(palabras));

        int[] posicionPalabras = new int[numeroPalabras];

        String letraAPedir=JOptionPane.showInputDialog("introduce una letra");
        char letrapedir=letraAPedir.charAt(0);
        posicionPalabras = posicionLetra(palabras,letrapedir);
        for (int i = 0; i < posicionPalabras.length; i++) {
            JOptionPane.showMessageDialog(null, palabras[i] + " letra " + letrapedir + " en la posicion " + posicionPalabras[i]);
            

        }
    }

    public static int cuantasPalabras(String menu) {
        int numero = 0;
        boolean repetir = true;
        do {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog(menu));
                repetir = false;
            } catch (NumberFormatException NFE) {
                JOptionPane.showMessageDialog(null, "Introduce un valor numerico");
            }
        } while (repetir);
        return numero;

    }

    public static String[] leerPalabras(int numero) {
        //con el numero que trae un for para pedir las palabras e introducirlas 
        //en el array que devuelve
        String[] palabras = new String[numero];
        for (int i = 0; i < numero; i++) {
            palabras[i] = JOptionPane.showInputDialog("introduce palabra numero: "
                    + (i + 1));
        }
        return palabras;
    }

    public static void mostrarPalabras(String[] palabras) {
        //creo un string para mostrar las palabras del array, un for que va añadiendo
        //al string cada palabra del array.
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < palabras.length; i++) {
            resultado.append("posicion " + i + " palabra: " + palabras[i] + "\n");

        }
        JOptionPane.showMessageDialog(null, resultado);
    }

    public static String[] tresVocales(String[] palabras) {

        //
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        int contador = 0;
        int total3Vocales = 0;
        int contadorPalabra = 0;
        //for que que recorre todo el array
        for (int x = 0; x < palabras.length; x++) {
            char[] letras = palabras[x].toCharArray();
            //reinicia el contador para cada palabra
            contador = 0;
            //para cada posicion del array (cada palabra) comprueba cada posicion
            //del array de vocales
            for (int i = 0; i < letras.length; i++) {
                //comprueba que cada posicion sea igual al char de vocales
                //y si es igual suma uno al valor del contador
                for (int z = 0; z < vocales.length; z++) {
                    if (letras[i] == vocales[z]) {
                        contador++;
                    }
                }

            }
            //comprueba si tiene mas de tres vocales
            if (contador >= 3) {
                total3Vocales++;
            }
        }
        //cuando se cuantas palabras tienen mas de tres vocales, creo un array de
        //palabras y repito para añadirlas
        
        String[] tresVocales = new String[total3Vocales];

        for (int x = 0; x < palabras.length; x++) {
            char[] letras = palabras[x].toCharArray();
            contador = 0;

            for (int i = 0; i < letras.length; i++) {
                for (int z = 0; z < vocales.length; z++) {
                    if (letras[i] == vocales[z]) {
                        contador++;
                    }
                }

            }
            //las palabras que tienen mas de tres vocales se añaden al nuevo array
            if (contador >= 3) {
                tresVocales[contadorPalabra++] = palabras[x];
            }
        }

        return tresVocales;
    }

    public static String[] dosVocales(String[] palabras) {

        //metodo igual al anterior pero compruebo si el contador es menor a tres
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        int contador = 0;
        int total2Vocales = 0;
        int contadorPalabra = 0;

        for (int x = 0; x < palabras.length; x++) {
            char[] letras = palabras[x].toCharArray();
            contador = 0;

            for (int i = 0; i < letras.length; i++) {
                for (int z = 0; z < vocales.length; z++) {
                    if (letras[i] == vocales[z]) {
                        contador++;
                    }
                }

            }
            if (contador < 3) {
                total2Vocales++;
            }
        }
        String[] dosVocales = new String[total2Vocales];

        for (int x = 0; x < palabras.length; x++) {
            char[] letras = palabras[x].toCharArray();
            contador = 0;

            for (int i = 0; i < letras.length; i++) {
                for (int z = 0; z < vocales.length; z++) {
                    if (letras[i] == vocales[z]) {
                        contador++;
                    }
                }

            }
            if (contador < 3) {
                dosVocales[contadorPalabra++] = palabras[x];
            }
        }

        return dosVocales;
    }

    public static int[] posicionLetra(String[] palabras,char letra) {
        
        //creo un array de enteros con el numero de palabras
        
        int[] posicionLetra = new int[palabras.length];
        boolean seguir = true;
        
        for (int x = 0; x < palabras.length; x++) {
            //para cada palabra creo un array de letras para comprobarlas
            char[] letras = palabras[x].toCharArray();
            int i = 0;
            seguir=true;
            do {
                //si hemos llegado a la ultima letra sin encontrarla la posicion 
                //es -1
                
                if (i == letras.length) {
                    posicionLetra[x] = -1;
                    //si no lo encuentra sale del bucle
                    seguir = false;
                } else if (letras[i] == letra) {
                    //si encuentra la letra añade la posicion en el array
                    posicionLetra[x] = i;
                    //si lo encuentra sale del bucle
                    seguir = false;
                }
                i++;//pasa a la siguente letra

            } while (seguir);

        }

        return posicionLetra;
    }
    
  

}
