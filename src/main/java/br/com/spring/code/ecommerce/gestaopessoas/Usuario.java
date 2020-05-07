package br.com.spring.code.ecommerce.gestaopessoas;

public class Usuario {

	private Integer id;
	private String login;
	private String senha;

	public Usuario() {

	}

	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
 	public String toString() {
 		return "[Id: " + getId() + ", Login: " + getLogin() + ", Senha :" + getSenha() + "]";
 	}
}
