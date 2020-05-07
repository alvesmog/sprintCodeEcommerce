package br.com.spring.code.ecommerce.sessao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import br.com.spring.code.ecommerce.gestaopessoas.RepositorioPessoas;
import br.com.spring.code.ecommerce.gestaopessoas.Usuario;

public class ControladorSessao {
	// Atributos
	private Queue<Sessao> tokenFila;

	// Construtor
	public ControladorSessao(LinkedList<Sessao> tokenFila) {
		this.tokenFila = tokenFila;
		this.expirarTokens();
	}

	public ControladorSessao() {
		this.tokenFila = new LinkedList<Sessao>();
		this.expirarTokens();
	}

	// Getters e Setters
	public Queue<Sessao> getTokenFila() {
		return tokenFila;
	}

	// Métodos

	/**
	 * Randomiza um novo UUID
	 * @return UUID aleatório;
	 */
	public UUID gerarToken() {
		return UUID.randomUUID();
	}

	/**
	 * Adiciona uma sessão a fila
	 * @param novaSessao
	 * @return {@code true} se adicionar corretamente a fila, {@code false} caso contrário.
	 */
	private boolean autorizar(Sessao novaSessao) {
		if (novaSessao == null) return false;
		return this.tokenFila.add(novaSessao);
	}

	private boolean removerAutorizacao(Sessao sessaoExistente) {
		if (sessaoExistente == null) return false;
		return this.tokenFila.remove(sessaoExistente);
	}

	/**
	 * Realiza o login, caso o login e senha estejam corretos.
	 * @param login
	 * @param senha
	 * @param repositorioPessoas
	 * @return {@code true} se o login for realizado corretamente, {@code false} caso contrário.
	 */
	public boolean login(
			String username, 
			String senha, 
			RepositorioPessoas repositorioPessoas) {

		if (this.isAutenticado(username)) return false;

		try {

			Usuario novoUsuario = 
					repositorioPessoas
					.estaAutenticadoRetornaPessoa(username, senha)
					.getUsuario();

			if (novoUsuario != null) {
				Sessao novaSessao = new Sessao(
						this.gerarToken(),
						novoUsuario
						);

				return this.autorizar(novaSessao);
			}
		} catch (Exception e) {
			System.out.println("\n	 > Ocorreu o erro: " + e.getClass());
		}
		return false;
	}

	/**
	 * Realizar o logoff de um usuario a partir de seu `username`
	 * @param username
	 * @return {@code true} se o logoff for realizado corretamente, {@code false} caso contrário.
	 */
	public boolean logoff(String username) {

		if (!this.isAutenticado(username)) return false;

		for (Sessao sessao : tokenFila) {
			if (sessao
					.getUsuario()
					.getLogin()
					.equals(username)) {

				return this.removerAutorizacao(sessao);
			}
		}
		return false;
	}

	private void expirarTokens() {

		if (this.getTokenFila().isEmpty()) return;

		TimerTask expirarTask = new TimerTask() {

			@Override
			public void run() {
				getTokenFila().poll();
				cancel();
			}
		};

		Timer expiracaoTimer = new Timer("Token Expirator");
		long delay = 1000L * 60L;
		long periodo = 1000L * 60L * 5L;
		expiracaoTimer.scheduleAtFixedRate(expirarTask, delay, periodo);
	}

	/**
	 * Usado para verificar se o usuario esta com a sessao ativa.
	 * @param username
	 * @return {@code true} se o usuario está logado, {@code false} caso contrário.
	 */
	public boolean isAutenticado(String username) {

		if (username == null 
				|| username.equals("") 
				|| this.getTokenFila().isEmpty()) 
			return false;

		for (Sessao sessao : tokenFila) {
			if (sessao
					.getUsuario()
					.getLogin()
					.equals(username))
				return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return String.format("ControladorSessao [ Fila = %s ]", getTokenFila());
	}
}
