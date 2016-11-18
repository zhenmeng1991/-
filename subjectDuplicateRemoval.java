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

public class subjectDuplicateRemoval {
	public static String inputFileName = upLoad.address.getText().replace("\\", "//");
	/**
	 * @param args
	 */
	public static String  main(String args) {
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
        Set setsubject=new HashSet();
        StmtIterator iter = model.listStatements();
        
        while(iter.hasNext()){  
            Statement stmt = iter.nextStatement();   
            Resource subject = stmt.getSubject();
            
            String s1=subject.toString();
            setsubject.add(s1);   
        }
        Iterator it1= setsubject.iterator();
        int k=0;
        while (it1.hasNext()) {
            System.out.println(it1.next());
            k++;
        }
//        System.out.println("一、subject（去重后）共计"+k+"条."); 
        String tongjiresult2=new String();
        tongjiresult2="7、主体去重后共计"+k+"条."+"\r\n";
        return tongjiresult2;
	}

}
