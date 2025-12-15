import org.example.Address;
import org.example.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DepartmentTest {
    @Test
    @DisplayName("isDepartmentNameValid: Computer Science -> true ")
    void testIsDepartmentNameValid1() {
        String input = "Computer Science";
        Boolean expected = true;
        Boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: Computer Science 101 -> false ")
    void testIsDepartmentNameValid2() {
        String input = "Computer Science 101";
        Boolean expected = false;
        Boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: null -> null ")
    void testIsDepartmentNameValid3() {
        String input = null;
        Boolean expected = false;
        Boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid: \" \" -> false ")
    void testIsDepartmentNameValid4() {
        String input = " ";
        Boolean expected = false;
        Boolean actual = Department.isDepartmentNameValid(input);

        Assertions.assertEquals(expected, actual);
    }
}
