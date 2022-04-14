package iris.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

import iris.Main;
import iris.util.Recorder;

/**
 * This is the iris Server
 */
public class Server extends AbstractVerticle {

    /**
     * Recorder instance for Server
     */
    final private Recorder recorder = new Recorder(this.getClass().getSimpleName());

    /**
     * Instance of vert.x http server
     */
    private HttpServer httpServer;

    /**
     * Instance of the http server main router
     */
    final private Router mainRouter = mainRouting();

    /**
     * Start the HttpServer Verticle, then listen on given port
     *
     * @throws Exception when it's not started
     */
    @Override
    public void start() throws Exception {
        super.start();
        this.httpServer = Main.vertx.createHttpServer();
        this.httpServer.requestHandler(mainRouter).listen(4000);
    }

    /**
     * Instantiate mainRouter with handler
     *
     * @return the created router
     */
    public Router mainRouting() {
        Router router = Router.router(Main.vertx);
        router.route(HttpMethod.GET, "/doc").handler(context -> {

            context.response().end();
        });
        router.route(HttpMethod.GET, "/health").handler(context -> {

            context.response().end();
        });
        router.route(HttpMethod.GET, "/param").handler(context -> {

            context.response().end();
        });
        router.route(HttpMethod.PATCH, "/param").handler(context -> {

            context.response().end();
        });
        router.route(HttpMethod.GET, "/route").handler(context -> {

            context.response().end();
        });
        return router;
    }

}
