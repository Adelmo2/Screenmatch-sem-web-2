package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmachApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmachApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		//Alura
		//var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c"); /

		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=friends&apikey=7d48dedc");
		System.out.println(json);

		System.out.println("------ SERIE 1 ------");
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

		System.out.println("------ EPISODIO 1 ------");
		json = consumoApi.obterDados("http://www.omdbapi.com/?t=friends&season=1&episode=1&apikey=7d48dedc");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);

		System.out.println("------ EPISODIO 2 ------");
		json = consumoApi.obterDados("http://www.omdbapi.com/?t=friends&season=1&episode=2&apikey=7d48dedc");
		DadosEpisodio dadosEpisodio2 = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio2);

		//TESTE INI
		json = consumoApi.obterDados("http://www.omdbapi.com/?t=friends&season=5&apikey=7d48dedc");
		DadosTemporada dadosTemporada2 = conversor.obterDados(json, DadosTemporada.class);
		System.out.println("Antes do FOR: " +  dadosTemporada2);

		System.out.println("*****TODOS EPISODIOS (<list>****");

		List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i<= dados.totalTemporadas(); i++) {
			json = consumoApi.obterDados("http://www.omdbapi.com/?t=friends&season=" + i + "&apikey=7d48dedc");
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
			//System.out.println("Temoradas dentro do for..." + dadosTemporada);
		}

		temporadas.forEach(System.out::println);

	}
}
