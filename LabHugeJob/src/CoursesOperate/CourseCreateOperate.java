package CoursesOperate;

import Courses.Course;
import Courses.CourseCreatedInfo;
import UsersActive.UsersActive;
import UsersInfo.TeacherUser;
import UsersInfo.User;
import UsersInfo.UserRegisteredInfo;

import java.util.List;

public class CourseCreateOperate {
    public static void courseCreateCheck(Course course) {
        User activeUser = UsersActive.getActiveUser();
        if(UsersActive.activeUserIsNull()) {
            System.out.println("No one is online");
            return;
        }
        if(!activeUser.getUserType().equals("Teacher")) {
            System.out.println("Permission denied");
            return;
        }
        TeacherUser courseCreator = UserRegisteredInfo.getTeacherUser(activeUser.getUserId());
        course.setCourseCreator(courseCreator);
        if (courseCreator != null && !courseCreator.teacherHasCourseCheck()) {
            System.out.println("Course count reaches limit");
            return;
        }
        if(!course.courseNameCheck()) {
            System.out.println("Illegal course name");
            return;
        }
        // false if course name is in-unique
        List<Course> createdCourses = null;
        if (courseCreator != null) {
            createdCourses = courseCreator.getTeacherHasCourse();
        }
        if (createdCourses != null && !course.courseNameConflictCheck(createdCourses)) {
            System.out.println("Course name exists");
            return;
        }
        // false if course time is invalid
        if(!course.courseTimeCheck()) {
            System.out.println("Illegal course time");
            return;
        }
        if (createdCourses != null && !course.courseTimeConflictCheck(createdCourses)) {
            System.out.println("Course time conflicts");
            return;
        }
        if(!course.coursePriceCheck()) {
            System.out.println("Illegal course credit");
            return;
        }
        if(!course.courseStudyTimeCheck()) {
            System.out.println("Illegal course period");
            return;
        }
        int teacherHasCourseNumber = 0;
        if (courseCreator != null) {
            teacherHasCourseNumber = courseCreator.getTeacherHasCourseNumber();
        }
        if (courseCreator != null) {
            courseCreator.setTeacherHasCourseNumber(teacherHasCourseNumber + 1);
        }
        CourseCreatedInfo.addCreatedCourse(course);
        System.out.println("Create course success (courseId: " + course.getCourseId() + ")");
    }
}
