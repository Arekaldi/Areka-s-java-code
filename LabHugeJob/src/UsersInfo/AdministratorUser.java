package UsersInfo;

public class AdministratorUser extends User {
    public AdministratorUser() {}
    public AdministratorUser(User user) {
        super(user.userId, user.userName, user.userPassword, user.userConfirmPassword, user.userType);
    }
    public AdministratorUser(String userId, String userName, String userPassword, String userConfirmPassword, String userType) {
        super(userId, userName, userPassword, userConfirmPassword, userType);
    }
}
