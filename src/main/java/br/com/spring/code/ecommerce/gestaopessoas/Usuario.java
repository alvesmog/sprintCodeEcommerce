package br.com.spring.code.ecommerce.gestaopessoas;

public class Usuario {

	private Integer id;
	private String email;
	private String senha;

	public Usuario() {

	}

	public Usuario(Integer id, String email, String senha) {
		this.id = id;
		this.email = email;
		this.senha = senha;
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
