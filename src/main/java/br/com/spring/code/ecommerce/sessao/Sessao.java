package br.com.spring.code.ecommerce.sessao;

import java.util.UUID;

import br.com.spring.code.ecommerce.gestaopessoas.Usuario;

public class Sessao {
	
	private UUID idUnico;
	private Usuario usuario;
	
	
	public Sessao(UUID idUnico, Usuario usuario) {
		this.idUnico = idUnico;
		this.usuario = usuario;
	}

	public UUID getIdUnico() {
		return idUnico;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sessao [UUID = ");
		builder.append(getIdUnico());
		builder.append(", ID_Usuario = ");
		builder.append(getUsuario().getId());
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
