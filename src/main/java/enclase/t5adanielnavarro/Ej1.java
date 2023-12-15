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
        final String menu = """
                          Cuantas palabras vas a introducir?
                          """;

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
            System.out.println(palabras[i] + " letra a en la posicion " + posicionPalabras[i]);

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

        String[] palabras = new String[numero];
        for (int i = 0; i < numero; i++) {
            palabras[i] = JOptionPane.showInputDialog("introduce palabra numero: " + (i + 1));
        }
        return palabras;
    }

    public static void mostrarPalabras(String[] palabras) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < palabras.length; i++) {
            resultado.append("posicion " + i + " palabra: " + palabras[i] + "\n");

        }
        JOptionPane.showMessageDialog(null, resultado);
    }

    public static String[] tresVocales(String[] palabras) {

        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        int contador = 0;
        int total3Vocales = 0;
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
            if (contador >= 3) {
                total3Vocales++;
            }
        }
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
            if (contador >= 3) {
                tresVocales[contadorPalabra++] = palabras[x];
            }
        }

        return tresVocales;
    }

    public static String[] dosVocales(String[] palabras) {

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
        
        int[] posicionLetra = new int[palabras.length];
        boolean seguir = true;
        for (int x = 0; x < palabras.length; x++) {
            char[] letras = palabras[x].toCharArray();
            int i = 0;
            seguir=true;
            do {
                if (i == letras.length) {
                    posicionLetra[x] = -1;
                    seguir = false;
                } else if (letras[i] == letra) {
                    posicionLetra[x] = i;
                    seguir = false;
                }
                i++;

            } while (seguir);

        }

        return posicionLetra;
    }
    
  

}
