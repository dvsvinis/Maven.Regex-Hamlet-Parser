import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        //Given
        String nameToSearchFor = "Hamlet";
        String nameToSubstitute = "Leon";
        String newHamlet = "";

        //When
        newHamlet = HamletParser.exactMatch(nameToSearchFor, nameToSubstitute, hamletText);
        newHamlet = HamletParser.allUpperCaseMatch(nameToSearchFor, nameToSubstitute, newHamlet);

        Boolean containsHamlet = HamletParser.findName(nameToSearchFor, newHamlet);
        Boolean containsHAMLET = HamletParser.findName(nameToSearchFor.toUpperCase(), newHamlet);

        //Then
        Assert.assertFalse(containsHamlet);
        Assert.assertFalse(containsHAMLET);
    }

    @Test
    public void testChangeHoratioToTariq() {
        //Given
        String nameToSearchFor = "Horatio";
        String nameToSubstitute = "Tariq";
        String newHamlet = "";

        //When
        newHamlet = HamletParser.exactMatch(nameToSearchFor, nameToSubstitute, hamletText);
        newHamlet = HamletParser.allUpperCaseMatch(nameToSearchFor, nameToSubstitute, newHamlet);

        Boolean containsHoratio = HamletParser.findName(nameToSearchFor, newHamlet);
        Boolean containsHORATIO = HamletParser.findName(nameToSearchFor.toUpperCase(), newHamlet);

        //Then
        assertFalse(containsHoratio);
        assertFalse(containsHORATIO);
    }


    @Test
    public void testFindHoratio() {
        //Given
        String nameToSearchFor = "Horatio";

        //When
        Boolean containsHoratio = HamletParser.findName(nameToSearchFor, hamletText);
        Boolean containsHORATIO = HamletParser.findName(nameToSearchFor.toUpperCase(), hamletText);

        //Then
        assertTrue(containsHoratio);
        assertTrue(containsHORATIO);
    }

    @Test
    public void testFindHamlet() {
        //Given
        String nameToSearchFor = "Hamlet";

        //When
        Boolean containsHamlet = HamletParser.findName(nameToSearchFor, hamletText);
        Boolean containsHAMLET = HamletParser.findName(nameToSearchFor.toUpperCase(), hamletText);

        //Then
        assertTrue(containsHamlet);
        assertTrue(containsHAMLET);
    }
}