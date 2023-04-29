public class HurricaneApp 
{
    public static void printNewsAlert(Hurricane someHurricane)
    {
        System.out.println("================================");
        System.out.println("BREAKING NEWS! HURRICANE UPDATE!");
        System.out.println("================================");
        someHurricane.printInfo();
        
        // changes the local copy to null not the original address
        someHurricane = null;
    }

    public static void main(String [] args)
    {
        // h1 is a memory address to the newly created object 
        Hurricane h1 = new Hurricane();

        h1.setName("Herbert");
        h1.currentSpeed=128;

        printNewsAlert(h1);
    }
    
    
}
