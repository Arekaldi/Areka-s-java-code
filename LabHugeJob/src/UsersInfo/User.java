package UsersInfo;

import static Functions.Function.charIsDigitInRange;
import static Functions.Function.charIsLetter;

public class User {
    protected String userId;
    protected String userName;
    protected String userPassword;
    protected String userConfirmPassword;
    protected String userType;

    public User() {}
    public User(User user) {
        this(user.userId, user.userName, user.userPassword, user.userConfirmPassword, user.userType);
    }
    public User(String userId, String userName, String userPassword, String userConfirmPassword, String userType) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userConfirmPassword = userConfirmPassword;
        this.userType = userType;
    }
    public User(String[] userInfo) {
        this(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[4]);
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserInfo(String userId, String userName, String userPassword, String userConfirmPassword, String userType) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userConfirmPassword = userConfirmPassword;
        this.userType = userType;
    }

    public static User getUserInfoByString(String[] userInfo) {
        return new User(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[4]);
    }

    public String[] getUserInfo() {
        return new String[] { userId, userName, userPassword, userConfirmPassword, userType };
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserConfirmPassword() {
        return userConfirmPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void printUserInfo() {
        System.out.println("User id: " + userId);
        System.out.println("Name: " + userName);
        System.out.println("Type: " + userType);
        System.out.println("Print information success");
    }

    /*
     *检查userId是否符合要求
     * checkArg = 1: 本科生
     * checkArg = 2: 研究生
     * checkArg = 3: 博士生
     * checkArg = 4: 教职工
     * checkArg = 5: 管理员
     * checkArg = 6: 其他
     */

    private boolean userIdCheckBit12(int checkArg) {
        char bit1 = userId.charAt(0);
        char bit2 = userId.charAt(1);
        if(checkArg == 1)
            return charIsDigitInRange(bit1, bit2, 19, 24);
        else if(checkArg == 2) {
            if(bit1 == 'S' || bit1 == 'Z')
                return bit2 == 'Y';
            return false;
        }
        else if(checkArg == 3)
            return bit1 == 'B' && bit2 == 'Y';
        else if(checkArg == 4)
            return bit1 >= '0' && bit1 <= '9' && bit2 >= '0' && bit2 <= '9';
        else if(checkArg == 5)
            return bit1 == 'A' && bit2 == 'D';
        else
            return false;
    }

    private boolean userIdCheckBit34(int checkArg) {
        char bit3 = userId.charAt(2);
        char bit4 = userId.charAt(3);
        if(checkArg == 1)
                return charIsDigitInRange(bit3, bit4, 1, 43);
        else if(checkArg == 2)
            return charIsDigitInRange(bit3, bit4, 21, 24);
        else if(checkArg == 3)
            return charIsDigitInRange(bit3, bit4, 19, 24);
        else if(checkArg == 4 || checkArg == 5)
            return bit3 >= '0' && bit3 <= '9' && bit4 >= '0' && bit4 <= '9';
        else
            return false;
    }
    /*
    * 5 6位有些特殊
    * 本科生检查5位，然后直接检查尾数
    * 教职工只有5位，记得检查教职工的位数
    * 管理员同理。
     */
    private boolean userIdCheckBit56(int checkArg) {
        char bit5 = userId.charAt(4);
        if(checkArg == 1)
            return bit5 >= '1' && bit5 <= '6';
        else if(checkArg == 2 || checkArg == 3) {
            char bit6 = userId.charAt(5);
            return charIsDigitInRange(bit5, bit6, 1, 43);
        }
        else if(checkArg == 4 || checkArg == 5)
            return bit5 >= '0' && bit5 <= '9';
        else
            return false;
    }
    /*
    * 检查尾数
    * 研究生或博士生拆开检查
    * 教职工和管理员检查全0
     */
    private boolean userIdCheckTail(int checkArg) {
        if (checkArg == 1) {
            char tailNum1 = userId.charAt(5);
            char tailNum2 = userId.charAt(6);
            char tailNum3 = userId.charAt(7);
            if(tailNum1 >= '0' && tailNum1 <= '9' && tailNum2 >= '0' && tailNum2 <= '9' && tailNum3 >= '0' && tailNum3 <= '9') {
                int tailNum = (tailNum1 - '0') * 100 + (tailNum2 - '0') * 10 + (tailNum3 - '0');
                return tailNum >= 1;
            }
            return false;
        }
        else if(checkArg == 2 || checkArg == 3) {
            char tailNum1 = userId.charAt(6);
            char tailNum2 = userId.charAt(7);
            char tailNum3 = userId.charAt(8);
            if(tailNum1 >= '1' && tailNum1 <= '6' && tailNum2 >= '0' && tailNum2 <= '9' && tailNum3 >= '0' && tailNum3 <= '9') {
                int tailNum = (tailNum2 - '0') * 10 + (tailNum3 - '0');
                return tailNum >= 1;
            }
            return false;
        }
        else if(checkArg == 4) {
            char tailNum1 = userId.charAt(0);
            char tailNum2 = userId.charAt(1);
            char tailNum3 = userId.charAt(2);
            char tailNum4 = userId.charAt(3);
            char tailNum5 = userId.charAt(4);
            int tailNum = (tailNum1 - '0') * 10000 + (tailNum2 - '0') * 1000 + (tailNum3 - '0') * 100 + (tailNum4 - '0') * 10 + (tailNum5 - '0');
            return tailNum != 0;
        }
        else if(checkArg == 5) {
            char tailNum1 = userId.charAt(2);
            char tailNum2 = userId.charAt(3);
            char tailNum3 = userId.charAt(4);
            int tailNum = (tailNum1 - '0') * 100 + (tailNum2 - '0') * 10 + (tailNum3 - '0');
            return tailNum != 0;
        }
        else
            return false;
    }

    public boolean userIdCheck() {
        if(userId.length() == 8) {
            return userIdCheckBit12(1) && userIdCheckBit34(1) && userIdCheckBit56(1) && userIdCheckTail(1);
        }
        else if(userId.length() == 9) {
            if(userId.charAt(0) != 'B')
                return userIdCheckBit12(2) && userIdCheckBit34(2) && userIdCheckBit56(2) && userIdCheckTail(2);
            else
                return userIdCheckBit12(3) && userIdCheckBit34(3) && userIdCheckBit56(3) && userIdCheckTail(3);
        }
        else if(userId.length() == 5) {
            if(userId.charAt(0) != 'A')
                return userIdCheckBit12(4) && userIdCheckBit34(4) && userIdCheckBit56(4) && userIdCheckTail(4);
            else
                return userIdCheckBit12(5) && userIdCheckBit34(5) && userIdCheckBit56(5) && userIdCheckTail(5);
        }
        else
            return false;
    }

    public boolean userNameCheck() {
        if(userName.length() >= 4 && userName.length() <= 16) {
            if(userName.charAt(0) != '_') {
                for(char c : userName.toCharArray()) {
                    if(c != '_'  && !charIsLetter(c))
                        return false;
                }
                return true;
            }
        }
        return false;
    }

    public boolean userPasswordCheck() {
        if(userPassword.length() >= 6 && userPassword.length() <= 16) {
            boolean hasDigit = false, hasLetter = false, hasSpecial = false;
            for(char c : userPassword.toCharArray()) {
                if(c >= '0' && c <= '9')
                    hasDigit = true;
                else if(charIsLetter(c))
                    hasLetter = true;
                else if(c == '@' || c == '_' || c == '%' || c == '$')
                    hasSpecial = true;
                else
                    return false;
            }
            return hasDigit && hasLetter && hasSpecial;
        }
        return false;
    }

    public boolean userConfirmPasswordCheck() {
        return userPassword.equals(userConfirmPassword);
    }

    public boolean userTypeCheck() {
        return userType.equals("Student") || userType.equals("Teacher") || userType.equals("Administrator");
    }

    public boolean userIsRegistered() {
        return UserRegisteredInfo.userIsRegistered(userId);
    }

}
