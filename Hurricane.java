public class Hurricane 
{
    // an instance variable is any non static variable
    private String name;
    public int currentSpeed;

    public void setName(String nameArg)
    {
        // don't need distinction between static and non static for local variables
        int i=0;
        name=nameArg;
    }

    public String getName()
    {
        return name;
    }

    public void printInfo()
    {
        System.out.println("Hurricane Name: " +name);
        System.out.println("Current Speed: " +currentSpeed);
        System.out.println(" ");
    }


    
}
