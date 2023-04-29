import java.util.Arrays;

public class ArrayExample
{
    public static int getMax(int [] arr)
    {
      
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        return max;
    }


    public static void main(String [] args)
    {
        int [] arr=new int[10];
        // .length is a field in the array class
        // always use arr.length in loops
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=i*10;
            System.out.println("array["+i+"]: "+arr[i]);
        }
        System.out.println(arr);
        // makes a copy of the array at a different address
        int [] arr2=Arrays.copyOf(arr,arr.length);
        int [] arr3={5,3,1,78,8,4,45,23,11,66,43};
        // sorts the array
        Arrays.sort(arr3);
        // to print an array without having to write a for loop
        System.out.println(Arrays.toString(arr3));
        System.out.println(getMax(arr3));
    }
}