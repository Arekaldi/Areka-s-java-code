package Question03;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var students = new Student[3];
        // step1. add data into this array
        students[0] = new Student("23371058", "罗文烨", 100.0);
        students[1] = new Student("23371173", "沈志鸣", 100.0);
        students[2] = new Student("23373475", "林日升", 100.0);
        // step2. write this array into file
        // step3. read students from file and print
        try {
            Student.writeIntoFile(students);
            try {
                var readStudents = Student.readFromFile("studentInfo.txt");
                for(Student stu : readStudents) {
                    System.out.println(Student.stringify(stu));
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

class Student {
    private String studentId;
    private String name;
    private double score;

    Student() {}

    Student(String id, String name, double score) {
        this.studentId = id;
        this.name = name;
        this.score = score;
    }

    public static String stringify(Student stu) {
        return stu.studentId + ',' + stu.name + ',' + stu.score;
    }

    public static Student parseStudent(String s) {
        String[] modifiedS = s.split(",");
        return new Student(modifiedS[0], modifiedS[1], Double.parseDouble(modifiedS[2]));
    }
    // constructor(s) and other methods ...
    public static void writeIntoFile(Student[] students) throws IOException {
        File f = new File("studentInfo.txt");
        BufferedWriter bfw = new BufferedWriter(new FileWriter(f));

        for(Student stu : students) {
            bfw.write(Student.stringify(stu));
            bfw.write('\n');
        }

        bfw.close();
    }
    public static Student[] readFromFile(String filePath) throws IOException {
        File f = new File(filePath);
        BufferedReader bfr = new BufferedReader(new FileReader(f));
        ArrayList <Student> stu = new ArrayList<>();
        while(bfr.ready())
            stu.add(Student.parseStudent(bfr.readLine()));
        bfr.close();
        return stu.toArray(new Student[0]);
    }
}