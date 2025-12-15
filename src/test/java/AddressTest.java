import org.example.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AddressTest {
    @Test
    @DisplayName("isPostalCodeValid: A1B2C3 -> true ")
    void testIsPostalCodeValid1() {
        String input = "A1B2C3";
        Boolean expected = true;
        Boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: 1A1B2C -> false ")
    void testIsPostalCodeValid2() {
        String input = "1A1B2C";
        Boolean expected = false;
        Boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: A1B2C -> false ")
    void testIsPostalCodeValid3() {
        String input = "A1B2C";
        Boolean expected = false;
        Boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: null -> false ")
    void testIsPostalCodeValid4() {
        String input = null;
        Boolean expected = false;
        Boolean actual = Address.isPostalCodeValid(input);

        Assertions.assertEquals(expected, actual);
    }
}
