package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.thoughtworks.xstream.XStream;

@Entity
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private int anoDeInicio;

	public Projeto(final long id, final String nome, final int anoDeInicio) {
		this.id = id;
		this.nome = nome;
		this.anoDeInicio = anoDeInicio;
	}

	public Projeto(final long id) {
		this.id = id;
	}

	public Projeto() {
	}

	public long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public int getAnoDeInicio() {
		return this.anoDeInicio;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public void setAnoDeInicio(final int anoDeInicio) {
		this.anoDeInicio = anoDeInicio;
	}

	public String toXML() {
		return new XStream().toXML(this);
	}

}
