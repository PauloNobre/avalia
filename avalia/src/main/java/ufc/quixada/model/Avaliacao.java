package ufc.quixada.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class Avaliacao implements Serializable{

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Campo Obrigatório")
	private double atendimento;
	
	@NotNull(message = "Campo Obrigatório")
	private double qualidadeComida;
	
	@NotNull(message = "Campo Obrigatório")
	private double preco;
	
	@NotNull(message = "Campo Obrigatório")
	private double ambiente;
	
	@NotNull(message = "Campo Obrigatório")
	private double custoBeneficio;
	
	private double media;
	
	@ManyToOne
	private Estabelecimento estabelecimento;

	public Avaliacao() {
		super();
	}
	
	public Avaliacao(double atendimento, double qualidadeComida, double preco, double ambiente, double custoBeneficio,
			double media, Estabelecimento estabelecimento){
		this.atendimento = atendimento;
		this.qualidadeComida = qualidadeComida;
		this.preco = preco;
		this.ambiente = ambiente;
		this.custoBeneficio = custoBeneficio;
		this.media = media;
		this.estabelecimento = estabelecimento;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(double atendimento) {
		this.atendimento = atendimento;
	}

	public double getQualidadeComida() {
		return qualidadeComida;
	}

	public void setQualidadeComida(double qualidadeComida) {
		this.qualidadeComida = qualidadeComida;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(double ambiente) {
		this.ambiente = ambiente;
	}

	public double getCustoBeneficio() {
		return custoBeneficio;
	}

	public void setCustoBeneficio(double custoBeneficio) {
		this.custoBeneficio = custoBeneficio;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia() {
		this.media = (ambiente + atendimento + custoBeneficio + preco + qualidadeComida)/5;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
}
