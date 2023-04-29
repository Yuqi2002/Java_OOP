// Yuqi Zhou
// COP 3330
// Spring 2023
// yu894053

import java.util.Arrays;

public class Strands
{    
    public static void straightAndNarrow(String str)
    {
        // check if str is empty
        if(str == null || str.length() == 0)
        {
            System.out.println("Pshh!");
            return;
        }
        // loop through the string to pring out each char
        for (int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i)!=' ')
            {
                System.out.print("  ");
                System.out.println(str.charAt(i));
            }
            else
                System.out.println();
        }
    }

    public static void straightAndNarrow(String str, int n)
    {   
        // check if str is empty
        if(str == null || str.length() == 0)
        {
            System.out.println("Pshh!");
            return;
        }

        // create an array of chars, fill it with spaces and turn it into a string
        char[] spaces = new char[n];
        Arrays.fill(spaces, ' ');
        spaces.toString();

        // loop through the string to pring out each char
        for (int i = 0; i < str.length(); i++)
        {
            if(str.charAt(i)!=' ')
            {
                System.out.print(spaces);
                System.out.println(str.charAt(i));
            }
            else
                System.out.println();
        }
    }

    public static void meanderingPath(String str)
    {
        // initiate sequence and value to index sequence
        int sequence[] = { 2, 2, 2, 3, 4, 5, 5, 5, 4, 3 };
        int index = 0;
        for (int i = 0; i < str.length(); i++)
        {   
            // reset index to 0 so it doesn't go out of bounds
            if (index >= 10)
                index = 0;
            // pass in each char as a string to the previous function
            if (i == 0)
                straightAndNarrow(String.valueOf(str.charAt(i)), 3);
            if (i != 0)
                straightAndNarrow(String.valueOf(str.charAt(i)), sequence[index]);
            index++;
        }
    }

    public static void printRow(char[] row)
    {
        // convert char array into string and strip the remaining spaces
        String str = String.valueOf(row);
        System.out.println(str.stripTrailing());
    }
    public static void printMatrix(String[] strings, int[] sequenceX, int[] sequenceY, int rowLength, int maxStrLength)
    {
        int indexX = 1;
        int rowIndex = 3;
        // loop through columns
        for (int j = 0; j < maxStrLength; j++)
        {
            // wrap index back to zero if it goes out of bounds
            if (indexX >= sequenceX.length)
                indexX = 0;
            // initailize char array filled with spaces
            char[] row = new char[rowLength];
            Arrays.fill(row,' ');
            // loop through rows
            for (int i = 0; i < strings.length; i++)
            {
                // check if there is a vertical indent
                if (sequenceY[i] != 0)
                {
                    // start adding char to the row if vertical indent has already been printed
                    if ((j - sequenceY[i]) >= 0 && j < (strings[i].length() + sequenceY[i]))
                    {
                        row[rowIndex] = strings[i].charAt(j - sequenceY[i]);
                    }
                }
                // place each char at the correct spot in the row
                else if (j < strings[i].length())  
                {
                    row[rowIndex] = strings[i].charAt(j);
                }
                rowIndex += 3; 
            }
            rowIndex = sequenceX[indexX];
            printRow(row);
            indexX++;
        }
    }

    public static void classicRapunzel(String [] strings)
    {
        // initiate sequence and value to index sequence
        int sequenceX[] = { 2, 2, 2, 3, 4, 5, 5, 5, 4, 3 };
        int sequenceY[] = new int[strings.length];
        Arrays.fill(sequenceY, 0);
        int maxLength = -1;
        int rowLength = 5 * strings.length;

        // find string with the longest length so we can use it to iterate
        for (int i = 0; i < strings.length; i++)
        {   
            maxLength = Math.max(strings[i].length(),maxLength);
        }
        printMatrix(strings, sequenceX, sequenceY , rowLength, maxLength);
    }

    public static void steamyMocha(String [] strings)
    {
        // initiate sequence and value to index sequence
        int sequenceX[] = { 2, 2, 2, 3, 4, 5, 5, 5, 4, 3 };
        int sequenceY[] = new int[strings.length];
        int maxLength = -1;
        int rowLength = 5 * strings.length;

        // fill sequence array
        for (int i = 0; i < strings.length; i++)
        {
            sequenceY[i] = i % 2;
        }
        // find string with the longest length so we can use it to iterate
        for (int i = 0; i < strings.length; i++)
        {   
            maxLength = Math.max(strings[i].length(),maxLength);
        }
        printMatrix(strings, sequenceX, sequenceY , rowLength, maxLength + 1);
    }

    public static void cascadingWaterfall(String [] strings)
    {
        // initiate sequence and value to index sequence
        int sequenceX[] = { 2, 2, 2, 3, 4, 5, 5, 5, 4, 3 };
        int sequenceY[] = new int[strings.length];
        int maxLength = -1;
        int rowLength =strings.length * 6;

        // fill sequence array
        for (int i = 0; i < strings.length; i++)
        {
            sequenceY[i] = i;
        }
        // find string with the longest length so we can use it to iterate
        for (int i = 0; i < strings.length; i++)
        {   
            maxLength = Math.max((strings[i].length() + sequenceY[i]),maxLength);
        }
        printMatrix(strings, sequenceX, sequenceY , rowLength, maxLength);
    }

    public static double difficultyRating()
    {
        return 3.0;
    }

    public static double hoursSpent()
    {
        return 8.0;
    }
}
