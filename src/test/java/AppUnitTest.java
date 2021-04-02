import com.napier.sem.App;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.sql.*;
import java.util.Scanner;

class AppUnitTest
{
    static App app;

    // Create App instance and connect to database
    @BeforeAll
    static void init ()
    {
        app = new App();
        try
        {
            app.connect("localhost:33060");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    // Test that a readable file can be read
    @Test
    void getQuery_FileReadableTest ()
    {
        assertNotNull(app.getQuery("test1"));
    }

    // Test that a non-readable file returns null
    @Test
    void getQuery_FileNotReadableTest ()
    {
        assertNull(app.getQuery("test0"));
    }

    // Test that getQuery doesn't read comments by comparing two identical files other than a 1 line comment
    @Test
    void getQuery_SkipCommentTest ()
    {
        assertEquals(app.getQuery("test1"), app.getQuery("test2"));
    }

    // Test if executeQuery returns results for a valid sql statement
    @Test
    void executeQuery_ResultsTest ()
    {
        assertNotNull(app.executeQuery("SELECT 1;"));
    }

    // Test if executeQuery returns results for a valid sql statement with no results
    @Test
    void executeQuery_NoResultsTest () 
    {
        assertNull(app.executeQuery("SELECT * FROM elvis;"));
    }

    // Test if executeQuery returns results for a non valid sql statement
    @Test
    void executeQuery_NonValidStatementTest ()
    {
        assertNull(app.executeQuery("This is not a query"));
    }
    
    // Test if writeQuery writes results to file
    @Test
    void writeQuery_ResultsTest () 
    {
        app.writeQuery(app.executeQuery("SELECT 1;"), 1, "test-query-results");

        try
        {
            // Create filepath from filename
            File file = new File("test-query-results.csv");
            // Create new Scanner
            Scanner scanner = new Scanner(file);

            assertEquals("1", scanner.nextLine());
            assertEquals("1", scanner.nextLine());
            scanner.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    // Test writeQuery writes null to file
    void writeQuery_NoResultsTest ()
    {
        app.writeQuery(null, 2, "test-query-results");

        try
        {
            // Create filepath from filename
            File file = new File("test-query-results.csv");
            // Create new Scanner
            Scanner scanner = new Scanner(file);

            assertNull(scanner.nextLine());
            scanner.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    // Disconnects from database
    @AfterAll
    static void disconnect ()
    { 
        try 
        {
            app.disconnect();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    // Deletes test csv file
    @AfterAll
    static void deleteTestFile ()
    {
        try
        {
            File file = new File("./test-query-results.csv");
            if (file.delete())
                System.out.println("Test csv deleted.");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}