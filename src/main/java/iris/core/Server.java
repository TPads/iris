package iris.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;

/**
 * This is the iris Server
 */
public class Server extends AbstractVerticle {

    /**
     * Instance of vert.x server
     */
    private HttpServer server;

    /**
     * Start the HttpServer Verticle, then listen on given port
     * @throws Exception when it's not started
     */
    @Override
    public void start() throws Exception {
        super.start();
        server = vertx.createHttpServer();
        server.listen(8081);
    }

}
