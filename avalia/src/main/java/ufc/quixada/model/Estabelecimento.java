package ufc.quixada.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Estabelecimento implements Serializable {

	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Campo obrigatório")
	@Pattern(regexp = "[a-zA-Z\\sà-ùÀ-Ù]{0,}", message = "O campo Nome não pode possuir caracteres especiais ou números.")
	private String nome;

	private Coordenada coordenada;

	@OneToMany
	private List<Avaliacao> avaliacoes;

	public Estabelecimento() {
		super();
	}

	public Estabelecimento(String nome, Coordenada coordenadas, List<Avaliacao> avaliacoes) {
		super();
		this.nome = nome;
		this.coordenada = coordenadas;
		this.avaliacoes = avaliacoes;
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

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	public void addAvaliacao(Avaliacao avaliacao) {
		this.avaliacoes.add(avaliacao);
	}
	
	public double getMediaGeral() {
		double media =0;
		
		for(Avaliacao av : avaliacoes) {
			media += av.getMedia();
		}
		
		return media/avaliacoes.size();
	}
}
