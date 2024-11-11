package Orders;

import Courses.Course;
import UsersActive.UsersActive;
import UsersInfo.StudentUser;
import UsersInfo.User;
import UsersInfo.UserRegisteredInfo;

import java.util.Arrays;
import java.util.List;

public class ListCourseSchedule {
    public static void listCourseSchedule(String[] orderArgs) {
        if(UsersActive.activeUserIsNull()) {
            System.out.println("No one is online");
            return;
        }
        User activeUser = UsersActive.getActiveUser();
        if(orderArgs.length == 0) {
            if(!activeUser.getUserType().equals("Student")) {
                System.out.println("Permission denied");
                return;
            }
            listStudentCourse(activeUser);
            return;
        }
        else {
            if(!activeUser.getUserType().equals("Administrator")) {
                System.out.println("Permission denied");
                return;
            }
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
            user = UserRegisteredInfo.getUser(user.getUserId());
            assert user != null;
            if(!user.getUserType().equals("Student")) {
                System.out.println("User id does not belong to a Student");
                return;
            }
            listStudentCourse(user);
        }
    }

    private static void listStudentCourse(User user) {
        StudentUser targetUser = UserRegisteredInfo.getStudentUser(user.getUserId());
        assert targetUser != null;
        List<Course> selectedCourses = targetUser.getSelectedCourses();
        if(selectedCourses.isEmpty()) {
            System.out.println("Student does not select course");
            return;
        }
        Course[] courses = selectedCourses.toArray(new Course[0]);
        Arrays.sort(courses, (c1, c2) -> {
            return c1.getCourseTime().compareTo( c2.getCourseTime());
        });
        for(Course course : courses) {
            System.out.println(course.getCourseTime() + " " + course.getCourseName() + " " + course.getCoursePrice() + " " + course.getCourseStudyTime() + " " + course.getCourseCreator().getUserName());
        }
        System.out.println("List course schedule success");
    }
}
