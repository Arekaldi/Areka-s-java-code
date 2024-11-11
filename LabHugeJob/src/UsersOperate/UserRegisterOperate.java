package UsersOperate;

import UsersInfo.User;
import UsersInfo.UserRegisteredInfo;

public class UserRegisterOperate {
    private static User user;

    UserRegisterOperate() {}

    public static void setUser(User user) {
        UserRegisterOperate.user = user;
    }

    private static boolean userRegisterIdCheck() {
        return user.userIdCheck();
    }
    private static boolean userRegisterNameCheck() {
        return user.userNameCheck();
    }
    private static boolean userRegisterPasswordCheck() {
        return user.userPasswordCheck();
    }
    private static boolean userRegisterConfirmPasswordCheck() {
        return user.userConfirmPasswordCheck();
    }
    private static boolean userRegisterTypeCheck() {
        return user.userTypeCheck();
    }

    public static boolean userRegister() {
        if(!userRegisterIdCheck()) {
            System.out.println("Illegal user id");
            return false;
        }
        if(UserRegisteredInfo.userIsRegistered(user.getUserId())) {
            System.out.println("User id exists");
            return false;
        }
        if(!userRegisterNameCheck()) {
            System.out.println("Illegal user name");
            return false;
        }
        if(!userRegisterPasswordCheck()) {
            System.out.println("Illegal password");
            return false;
        }
        if(!userRegisterConfirmPasswordCheck()) {
            System.out.println("Passwords do not match");
            return false;
        }
        if(!userRegisterTypeCheck()) {
            System.out.println("Illegal identity");
            return false;
        }
        UserRegisteredInfo.userRegister(user);
        return true;
    }
}
