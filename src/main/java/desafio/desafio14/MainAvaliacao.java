package desafio.desafio14;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.io.File;

public class MainAvaliacao implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(MainAvaliacao.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Tarefa tarefa = new Tarefa("assistir aula 1", false, "João");
        Avaliacao avaliacao = new Avaliacao(1, 8, "Boa Nota.");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("json/avaliacao.json"), avaliacao);
        System.out.println("Dados salvos no arquivo avaliacao.json!");
        System.out.println("Item: " + avaliacao.getItem() + " NOta: " + avaliacao.getNota() + " Comentario: " + avaliacao.getComentario());

    }
}
