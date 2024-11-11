package Orders;

import Courses.Course;
import Courses.CourseCreatedInfo;
import UsersActive.UsersActive;
import UsersInfo.StudentUser;
import UsersInfo.User;
import UsersInfo.UserRegisteredInfo;

import java.util.List;

public class RemoveStudent {
    public static void removeStudent(String[] orderArgs) {
        if(UsersActive.activeUserIsNull()) {
            System.out.println("No one is online");
            return;
        }
        if(UsersActive.getActiveUser().getUserType().equals("Student")) {
            System.out.println("Permission denied");
            return;
        }
        User targetUser = new User();
        targetUser.setUserId(orderArgs[0]);
        if(!targetUser.userIdCheck()) {
            System.out.println("Illegal user id");
            return;
        }
        if(!UserRegisteredInfo.userIsRegistered(targetUser.getUserId())) {
            System.out.println("User does not exist");
            return;
        }
        targetUser = UserRegisteredInfo.getUser(targetUser.getUserId());
        if (targetUser != null && !targetUser.getUserType().equals("Student")) {
            System.out.println("User id does not belong to a Student");
            return;
        }
        assert targetUser != null;
        StudentUser student = UserRegisteredInfo.getStudentUser(targetUser.getUserId());
        assert student != null;
        User activeUser = UsersActive.getActiveUser();

        if(activeUser.getUserType().equals("Teacher")) {
            List<Course> selectedCourses = student.getSelectedCourseByTeacher(activeUser.getUserId());
            if(orderArgs.length == 1) {
                if(selectedCourses.isEmpty()) {
                    System.out.println("Student does not select course");
                    return;
                }
                for(Course course : selectedCourses) {
                    course.removeStudent(student);
                    student.removeSelectedCourse(course);
                }
                System.out.println("Remove student success");
            }
            else {
                Course targetCourse = new Course();
                targetCourse.setCourseId(orderArgs[1]);
                if(!targetCourse.courseIdCheck()) {
                    System.out.println("Illegal course id");
                    return;
                }
                targetCourse = CourseCreatedInfo.getCreatedCourse(targetCourse.getCourseId());
                if(targetCourse == null) {
                    System.out.println("Course does not exist");
                    return;
                }
                if(activeUser.getUserType().equals("Teacher") && !targetCourse.getCourseCreator().getUserId().equals(activeUser.getUserId())) {
                    System.out.println("Course does not exist");
                    return;
                }
                if(!selectedCourses.contains(targetCourse)) {
                    System.out.println("Student does not select course");
                    return;
                }
                targetCourse.removeStudent(student);
                student.removeSelectedCourse(targetCourse);
                System.out.println("Remove student success");
            }
        }
        else {
            List<Course> selectedCourses = student.getSelectedCourses();
            if(orderArgs.length == 1) {
                if(selectedCourses.isEmpty()) {
                    System.out.println("Student does not select course");
                    return;
                }
                for(Course selectedCourse : selectedCourses) {
                    selectedCourse.removeStudent(student);
                }
                student.removeAllSelectedCourse();
                System.out.println("Remove student success");
            }
            else {
                Course targetCourse = new Course();
                targetCourse.setCourseId(orderArgs[1]);
                if(!targetCourse.courseIdCheck()) {
                    System.out.println("Illegal course id");
                    return;
                }
                targetCourse = CourseCreatedInfo.getCreatedCourse(targetCourse.getCourseId());
                if(targetCourse == null) {
                    System.out.println("Course does not exist");
                    return;
                }
                if(!selectedCourses.contains(targetCourse)) {
                    System.out.println("Student does not select course");
                    return;
                }
                targetCourse.removeStudent(student);
                student.removeSelectedCourse(targetCourse);
                System.out.println("Remove student success");
            }
        }
    }
}
