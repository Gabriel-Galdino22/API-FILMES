package service;

import java.util.List;

import br.com.fiap.filmesAPI.data.FilmeDAO;
import br.com.fiap.filmesAPI.model.Filme;

public class FilmeService{
	
	private FilmeDAO dao = new FilmeDAO();
	
	public List<Filme> findAll() {
		return dao.findAll();
	}
	
	public Filme findById(Long id) {
		return dao.findById(id);
	}

	public void delete(Filme filme) {
		//Deletar no BD
	}

	public boolean save(Filme filme) {
		
				if (filme.id() == 0) return false;
				if (filme.duracao().length() < 5) return false;
				if (filme.nomeDoFilme().length() < 9) return false;
				if (filme.atorPrincipal().length() < 8) return false;
				if (filme.produtora().length() < 10) return false;
				
				//inserir no BD
				return true;
	}

	
	public boolean update(Filme filme) {
		// atualizar no BD
		return true;
	}
}