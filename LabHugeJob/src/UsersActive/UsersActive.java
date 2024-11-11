package UsersActive;

import UsersInfo.User;
import UsersInfo.UserLoginedInfo;
import UsersInfo.UserRegisteredInfo;

public class UsersActive {
    private static User activeUser;

    public static void setActiveUser(User nowUser) {
        User getNowUserFromLoginedInfo = UserLoginedInfo.getNowUser(nowUser);
        if (getNowUserFromLoginedInfo != null) {
            activeUser = new User(getNowUserFromLoginedInfo);
        }
        else
            return;
    }

    public static User getActiveUser() {
        return activeUser;
    }

    public static boolean activeUserIsNull() {
        return activeUser == null;
    }

    public static void clearActiveUser(User targetUser) {
        if(activeUserIsNull()) {
            System.out.println("No one is online");
            return;
        }
        if(targetUser.getUserId() == null) {
            UserLoginedInfo.userLogout(activeUser);
            System.out.println(activeUser.getUserId() + " Bye~");
            activeUser = null;
        }
        else {
            if(!activeUser.getUserType().equals("Administrator")) {
                System.out.println("Permission denied");
                return;
            }
            if(!targetUser.userIdCheck()) {
                System.out.println("Illegal user id");
                return;
            }
            if(!UserRegisteredInfo.userIsRegistered(targetUser.getUserId())) {
                System.out.println("User does not exist");
                return;
            }
            if(!UserLoginedInfo.userIsLogined(targetUser.getUserId())) {
                System.out.println(targetUser.getUserId() + " is not online");
                return;
            }
            targetUser = UserRegisteredInfo.getUser(targetUser.getUserId());
            if (targetUser != null) {
                UserLoginedInfo.userLogout(targetUser);
            }
            if (targetUser != null) {
                System.out.println(targetUser.getUserId() + " Bye~");
            }
        }
    }
}
