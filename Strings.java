public class Strings 
{
    public static void main(String [] args)
    {
        String s = "Hello";
        System.out.println(s);

        // strings are immutable in java so when we change s to goodbye, it creates a new 
        // block of memory for goodbye and s now points to the new block, the old block containing
        // hello eventually gets freed by the garbage collector 
        s = "Goodbye"; 
        System.out.println(s);
        // strcat in java is really slow
        // it takes the string copies it to a new location and adds the goodbye 
        s = s + "Goodbye";


    }
    
}
