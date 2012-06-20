
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import jcube.core.server.entry.Develop;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;

/**
 * The Class RunDevelop.
 */
public class RunDevelop   {
   /**
    * The main method.
    *
    * @param list the arguments
    * @throws Exception the exception
    */  
   public static void main(String[] list) throws Exception {
       Connection connection = new SocketConnection( new Develop(list[1]) );
       SocketAddress address = new InetSocketAddress(Integer.parseInt(list[0]));
       connection.connect(address);
       System.out.println("Jcube develop server started at http://localhost:"+list[0]);
   }
}