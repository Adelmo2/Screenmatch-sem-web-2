package desafio.desafio14;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.io.File;

public class DesSerializarJson implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(DesSerializarJson.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Tarefa tarefaLida = objectMapper.readValue(new File("tarefa.json"), Tarefa.class);
        System.out.println("Tarefa lida do JSON:");
        System.out.println(tarefaLida);
    }

}
