package ARTICLE;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;

public class sameAsAndseeAlsoDetection {
	public static String inputFileName = upLoad.address.getText().replace("\\", "//");
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
//		model.read(inputFileName); 
		int k=0;
        int h=0;
        StmtIterator iter = model.listStatements();
        
        while(iter.hasNext()){  
            Statement stmt = iter.nextStatement();  
            Resource subject = stmt.getSubject();
            Property predicate = stmt.getPredicate();
            RDFNode object = stmt.getObject();
            
            String s2=predicate.toString();
            
            
            if (s2.contains("seeAlso")||s2.contains("seealso")) {             	
            	 k++;
			};			
            if (s2.contains("sameas")||s2.contains("sameAs")) {
				h++;
			}
                
        }
        
//        System.out.println("一、sameAs共计"+h+"条."); 
//        System.out.println("一、seeAlso共计"+k+"条."); 
        String tongjiresult2=new String();
        tongjiresult2="9、sameAs链接共计"+h+"条."+"\r\n"+"10、seeAlso链接共计"+k+"条."+"\r\n";
        return tongjiresult2;
	}

}
