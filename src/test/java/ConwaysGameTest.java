import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ConwaysGameTest {

    public static City createCity(Scanner scanner) throws Exception {
        City city = new City();

        int people = 0;
        int totalPeople = city.getWidth() * city.getHeight();
        while (people < totalPeople) {
            boolean isAlive = scanner.next().equals("+");
            Person person = new Person(isAlive);
            city.insertPerson(person);
            people++;
        }

        return city;
    }

    @Test
    public void testBasic1() throws Exception {
        String input = new StringBuilder()
                .append("- - - - - - + - \n")
                .append("+ + + - - - + - \n")
                .append("- - - - - - + - \n")
                .append("- - - - - - - - \n")
                .append("- - - + + - - - \n")
                .append("- - - + + - - - \n").toString();
        String expectedResult = new StringBuilder()
                .append("- + - - - - - - \n")
                .append("- + - - - + + + \n")
                .append("- + - - - - - - \n")
                .append("- - - - - - - - \n")
                .append("- - - + + - - - \n")
                .append("- - - + + - - - \n").toString();
        InputStream fakeIn = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(fakeIn);

        City city = createCity(scanner);
        city.passTime();
        String result = city.toString();

        assertEquals(expectedResult, result);
    }

    @Test
    public void testBasic2() throws Exception {
        String input = new StringBuilder()
                .append("- + - + - + - + \n")
                .append("- + - + - + - + \n")
                .append("- + - + - + - + \n")
                .append("- + - + - + - + \n")
                .append("- + - + - + - + \n")
                .append("- + - + - + - + \n").toString();
        String expectedResult = new StringBuilder()
                .append("- - - - - - - - \n")
                .append("+ + - + - + - + \n")
                .append("+ + - + - + - + \n")
                .append("+ + - + - + - + \n")
                .append("+ + - + - + - + \n")
                .append("- - - - - - - - \n").toString();
        InputStream fakeIn = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(fakeIn);

        City city = createCity(scanner);
        city.passTime();
        String result = city.toString();

        assertEquals(expectedResult, result);
    }

    @Test
    public void testAllAlive() throws Exception {
        String input = new StringBuilder()
                .append("+ + + + + + + + \n")
                .append("+ + + + + + + + \n")
                .append("+ + + + + + + + \n")
                .append("+ + + + + + + + \n")
                .append("+ + + + + + + + \n")
                .append("+ + + + + + + + \n").toString();
        String expectedResult = new StringBuilder()
                .append("+ - - - - - - + \n")
                .append("- - - - - - - - \n")
                .append("- - - - - - - - \n")
                .append("- - - - - - - - \n")
                .append("- - - - - - - - \n")
                .append("+ - - - - - - + \n").toString();
        InputStream fakeIn = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(fakeIn);

        City city = createCity(scanner);
        city.passTime();
        String result = city.toString();

        assertEquals(expectedResult, result);

    }

    @Test
    public void testAllDead() throws Exception {
        String input = new StringBuilder()
                .append("- - - - - - - - \n")
                .append("- - - - - - - - \n")
                .append("- - - - - - - - \n")
                .append("- - - - - - - - \n")
                .append("- - - - - - - - \n")
                .append("- - - - - - - - \n").toString();
        String expectedResult = new StringBuilder()
                .append("- - - - - - - - \n")
                .append("- - - - - - - - \n")
                .append("- - - - - - - - \n")
                .append("- - - - - - - - \n")
                .append("- - - - - - - - \n")
                .append("- - - - - - - - \n").toString();
        InputStream fakeIn = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(fakeIn);

        City city = createCity(scanner);
        city.passTime();
        String result = city.toString();

        assertEquals(expectedResult, result);
    }

    @Test
    public void testSubsequentTurn() throws Exception {
        String input = new StringBuilder()
                .append("- - - - - - + - \n")
                .append("+ + + - - - + - \n")
                .append("- - - - - - + - \n")
                .append("- - - - - - - - \n")
                .append("- - - + + - - - \n")
                .append("- - - + + - - - \n").toString();
        String expectedResult = new StringBuilder()
                .append("- - - - - - + - \n")
                .append("+ + + - - - + - \n")
                .append("- - - - - - + - \n")
                .append("- - - - - - - - \n")
                .append("- - - + + - - - \n")
                .append("- - - + + - - - \n").toString();
        InputStream fakeIn = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(fakeIn);

        City city = createCity(scanner);
        city.passTime();
        city.passTime();
        String result = city.toString();

        assertEquals(expectedResult, result);

    }
}
