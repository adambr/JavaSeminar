package Ukol2;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.fail;

import org.apache.derby.jdbc.ClientDataSource;

/**
 * Created with IntelliJ IDEA.
 * User: Phaser
 * Date: 18.3.13
 * Time: 21:24
 * To change this template use File | Settings | File Templates.
 */
public class EventManagerImplTest {



    private ClientDataSource getDs()
    {

        ClientDataSource ds = new ClientDataSource();
        ds.setServerName("localhost");
        ds.setPortNumber(1527);
        ds.setDatabaseName("MojeDB");
        ds.setUser("adam");
        ds.setPassword("adam");
        return ds;
    }

    EventManager eventManager;

    @Before
    public void setUp() throws Exception {
        eventManager = new EventManagerImpl(getDs());
    }

    @Test
    public void testAddEventWithNull() throws Exception {
        try {
            eventManager.addEvent(null);
            fail("nevyhodil NullPointerException pro prazdny vstup");
        } catch (NullPointerException ex) {
        }
    }

    @Test
    public void testGetEventById() throws Exception {
        try {
            eventManager.getEventById(-5);
            eventManager.getEventById(0);
            fail("nevyhodil IllegalArgumentException pro zaporne id nebo 0");
        } catch (IllegalArgumentException ex) {
        }
    }

    @Test
    public void testRemoveEvent() throws Exception {
        try {
            eventManager.removeEvent(null);
            fail("nevyhodil NullPointerException pro prazdny vstup");
        } catch (NullPointerException ex) {
        }
    }
}