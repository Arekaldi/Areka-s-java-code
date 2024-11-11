package UsersInfo;
import java.util.ArrayList;
import java.util.List;

public class UserRegisteredInfo {
    private static List<StudentUser> studentUsers = new ArrayList<>();
    private static List<TeacherUser> teacherUsers = new ArrayList<>();
    private static List<AdministratorUser> adminUsers = new ArrayList<>();

    public static boolean userIsRegistered(String userId) {
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

    public static User getUser(String userId) {
        if(userId.length() == 8 || userId.length() == 9) {
            return getStudentUser(userId);
        }
        else if(userId.length() == 5) {
            if (userId.charAt(0) != 'A') {
                return getTeacherUser(userId);
            } else {
                return getAdminUser(userId);
            }
        }
        else
            return null;
    }

    public static StudentUser getStudentUser(String userId) {
        for(StudentUser studentUser : studentUsers) {
            if(studentUser.getUserId().equals(userId))
                return studentUser;
        }
        return null;
    }

    public static TeacherUser getTeacherUser(String userId) {
        for(TeacherUser teacherUser : teacherUsers) {
            if(teacherUser.getUserId().equals(userId))
                return teacherUser;
        }
        return null;
    }

    public static AdministratorUser getAdminUser(String userId) {
        for(AdministratorUser adminUser : adminUsers) {
            if(adminUser.getUserId().equals(userId))
                return adminUser;
        }
        return null;
    }

    public static void userRegister(User user) {
        switch (user.getUserType()) {
            case "Student" -> studentUsers.add(new StudentUser(user));
            case "Teacher" -> teacherUsers.add(new TeacherUser(user));
            case "Administrator" -> adminUsers.add(new AdministratorUser(user));
        }
    }

}
