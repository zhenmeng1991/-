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

public class bookPropertyDuplicateRemoval {
	public static String inputFileName = "C://Users//123//Desktop//bnf - 3000.rdf";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
        
        
        Set setpredicate = new HashSet();
        StmtIterator iter = model.listStatements();
        
        while(iter.hasNext()){  
            Statement stmt = iter.nextStatement();  
            Resource subject = stmt.getSubject();
            Property predicate = stmt.getPredicate();
            
            String s1=subject.toString();
            String s2=predicate.toString();
            
//            法国书目数据字段检测字段限制
            if (s1.contains("http://data.bnf.fr/ark:/12148/")&&!(s1.contains("#"))) {          	
                setpredicate.add(s2);
			}
            
            //英国书目数据字段检测字段限制
            if (s1.contains("http://bnb.data.bl.uk/id/resource/")) {          	
                setpredicate.add(s2);
			}
            
            //德国书目数据字段检测字段限制
//            if (s1.contains("http://d-nb.info/")) {          	
//                setpredicate.add(s2);
//			}
            
            //瑞典书目数据字段检测字段限制
//            if (s1.contains("http://libris.kb.se/resource/bib/")) {          	
//                setpredicate.add(s2);
//			}
//            
            //西班牙书目数据字段检测字段限制
//            if (s1.contains("http://datos.bne.es/resource/bimo")) {          	
//                setpredicate.add(s2);
//			}
            
        }
        Iterator it2 = setpredicate.iterator();
        int k=0;
        while (it2.hasNext()) {
            System.out.println(it2.next());
            k++;
        }
        System.out.println("一、书目数据（去重后）共计"+k+"条."); 
	}

}
