package projekt.my.cdi.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;
import org.wildfly.swarm.arquillian.DefaultDeployment.Type;


@RunWith(Arquillian.class)
@DefaultDeployment(type = Type.WAR)
public class CDIArquillianTest {
	
    @Inject
    private SomeClass someclass;
    
    @Test
    public void testInjection() {
        assertNotNull(someclass);
        assertTrue(someclass.printI().contains("my string"));
    }
   
    @Test
    public void testCDIContainerPresence() throws Exception {
        assertNotNull(CDI.current());
    }
}