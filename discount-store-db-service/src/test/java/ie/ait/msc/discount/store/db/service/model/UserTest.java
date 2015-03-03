package ie.ait.msc.discount.store.db.service.model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";
    private static final Long ID = new Long("10");

    private User user;

    @Before
    public void setup() {
        user = new User();
        user.setId(ID);
        user.setUserName(USERNAME);
        user.setPassword(PASSWORD);
        user.setRetailer(new Retailer());
    }

    @Test
    public void getId() {
        assertTrue(user.getId() == ID);
    }

    @Test
    public void getUserName_success() {
        assertTrue(user.getUserName().equals(USERNAME));
    }

    @Test
    public void getPassword_success() {
        assertTrue(user.getPassword().equals(PASSWORD));
    }

    @Test
    public void getRetailer_success() {
        assertTrue(user.getRetailer() != null);
    }

    @Test
    public void toString_success() {
        assertTrue(user.toString().contains(USERNAME));
    }

    @Test
    public void equals_success() {
        User anotherUser = new User();
        anotherUser.setUserName(USERNAME);
        assertTrue(user.equals(anotherUser));
    }

    @Test
    public void hashCode_success() {
        assertTrue(user.hashCode() != 0);
    }
}
