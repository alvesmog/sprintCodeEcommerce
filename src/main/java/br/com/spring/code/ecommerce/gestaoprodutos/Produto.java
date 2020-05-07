package br.com.spring.code.ecommerce.gestaoprodutos;

import br.com.spring.code.ecommerce.gestaopessoas.Pessoa;

public class Produto {
	
	// Atributos
	
	private Integer id;
	private String titulo;
	private String descricao;
	//TODO: Encontrar o tipo que se encaixa em uma foto.
	private String foto;	
	private Categoria categoria;
	private Integer quantidade;
	private Estado estado;
	private FaixaEtaria faixaEtaria;
	private Integer idPessoa;
	
	// Construtor
	
	public Produto(Integer id, String titulo, String descricao, String foto, Pessoa pessoa, Categoria categoria) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.foto = foto;
		this.idPessoa = pessoa.getId();
		this.categoria = categoria;
	}
	
	// Construtor vazio
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	
	// Getters e Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public FaixaEtaria getTamanho() {
		return faixaEtaria;
	}

	public void setTamanho(FaixaEtaria faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}
	
	public FaixaEtaria getFaixaEtaria() {
		return faixaEtaria;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	// Hashcode & `equals`
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [Id=" + id 
				+ ", Titulo=" + titulo 
				+ ", Descricao=" + descricao
				+ ", Quantidade=" + quantidade
				+ ", Categoria=" + categoria.getNome()
				+ ", Estado=" + estado 
				+ ", FaixaEtaria=" + faixaEtaria + "]\n";
	}
	
}
