/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2012
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package ie.ait.msc.discount.store.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;

import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Arquillian.class)
public class DiscountStoreTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiscountStoreTest.class);

    @ArquillianResource
    private URL deploymentURL;

    @Deployment(testable = false)
    public static EnterpriseArchive createMociHandlerDeployment() {
        // Default is to use ear built by Maven
        File earFile = new File("../discount-store-ear/target/discount-store-ear-0.0.1-SNAPSHOT.ear");
        if (!earFile.exists())
            earFile = new File("../discount-store-ear/build/libs/discount-store-ear-0.0.1-SNAPSHOT.ear");
        EnterpriseArchive archive = ShrinkWrap.createFromZipFile(EnterpriseArchive.class, earFile);
        LOGGER.info("Content of ear: " + archive.toString(true));
        return archive;
    }

    @Test
    public void basicRetailerServiceTest() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/DiscountStore/rest/retailer/test");
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        assertTrue(value.equals("hello from server"));
        response.close();
    }

    @Test
    public void getAllOffersTest() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/DiscountStore/rest/retailer/AllOffers/user1");
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        assertTrue(value.contains("http://www.sometest/shirt"));
        assertTrue(value.contains("A really nice shirt"));
        response.close();
    }
}
