package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private List<Integer> scores;

    private static int nextId = 0;

    public Assignment(String assignmentName, double weight) {
        this.assignmentId = String.format("%d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }

    /**
     * Calculates the average score for the assignment
     * @return The assignment average
     */
    public double calcAssignmentAvg() {
        if (scores == null || scores.isEmpty()) {
            return 0;
        }

        double sum = 0;

        for (int score : scores) {
            sum += score;
        }

        return sum / scores.size();
    }

    /**
     * Generates random scores for all students in an assignment
     */
    public void generateRandomScore() {
        if (scores == null) {
            return;
        }

        Random rand = new Random();
        int numberOfStudents = scores.size();

        for (int i = 0; i < numberOfStudents; i++) {
            int randNum = rand.nextInt(11);
            switch (randNum) {
                case 0 -> scores.set(i, rand.nextInt(60));
                case 1,2 -> scores.set(i, rand.nextInt(60,70));
                case 3,4 -> scores.set(i, rand.nextInt(70,80));
                case 5,6,7,8 -> scores.set(i, rand.nextInt(80,90));
                case 9,10 -> scores.set(i, rand.nextInt(90,100));
            }
        }
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
