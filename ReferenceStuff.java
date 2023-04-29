public class ReferenceStuff
{
    public static void main(String[] args)
    {
        // local variables are stored in the stack
        // objects are in heap space but the reference variable to the object is stored in the stack
        // all memory in the stack allocated by a function is freed when the function terminates
        // all memory is freed when the program terminates
        // everything except the primitives are a reference in java 
        // fields are auto initialized to zero
        // arrays are also auto initialized to zero
        // variables inside functions are not auto initialized 

        // instantiate a class
        Diamond d1=new Diamond();
        Diamond d2=new Diamond();


        d2.printChar(2, '+');
        d1.printDiamond(7);
        // this will print out an address 
        // d1 is the address to the object 
        System.out.println(d1);
        

    }
    

}