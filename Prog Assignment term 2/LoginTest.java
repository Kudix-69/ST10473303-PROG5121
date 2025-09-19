


import static org.junit.Assert.*;
import org.junit.Test;

public class LoginTest {
    
    private Login login = new Login();
    private String validUsername = "test_user";
    private String validPassword = "Pass123!";
    
    @Test
    public void testFailedLogin_wrongUsername() {
        assertFalse(login.loginUser("WrongUser", validPassword));
    }
    
    @Test
    public void testFailedLogin_wrongPassword() {
        assertFalse(login.loginUser(validUsername, "WrongPass11"));
    }
    
    @Test
    public void testFailedLogin_emptyFields() {
        assertFalse(login.loginUser("", ""));
    }
    
    @Test
    public void testLoginStatusMessage_success() {
        // First register the user
        login.registerUser(validUsername, validPassword, "0123456789");
        
        String message = login.returnLoginStatus(validUsername, validPassword);
        assertEquals("Welcome user: " + validUsername, message);
    }
    
    @Test
    public void testLoginStatusMessage_failure() {
        String message = login.returnLoginStatus("WrongUser", "WrongPass11");
        assertEquals("Username or password incorrect, please try again", message);
    }
}