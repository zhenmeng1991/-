	package ARTICLE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;

	public class noDefinedClassOrProperty {
		public static String inputFileName = grammerEveluation.address.getText().replace("\\", "//");
		public static String allvocabulary = "C://Users//123//Desktop//t_lovdetail.txt";
		/**
		 * @param args
		 */
		public static String main(String args) {
			// TODO Auto-generated method stub
			Model model = ModelFactory.createDefaultModel(); 
			InputStream in = FileManager.get().open( inputFileName );  
	        if (in == null) {  
	            throw new IllegalArgumentException(  
	                                     "File: " + inputFileName + " not found");  
	        } 
	        // 读取RDF/XML 文件  
	        model.read(in, null); 
	        String allvocabularyresource="";
	        try {
				File file=new File("C://Users//123//Desktop//t_lovdetail.txt");
				if(file.isFile() && file.exists()){ //判断文件是否存在
				    InputStreamReader read = new InputStreamReader(
				    new FileInputStream(file),"UTF-8");//考虑到编码格式
				    BufferedReader bufferedReader = new BufferedReader(read);
				    String lineTxt = null;
				    while((lineTxt = bufferedReader.readLine()) != null){
				        allvocabularyresource=allvocabularyresource+lineTxt;
				    }
				    read.close();
   }else{
      System.out.println("找不到指定的文件");
   }
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        
 
//			model.read(inputFileName); 
	        Set setpredicate = new HashSet();
	        StmtIterator iter = model.listStatements();
	        
	        while(iter.hasNext()){  
	            Statement stmt = iter.nextStatement();  
	            Property predicate = stmt.getPredicate();
	            
	            String s2=predicate.toString();    	
	            setpredicate.add(s2);

	        }
	        Iterator it2 = setpredicate.iterator();
	        int k=0;
	        while (it2.hasNext()) {
	        	if (!allvocabularyresource.contains(it2.next().toString())) {
//	 	           System.out.println(it2.next().toString());	
		            k++;
				}
	        }
	        System.out.println("一、未定义的类和属性共计"+k+"条."); 
	        String yufaresult1=new String();
	        yufaresult1="2、未定义的类和属性共计"+k+"条."+"\r\n";
	        return yufaresult1;
		}

	}
