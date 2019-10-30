package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class ClassroomTest {
    @Test
    public void getAverageExamScore() {
        Double[] scores1 = {100.0, 100.0, 100.0};
        ArrayList<Double> scoresList1 = new ArrayList<Double>(Arrays.asList(scores1));
        Student student1 = new Student("Oi", "Yo", scoresList1);

        Double[] scores2 = {50.0, 75.0, 100.0};
        ArrayList<Double> scoresList2 = new ArrayList<Double>(Arrays.asList(scores2));
        Student student2 = new Student("Yep", "Bap", scoresList2);

        Classroom classRoom = new Classroom();
        classRoom.addStudent(student1);
        classRoom.addStudent(student2);

        Double expected = 87.5;
        Double actual = classRoom.getAverageExamScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addStudent() {
        Double[] scores1 = {100.0, 100.0, 100.0};
        ArrayList<Double> scoresList1 = new ArrayList<Double>(Arrays.asList(scores1));
        Student student1 = new Student("Oi", "Yo", scoresList1);

        Classroom classroom = new Classroom(1);
        classroom.addStudent(student1);

        Student[] students = classroom.getStudents();
        String out = Arrays.toString(students);

        System.out.println(out);
    }

    @Test
    public void removeStudent() {

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Oi", "Ao", new ArrayList<>(Arrays.asList(100.0, 90.0))));
        students.add(new Student("Qi", "So", new ArrayList<>(Arrays.asList(80.0, 80.0, 75.0))));
        students.add(new Student("Wi", "Do", new ArrayList<>(Arrays.asList(100.0, 100.0, 90.0))));

        Classroom classroom = new Classroom(students.toArray(new Student[3]));
        classroom.removeStudent("Qi", "So");

        String out = Arrays.toString(classroom.getStudents());
        System.out.println(out);
    }

    @Test
    public void getStudentsByScore() {

        Double[] scores1 = {100.0, 100.0, 100.0};
        ArrayList<Double> scoresList1 = new ArrayList<Double>(Arrays.asList(scores1));
        Student student1 = new Student("Oi", "Yo", scoresList1);

        Double[] scores2 = {20.0, 45.0, 100.0};
        ArrayList<Double> scoresList2 = new ArrayList<Double>(Arrays.asList(scores2));
        Student student2 = new Student("Yep", "Bap", scoresList2);

        Double[] scores3 = {100.0, 95.0, 80.0};
        ArrayList<Double> scoresList3 = new ArrayList<Double>(Arrays.asList(scores3));
        Student student3 = new Student("vdsvs", "Bap", scoresList3);

        Double[] scores4 = {70.0, 75.0, 70.0};
        ArrayList<Double> scoresList4 = new ArrayList<Double>(Arrays.asList(scores4));
        Student student4 = new Student("dfdasfds", "Bap", scoresList4);

        Classroom classRoom = new Classroom(10);
        classRoom.addStudent(student1);
        classRoom.addStudent(student2);
        classRoom.addStudent(student3);
        classRoom.addStudent(student4);

        classRoom.removeStudent("Yep", "Bap");

        Student[] students = classRoom.getStudentsByScore();
        String out = Arrays.toString(students);

        System.out.println(out);
    }

    @Test
    public void getGradeBook() {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Oi", "Ao", new ArrayList<>(Arrays.asList(100.0, 90.0))));
        students.add(new Student("Qi", "So", new ArrayList<>(Arrays.asList(80.0, 80.0, 75.0))));
        students.add(new Student("Wi", "Do", new ArrayList<>(Arrays.asList(100.0, 100.0, 90.0))));
        students.add(new Student("Ei", "Fo", new ArrayList<>(Arrays.asList(60.0))));
        students.add(new Student("Ri", "Go", new ArrayList<>(Arrays.asList(75.0))));
        students.add(new Student("Ti", "Ho", new ArrayList<>(Arrays.asList(40.0))));
        students.add(new Student("Yi", "Jo", new ArrayList<>(Arrays.asList(90.0))));
        students.add(new Student("Ui", "Ko", new ArrayList<>(Arrays.asList(20.0))));
        students.add(new Student("Pi", "Lo", new ArrayList<>(Arrays.asList(100.0, 70.0))));
        students.add(new Student("Ai", "Zo", new ArrayList<>(Arrays.asList(85.0, 75.0, 40.0))));

        Classroom classRoom = new Classroom(10);
        for (Student s : students) {
            classRoom.addStudent(s);
        }


        Map<String, ArrayList<Student>> map = classRoom.getGradeBook();
        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue().toString());
        }
    }
}
