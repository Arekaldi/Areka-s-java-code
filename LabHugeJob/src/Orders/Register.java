package Orders;

import UsersInfo.User;
import UsersOperate.UserRegisterOperate;

public class Register {
    public static void userRegister(String[] orderArgs) {
        User registerUser = new User(orderArgs[0], orderArgs[1], orderArgs[2], orderArgs[3], orderArgs[4]);
        UserRegisterOperate.setUser(registerUser);
        if(UserRegisterOperate.userRegister()) {
            System.out.println("Register success");
        }
    }
}
