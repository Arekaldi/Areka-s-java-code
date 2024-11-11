package Orders;

import UsersActive.UsersActive;
import UsersInfo.User;

public class Logout {
    public static void userLogout(String[] orderArgs) {
        if(orderArgs.length == 0) {
            UsersActive.clearActiveUser(new User());
        }
        else {
            User targetUser = new User();
            targetUser.setUserId(orderArgs[0]);
            UsersActive.clearActiveUser(targetUser);
        }
    }
}
