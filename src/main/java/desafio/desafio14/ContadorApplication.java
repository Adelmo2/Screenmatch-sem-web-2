package desafio.desafio14;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ContadorApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ContadorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bem vindo ao contador!");
        System.out.println("--------------------------");
        System.out.println("Digite um numero para contagem: ");

        Scanner entrada = new Scanner(System.in);
        var numero = entrada.nextInt();

        for (int i= 1; i <= numero; i++) {
            System.out.print(i + " ");
        }
    }
}
