import com.napier.sem.App;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Scanner;

class AppUnitTest {
    static App app;

    /**
     * Creates app and connects to database to allow tests to run
     */
    @BeforeAll
    static void init() {
        app = new App();
        try {
            app.connect("localhost:33060");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Asserts that when a readable file (exists and has appropriate permissions) is passed to getQuery, it will return a non-null value.
     */
    @Test
    void getQuery_FileReadableTest() {
        assertNotNull(app.getQuery("test1"));
    }

    /**
     * Asserts that when a non-readable file (does not exist) is passed to getQuery, it will return null.
     */
    @Test
    void getQuery_FileNotReadableTest() {
        assertNull(app.getQuery("test0"));
    }

    /**
     * Asserts that getQuery drops comments when reading in a query by comparing two files where one has a comment but the files are otherwise identical. 
     */
    @Test
    void getQuery_SkipCommentTest() {
        assertEquals(app.getQuery("test1"), app.getQuery("test2"));
    }

    /**
     * Asserts that when a valid MySQL query is passed to executeQuery, it will return a non-null value.
     */
    @Test
    void executeQuery_ResultsTest() {
        assertNotNull(app.executeQuery("SELECT 1;"));
    }

    /**
     * Asserts that when a valid MySQL query, which has no results in the World database (table 'Elvis'), is passed to executeQuery, it will return null.
     */
    @Test
    void executeQuery_NoResultsTest() {
        assertNull(app.executeQuery("SELECT * FROM elvis;"));
    }

    /**
     * Asserts that when a non-valid MySQL query is passed to executeQuery, it will return null.
     */
    @Test
    void executeQuery_NonValidStatementTest() {
        assertNull(app.executeQuery("This is not a query"));
    }

    /**
     * Asserts that when a results set, returned by executeQuery, is passed to writeQuery will write the results to a csv file.
     */
    @Test
    void writeQuery_ResultsTest() {
        app.writeQuery(app.executeQuery("SELECT 1;"), 1, "test-query-results");

        try {
            // Create filepath from filename
            File file = new File("test-query-results.csv");
            // Create new Scanner
            Scanner scanner = new Scanner(file);

            assertEquals("1", scanner.nextLine());
            assertEquals("1", scanner.nextLine());
            scanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Asserts that when null is passed to writeQuery, it will not write anything to the csv file.
     */
    void writeQuery_NoResultsTest() {
        app.writeQuery(null, 2, "test-query-results");

        try {
            // Create filepath from filename
            File file = new File("test-query-results.csv");
            // Create new Scanner
            Scanner scanner = new Scanner(file);

            assertNull(scanner.nextLine());
            scanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Disconnects app from database.
     */
    @AfterAll
    static void disconnect() {
        try {
            app.disconnect();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Deletes csv file used to run tests.
     */
    @AfterAll
    static void deleteTestFile() {
        try {
            File file = new File("./test-query-results.csv");
            if (file.delete())
                System.out.println("Test csv deleted.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}