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

public class propertyDuplicateRemoval {
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
        Set setpredicate = new HashSet();
        StmtIterator iter = model.listStatements();
        
        while(iter.hasNext()){  
            Statement stmt = iter.nextStatement();  
            Property predicate = stmt.getPredicate();
            Resource subject = stmt.getSubject();
            
            String s1=subject.toString(); 
            String s2=predicate.toString();   
            if (s1.contains("http://data.theeuropeanlibrary.org/")) {
            	setpredicate.add(s2);
			}
            

        }
        Iterator it2 = setpredicate.iterator();
        int k=0;
        while (it2.hasNext()) {
            System.out.println(it2.next());
            k++;
        }
        //System.out.println("一、Property（去重后）共计"+k+"条."); 
        String tongjiresult2=new String();
        tongjiresult2="8、谓词去重后共计"+k+"条."+"\r\n";
        return tongjiresult2;
	}

}
