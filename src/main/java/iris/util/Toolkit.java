package iris.util;

import io.vertx.ext.web.RoutingContext;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * A kit of tools, so it's a Toolkit
 */
public interface Toolkit {

    /**
     * Retrieve system hostname from InetAddress way
     * @return hostname or "UnknownHost"
     */
    static String host() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return ErrorCode.UnknownHost.name();
        }
    }

    /**
     * Retrieve System Timestamp
     * @return timestamp
     */
    static String timestamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return simpleDateFormat.format(timestamp);
    }

    /**
     * Get correlation id from a request or create one if it's not setted
     * @param context the context of call
     * @return correlationId
     */
    static String getCorrelationId(RoutingContext context) {
        return (context != null && context.get("X-Request-ID") != null && !"".equals(context.get("X-Request-ID")))
                ? context.get("X-Request-ID")
                : UUID.randomUUID().toString();
    }

    /**
     * Use the method getCorrelationId with a null context to generate a new correlationId
     * @return correlationId
     */
    static String generateCorrelationId() {
        return getCorrelationId(null);
    }

}
