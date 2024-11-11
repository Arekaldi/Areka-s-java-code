package CoursesOperate;

import Courses.Course;
import Courses.CourseCreatedInfo;
import UsersActive.UsersActive;
import UsersInfo.TeacherUser;
import UsersInfo.UserRegisteredInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class CourseInputOperate {
    public static void courseInput(File inputFile) throws FileNotFoundException {
        Scanner in = new Scanner(inputFile);
        while(in.hasNextLine()) {
            String[] inputCourseArgs = in.nextLine().split(" ");
            String courseName = inputCourseArgs[0];
            String courseTime = inputCourseArgs[1];
            String coursePriceString = inputCourseArgs[2];
            double coursePrice = Double.parseDouble(coursePriceString);
            String courseStudyTimeString = inputCourseArgs[3];
            int courseStudyTime = Integer.parseInt(courseStudyTimeString);
            TeacherUser courseCreator = UserRegisteredInfo.getTeacherUser(UsersActive.getActiveUser().getUserId());
            Course targetCourse = new Course(courseCreator, courseName, courseTime, coursePrice, courseStudyTime);
            List<Course> createdCourses = null;
            if(courseCreator != null) {
                createdCourses = courseCreator.getTeacherHasCourse();
            }
            if(createdCourses != null && !targetCourse.courseNameConflictCheck(createdCourses)) {
                System.out.println("Course name already exists");
                continue;
            }
            if(createdCourses != null && !targetCourse.courseTimeConflictCheck(createdCourses)) {
                System.out.println("Course time conflicts");
                continue;
            }
            if(courseCreator != null && !courseCreator.teacherHasCourseCheck()) {
                System.out.println("Course count reaches limit");
                break;
            }
            CourseCreatedInfo.addCreatedCourse(targetCourse);
            if(courseCreator != null) {
                courseCreator.setTeacherHasCourseNumber(courseCreator.getTeacherHasCourseNumber() + 1);
            }
            System.out.println("Create course success (courseId: " + targetCourse.getCourseId() + ")");
        }
        in.close();
        System.out.println("Input course batch success");
    }
}
