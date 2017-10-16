package br.com.dao;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import br.com.mobel.Livro;

public class LivroDAO {

	public List<Livro> getLivros() {
	    Livro Livro1 = new Livro("Head First Java", "Kathy Serria", 79, new Date());
	    Livro Livro2 = new Livro("Effective Java", "Joshua Bloch", 36, new Date());
	    Livro Livro3 = new Livro("Clean Code", "Robert Martin", 42, new Date());
	    Livro Livro4 = new Livro("Thinking in Java", "Bruce Eckel", 35, new Date());
	 
	    List<Livro> listLivro = Arrays.asList(Livro1, Livro2, Livro3, Livro4);
	 
	    return listLivro;
	}
	
}
