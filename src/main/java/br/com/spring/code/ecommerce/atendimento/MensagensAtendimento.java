package br.com.spring.code.ecommerce.atendimento;

/**
 * 
 * @author amandalima
 * 
 * @Definição Esta classe implementa as mensagens trocadas durante um 
 * atendimento entre um usuário e um atendente do sistema
 *
 */

public class MensagensAtendimento {
	private Integer idMensagemAtendimento;
	private EmissorMensagem emissorMensagem;
	private String mensagem;
	
	
	public MensagensAtendimento(Integer idAtendimento,Integer idMensagemAtendimento, EmissorMensagem emissorMensagem, String mensagem) {
		super();
		this.idMensagemAtendimento = idMensagemAtendimento;
		this.emissorMensagem = emissorMensagem;
		this.mensagem = mensagem;
	}
	
	
	public EmissorMensagem getEmissorMensagem() {
		return emissorMensagem;
	}
	public void setEmissorMensagem(EmissorMensagem emissorMensagem) {
		this.emissorMensagem = emissorMensagem;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Integer getIdMensagemAtendimento() {
		return idMensagemAtendimento;
	}
	
	@Override
		public String toString() {
			return "Id da Mensagem: "+idMensagemAtendimento+"\n"+ "Emissor da mensagem "+emissorMensagem + "\n"
		 + "Mensagem: "+mensagem +"\n";
		}

	

}
