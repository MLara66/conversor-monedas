package com.alura.conversor.principal;

import com.alura.conversor.util.ConversorUtil;

import java.util.Scanner;

public class ConversorPrincipal {
  public static void main(String[] args) {

    Scanner lectura = new Scanner(System.in);
    ConsultaCambio consulta = new ConsultaCambio();

    while (true) {

      System.out.println("********************************************** ");
      System.out.println(" ");
      System.out.println("Sea bienvenido al conversor de Monedas ");
      System.out.println("1) Dolar =>> Peso argentino");
      System.out.println("2) Peso argentino =>> Dolar");
      System.out.println("3) Dolar =>> Real Brasileño");
      System.out.println("4) Real Brasileño =>> Dolar");
      System.out.println("5) Dolar =>> Peso Colombiano");
      System.out.println("6) Peso Colombiano =>> Dolar");
      System.out.println("7) Salir");
      System.out.println("Elija una opcion valida:");
      System.out.println("********************************************** ");
      try {
        var numeroDeMenu = Integer.valueOf(lectura.nextLine());

        if (numeroDeMenu ==7){
          break;
        }

        switch (numeroDeMenu) {
          case 1:
            ConversorUtil.convertirMoneda("USD", "ARS", consulta);
            break;
          case 2:
            ConversorUtil.convertirMoneda("ARS", "USD", consulta);
            break;
          case 3:
            ConversorUtil.convertirMoneda("USD", "BRL", consulta);
            break;
          case 4:
            ConversorUtil.convertirMoneda("BRL", "USD", consulta);
            break;
          case 5:
            ConversorUtil.convertirMoneda("USD", "COP", consulta);
            break;
          case 6:
            ConversorUtil.convertirMoneda("COP", "USD", consulta);
            break;
          case 7:
            System.out.println("Saliendo...");
            return;
          default:
            System.out.println("Opción no válida.");
            break;
        }


      } catch (NumberFormatException e){
        System.out.println("Número no encontrado "+e.getMessage()+" no es valido");
      }

    }

  }

}
