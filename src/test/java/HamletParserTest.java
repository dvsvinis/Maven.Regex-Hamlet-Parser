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
    }

    @Test
    public void testFindHoratio() {
    }

    @Test
    public void testFindHamlet() {
    }
}