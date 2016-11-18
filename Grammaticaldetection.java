package ARTICLE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.client.utils.URLEncodedUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Grammaticaldetection {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	 	   //URL地址编码  
	 	   URLEncoder encoder=null;
	 	   //启动本地tomcat服务器，建立站点，提供数据传送服务
	 	    String string=encoder.encode("http://159.226.141.135/Grammaticaldetection/BNBLODB_3000.rdf");			 	  
	 	    String url="http://swse.deri.org/RDFAlerts/alerts?url="+string+"&format=html";
		  String rdfcontent = "";
        
			 	      try {
						  Document tempdoc = Jsoup.connect(url).timeout(60000).get();
						 // rdfcontent = tempdoc.toString();
						 rdfcontent=tempdoc.getElementsByTag("td").toString();
					} catch (Exception e) {
						e.printStackTrace();
					}
			 	    String rdfcontent1=rdfcontent.replace("<td>","");
			 	    String rdfcontent2=rdfcontent1.replace("</td>","");
			 	     System.out.println(rdfcontent2); 

			       }
		     }

			 	      