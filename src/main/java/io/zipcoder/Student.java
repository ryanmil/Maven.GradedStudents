package io.zipcoder;

import java.util.ArrayList;

public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, ArrayList<Double> examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addExamScore(Double score) {
        examScores.add(score);
    }

    public void setExamScore(Integer index, Double score) {
        examScores.set(index, score);
    }

    public String getExamScores() {
        String output = "Exam Scores:\n";
        for (int i = 0; i < examScores.size(); i++) {
            output += "\tExam " + (i + 1) + " -> " + examScores.get(i) + "\n";
        }
        return output;
    }

    public Integer getNumberOfExamsTaken() {
        return  examScores.size();
    }

    public Double getAverageExamScore() {
        Double sum = 0.0;
        for (Double score : examScores) {
            sum += score;
        }
        return sum / examScores.size();
    }

    @Override
    public String toString() {
        String output = "Student Name: " + firstName + " " + lastName + "\n";
        output += "> Average Score: " + this.getAverageExamScore() + "\n";
        output += "> " + getExamScores();
        return output;
    }

    @Override
    public int compareTo(Student o) {
        if(this.getAverageExamScore() > o.getAverageExamScore()) {
            return 1;
        } else if (this.getAverageExamScore() < o.getAverageExamScore()) {
            return -1;
        } else {
            return (this.firstName + this.lastName).compareTo(o.firstName + o.lastName);
        }
    }
}
