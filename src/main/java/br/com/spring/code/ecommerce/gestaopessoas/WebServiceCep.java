package br.com.spring.code.ecommerce.gestaopessoas;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.json.Json;
import javax.json.JsonObject;

public final class WebServiceCep {

	public static JsonObject buscarCep(String cep) {

		JsonObject json;

		try {
			URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();

			json = Json.createReader(is).readObject();

		} catch (Exception e) {
			throw new CepException(e.getMessage());
		}

		return json;
	}
}