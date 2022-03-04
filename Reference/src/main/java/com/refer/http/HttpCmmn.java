package com.refer.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpCmmn {
		
		public static void main(String[] args) throws Exception {
			String pageNo = "1";
			String numOfRows = "10";
			String lawdCd = "11470";
			String dealYmd = "202111";
			HashMap<String, Object> inputMap = new HashMap<String, Object>();
					
			inputMap.put("pageNo", pageNo);
			inputMap.put("numOfRows", numOfRows);
			inputMap.put("LAWD_CD", lawdCd);
			inputMap.put("DEAL_YMD", dealYmd);
			inputMap.put("serviceKey", "McUjCQTdkXbQJAiDABPqRmL6wkwz8P7Y07AfGEzIsykaST1z6HgCIbr6VHYr7O7mSJ1d1WVEt82AIKVRf+n9vA==");
			//http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?serviceKey=McUjCQTdkXbQJAiDABPqRmL6wkwz8P7Y07AfGEzIsykaST1z6HgCIbr6VHYr7O7mSJ1d1WVEt82AIKVRf%2Bn9vA%3D%3D&pageNo=1&numOfRows=10&LAWD_CD=11110&DEAL_YMD=201512
			//String xml = HttpUtil.sendGet("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev", inputMap);
			String url = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev";
			HttpCmmn http = new HttpCmmn();
			System.out.println(http.sendGet(url, inputMap));
			System.out.println(http.sendPost(url, inputMap));
		}
	// HTTP GET request
		public String sendGet(String targetUrl, HashMap<String, Object> inputMap) throws Exception {
			StringBuilder urlBuilder = new StringBuilder();
			int index = 0;
			
			if(inputMap !=null) {
				for(String key: inputMap.keySet()) {
					String appendStr = "?";
					if(		index > 0 ) {
						appendStr = "&";
					}
					urlBuilder.append(appendStr + URLEncoder.encode(key,"UTF-8") 
												+ "="+URLEncoder.encode((String)inputMap.get(key),"UTF-8") );
					index++;
				}
			}
			
			targetUrl = targetUrl+ urlBuilder.toString();
			System.out.println("targetUrl : "+ targetUrl);
			
			
			URL url = new URL(targetUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("GET"); // optional default is GET
			con.setRequestProperty("User-Agent", "Mozilla/5.0"); // add request header

			int responseCode = con.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println("HTTP 응답코드:" + responseCode);
			System.out.println("HTTP response.length() : " + response.length());
			System.out.println("HTTP body : " + response.toString());
			
			return response.toString();
		}

		// HTTP POST request
		public String sendPost(String targetUrl, HashMap<String, Object> inputMap) throws Exception {

			URL url = new URL(targetUrl);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

			StringBuffer response = new StringBuffer();
			
			con.setRequestMethod("POST"); // HTTP POST �޼ҵ� ����
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setDoOutput(true); // POST �Ķ���� ������ ���� ����

			StringBuilder urlBuilder = new StringBuilder();
			int index = 0;
			for(String key: inputMap.keySet()) {
				String appendStr = "";
				if(index > 0) {
					appendStr = "&";
				}
				urlBuilder.append(appendStr + URLEncoder.encode(key,"UTF-8") 
											+ "="+URLEncoder.encode((String)inputMap.get(key),"UTF-8") );
				index++;
			}
			
			// Send post request
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlBuilder.toString());
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println("HTTP 응답코드: " + responseCode);
			System.out.println("HTTP body : " + response.toString());
			
			return response.toString();
		}
		
		public String getHttpURLConnection(String apiUrl, Map<String, String> requestHeaders) throws Exception{
	        HttpURLConnection con = connect(apiUrl);
	        try {
	            con.setRequestMethod("GET");
	            if(requestHeaders != null) {
	            	for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	                    con.setRequestProperty(header.getKey(), header.getValue());
	                }
	            }
	            
	            int responseCode = con.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
	                return readBody(con.getInputStream());
	            } else { // 에러 발생
	                return readBody(con.getErrorStream());
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("API 요청과 응답 실패", e);
	        } finally {
	            con.disconnect();
	        }
	    }


	    private static HttpURLConnection connect(String apiUrl) throws Exception{
	    	setSSL();
	    	
	        try {
	            URL url = new URL(apiUrl);
	            return (HttpURLConnection)url.openConnection();
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
	        } catch (IOException e) {
	            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
	        }
	    }


	    private static String readBody(InputStream body){
	        InputStreamReader streamReader = new InputStreamReader(body);


	        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	            StringBuilder responseBody = new StringBuilder();


	            String line;
	            while ((line = lineReader.readLine()) != null) {
	                responseBody.append(line);
	            }


	            return responseBody.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
	        }
	    }
	    
	    public static void setSSL() throws NoSuchAlgorithmException, KeyManagementException {
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
			} };
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			});
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		}
}
