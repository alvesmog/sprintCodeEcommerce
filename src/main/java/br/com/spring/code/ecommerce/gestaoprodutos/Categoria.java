package br.com.spring.code.ecommerce.gestaoprodutos;

public class Categoria {
	
	// Atributos
	
	private Integer id; 
	private String nome;
	
	// Construtor
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	// Setters e Getters
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [" + nome + "]";
	}
	
	
}
