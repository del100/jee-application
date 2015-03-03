package ie.ait.msc.discount.store.retailer.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/*
 * A class extending {@link Application} and annotated with @ApplicationPath is the Java EE 6 "no XML" approach to activating
 * JAX-RS. Resources are served relative to the servlet path specified in the {@link ApplicationPath} annotation.
 */
@ApplicationPath("/rest")
public class JaxRsActivator extends Application {
}
