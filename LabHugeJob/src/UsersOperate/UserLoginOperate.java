package UsersOperate;

import UsersInfo.User;
import UsersInfo.UserLoginedInfo;
import UsersInfo.UserRegisteredInfo;

public class UserLoginOperate {
    private static User user;

    UserLoginOperate() {}
    public static void setUser(User user) {
        UserLoginOperate.user = user;
    }

    private static boolean userLoginIdCheck() {
        return user.userIdCheck();
    }

    /*
     * This method is used to check the login credentials of the user.
     * It returns 1 if the login credentials are correct
     * 0 if the password is incorrect
     * and -1 if the user is not registered.
     */

    private static boolean userLoginPasswordCheck(String registeredPassword) {
        String loginPassword = user.getUserPassword();
        return loginPassword.equals(registeredPassword);
    }

    public static boolean userLogin() {
        User userRegistered = UserRegisteredInfo.getUser(user.getUserId());
        String[] userRegisteredInfo = null;
        if (userRegistered != null) {
            userRegisteredInfo = userRegistered.getUserInfo();
        }
        if(!userLoginIdCheck()) {
            System.out.println("Illegal user id ");
            return false;
        }
        if(userRegisteredInfo == null) {
            System.out.println("User does not exist");
            return false;
        }
        if(UserLoginedInfo.userIsLogined(user.getUserId())) {
            System.out.println(user.getUserId() + " is online");
            return false;
        }
        if(!userLoginPasswordCheck(userRegisteredInfo[2])) {
            System.out.println("Wrong password");
            return false;
        }
        user.setUserInfo(userRegisteredInfo[0], userRegisteredInfo[1], userRegisteredInfo[2], userRegisteredInfo[3], userRegisteredInfo[4]);
        UserLoginedInfo.userLogin(user);
        return true;
    }
}
