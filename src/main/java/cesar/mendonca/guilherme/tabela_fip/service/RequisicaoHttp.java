package cesar.mendonca.guilherme.tabela_fip.service;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Getter
public class RequisicaoHttp {

    private String transporte;
    @Setter
    private String marca;

    public HttpResponse<String> requisicaoTransporte (String transporte)
            throws IOException, InterruptedException {

        this.setTransporte(transporte);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://parallelum.com.br/fipe/api/v1/"
                        + this.getTransporte() + "s/marcas"))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());

    }

    public HttpResponse<String> requisicaoMarca (String marca) throws IOException, InterruptedException {

        this.setMarca(marca);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://parallelum.com.br/fipe/api/v1/"
                        + this.getTransporte() + "s/marcas/" + this.getMarca() + "/modelos"))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());

    }

    public void setTransporte(String transporte) {
        if (transporte.equalsIgnoreCase("caminhao")) {
            transporte = "caminhoe";
        }
        this.transporte = transporte.toLowerCase();
    }

}
