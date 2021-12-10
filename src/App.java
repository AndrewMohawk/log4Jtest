// Simple Java Webserver

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.logging.log4j.*;



public class App {
    private final static Logger l4jlogger = LogManager.getLogger();

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new MyHandler());
        l4jlogger.error("Java is the run on 3 batrillion devices! Here is another one!");
        server.setExecutor(null); // creates a default executor
        server.start();
        
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            
            l4jlogger.error("oh no, here come the query parameters into the log! :( ");
            l4jlogger.error(t.getRequestURI().getQuery().toString());
           
           
            String response = "Please dont exploit me, I log all the request query parameters :( :(";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}