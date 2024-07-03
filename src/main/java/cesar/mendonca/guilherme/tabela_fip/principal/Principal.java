package cesar.mendonca.guilherme.tabela_fip.principal;

import cesar.mendonca.guilherme.tabela_fip.model.DadosMarca;
import cesar.mendonca.guilherme.tabela_fip.model.DadosModelo;
import cesar.mendonca.guilherme.tabela_fip.model.Marca;
import cesar.mendonca.guilherme.tabela_fip.model.Modelo;
import cesar.mendonca.guilherme.tabela_fip.service.RequisicaoHttp;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

public class Principal {

    RequisicaoHttp requisicao = new RequisicaoHttp();
    Scanner scanner = new Scanner(System.in);
    ObjectMapper objectMapper = new ObjectMapper();

    public void exibeMenu() throws IOException, InterruptedException {
        System.out.println("**** OPÇÕES ****\nCarro\nMoto\nCaminhão");
        System.out.println("\nDigite uma das opções para consultar valores:");
        String consulta = scanner.nextLine();
        String json = requisicao.requisicaoTransporte(consulta).body();
        List<String> listaMarcas = new ArrayList<>(Arrays.asList(json.replace("[", "")
                .replace("]", "")
                .replace(",{", " ,{")
                .split(" ,")));
        List<Marca> marcas = new ArrayList<>();
        for (String s : listaMarcas) {
            marcas.add(new Marca(objectMapper.readValue(s, DadosMarca.class)));
        }
        marcas.stream()
                .sorted(Comparator.comparing(Marca::getCodigo))
                .forEach(System.out::println);

        System.out.println("Informe o código da marca para consulta: ");
        consulta = scanner.nextLine();
        json = requisicao.requisicaoMarca(consulta).body();
        List<String> listaModelos = new ArrayList<>(Arrays.asList(json.replace("[", "")
                .replace("]", "")
                .replace(",{", " ,{")
                .split(" ,")));
        List<Modelo> modelos = new ArrayList<>();
        for (String s : listaModelos) {
            modelos.add(new Modelo(objectMapper.readValue(s, DadosModelo.class)));
        }
//        modelos.stream()
//                .sorted(Comparator.comparing(Modelo::getCodigo))
//                .forEach(System.out::println);

    }

}
