import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class SimpleJettyServer {
	
	 public static void main( String[] args ) throws Exception
	    {
	        Server server = new Server(8080);
	        ResourceHandler rh = new ResourceHandler();
	        rh.setDirectoriesListed(true);
	        rh.setResourceBase("./html");
	        server.setHandler(rh);
	        
	        server.start();
	        server.dumpStdErr();
	        server.join();
	    }

}
