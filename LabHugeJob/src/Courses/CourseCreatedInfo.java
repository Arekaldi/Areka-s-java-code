package Courses;

import UsersInfo.StudentUser;
import UsersInfo.TeacherUser;

import java.util.ArrayList;
import java.util.List;

public class CourseCreatedInfo {
    private static int courseCreatedCount = 0;
    private static List<Course> createdCourses = new ArrayList<>();

    public static void createCourse(Course course) {
        TeacherUser courseCreator = course.getCourseCreator();
    }

    public static List<Course> getCreatedCourses() {
        return createdCourses;
    }

    public static Course getCreatedCourse(String courseId) {
            for (Course course : createdCourses) {
                if (course.getCourseId().equals(courseId)) {
                    return course;
                }
            }
            return null;
    }


    public static List<Course> getCreatedCoursesByTeacher(TeacherUser teacherUser) {
        List<Course> coursesByTeacher = new ArrayList<>();
        for (Course course : createdCourses) {
            if (course.getCourseCreator().equals(teacherUser)) {
                coursesByTeacher.add(course);
            }
        }
        return coursesByTeacher;
    }

    public static void addCreatedCourse(Course course) {
        course.setCourseId("C-" + (++courseCreatedCount));
        course.setCourseIdNumber(courseCreatedCount);
        createdCourses.add(course);
        return;
    }

    public static void deleteCreatedCourse(Course course) {
        List<StudentUser> students = course.getCourseStudents();
        for (StudentUser studentUser : students)
            studentUser.removeSelectedCourse(course);
        TeacherUser teacherUser = course.getCourseCreator();
        teacherUser.setTeacherHasCourseNumber(teacherUser.getTeacherHasCourseNumber() - 1);
        createdCourses.remove(course);
    }
}
