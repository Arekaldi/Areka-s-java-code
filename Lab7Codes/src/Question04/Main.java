package Question04;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        var students = new Student[3];
        students[0] = new Student("23371058", "罗文烨", 100.0);
        students[1] = new Student("23371173", "沈志鸣", 100.0);
        students[2] = new Student("23373475", "林日升", 100.0);

        try {
            Student.serializeIntoFile(students, "studentInfo.txt");
            Student[] readStudents = Student.deserializeFromFile("studentInfo.txt");
            for (Student stu : readStudents) {
                System.out.println(stu);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

}

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String studentId;
    private String name;
    private double score;

    Student() {}

    Student(String id, String name, double score) {
        this.studentId = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return studentId + ',' + name + ',' + score;
    }

    public static void serializeIntoFile(Student[] students, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(students);
        }
    }

    public static Student[] deserializeFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Student[]) ois.readObject();
        }
    }
}