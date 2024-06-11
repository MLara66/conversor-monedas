package com.alura.conversor.util;

import com.alura.conversor.modelos.Conversor;
import com.alura.conversor.principal.ConsultaCambio;

import java.lang.reflect.Method;
import java.util.Scanner;

public class ConversorUtil {
  public static void convertirMoneda(String unidadActual, String unidadAConvertir, ConsultaCambio consulta) {

    System.out.println("Ingrese el valor que desea convertir: ");
    Scanner lecturaValor = new Scanner(System.in);
    var valorAConvertir = Double.valueOf(lecturaValor.nextLine());

    Conversor conversor = consulta.buscaCambio(unidadActual);

    double tasaDeCambio;
    try {
      String methodName = "get" + unidadAConvertir.substring(0, 1).toLowerCase() + unidadAConvertir.substring(1).toUpperCase();
      Method method = conversor.conversion_rates().getClass().getMethod(methodName);
      tasaDeCambio = (double) method.invoke(conversor.conversion_rates());
    } catch (Exception e) {
      throw new RuntimeException("Error obteniendo la tasa de cambio para " + unidadAConvertir, e);
    }

    double valorConvertido = valorAConvertir * tasaDeCambio;
    double valorRedondeado = Math.round(valorConvertido * 100.0) / 100.0;

    System.out.println("El valor " + valorAConvertir + " [" + unidadActual + "]" + " corresponde al valor final de =>>> "
        + valorRedondeado + " [" + unidadAConvertir+ "]");
  }
}
