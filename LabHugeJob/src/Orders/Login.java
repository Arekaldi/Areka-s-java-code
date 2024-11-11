package Orders;

import UsersActive.UsersActive;
import UsersInfo.User;
import UsersOperate.UserLoginOperate;

public class Login {
    public static void userLogin(String[] orderArgs) {
        User user = new User();
        user.setUserId(orderArgs[0]);
        user.setUserPassword(orderArgs[1]);
        UserLoginOperate.setUser(user);
        if(UserLoginOperate.userLogin()) {
            System.out.println("Welcome to ACP, " + user.getUserId());
            UsersActive.setActiveUser(user);
        }
    }
}
