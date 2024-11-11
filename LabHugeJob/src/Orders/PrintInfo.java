package Orders;

import UsersActive.UsersActive;
import UsersInfo.User;
import UsersInfo.UserRegisteredInfo;

public class PrintInfo {
    public static void printInfo(String[] orderArgs) {
        User activeUser = UsersActive.getActiveUser();
        if(UsersActive.activeUserIsNull()) {
            System.out.println("No one is online");
            return;
        }
        if(orderArgs.length == 0) {
            activeUser.printUserInfo();
        }
        else {
            if(!activeUser.getUserType().equals("Administrator")) {
                System.out.println("Permission denied");
                return;
            }
            User newUser = new User(activeUser);;
            newUser.setUserId(orderArgs[0]);
            if(!newUser.userIdCheck()) {
                System.out.println("Illegal user id");
                return;
            }
            if(!UserRegisteredInfo.userIsRegistered(orderArgs[0])) {
                System.out.println("User does not exist");
                return;
            }
            User targetUser = UserRegisteredInfo.getUser(orderArgs[0]);
            if (targetUser != null) {
                targetUser.printUserInfo();
            }
        }
    }
}
