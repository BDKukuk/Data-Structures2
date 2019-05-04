package p7_package;

public class StateDataClass
{
    private int population;
    private String state;

    /**
     * Default constructor, initializes all state data to default values
     */
    public StateDataClass()
    {
        this.population = 0;
        this.state = " ";
    }

    /**
     * Initialization constructor, initializes state data to default values
     * @param stateName
     * @param inPopulation
     */
    public StateDataClass(String stateName, int inPopulation)
    {
        this.state = stateName;
        this.population = inPopulation;
    }

    /**
     * Copy constructor, sets all data to copied object
     * @param copiedSC
     */
    public StateDataClass(StateDataClass copiedSC)
    {
        this.population = copiedSC.population;
        this.state = copiedSC.state;
    }

    /**
     * Provides required method for comparing this object to another
     * StateDataClass object
     * Note: uses .length to get length of state string
     *
     * Note: uses toLowerCase to test all characters as lower case
     *
     * Note: returns negative value (not necessarily -1)
     * if this data is less than other data; returns positive value
     * (not necessarily +1) if this data is greater than other data;
     * returns zero if this item and other item are alphabetically equal
     * and the same length
     * @param other
     * @return
     */
    public int compareTo(StateDataClass other)
    {
     int wordIndex;
     int otherTotal = 0;
     int total = 0;

     for(wordIndex = 0; wordIndex < other.state.length(); wordIndex++)
     {
         total = total + (int)this.state.charAt(wordIndex);
         otherTotal = otherTotal + (int)(other.state.charAt(wordIndex));
     }

     return total - otherTotal;
    }


    /**
     * Changes character to lower case only if character was originally
     * an upper case letter
     * @param testChar
     * @return
     */
    public char toLowerCase(char testChar)
    {
        {
            if (testChar < 'A' || testChar > 'Z')
            {
                testChar = (char)((testChar - 'A') + 'a');
            }
            return testChar;
        }
    }

    /**
     * Overrides Object.toString, provides raw data from object
     * @return
     */
    public String toString()
    {
        return "State: "+ this.state + ", Population:" + this.population;
    }
}
