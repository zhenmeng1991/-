	package ARTICLE;

	import java.io.InputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

	import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;

	public class detectionForwardOrBackwardLinks {
	    public static String inputFileName = upLoad.address.getText().replace("\\", "//");  
	    
	    public static String main(String args){  
	        Model model = ModelFactory.createDefaultModel();  
	  
	        // 使用 FileManager 查找文件  
	        InputStream in = FileManager.get().open( inputFileName );  
	        if (in == null) {  
	            throw new IllegalArgumentException(  
	                                     "File: " + inputFileName + " not found");  
	        }   
	        // 读取RDF/XML 文件  
	        model.read(in, null); 
//			model.read(inputFileName); 
	        
	        int n=0;
	        int k=0;
	        
	        StmtIterator iter = model.listStatements();
	        while(iter.hasNext()){  
	            Statement stmt = iter.nextStatement();  
	            Resource subject = stmt.getSubject(); 
	            RDFNode object = stmt.getObject();
	                
	            if(object instanceof Resource && object.isURIResource()){  
	            	n++;  
	            }   
	            
	            if (object.isURIResource()&&object.toString().contains("http://data.theeuropeanlibrary.org/")) {
	            	k++;
				}
	        }
//	        System.out.println("一、内链接数量共计"+k+"个");
//	        System.out.println("二、外链接数量共计"+(n-k)+"个");
	        String tongjiresult2=new String();
	        tongjiresult2="11、内链接数量共计"+k+"个."+"\r\n"+"12、外链接数量共计"+(n-k)+"个"+"\r\n";
	        return tongjiresult2;
		}

	}

