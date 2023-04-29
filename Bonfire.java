// Yuqi Zhou
// COP 3330
// Spring 2023
// yu894053

public class Bonfire 
{
    public static boolean containsValueAfterIndex(int needle, int [] haystack, int index)
    {
        // check if input value is valid
        if (haystack.length == 0 || index > haystack.length)
            return false;
        
        // start at 0 if index given is less than zero so we don't go out of bounds
        if (index < 0)
            index = 0;
        
        // search the array starting at the input index + 1
        for (int i = index + 1; i < haystack.length; i++)
        {
            if (needle == haystack[i])
            return true;
        }
        return false;
    }

    public static int getThirdLargest(int [] array)
    {
        // check if input array is valid 
        if (array.length < 3)
            return Integer.MIN_VALUE;

        // keep track if first second and third largest value
        int first = 0;
        int second = 0;
        int third = 0;

        for (int i = 0; i < array.length; i++)
        {
            // update all 3 variables if we encounter a value larger than our current largest value
            if (first <= array[i])
            {
                third = second;
                second = first;
                first = array[i];
            }
            // only update 2nd and 3rd if we encounter a value larger than second
            else if (second <= array[i])
            {
                third = second;
                second = array[i];
            }
            // update 3rd if we encounter a value larger than third
            else if (third <= array[i])
            {
                third = array[i];
            }
        }
        return third;
    }
    
    public static void printThirdLargest(int [] array)
    {
        System.out.println(getThirdLargest(array));
    }

    public static boolean isRotation(int [] array1, int [] array2)
    {
        // if both arrays are empty, return true
        if (array1.length == 0 && array2.length == 0)
            return true;
        // if array lengths are different, return false
        if (array1.length != array2.length)
            return false;
        
        
        int arr1Ptr = 0; // ptr to array 1
        int leftPtr = 0; // left ptr of sliding window for array 2
        int rightPtr = 0; // right ptr of sliding window for array 2
        // sliding window approach 
        for (int i = 0; i < array1.length * 2; i++)
        {
            // if value matches in the 2 arrays, increment arr1Ptr and rightPtr
            if (array2[rightPtr] == array1[arr1Ptr])
            {
                // index wraps back to 0 instead of going out of bounds
                if (rightPtr >= array2.length-1)
                    rightPtr = 0;
                else 
                    rightPtr++;

                if (arr1Ptr >= array2.length-1)
                    arr1Ptr = 0;
                else 
                    arr1Ptr++;
                
                
            }
            // handle cases if value does not match
            else if (array2[rightPtr] != array1[arr1Ptr]) 
            {
                // increment the start of the sliding window right
                if (arr1Ptr == 0)
                {
                    if (rightPtr >= array2.length-1)
                        rightPtr = 0;
                    else 
                        rightPtr++;
                    if (leftPtr >= array2.length-1)
                        leftPtr = 0;
                    else 
                        leftPtr++;
                }
                // reset sliding window and have it begin at rightPtr
                else if (arr1Ptr != 0)
                {
                    arr1Ptr = 0;
                    leftPtr = rightPtr;
                }
            }
            // if arr1Ptr reaches the end, we know array 2 is a rotation of array 1
            if (arr1Ptr == array1.length-1)
                return true;
        }
        return false;
    }

    public static int [] generateNthRotation(int [] array, int n)
    {
        if (array.length == 0)
            return array;
        if (n < 0)
            n = array.length + n;

        int [] retArr = new int[array.length];
        // determine the beginning index of the new array in O(1)
        int index = n % array.length;

        // copy values over to return array 
        for (int i = 0; i < array.length; i++)
        {
            retArr[index] = array[i];
            // make sure we don't go out of bounds
            if (index >= array.length - 1)
                index=0;
            else 
                index++;
        }
        return retArr;
    }

    public static void printRibbon(int n, int width)
    {
        printLine(width);
        // call recursive function to print all the lines
        printRibbonRec(n, width, 0);
        printLine(width);
    }

    // recursive solution
    public static void printRibbonRec(int n, int width, int spaces)
    {
        // base case stops the recursion when spaces reach width or if width = 0
        if (spaces == width)
            return;

        System.out.print('|');
        // print the current line 
        for (int i = 0; i < width; i++)
        {
            if (i < spaces)
                System.out.print(' ');
            else if (i < n + spaces)
                System.out.print('@');
            else if (i < (n * 2) + spaces)
                System.out.print('o');
            else if (i < (n * 3) + spaces)
                System.out.print('@');
            else if (i >=  (n * 3) + spaces)
                System.out.print(' ');
        }
        System.out.println('|');

        // recurse 
        printRibbonRec(n, width, spaces + 1);
    }

    // prints the top and bottom edge of the box
    public static void printLine(int width)
    {
        System.out.print('+');
        for (int i = 0; i < width ; i++)
        {
            System.out.print('-');
        }
        System.out.println('+');
    }

    public static double difficultyRating()
    {
        return 2.5;
    }

    public static double hoursSpent()
    {
        return 8.0;
    }
}
