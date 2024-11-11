package CoursesOperate;

import Courses.Course;
import Courses.CourseCreatedInfo;
import UsersActive.UsersActive;
import UsersInfo.StudentUser;
import UsersInfo.TeacherUser;
import UsersInfo.User;
import UsersInfo.UserRegisteredInfo;

import java.util.List;

public class CourseCancelOperate {
    public static void cancelCourseCheck(String courseId) {
        User activeUser = UsersActive.getActiveUser();
        if(UsersActive.activeUserIsNull()) {
            System.out.println("No one is online");
            return;
        }
        Course course = new Course();
        course.setCourseId(courseId);
        if(!course.courseIdCheck()) {
            System.out.println("Illegal course id");
            return;
        }
        if(activeUser.getUserType().equals("Administrator")) {
            Course targetCourse = CourseCreatedInfo.getCreatedCourse(courseId);
            if(targetCourse == null) {
                System.out.println("Course does not exist");
                return;
            }
            CourseCreatedInfo.deleteCreatedCourse(targetCourse);
        }
        else if(activeUser.getUserType().equals("Student")) {
            StudentUser studentUser = UserRegisteredInfo.getStudentUser(activeUser.getUserId());
            List<Course> studentCourses = null;
            if (studentUser != null) {
                studentCourses = studentUser.getSelectedCourses();
            }
            Course targetCourse = null;
            if (studentCourses != null) {
                for(Course studentCourse : studentCourses) {
                    if(studentCourse.getCourseId().equals(courseId)) {
                        targetCourse = studentCourse;
                        break;
                    }
                }
            }
            if(targetCourse == null) {
                System.out.println("Course does not exist");
                return;
            }
            studentUser.removeSelectedCourse(targetCourse);
            targetCourse.removeStudent(studentUser);
        }
        else {
            TeacherUser teacherUser = UserRegisteredInfo.getTeacherUser(activeUser.getUserId());
            List<Course> teachersCourses = null;
            if (teacherUser != null) {
                teachersCourses = teacherUser.getTeacherHasCourse();
            }
            Course targetCourse = null;
            if (teachersCourses != null) {
                for(Course teachersCourse : teachersCourses) {
                    if(teachersCourse.getCourseId().equals(courseId)) {
                        targetCourse = teachersCourse;
                        break;
                    }
                }
            }
            if(targetCourse == null) {
                System.out.println("Course does not exist");
                return;
            }
            CourseCreatedInfo.deleteCreatedCourse(targetCourse);
        }
        System.out.println("Cancel course success (courseId: " + courseId + ")");
        return;
    }
}
