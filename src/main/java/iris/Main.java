package iris;

import io.vertx.core.Vertx;
import iris.core.Server;
import iris.util.Recorder;
import iris.util.Toolkit;

/**
 * Main Class of iris
 */
public class Main {

    /**
     * Unique Vert.x's instance in iris
     */
    static final public Vertx vertx = Vertx.vertx();

    /**
     * Instance of iris services server
     */
    static final public Server server = new Server();

    /**
     *
     */
    static final Recorder recorder = new Recorder(Main.class.getSimpleName());

    /**
     * Starting point of iris, it will deploy all our beloved Verticles
     * @param args not used yet, maybe later for the Context
     */
    static public void main(String... args) {
        String correlationId = Toolkit.generateCorrelationId();
        try {
            server.start();
        } catch (Exception e) {
            recorder.startFail("An Error occurred during iris server start", correlationId, e.getMessage());
        }
    }

}
