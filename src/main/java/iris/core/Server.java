package iris.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;

/**
 * HttpServer of app
 */
public class Server extends AbstractVerticle {

    private HttpServer server;

    /**
     * Start the HttpServer Verticle, then listen on given port
     * @throws Exception
     */
    @Override
    public void start() throws Exception {
        super.start();
        server = vertx.createHttpServer();
        server.listen(8081);
    }

}
