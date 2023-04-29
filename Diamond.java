public class Diamond
{
    public static void printChar(int n, char ch)
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(ch);
        }
    }
    public static void printLine(int width, int numStars)
    {
        System.out.print("| ");
        int numSpaces=(width-numStars)/2;

        printChar(numSpaces,' ');
        printChar(numStars,'*');
        printChar(numSpaces,' ');

        System.out.println(" |");
    }
    public static void printDiamond(int width)
    {   
        if(width%2==0) return;
        printChar(1,'+');
        printChar(width+2,'-');
        printChar(1,'+');
        System.out.println();
        // print top half
       for(int i=1; i<=width;i+=2)
       {
            printLine(width,i);
       }
       // print bottom half
       for(int i=width-2;i>=1;i-=2)
       {
            printLine(width,i);
       } 
       printChar(1,'+');
       printChar(width+2,'-');
       printChar(1,'+');
       System.out.println();

    }
    public static void main(String [] args)
    {
        int n=(args.length<1)? 0 : Integer.parseInt(args[0])
        //  sets n to zero if true| sets n to args[0] if false 
        printDiamond(n);
    }
}
