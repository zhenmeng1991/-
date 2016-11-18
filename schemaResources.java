package ARTICLE;

import java.io.InputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NsIterator;
import com.hp.hpl.jena.util.FileManager;

public class schemaResources {
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
      NsIterator nsIterator=model.listNameSpaces();
      System.out.println("一、本文档命名空间有以下这些：");  
      while(nsIterator.hasNext()){
      	System.out.println(nsIterator.next());
      	k++;
      }
      String tongjiresult3=new String();
      tongjiresult3="14、本文档命名空间共计"+k+"个."+"\r\n";
      return tongjiresult3;
	}

}
