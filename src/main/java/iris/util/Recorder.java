package iris.util;

import com.jcabi.manifests.Manifests;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.json.JsonObject;

import java.util.Objects;

/**
 * The Recorder class abstract the vert.x logger
 */
public class Recorder {

    /**
     * the vert.x logger
     */
    final private Logger logger;

    /**
     * the classname of the class which log message
     */
    final private String loggerName;

    /**
     * Constructor of Recorder class
     *
     * @param loggerName the classname of the class which log message
     */
    public Recorder(String loggerName) {
        this.logger = LoggerFactory.getLogger(loggerName);
        this.loggerName = loggerName;
    }

    /**
     * Log a message during the start of iris service
     *
     * @param message       the message to log
     * @param correlationId the correlationId
     */
    public void start(String message, String correlationId) {
        this.simpleMessage(message, correlationId, ContextLogger.ServiceStart);
    }

    /**
     * Log a Fail Message during start
     */
    public void startFail(String message, String correlationId, String exceptionMessage) {
        this.exceptionMessage(message, correlationId, ContextLogger.ServiceStart, exceptionMessage);
    }

    /**
     * Log a simple message
     *
     * @param message       to log
     * @param correlationId the correlationId
     * @param contextLogger The context of execution
     */
    public void simpleMessage(String message, String correlationId, ContextLogger contextLogger) {
        this.logger.info(createJson(contextLogger, correlationId)
                .put("message", message)
                .toString()
        );
    }

    /**
     * Log a message when an exception occurred
     *
     * @param message          to log
     * @param correlationId    the correlationId
     * @param contextLogger    the context of execution
     * @param exceptionMessage the message from the occurred exception
     */
    public void exceptionMessage(String message, String correlationId, ContextLogger contextLogger, String exceptionMessage) {
        this.logger.info(createJson(contextLogger, correlationId)
                .put("message", message)
                .put("exception", exceptionMessage)
                .toString()
        );
    }

    /**
     * Create the logMessage and the minimal data
     *
     * @param contextLogger the context of execution
     * @param correlationId the correlationId
     * @return the logMessage in Json
     */
    private JsonObject createJson(ContextLogger contextLogger, String correlationId) {
        return new JsonObject()
                .put("timestamp", Toolkit.timestamp())
                .put("service", Manifests.read("Implementation-Title"))
                .put("host", Toolkit.host())
                .put("level", Objects.requireNonNull(contextLogger))
                .put("correlationId", Objects.requireNonNull(correlationId));
    }

}
