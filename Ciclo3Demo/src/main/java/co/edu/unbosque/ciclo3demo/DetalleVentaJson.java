package co.edu.unbosque.ciclo3demo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class DetalleVentaJson {

	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static int postJSON(DetalleVenta detalleVenta) throws IOException {
		
		url = new URL(sitio+"detalleventas/guardar");
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
				+ "\"codigo_detalle_venta\":\""+detalleVenta.getCodigo_detalle_venta()
				+"\",\"cantidad_producto\": \""+detalleVenta.getCantidad_producto()
				+"\",\"codigo_producto\": \""+detalleVenta.getCodigo_producto()
				+"\",\"codigo_venta\":\""+detalleVenta.getCodigo_venta()
				+"\",\"valor_total\":\""+detalleVenta.getValor_total()
				+"\",\"valor_venta\":\""+detalleVenta.getValor_venta()
				+"\",\"ivacompra\":\""+detalleVenta.getIvacompra()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
}
