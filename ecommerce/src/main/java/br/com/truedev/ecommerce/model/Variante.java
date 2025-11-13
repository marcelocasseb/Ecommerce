package br.com.truedev.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_variante_produto")
public class Variante {
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLink_foto() {
		return link_foto;
	}

	public void setLink_foto(String link_foto) {
		this.link_foto = link_foto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_variante")
	private Integer id;
	
	@Column(name="nome", length = 45, nullable=false)
	private String nome;

	@Column(name="descricao", columnDefinition = "TEXT")
	private String descricao;
	
	@Column(name="link_foto", length = 255)
	private String link_foto;
	
	@ManyToOne
	@JoinColumn(name = "tbl_produto_id_produto")
	@JsonIgnoreProperties("variantes")
	private Produto produto;
}
