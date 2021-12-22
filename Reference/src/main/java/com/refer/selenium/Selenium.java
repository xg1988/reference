package com.refer.selenium;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.sourceforge.tess4j.TesseractException;

public class Selenium {


    //WebDriver
    private WebDriver driver;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "C:/chrome/chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public Selenium() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        //Driver SetUp
        driver = new ChromeDriver();
        base_url = "https://www.naver.com";
    }
 
    public void crawl() {
 
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(base_url);
            System.out.println(driver.getPageSource());
    
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            driver.close();
        }
 
    }
	public static void main(String[] args) throws TesseractException {
		/*
		 * Tesseract tesseract = new Tesseract(); tesseract.setDatapath(
		 * "C:\\Users\\MT00542\\eclipse-workspace\\Selenium\\resource\\");
		 * tesseract.setLanguage("kor");
		 * 
		 * String result = ""; try { result = tesseract.doOCR(new
		 * File("C:\\Users\\MT00542\\Desktop\\event_cont_02_double_1124_2.jpg")); }
		 * catch (TesseractException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } System.out.println(result);
		 */
		
		/*
		 * Document 클래스 : 연결해서 얻어온 HTML 전체 문서 Element 클래스 : Documnet의 HTML 요소 Elements
		 * 클래스 : Element가 모인 자료형
		 * 
		 * String url = "https://omoney.kbstar.com/quics?page=oevent&QSL=F#loading";
		 * String selector = ".eventListArea li"; Document doc = null;
		 * 
		 * if(url.indexOf("https://")> -1) { try { Test.setSSL(); } catch
		 * (KeyManagementException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (NoSuchAlgorithmException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } } try { doc =
		 * Jsoup.connect(url).get(); // -- 1. get방식의 URL에 연결해서 가져온 값을 doc에 담는다.
		 * //System.out.println(doc.text()); } catch (IOException e) {
		 * System.out.println(e.getMessage()); }
		 * 
		 * Elements titles = doc.select(selector); // -- 2. doc에서 selector의 내용을 가져와
		 * System.out.println(titles.size());
		 * 
		 * for (int i = 0; i< titles.size(); i++) { // -- 3. Elemntes 길이만큼 반복한다.
		 * //System.out.println(titles.get(i).text()); // -- 4. 원하는 요소가 출력된다.
		 * System.out.println("============================================"); String
		 * eventNm = titles.get(i).getElementsByTag("dt").text();
		 * System.out.println("eventNm: "+ eventNm); String eventNum =
		 * titles.get(i).getElementsByTag("a").get(0).attr("onclick").replaceAll(
		 * "[^0-9]",""); System.out.println("eventNum: "+ eventNum); String eventPeriod
		 * = titles.get(i).getElementsByTag("dd").get(0).text();
		 * System.out.println("eventPeriod: "+ eventPeriod); String eventImgSrc =
		 * titles.get(i).getElementsByTag("img").get(0).attr("src");
		 * System.out.println("eventImgSrc:"+ eventImgSrc);
		 * 
		 * Map<String, String> map = new HashMap<String, String>(); map.put("이벤트일련번호",
		 * eventNum); Document tempDoc =
		 * jsoupPost("https://omoney.kbstar.com/quics?page=C016559&cc=b033091:b032977",
		 * map); System.out.println(tempDoc.select("img").get(0).text());
		 * System.out.println("============================================"); }
		 */

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

	public static Document jsoupPost(String url, Map<String, String> map) {

		Document doc = null;
		if (url.indexOf("https://") > -1) {
			try {
				Selenium.setSSL();
			} catch (KeyManagementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			doc = Jsoup.connect(url).data(map).post(); // -- 1. get방식의 URL에 연결해서 가져온 값을 doc에 담는다.

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return doc;
	}
}
