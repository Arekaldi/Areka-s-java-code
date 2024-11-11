package Orders;

import CoursesOperate.CourseInputOperate;
import UsersActive.UsersActive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputCourseBatch {
    public static void inputCourseBatch(String[] orderArgs) throws FileNotFoundException {
        File infile = new File("./data/" + orderArgs[0]);
        if(UsersActive.activeUserIsNull()) {
            System.out.println("No one is online");
            return;
        }
        if(!UsersActive.getActiveUser().getUserType().equals("Teacher")) {
            System.out.println("Permission denied");
            return;
        }
        if (!infile.exists()) {
            System.out.println("File does not exist");
            return;
        }
        if(infile.isDirectory()) {
            System.out.println("File is a directory");
            return;
        }
        CourseInputOperate.courseInput(infile);
        return;
    }
}
