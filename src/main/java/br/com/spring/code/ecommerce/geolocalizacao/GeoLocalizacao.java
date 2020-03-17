package br.com.spring.code.ecommerce.geolocalizacao;

import br.com.spring.code.ecommerce.gestaoprodutos.Produto;

public class GeoLocalizacao {
	private Integer id;
	private Integer IdProduto;
	private Double latitude;
	private Double longitude;
	private static final Integer RAIO_EM_KM = 10; 
	
	
	
	
	/* Este construtor depende do ID do produto */
	
	public GeoLocalizacao(Integer id, Produto produto, Double latitude, Double longitude) {
		this.id = id;
		this.IdProduto = produto.getId();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	
	/** Este método calculará o raio do local com base na lat e long do objeto
	 * Depende da API que será usada para os mapas
	 * calcularRaio(){
	 * }
	 *
	 */
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdProduto() {
		return IdProduto;
	}
	public void setIdProduto(Integer idProduto) {
		IdProduto = idProduto;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public static Integer getRaioEmKm() {
		return RAIO_EM_KM;
	}
	
	

}
