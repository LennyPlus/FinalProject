package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private List<Course> registeredCourses;

    private static int nextId = 0;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId);
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * Adds the course to the student's registeredCourses list
     * Adds the student to the course's registeredStudents list
     * Appends a null value for the scores of each assignment of the course
     * If the course already exists in the student's registeredCourses list, return false without adding anything
     * @param course The course to be added
     * @return False if the course is already registered, otherwise true
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);

        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().add(null);
        }

        return true;
    }

    /**
     * Drops a course
     * @param course The course to be dropped
     * @return False if the course isn't registered yet, otherwise true
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.remove(course);

        course.getRegisteredStudents().remove(this);
        return true;
    }

    public String toSimplifiedString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", department=" + department.getDepartmentName() +
                '}';
    }

    @Override
    public String toString() {
        String str =  "Student{" +
                    "studentId='" + studentId + '\'' +
                    ", studentName='" + studentName + '\'' +
                    ", gender=" + gender +
                    ", address=" + address +
                    ", department=" + department +
                    ", registeredCourses=";
        for (Course course : registeredCourses) {
            str += course.toSimplifiedString();
        }
        return str;
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}
