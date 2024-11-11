package Orders;

import Courses.Course;
import Courses.CourseCreatedInfo;
import UsersActive.UsersActive;
import UsersInfo.StudentUser;

import java.util.Arrays;
import java.util.List;

public class ListStudent {
    public static void listStudent(String[] orderArgs) {
        if(UsersActive.activeUserIsNull()) {
            System.out.println("No one is online");
            return;
        }
        if(UsersActive.getActiveUser().getUserType().equals("Student")) {
            System.out.println("Permission denied");
            return;
        }
        Course targetCourse = new Course();
        targetCourse.setCourseId(orderArgs[0]);
        if(!targetCourse.courseIdCheck()) {
            System.out.println("Illegal course id");
            return;
        }
        targetCourse = CourseCreatedInfo.getCreatedCourse(targetCourse.getCourseId());
        if(targetCourse == null) {
            System.out.println("Course does not exist");
            return;
        }
        if(UsersActive.getActiveUser().getUserType().equals("Teacher") && !targetCourse.getCourseCreator().getUserId().equals(UsersActive.getActiveUser().getUserId())) {
            System.out.println("Course does not exist");
            return;
        }
        List<StudentUser> studentList = targetCourse.getCourseStudents();
        if(studentList.isEmpty()) {
            System.out.println("Student does not select course");
            return;
        }
        StudentUser[] studentArray = studentList.toArray(new StudentUser[0]);
        Arrays.sort(studentArray, (s1, s2) -> {
            if(s1.getUserIdPriority() == s2.getUserIdPriority()) {
                return s1.getUserId().compareTo(s2.getUserId());
            }
            return -s1.getUserIdPriority() + s2.getUserIdPriority();
        });
        for(StudentUser studentUser : studentArray) {
            System.out.println(studentUser.getUserId() + ": " + studentUser.getUserName());
        }
        System.out.println("List student success");
        return;
    }
}
