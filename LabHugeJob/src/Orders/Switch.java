package Orders;

import UsersActive.UsersActive;
import UsersInfo.User;
import UsersInfo.UserLoginedInfo;
import UsersInfo.UserRegisteredInfo;

public class Switch {
    public static void switchUser(String[] orderArgs) {
        User user = new User();
        user.setUserId(orderArgs[0]);
        if(!user.userIdCheck()) {
            System.out.println("Illegal user id");
            return;
        }
        if(!UserRegisteredInfo.userIsRegistered(user.getUserId())) {
            System.out.println("User does not exist");
            return;
        }
        if(!UserLoginedInfo.userIsLogined(user.getUserId())) {
            System.out.println(user.getUserId() +  " is not online");
            return;
        }
        User targetUser = UserRegisteredInfo.getUser(user.getUserId());
        UsersActive.setActiveUser(targetUser);
        if (targetUser != null)
            System.out.println("Switch to " + targetUser.getUserId());

    }
}
