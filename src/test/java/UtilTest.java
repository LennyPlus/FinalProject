import org.example.Main;
import org.example.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilTest {
    @Test
    @DisplayName("testToTitleCase: one two -> One Two")
    void testToTitleCase1() {
        String input = "one two";
        String expected = "One Two";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("testToTitleCase: COMPUTER SCIENCE AND MATH -> Computer Science And Math")
    void testToTitleCase2() {
        String input = "COMPUTER SCIENCE AND MATH";
        String expected = "Computer Science And Math";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("testToTitleCase: null -> null")
    void testToTitleCase3() {
        String input = null;
        String expected = null;
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("testToTitleCase: \" \" -> \"\" ")
    void testToTitleCase4() {
        String input = " ";
        String expected = "";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("testToTitleCase: heLlO tHiS iS -> Hello This Is")
    void testToTitleCase5() {
        String input = "heLlO tHiS iS";
        String expected = "Hello This Is";
        String actual = Util.toTitleCase(input);

        Assertions.assertEquals(expected, actual);
    }

}
