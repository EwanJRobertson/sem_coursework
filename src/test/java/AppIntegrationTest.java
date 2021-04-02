import com.napier.sem.App;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;
import java.io.File;
import java.util.Scanner;

public class AppIntegrationTest
{
    static App app;

    // Create App instance and connect to database
    @BeforeAll
    static void initApp ()
    {
        app = new App();
    }
    
    // Connect to database
    @BeforeEach
    void initConnect ()
    {
        try
        {
            app.connect("localhost:33060");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    // Test app connection to database
    @Test
    void connect_Test ()
    {
        try 
        {
            assertDoesNotThrow(() -> app.connect("localhost:33060"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    // Test app connection to database
    @Test
    void connect_EmptyTest ()
    {
        assertThrows(Exception.class, () -> app.connect(""));
    }
    
    // Test app methods
    @Test
    void integrationTest ()
    {
        String query = app.getQuery("test1");
        ResultSet rset = app.executeQuery(query);
        app.writeQuery(rset, 1, "test-query-results");
        
        try 
        {
            // Create filepath from filename
            File file = new File("./test-query-results.csv");
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
    
    // Test disconnect from database when con is not null
    @Test
    void disconnect_Test ()
    {
        assertDoesNotThrow(() -> app.disconnect());
    }

    // Test disconnect from database when con is null
    @Test
    void disconnect_NullTest ()
    {
        try
        {
            app.disconnect();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        assertThrows(Exception.class, () -> app.disconnect());
    }

    // Disconnects from database
    @AfterEach
    void disconnect ()
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