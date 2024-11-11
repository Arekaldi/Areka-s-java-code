import Command.CommandSentence;
import Functions.Function;
import Orders.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        File folder = new File("./data");
        if (!folder.exists()) {
            folder.mkdir();
        }
        while(true) {
            String inputCommandSentence = input.nextLine();
            if(inputCommandSentence.isEmpty())
                continue;
            CommandSentence.setInputCommandSentence(inputCommandSentence);
            if(!CommandSentence.commandCheck())
                continue;
            String order = CommandSentence.getCommandOrder();
            String[] orderArgs = CommandSentence.getCommandArgs();
            if(order.equals("register"))
                Register.userRegister(orderArgs);
            if(order.equals("login"))
                Login.userLogin(orderArgs);
            if(order.equals("logout"))
                Logout.userLogout(orderArgs);
            if(order.equals("printInfo"))
                PrintInfo.printInfo(orderArgs);
            if(order.equals("createCourse"))
                CreateCourse.createCourse(orderArgs);
            if(order.equals("listCourse"))
                ListCourse.listCourse(orderArgs);
            if(order.equals("selectCourse"))
                SelectCourse.selectCourse(orderArgs);
            if(order.equals("cancelCourse"))
                CancelCourse.cancelCourse(orderArgs);
            if(order.equals("inputCourseBatch"))
                InputCourseBatch.inputCourseBatch(orderArgs);
            if(order.equals("outputCourseBatch"))
                OutputCourseBatch.outputCourseBatch(orderArgs);
            if(order.equals("switch"))
                Switch.switchUser(orderArgs);
            if(order.equals("listStudent"))
                ListStudent.listStudent(orderArgs);
            if(order.equals("removeStudent"))
                RemoveStudent.removeStudent(orderArgs);
            if(order.equals("listCourseSchedule"))
                ListCourseSchedule.listCourseSchedule(orderArgs);
            if(order.equals("quit")) {
                Quit.quit();
                break;
            }
        }
        input.close();
        Function.deleteDir(folder);
    }
}
