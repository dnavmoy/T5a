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
        final String menu="""
                          Cuantas palabras vas a introducir?
                          """;
        
        int numeroPalabras=cuantasPalabras(menu);
           String[] palabras=new String[numeroPalabras];
        palabras=leerPalabras(numeroPalabras);
        mostrarPalabras(palabras);
        tresVocales(palabras);
    }
    
    
    public static int cuantasPalabras(String menu){
        int numero=0;
        boolean repetir=true;
        do{
            try{
        numero=Integer.parseInt(JOptionPane.showInputDialog(menu));
            repetir=false;
            }catch(NumberFormatException NFE){
                JOptionPane.showMessageDialog(null, "Introduce un valor numerico");
            }
        }while(repetir);
        return numero;
        
    }
    
    public static String[] leerPalabras(int numero){
        
        String[] palabras=new String[numero];
        for(int i=0;i<numero;i++){
        palabras[i]=JOptionPane.showInputDialog("introduce palabra numero: " + (i+1));
        }
        return palabras;
    }
    public static void mostrarPalabras(String[] palabras){
        StringBuilder resultado = new StringBuilder();
        for(int i=0;i<palabras.length;i++){
            resultado.append("posicion " + i + " palabra: " + palabras[i] + "\n" );
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
    
    public static String[] tresVocales(String[]palabras){
        String[] tresVocales = new String[palabras.length];
        boolean tienelaA=palabras[1].contains("a");
        System.out.println("tiene la a?" + tienelaA);
        
        return tresVocales;
    }
    
}
