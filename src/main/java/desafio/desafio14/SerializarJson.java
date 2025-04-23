package desafio.desafio14;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.io.File;

public class SerializarJson implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SerializarJson.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Tarefa tarefa = new Tarefa("assistir aula 1", false, "João");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("tarefa.json"), tarefa);
        System.out.println("Dados salvos no arquivo tarefa.json!");
    }

}
