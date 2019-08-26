/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;



import java.net.URL;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import org.json.JSONObject;


public class RESTFul {

    public static String makeGetRequest(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   public String enviarHttpRequest(String urlParam, String method, JSONObject jsonParam) {
		try {
			URL url = new URL(urlParam);
			HttpURLConnection urlConnection = null;
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			if(jsonParam.length()>0) {
				urlConnection.setFixedLengthStreamingMode(jsonParam.toString().getBytes().length);
			}
			urlConnection.setRequestProperty("Content-Type","application/json;charset=utf-8");
			urlConnection.setRequestProperty("X-Requested-With","XMLHttpRequest");
			urlConnection.connect();
			if(jsonParam.length()>0) {
				OutputStream os;
				os = new BufferedOutputStream(urlConnection.getOutputStream());
				os.write(jsonParam.toString().getBytes());
				os.flush();
			}
			StringBuilder sBuilder;
			InputStream inputStream;
			inputStream = urlConnection.getInputStream();
			BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"),5);
			sBuilder = new StringBuilder();
			String line = null;
			while ((line = bReader.readLine()) != null) {
				sBuilder.append(line + "\n");
			}
			String texto = sBuilder.toString();
			return texto;
		} catch (IOException e) {
			return e.getMessage();
		}
	}  
}
