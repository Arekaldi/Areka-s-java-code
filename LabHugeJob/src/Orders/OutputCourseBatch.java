package Orders;
import Courses.Course;
import UsersActive.UsersActive;
import UsersInfo.TeacherUser;
import UsersInfo.UserRegisteredInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class OutputCourseBatch {
    public static void outputCourseBatch(String[] orderArgs) throws FileNotFoundException {
        if(UsersActive.activeUserIsNull()) {
            System.out.println("No one is online");
            return;
        }
        if(!UsersActive.getActiveUser().getUserType().equals("Teacher")) {
            System.out.println("Permission denied");
            return;
        }
        TeacherUser teacherUser = UserRegisteredInfo.getTeacherUser(UsersActive.getActiveUser().getUserId());
        File outputFile = new File("./data/" + orderArgs[0]);
        PrintWriter output = new PrintWriter(outputFile);
        if (teacherUser != null) {
            List<Course> outputCourse = teacherUser.getTeacherHasCourse();
            for(Course course : outputCourse)
                output.println(course.getCourseName() + " " + course.getCourseTime() + " " + course.getCoursePrice() + " " + course.getCourseStudyTime());
        }
        output.close();
        System.out.println("Output course batch success");
    }
}
