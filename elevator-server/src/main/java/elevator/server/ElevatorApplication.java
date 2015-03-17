package elevator.server;

import com.google.common.collect.Sets;
import elevator.server.security.AdminAuthenticationFilter;
import elevator.server.security.UserAuthenticationFilter;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

public class ElevatorApplication extends Application {
    private final HashSet<Object> singletons;

    public ElevatorApplication() {
        ElevatorServer server = new ElevatorServer();
        singletons = newHashSet(
                new WebResource(server),
                new UserAuthenticationFilter(server),
                new AdminAuthenticationFilter(),
                new ServerStarter(server));
    }

    @Override
    public Set<Class<?>> getClasses() {
        return Sets.<Class<?>>newHashSet(JacksonJsonProvider.class, MultiPartFeature.class);
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
