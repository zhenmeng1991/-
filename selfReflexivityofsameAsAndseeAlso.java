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

	public class selfReflexivityofsameAsAndseeAlso {
		public static String inputFileName = "C://Users//123//Desktop//NLS-3000.nt";
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Model model = ModelFactory.createDefaultModel(); 
//			InputStream in = FileManager.get().open( inputFileName );  
//	        if (in == null) {  
//	            throw new IllegalArgumentException(  
//	                                     "File: " + inputFileName + " not found");  
//	        }  
//	  
//	        // 读取RDF/XML 文件  
//	        model.read(in, null);  
			model.read(inputFileName); 
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
	            	if (subject.toString()==object.toString()) {
	            		k++;
					}
	            	 
				}
	            if (s2.contains("sameas")||s2.contains("sameAs")) {
	            	if (subject.toString()==object.toString()) {
	            		h++;
					}
				}
	                
	        }
	        
	        System.out.println("一、sameAs中违反自反属性的triple共计"+h+"条."); 
	        System.out.println("一、seeAlso中违反自反属性的triple共计"+k+"条."); 
		}

	}

