// Yuqi Zhou
// COP 3330, Spring 2023
// VS code
// Linux bash shell on Windows 10


// java runs the same on every computer becuase 
// when you compile a java program, you get a .class file
// that runs in the java compiling machine 
public class Hello 
{
    // capitalize class names
    // lowercase all other names 
    // use camel case for names
    public static void smile()
    {
        System.out.println(":3");
    }
    public static void main(String [] args)
    {
        int num=50;
        System.out.println("num= "+num+" wow so easy");
        smile();
        primitives();
    } 
    public static void primitives()
    {
        // a literal is when you hard code a value to a variable 
        double x=3.14; // uses 64 bits, more precision
        char y='U'; // uses 16 bits
        boolean z=false; 
        System.out.println("x = "+x+"\ny = "+y+"\nz = "+z);
        System.out.println(Integer.max(12,18));
        if(z)
            System.out.println("Not True");
        else 
            System.out.println("False");
    }

    

}
