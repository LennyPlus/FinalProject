package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;
    private List<Integer> finalScores;

    private static int nextId = 0;

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }

    /**
     * Checks if the sum of weights of all assignments of a course equals to 100%
     * @return True if it does, otherwise false
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0;
        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }
        return sum == 100.0;
    }

    /**
     * Adds a student to the student list of the course
     * Adds a new null element to each assignment of this course
     * Add a new null element for the finalScores
     * @param student
     * @return
     */
    public boolean registerStudent(Student student) {
        if(registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }
        finalScores.add(null);
        return true;
    }

    /**
     * Calculates the weighted average score of all students in this course
     * @return An array with the weighted average score of all students
     */
    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];
        for (int i = 0; i < registeredStudents.size(); i++) {
            double weightedSum = 0;
            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    weightedSum += score * (assignment.getWeight() / 100.0);
                }
            }
            averages[i] = (int) weightedSum;
        }
        return averages;
    }

    /**
     * Adds a new assignment to the course
     * @param assignmentName Name of the assignment to add
     * @param weight Weight of the assignment to add
     * @return Always true
     */
    public boolean addAssignment(String assignmentName, double weight) {
        Assignment newAssignment = new Assignment(assignmentName, weight);

        for (int i = 0; i < registeredStudents.size(); i++) {
            newAssignment.getScores().add(null);
        }

        assignments.add(newAssignment);

        return true;
    }

    /**
     * Generates random scores for each assignment and student, and calculates the final score for each student
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }

        int[] avgs = calcStudentsAverage();

        for (int i = 0; i < finalScores.size(); i++) {
            finalScores.add(avgs[i]);
        }
    }

    void displayScores() {
        System.out.printf("Course: %s (%s)\n", courseName, courseId);

        System.out.printf("%-20s", " ");
        for (Assignment assignment : assignments) {
            System.out.printf("%-15s", assignment.getAssignmentName());
        }
        System.out.printf("%-15s\n", "Final Score");

        int[] avgs = calcStudentsAverage();
        for (int i = 0; i < registeredStudents.size(); i++) {
            System.out.printf("%-20s", registeredStudents.get(i).getStudentName());
            for (Assignment assignment : assignments) {
                int score = assignment.getScores().get(i);
                System.out.printf("%-15s", score);
            }
            System.out.printf("%-15d\n", avgs[i]);
        }

        System.out.printf("%-20s", "Average");
        for (Assignment assignment : assignments) {
            System.out.printf("%-15f", assignment.calcAssignmentAvg());
        }
        System.out.println();
    }


    public String toSimplifiedString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", departmentName=" + department.getDepartmentName() +
                '}';
    }

    @Override
    public String toString() {
        String str = "Course{" +
                    "courseId='" + courseId + '\'' +
                    ", courseName='" + courseName + '\'' +
                    ", credits=" + credits +
                    ", departmentName=" + department.getDepartmentName() +
                    ", assignments=" + assignments.toString() +
                    ", isAssignmentWeightValid=" + isAssignmentWeightValid() +
                    ", registeredStudents=";
        for (Student student : registeredStudents) {
            str += student.toSimplifiedString();
        }
        return str;
    }
}
