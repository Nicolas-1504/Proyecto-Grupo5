package co.edu.unbosque.ciclo3demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class VentaJson {

	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<Venta> parsingVentas(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		ArrayList<Venta> lista = new ArrayList<Venta>();
		JSONArray ventas = (JSONArray) jsonParser.parse(json);
		Iterator i = ventas.iterator();
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Venta venta = new Venta();
			venta.setCodigo_venta(Long.parseLong(innerObj.get("codigo_venta").toString()));
			venta.setCedula_cliente(Long.parseLong(innerObj.get("cedula_cliente").toString()));
			venta.setCedula_usuario(Long.parseLong(innerObj.get("cedula_usuario").toString()));
			venta.setIvaventa(Double.parseDouble(innerObj.get("ivaventa").toString()));
			venta.setTotal_venta(Double.parseDouble(innerObj.get("total_venta").toString()));
			venta.setValor_venta(Double.parseDouble(innerObj.get("valor_venta").toString()));
			lista.add(venta);
		}
		return lista;
	}
	
	public static ArrayList<Venta> getJSON() throws IOException, ParseException{
			
			url = new URL(sitio +"ventas/listar");
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			
			http.setRequestMethod("GET");
			http.setRequestProperty("Accept", "application/json");
			
			InputStream respuesta = http.getInputStream();
			byte[] inp = respuesta.readAllBytes();
			String json = "";
			
			for (int i = 0; i<inp.length ; i++) {
			   json += (char)inp[i];
			}
			
			ArrayList<Venta> lista = new ArrayList<Venta>();
			lista = parsingVentas(json);
			http.disconnect();
			return lista;
		}
	
	public static int postJSON(Venta venta) throws IOException {
		
		url = new URL(sitio+"ventas/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		
		try {
		  http.setRequestMethod("POST");
		} catch (ProtocolException e) {
		  e.printStackTrace();
		}
		
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		
		String data = "{"
				+ "\"codigo_venta\":\""+ String.valueOf(venta.getCodigo_venta())
				+"\",\"cedula_cliente\": \""+venta.getCedula_cliente()
				+"\",\"cedula_usuario\": \""+venta.getCedula_usuario()
				+"\",\"ivaventa\":\""+venta.getIvaventa()
				+"\",\"total_venta\":\""+venta.getTotal_venta()
				+"\",\"valor_venta\":\""+venta.getValor_venta()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
}
