package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class Department {
    private String departmentId;
    @Setter
    private String departmentName;

    private static int nextId = 0;

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentId = String.format("%d", nextId++);
            this.departmentName = departmentName;
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    /**
     * Checks if a department name is valid or not
     * A department name should only contain letters or spaces
     * @param departmentName The department name to be checked
     * @return True if the name is valid, otherwise false
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null) {
            return false;
        }

        for (char c : departmentName.toCharArray()) {
            if (!Character.isDigit(c) && c != ' ') {
                return false;
            }
        }

        return true;
    }
}
