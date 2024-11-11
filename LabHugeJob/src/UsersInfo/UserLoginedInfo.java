package UsersInfo;

import java.util.ArrayList;
import java.util.List;

public class UserLoginedInfo {
    private static List<StudentUser> studentUsers = new ArrayList<>();
    private static List<TeacherUser> teacherUsers = new ArrayList<>();
    private static List<AdministratorUser> adminUsers = new ArrayList<>();
    //TODO: Login order
    private static List<String> userLoginOrder = new ArrayList<>();

    public static User getNowUser(User nowUser) {
        switch (nowUser.getUserType()) {
            case "Student" -> {
                for (StudentUser studentUser : studentUsers) {
                    if (studentUser.getUserId().equals(nowUser.getUserId())) {
                        return studentUser;
                    }
                }
            }
            case "Teacher" -> {
                for (TeacherUser teacherUser : teacherUsers) {
                    if (teacherUser.getUserId().equals(nowUser.getUserId())) {
                        return teacherUser;
                    }
                }
            }
            case "Administrator" -> {
                for (AdministratorUser adminUser : adminUsers) {
                    if (adminUser.getUserId().equals(nowUser.getUserId())) {
                        return adminUser;
                    }
                }
            }
        }
        return null;
    }

    public static boolean userIsLogined(String userId) {
        if(userId.length() == 8 || userId.length() == 9) {
            for(StudentUser studentUser : studentUsers) {
                if(studentUser.getUserId().equals(userId))
                    return true;
            }
            return false;
        }
        else if(userId.length() == 5) {
            if(userId.charAt(0) != 'A') {
                for(TeacherUser teacherUser : teacherUsers) {
                    if(teacherUser.getUserId().equals(userId))
                        return true;
                }
                return false;
            }
            else {
                for(AdministratorUser administratorUser : adminUsers) {
                    if(administratorUser.getUserId().equals(userId))
                        return true;
                }
                return false;
            }
        }
        else
            return false;
    }

    public static void userLogin(User user) {
        switch (user.getUserType()) {
            case "Student" -> studentUsers.add(new StudentUser(user));
            case "Teacher" -> teacherUsers.add(new TeacherUser(user));
            case "Administrator" -> adminUsers.add(new AdministratorUser(user));
        }
        userLoginOrder.add(user.getUserId());
    }

    public static void userLogout(User user) {
        switch (user.getUserType()) {
            case "Student" -> {
                for(StudentUser studentUser : studentUsers) {
                    if(studentUser.getUserId().equals(user.getUserId())) {
                        studentUsers.remove(studentUser);
                        break;
                    }
                }
            }
            case "Teacher" -> {
                for(TeacherUser teacherUser : teacherUsers) {
                    if(teacherUser.getUserId().equals(user.getUserId())) {
                        teacherUsers.remove(teacherUser);
                        break;
                    }
                }
            }
            case "Administrator" -> {
                for(AdministratorUser administratorUser : adminUsers) {
                    if(administratorUser.getUserId().equals(user.getUserId())) {
                        adminUsers.remove(administratorUser);
                        break;
                    }
                }
            }
        }
        userLoginOrder.remove(user.getUserId());
    }

    public static void userLogoutByOrder() {
        while(!userLoginOrder.isEmpty()) {
            String userId = userLoginOrder.get(0);
            System.out.println(userId + " Bye~");
            userLoginOrder.remove(userId);
        }
    }
}
