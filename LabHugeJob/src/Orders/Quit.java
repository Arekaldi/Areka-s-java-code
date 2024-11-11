package Orders;

import UsersInfo.UserLoginedInfo;

public class Quit {
    public static void quit() {
        UserLoginedInfo.userLogoutByOrder();
        System.out.println("----- Good Bye! -----");
    }
}
