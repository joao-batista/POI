package br.com.main;

import java.io.IOException;
import java.util.List;

import br.com.dao.LivroDAO;
import br.com.mobel.Livro;
import br.com.service.LivroService;

public class Main {
	
	private static final String path = "arquivo/saida.xls";
	LivroDAO dao = new LivroDAO();
	LivroService service = new LivroService();
	
	
	public static void main(String[] args) {
		new Main().processar();
	}
	
	public void processar() {
		try {
			List<Livro> livros = dao.getLivros();
			service.writeExcel(livros, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
