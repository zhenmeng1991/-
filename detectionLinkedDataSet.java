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

public class detectionLinkedDataSet {
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
            Resource subject = stmt.getSubject();
            Property predicate = stmt.getPredicate();
            RDFNode object = stmt.getObject();
            
            String s1=subject.toString();
            String s2=predicate.toString();
            String s3=object.toString();
            //更换唯一性限制标识
            if (s1.contains("http://data.theeuropeanlibrary.org/BibliographicResource/")&&(object.isURIResource())) {          	
                setpredicate.add(s2);
                
//              System.out.print(s2+"  ");  
//              System.out.println(s3+"."); 
			}
                
        }
        Iterator it2 = setpredicate.iterator();
        int k=0;
        while (it2.hasNext()) {
            System.out.println(it2.next());
            k++;
        }
        System.out.println("一、数据关联字段共计"+k+"条.");
        String tongjiresult3=new String();
        tongjiresult3="13、数据关联字段共计"+k+"条."+"\r\n";
        return tongjiresult3;
	}

}
