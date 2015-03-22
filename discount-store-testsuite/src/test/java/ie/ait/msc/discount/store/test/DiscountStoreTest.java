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

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class DiscountStoreTest {

    @Deployment
    public static EnterpriseArchive createMociHandlerDeployment() {

        File earFile = new File("/home/eeiwdey/git/jee-application/discount-store-ear/target/discount-store-ear-0.0.1-SNAPSHOT.ear");
        EnterpriseArchive archive = ShrinkWrap.createFromZipFile(EnterpriseArchive.class, earFile);
        return archive;
    }

    @Test
    public void someTest() {
        assertTrue(true);
    }
}
