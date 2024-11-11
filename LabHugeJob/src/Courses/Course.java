package Courses;

//import

import Functions.Function;
import UsersInfo.StudentUser;
import UsersInfo.TeacherUser;

import java.util.ArrayList;
import java.util.List;

public class Course {
    TeacherUser courseCreator = new TeacherUser();
    private String courseName;
    private String courseTime;
    private double coursePrice;
    private int courseStudyTime;
    private String courseId;
    private int courseIdNumber;
    private List<StudentUser> courseStudents = new ArrayList<StudentUser>();

    public void addStudent(StudentUser student) {
        courseStudents.add(student);
    }
    public void removeStudent(StudentUser student) {
        courseStudents.remove(student);
    }
    public List<StudentUser> getCourseStudents() {
        return courseStudents;
    }

    public boolean isCourseFull() {
        return (courseStudents.size() >= 30);
    }

    public Course() {}
    public Course(TeacherUser courseCreator, String courseName, String courseTime, double coursePrice, int courseStudyTime) {
        this.courseCreator = courseCreator;
        this.courseName = courseName;
        this.courseTime = courseTime;
        this.coursePrice = coursePrice;
        this.courseStudyTime = courseStudyTime;
    }

    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getCourseIdNumber() {
        return courseIdNumber;
    }
    public void setCourseIdNumber(int courseIdNumber) {
        this.courseIdNumber = courseIdNumber;
    }

    public TeacherUser getCourseCreator() {
        return courseCreator;
    }
    public void setCourseCreator(TeacherUser courseCreator) {
        this.courseCreator = courseCreator;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseTime() {
        return courseTime;
    }
    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }
    public double getCoursePrice() {
        return coursePrice;
    }
    public void setCoursePrice(double coursePrice) {
        this.coursePrice = coursePrice;
    }
    public int getCourseStudyTime() {
        return courseStudyTime;
    }
    public void setCourseStudyTime(int courseStudyTime) {
        this.courseStudyTime = courseStudyTime;
    }

    public boolean courseNameCheck() {
        boolean hasNum, hasLetter, hasSpecialChar;
        hasNum = hasLetter = hasSpecialChar = false;
        if(!Character.isLetter(courseName.charAt(0)))
            return false;
        if(courseName.isEmpty() || courseName.length() > 20)
            return false;
        for (int i = 0; i < courseName.length(); i++) {
            if (Character.isDigit(courseName.charAt(i))) {
                hasNum = true;
            }
            else if (Character.isLetter(courseName.charAt(i))) {
                hasLetter = true;
            }
            else if(courseName.charAt(i) == '-' || courseName.charAt(i) == '_') {
                hasSpecialChar = true;
            }
            else
                return false;
        }
        return hasLetter;
    }

    public boolean courseNameConflictCheck(List<Course> courses) {
        if(courses.isEmpty())
            return true;
        for(Course course : courses) {
            if(course.getCourseName().equals(courseName)) {
                return false;
            }
        }
        return true;
    }

    private int[] getCourseTimeInfoByString(String courseTime) {
        int[] res = new int[3];
        String[] courseTimeInfo = courseTime.split("[_\\-]");
        res[0] = Function.getNumberByString(courseTimeInfo[0]);
        res[1] = Function.getNumberByString(courseTimeInfo[1]);
        res[2] = Function.getNumberByString(courseTimeInfo[2]);
        return res;
    }

    private boolean courseTimeConflictCheck(String courseTime1, String courseTime2) {
         int[] courseTime1Info = getCourseTimeInfoByString(courseTime1);
         int[] courseTime2Info = getCourseTimeInfoByString(courseTime2);
         if(courseTime1Info[0] == courseTime2Info[0]) {
             return ((courseTime1Info[1] <= courseTime2Info[1]) && (courseTime1Info[2] <= courseTime2Info[2]) && (courseTime2Info[1] <= courseTime1Info[2]))
                     ||
                     ((courseTime2Info[1] <= courseTime1Info[1]) && (courseTime2Info[2] <= courseTime1Info[2]) && (courseTime1Info[1] <= courseTime2Info[2]));
         }
         return false;
    }

    public boolean courseTimeCheck() {
        int[] courseTimeInfo = getCourseTimeInfoByString(courseTime);
        if(courseTimeInfo[0] < 1 || courseTimeInfo[0] > 7)
                return false;
        if(courseTimeInfo[1] < 1 || courseTimeInfo[1] > 14)
            return false;
        if(courseTimeInfo[2] < 1 || courseTimeInfo[2] > 14)
            return false;
        return courseTimeInfo[1] <= courseTimeInfo[2];
    }

    public boolean courseTimeConflictCheck(List<Course> courses) {
        for(Course course : courses) {
            if(courseTimeConflictCheck(courseTime, course.getCourseTime())) {
                return false;
            }
        }
        return true;
    }

    public boolean coursePriceCheck() {
        return (coursePrice > 0.0 && coursePrice <= 12.0);
    }

    public boolean courseStudyTimeCheck() {
        return (courseStudyTime > 0 && courseStudyTime <= 1280);
    }

    public boolean courseIdCheck() {
        if(!courseId.isEmpty() && courseId.length() > 2) {
            if(courseId.charAt(0) == 'C' && courseId.charAt(1) == '-') {
                boolean isFirstZero = false;
                for(int i = 2; i < courseId.length(); ++i) {
                    if(!Character.isDigit(courseId.charAt(i))) {
                        return false;
                    }
                    if(courseId.charAt(i) == '0' && !isFirstZero)
                        return false;
                    if(courseId.charAt(i) > '0' && courseId.charAt(i) <= '9')
                        isFirstZero = true;
                }
                return true;
            }
        }
        return false;
    }

    // Arg:1 when user is a teacher
    public void printCourseInfo(int Arg) {
        if(Arg == 1)
            System.out.println(courseId + " " + courseName + " " + courseTime + " " + coursePrice + " " + courseStudyTime);
        else
            System.out.println(courseCreator.getUserName() + " " + courseId + " " + courseName + " " + courseTime + " " + coursePrice + " " + courseStudyTime);
    }

}
