package ie.ait.msc.discount.store.dto;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RetailerDtoTest {

    private static final String USER_NAME = "testuser";
    private static final String PASSWORD = "password";

    private RetailerDto retailerDto;

    @Before
    public void setup() {
        retailerDto = new RetailerDto();
        retailerDto.setUserName(USER_NAME);
        retailerDto.setPassword(PASSWORD);
    }

    @Test
    public void getUserName_success() {
        assertTrue(retailerDto.getUserName().equals(USER_NAME));
    }

    @Test
    public void getPassword_success() {
        assertTrue(retailerDto.getPassword().equals(PASSWORD));
    }
}
