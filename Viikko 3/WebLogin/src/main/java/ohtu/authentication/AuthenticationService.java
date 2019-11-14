package ohtu.authentication;

import ohtu.data_access.UserDao;
import ohtu.domain.User;
import ohtu.util.CreationStatus;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();
        
        if (userDao.findByName(username) != null) {
            status.addError("username is already taken");
        }

        if (username.length()<3 ) {
            status.addError("username should have at least 3 characters");
        }
        
        if (password.length() < 8) {
            status.addError("password should have at least 8 characters");
        }
        
        if(extractNumber(password).equals("")) {
            status.addError("password should contain at least one number");
        }
        
        if(!password.equals(passwordConfirmation)) {
            System.out.println(password);
            System.out.println(passwordConfirmation);
            status.addError("password and password confirmation do not match");
        }

        if (status.isOk()) {
            userDao.add(new User(username, password));
        }
        
        return status;
    }
    
    private String extractNumber(final String str) {                

    if(str == null || str.isEmpty()) return "";

    StringBuilder sb = new StringBuilder();
    boolean found = false;
    for(char c : str.toCharArray()){
        if(Character.isDigit(c)){
            sb.append(c);
            found = true;
        } else if(found){
            // If we already found a digit before and this char is not a digit, stop looping
            break;                
        }
    }

    return sb.toString();
}

}


