import com.napier.sem.App;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.sql.*;
import java.util.Scanner;

class AppUnitTest
{
    static App app;

    @BeforeAll
    static void init ()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void getQuery_FileExistTest ()
    {
        assertEquals("SELECT code, name, continent, region, population, capital " +
                "FROM country " +
                "WHERE code = \"GBR\" " +
                "; ", app.getQuery("test1"));
    }

    @Test
    void getQuery_FileNotExistTest ()
    {
        assertNull(app.getQuery("test0"));
    }

    @Test
    void getQuery_SkipCommentTest ()
    {
        assertEquals(app.getQuery("test1"), app.getQuery("test2"));
    }

    @Test
    void executeQuery_ResultsTest ()
    {
        ResultSet rset = app.executeQuery("SELECT Code,Name,Continent,Region,Population,Capital" +
                "FROM country " +
                "WHERE code = \"GBR\" " +
                ";");
        try
        {
            while (rset.next())
            {
                assertEquals(rset.getString(0), "GBR");
                assertEquals(rset.getString(1), "United Kingdom");
                assertEquals(rset.getString(2), "Europe");
                assertEquals(rset.getString(3), "British Islands");
                assertEquals(rset.getString(4), "59623400");
                assertEquals(rset.getString(5), "456");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void executeQuery_NoResultsTest () {
        ResultSet rset = app.executeQuery("SELECT code, name, continent, region, population, capital " +
                "FROM country " +
                "WHERE code = \"AAA\" " +
                ";");
        try
        {
            assertFalse(rset.next());
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void writeQuery_ResultsTest () 
    {
        ResultSet rset = app.executeQuery("SELECT code, name, continent, region, population, capital " +
                "FROM country " +
                "WHERE code = \"GBR\" " +
                ";");
        app.writeQuery(rset, 1, "test-query-results");

        try
        {
            // Create filepath from filename
            File file = new File("./test-query-results.csv");
            // Create new Scanner
            Scanner scanner = new Scanner(file);

            assertEquals("1", scanner.nextLine());
            assertEquals("code, name, continent, region, population, capital", scanner.nextLine());
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
    { app.disconnect();}
    
    @AfterAll
    static void deleteTestFile()
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