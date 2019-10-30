package io.zipcoder;

import java.util.*;

public class Classroom {

    private Student[] students;

    public Classroom(Integer maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    public  Double getAverageExamScore() {

        int count = 0;
        Double sum = 0.0;
        for (int i = 0; i < students.length; i++) {
            if(students[i] != null) {
                count++;
                sum += students[i].getAverageExamScore();
            }
        }
        return sum / count;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if(students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
        boolean removed = false;

        for (int i = 0; i < students.length; i++) {
            if(removed) {
                students[i - 1] = students[i];
                students[i] = null;
            }
            else if(students[i] != null) {
                if( students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName)) {
                    students[i] = null;
                    removed = true;
                    System.out.println("hi");
                }
            }
        }
    }

    public Student[] getStudentsByScore() {
        Arrays.sort(this.students, Collections.reverseOrder());
        return students;
    }

    public Map<String, ArrayList<Student>> getGradeBook() {

        TreeMap<String, ArrayList<Student>> gradeBook = new TreeMap<>();
        gradeBook.put("A", new ArrayList<>());
        gradeBook.put("B", new ArrayList<>());
        gradeBook.put("C", new ArrayList<>());
        gradeBook.put("D", new ArrayList<>());
        gradeBook.put("F", new ArrayList<>());

        Student[] sortedStudents = this.getStudentsByScore();

        for (int i = 0; i < sortedStudents.length; i++) {
            if(sortedStudents[i] != null) {
                double percentile = (sortedStudents.length - i) / (double)sortedStudents.length;
                System.out.println(percentile);
                if(percentile >= .9) {
                    gradeBook.get("A").add(sortedStudents[i]);
                } else if(percentile > .7) {
                    gradeBook.get("B").add(sortedStudents[i]);
                } else if(percentile >= .5) {
                    gradeBook.get("C").add(sortedStudents[i]);
                } else if (percentile > .1) {
                    gradeBook.get("D").add(sortedStudents[i]);
                } else {
                    gradeBook.get("F").add(sortedStudents[i]);
                }
            }
        }
        return gradeBook;
    }

}
