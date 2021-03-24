import com.napier.sem.App;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;
import java.io.File;
import java.util.Scanner;


public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }
    
    @Test
    void integrationTest()
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
            assertEquals("code,name,continent,region,population,capital", scanner.nextLine().toLowerCase());
            assertEquals("\"GBR\",\"United Kingdom\",\"Europe\",\"British Islands\"," +
                    "\"59623400\",\"456\"", scanner.nextLine());
            scanner.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @AfterAll
    static void disconnect ()
    { app.disconnect(); }

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