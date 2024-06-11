package com.alura.conversor.principal;

import com.alura.conversor.modelos.Conversor;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCambio {

    public Conversor buscaCambio(String tipoConversor){
      URI direccion = URI.create("https://v6.exchangerate-api.com/v6/3ab4f3b63678ee69025ea080/latest/"+tipoConversor);

      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
          .uri(direccion)
          .build();

      try {
        HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());
        return new Gson().fromJson(response.body(), Conversor.class);
      } catch (Exception e) {
        throw new RuntimeException("No encontré esa moneda.");
      }
    }
}
