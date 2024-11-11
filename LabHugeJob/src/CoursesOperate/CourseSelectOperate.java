package CoursesOperate;

import Courses.Course;
import Courses.CourseCreatedInfo;
import UsersActive.UsersActive;
import UsersInfo.StudentUser;
import UsersInfo.User;
import UsersInfo.UserRegisteredInfo;

import java.util.List;

public class CourseSelectOperate {
    public static void selectCourse(String courseId) {
        Course course = new Course();
        course.setCourseId(courseId);
        if(UsersActive.activeUserIsNull()) {
            System.out.println("No one is online");
            return;
        }
        User activeUser = UsersActive.getActiveUser();
        if(!activeUser.getUserType().equals("Student")) {
            System.out.println("Permission denied");
            return;
        }

        if(!course.courseIdCheck()) {
            System.out.println("Illegal course id");
            return;
        }

        Course targetCourse = CourseCreatedInfo.getCreatedCourse(courseId);
        StudentUser studentUser = UserRegisteredInfo.getStudentUser(activeUser.getUserId());
        List<Course> studentCourses = null;
        if (studentUser != null) {
            studentCourses = studentUser.getSelectedCourses();
        }
        if(targetCourse == null) {
            System.out.println("Course does not exist");
            return;
        }
        if (studentCourses != null && !targetCourse.courseTimeConflictCheck(studentCourses)) {
            System.out.println("Course time conflicts");
            return;
        }
        if(targetCourse.isCourseFull()) {
            System.out.println("Course capacity is full");
            return;
        }
        if (studentUser != null) {
            studentUser.addSelectedCourse(targetCourse);
        }
        targetCourse.addStudent(studentUser);
        System.out.println("Select course success (courseId: " + courseId + ")");
    }
}
