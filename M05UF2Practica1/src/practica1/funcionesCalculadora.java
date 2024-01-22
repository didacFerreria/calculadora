/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1;

import java.util.Scanner;

/**
 *
 * @author rodri
 */
public class funcionesCalculadora {
    
    public static void imprimirSalida(
            double numero1,double numero2,double res,String operacion){
        
        System.out.println("RESULTAT");
        System.out.printf("(%.2f) %s (%.2f) = %.2f",
                numero1,operacion,numero2,res);
        
        System.out.println("\n Vols continuar operant? \n");
        System.out.println(" [s/n]");
    }
    
    public static boolean comprobarContinuar(){
        
        boolean bucle= true;
        boolean comprobar= false;
        String opcion;
        Scanner sc = new Scanner(System.in);
        
        
        do {
                bucle = true;
                opcion = sc.nextLine();

                if(opcion.equalsIgnoreCase("s") 
                        || opcion.equalsIgnoreCase("n")){
                    
                    if(opcion.equalsIgnoreCase("s")) comprobar= true; 
                    bucle = false;
                    
                }else{
                    System.err.println("\n Error, posa un valor vàlid. \n");
                }
            } while (bucle);
        
        return comprobar;
    }
    
    public static double realizarOperacion(double numero1, double numero2, String operacion) {
        switch (operacion) {
            case "+":
                return numero1 + numero2;
            case "-":
                return numero1 - numero2;
            case "x":
            case "X":
                return numero1 * numero2;
            case "/":
                // división cero
                numero2 = divisionCero(numero2);
                return numero1 / numero2;
            case "*":
                return Math.pow(numero1, numero2);
            case "%":
                // división cero
                numero2 = divisionCero(numero2);
                return numero1 % numero2;
            default:
                System.err.println("Operació no vàlida.");
                return 0;
        }
    }
    
    public static double comprobarNumero() {
        Scanner sc = new Scanner(System.in);
        double numero;
        do {
            System.out.println("Introdueix un número vàlid: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Error, posa un valor vàlid.: ");
                sc.next();
            }
            numero = sc.nextDouble();
        } while (numero == 0);
        return numero;
    }
    
    public static double divisionCero(double numero) {
        if (numero == 0) {
            do {
                System.err.println(" Al denominador hi ha un zero \n"
                        + "per a evitar errors coloca un altre valor.");
                numero = comprobarNumero();
            } while (numero == 0);
        }
        return numero;
    }
    
    public static String operacionValida() {
        Scanner sc = new Scanner(System.in);
        String operacion;
        boolean esOperacionValida;
        do {
            System.out.println("\n Operació? (Indica el signe)");
            System.out.println("+ = sumar \n "
                    + "- = restar \n"
                    + " x = multiplicar \n "
                    + "/ = dividir \n "
                    + " = elevar primer num al segon num.\n"
                    + " % = residu");
            operacion = sc.nextLine();
            esOperacionValida = operacion.matches("[+\\-xX/*%]");
            if (!esOperacionValida) {
                System.err.println("Operació no vàlida. Torna a intentar.");
            }
        } while (!esOperacionValida);

        return operacion;
    }
}
