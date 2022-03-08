package iris;

import io.vertx.core.Vertx;
import iris.core.Server;

/**
 * Main Class of iris
 */
public class Main {

    /**
     * Unique Vert.x's instance in iris
     */
    static final Vertx vertx = Vertx.vertx();

    /**
     * Starting point of iris, it will deploy all our beloved Verticles
     *
     * @param args not used yet, maybe later for the Context
     */
    static public void main(String... args) {

        vertx.deployVerticle(new Server());
    }

}
