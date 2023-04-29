public class Overload
{
   public static char five(int a, int b)
   {
      return 'y';
   }

   public static char five(int a, double b)
   {
      return 'y';
   }

   public static char five(double b, int a)
   {
      System.out.println("here");
      return 'y';
   }

   public static char five(double b, double a)
   {
      return 'y';
   }

   public static void main(String [] args)
   {
      int b = 6;
      double a = 3.2;
      int x = five(a, b);
      System.out.println((char)x);
   }
}