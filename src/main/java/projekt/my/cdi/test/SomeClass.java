package projekt.my.cdi.test;

import javax.enterprise.context.ApplicationScoped;
import org.apache.solr.client.solrj.SolrServer;
//import org.apache.solr.client.solrj.impl.HttpSolrServer;

@ApplicationScoped
public class SomeClass{	

	String somestr;
	
	// Remove it so test pass!!!
	SolrServer solrServer;
	
	public SomeClass(){		
	}
	
	public String printI(){
		//Example of initialization when SolrServer works
		//solrServer = new HttpSolrServer("http://localhost:8083/solr/collection3");
		
		somestr = "my string";		
		return somestr;
	}		
}
