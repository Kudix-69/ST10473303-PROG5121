


public class Login {
    private String storedUsername;
    private String storedPassword;
    private String storedCellNumber;
    private boolean isLoggedIn = false;
    
    public boolean checkUsername(String username) {
        // Regex: must contain underscore and be max 5 characters
        return username.matches("^[a-zA-Z0-9_]{1,5}$");
    }
    
    public String returnUsernameMessage(String username) {
        if (checkUsername(username)) {
            return "Username successfully captured.";
        } else {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters";
        }
    }
    
    public boolean checkPasswordComplexity(String password) {
        // Regex: at least 8 characters, one capital, one digit, one special character
        return password.matches("^(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }
    
    public String returnPasswordMessage(String password) {
        if (checkPasswordComplexity(password)) {
            return "Password successfully captured.";
        } else {
            return "Password is not correctly formatted, please ensure that your password contains at least eight characters, a capital letter, a number and a special character";
        }
    }
    
    public boolean checkCellPhoneNumber(String cellNumber) {
        // Regex: must start with 0, only digits after that, and be exactly 10 characters
        return cellNumber.matches("^0[0-9]{9}$");
    }
    
    public String returnCellNumberMessage(String cellNumber) {
        if (checkCellPhoneNumber(cellNumber)) {
            return "Cell phone number accepted";
        } else {
            return "Cell phone number is incorrectly formatted";
        }
    }
    
    public boolean registerUser(String username, String password, String cellNumber) {
        if (checkUsername(username) && checkPasswordComplexity(password) && checkCellPhoneNumber(cellNumber)) {
            this.storedUsername = username;
            this.storedPassword = password;
            this.storedCellNumber = cellNumber;
            return true;
        }
        return false;
    }
    
    public boolean loginUser(String username, String password) {
        if (username.equals(storedUsername) && password.equals(storedPassword)) {
            this.isLoggedIn = true;
            return true;
        }
        return false;
    }
    
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome user: " + username;
        } else {
            return "Username or password incorrect, please try again";
        }
    }
    
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}