/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;

/**
 *
 * @author esther
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean bucle = true;

        do {
            double num1 = funcionesCalculadora.comprobarNumero();
            String operacion = funcionesCalculadora.operacionValida();
            double num2 = funcionesCalculadora.comprobarNumero();

            double resultado = funcionesCalculadora.realizarOperacion(num1, num2, operacion);

            funcionesCalculadora.imprimirSalida(num1, num2, resultado, operacion);

            bucle = funcionesCalculadora.comprobarContinuar();
        } while (bucle);
    }
}
