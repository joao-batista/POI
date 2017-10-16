package br.com.mobel;

import java.util.Date;

public class Livro {
	
	private String titulo;
    private String autor;
    private float preco;
    private Date lancamento;
    
    public Livro() {
    	
    }
    
	public Livro(String titulo, String autor, float preco, Date lancamento) {
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
		this.lancamento = lancamento;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public Date getLancamento() {
		return lancamento;
	}
	public void setLancamento(Date lancamento) {
		this.lancamento = lancamento;
	}
    
}
