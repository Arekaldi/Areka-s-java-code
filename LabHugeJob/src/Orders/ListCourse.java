package Orders;

import Courses.Course;
import Courses.CourseCreatedInfo;
import UsersActive.UsersActive;
import UsersInfo.TeacherUser;
import UsersInfo.User;
import UsersInfo.UserRegisteredInfo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListCourse {
    public static void listCourse(String[] orderArgs) {
        User activeUser = UsersActive.getActiveUser();
        if(UsersActive.activeUserIsNull()) {
            System.out.println("No one is online");
            return;
        }
        if(orderArgs.length == 0) {
            if(activeUser.getUserType().equals("Teacher")) {
                TeacherUser teacherUser = UserRegisteredInfo.getTeacherUser(activeUser.getUserId());
                if (teacherUser != null) {
                    List<Course> courses = teacherUser.getTeacherHasCourse();
                    if(courses.isEmpty()) {
                        System.out.println("Course does not exist");
                        return;
                    }
                    Course[] courseArray = courses.toArray(new Course[0]);
                    Arrays.sort(courseArray, Comparator.comparingInt(Course::getCourseIdNumber));
                    for(Course course : courseArray)
                        course.printCourseInfo(1);
                    System.out.println("List course success");
                    return;
                }
            }
            else {
                List<Course> courses = CourseCreatedInfo.getCreatedCourses();
                if(courses.isEmpty()) {
                    System.out.println("Course does not exist");
                    return;
                }
                Course[] courseArray = courses.toArray(new Course[0]);
                Arrays.sort(courseArray, (c1, c2) -> {
                    if(c1.getCourseCreator().getUserName().compareTo(c2.getCourseCreator().getUserName()) == 0) {
                        return c1.getCourseIdNumber() - c2.getCourseIdNumber();
                    }
                    else
                        return c1.getCourseCreator().getUserName().compareTo(c2.getCourseCreator().getUserName());
                });
                for(Course course : courseArray)
                    course.printCourseInfo(2);
                System.out.println("List course success");
                return;
            }
        }
        else {
            User newUser = new User();
            newUser.setUserId(orderArgs[0]);
            if(!activeUser.getUserType().equals("Administrator")) {
                System.out.println("Permission denied");
                return;
            }
            if(!newUser.userIdCheck()) {
                System.out.println("Illegal user id");
                return;
            }
            if(!UserRegisteredInfo.userIsRegistered(newUser.getUserId())) {
                System.out.println("User does not exist");
                return;
            }
            User targetUser = UserRegisteredInfo.getUser(orderArgs[0]);
            if (targetUser != null && !targetUser.getUserType().equals("Teacher")) {
                System.out.println("User id does not belong to a Teacher");
                return;
            }
            TeacherUser teacherUser = null;
            if (targetUser != null) {
                teacherUser = UserRegisteredInfo.getTeacherUser(targetUser.getUserId());
            }
            List<Course> courses = null;
            if (teacherUser != null) {
                courses = teacherUser.getTeacherHasCourse();
            }
            if (courses != null && courses.isEmpty()) {
                System.out.println("Course does not exist");
                return;
            }
            Course[] courseArray = null;
            if (courses != null) {
                courseArray = courses.toArray(new Course[0]);
            }
            if (courseArray != null) {
                Arrays.sort(courseArray, (c1, c2) -> {
                    if(c1.getCourseCreator().getUserName().compareTo(c2.getCourseCreator().getUserName()) == 0) {
                        return c1.getCourseIdNumber() - c2.getCourseIdNumber();
                    }
                    else
                        return c1.getCourseCreator().getUserName().compareTo(c2.getCourseCreator().getUserName());
                });
            }
            if (courseArray != null) {
                for(Course course : courseArray)
                    course.printCourseInfo(2);
            }
            System.out.println("List course success");
            return;
        }
    }
}
