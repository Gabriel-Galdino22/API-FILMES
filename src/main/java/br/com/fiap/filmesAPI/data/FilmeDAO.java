package br.com.fiap.filmesAPI.data;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.filmesAPI.model.Filme;

public class FilmeDAO {

	List<Filme> filmes = new ArrayList<>();

	public FilmeDAO() {
		filmes = List.of(
				
				//	String duracao, String nomeDoFilme, String atorPrincipal, String produtora 
				
				new Filme(1, "2h 10m", "Homem-Aranha: Longe de Casa", "Tom Holland", "Marvel Studios"),
				new Filme(2, "2h 15m", "Sound of Freedom", "Jim Caviezel", "Santa Fe Films e Metanoia Films"),
				new Filme(3, "01h50m", "Destinos a Deriva", "Anna Castillo", "Netflix"),
				new Filme(4, "2h16m", "Coach Carter Treino para a Vida", "Samuel L. Jackson", "MTV Films")
				

		);
	}

	public List<Filme> findAll() {
		return filmes;
	}

	public Filme findById(Long id) {
		return filmes
				.stream()
				.filter(filme -> filme.id() == id)
				.findFirst()
				.orElse(null);
		
	}

}