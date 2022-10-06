import java.util.*;
import sort.SortingAlgorithm;

public class Main
{

    public Main()
    {
    }

    public static void printArray(int array[])
    {
        int ai[];
        int j = (ai = array).length;
        for(int i = 0; i < j; i++)
        {
            int a = ai[i];
            System.out.print((new StringBuilder(String.valueOf(a))).append(" ").toString());
        }

        System.out.println();
    }

    public static int[] createRandomArray(int arrayLength)
    {
        int array[] = new int[arrayLength];
        Random random = new Random();
        for(int i = 0; i < arrayLength; i++)
            array[i] = random.nextInt(100);

        return array;
    }

    public static boolean isSorted(int array[])
    {
        for(int i = 0; i < array.length - 1; i++)
            if(array[i] > array[i + 1])
                return false;

        return true;
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        int arrayLength = 0;
        System.out.println("Please enter the size of input array:");
        arrayLength = scanner.nextInt();

        do
        {
            long startTime = System.currentTimeMillis();
            int array[] = createRandomArray(arrayLength);
            System.out.print("\nUnsorted Numbers:  \n" + Arrays.toString(array));
            startTime = System.currentTimeMillis();
            int sortedArray[] = SortingAlgorithm.mergeSort(array);
            double mergeTime = Double.valueOf((double)(System.currentTimeMillis() - startTime) / 1000D);
           
            System.out.print("\nMergeSort Numbers: \n" + Arrays.toString(sortedArray));
            System.out.println((new StringBuilder("The sorted array is in correct order: ")).append(isSorted(sortedArray)).toString());
            startTime = System.currentTimeMillis();
            SortingAlgorithm.bubbleSort(array);
            double bubbleTime = Double.valueOf((double)(System.currentTimeMillis() - startTime) / 1000D);
           
            System.out.print("\nBubbleSort Numbers:\n" + Arrays.toString(array));
            System.out.print("\n");

            System.out.println((new StringBuilder("\nIf sorted:  ")).append(isSorted(sortedArray)).toString());
           
            System.out.println((new StringBuilder("Same order: ")).append(Arrays.equals(sortedArray, array)).toString());
           
            System.out.printf("\nThe time of MergeSort  for size %d is %.6fs\n", new Object[] {
                Integer.valueOf(arrayLength), mergeTime});
            System.out.printf("The time of BubbleSort for size %d is %.6fs\n", new Object[] {
                Integer.valueOf(arrayLength), bubbleTime});
            System.out.println((new StringBuilder("\nMergeSort is ")).append(String.valueOf(bubbleTime/mergeTime)).append(" times faster than BubbleSort."));
           
            System.out.println("\nPlease enter the size of input array, or 0(exit):");
           
            arrayLength = scanner.nextInt();
        } while(!(arrayLength==0));
        scanner.close();

    }
}
