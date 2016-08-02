package ufc.quixada.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Estabelecimento implements Serializable{

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo obrigatório")
	@Pattern(regexp = "[a-zA-Z\\sà-ùÀ-Ù]{0,}", message = "O campo Nome não pode possuir caracteres especiais ou números.")
	private String nome;

	@JsonBackReference
	private Coordenada coordenadas;
	
	public Estabelecimento() {
		super();
	}

	public Estabelecimento(String nome, Coordenada coordenadas, List<Avaliacao> avaliacoes) {
		super();
		this.nome = nome;
		this.coordenadas = coordenadas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Coordenada getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenada coordenadas) {
		this.coordenadas = coordenadas;
	}
}
