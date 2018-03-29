package AB07;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AB07Main {

    public static void main(String a[]){
        int[] liste = {0,9,4,6,2,8,5,1,7,3,12,45,21,45,1};
        List<Integer> listeFuerNeFuckingQuickSort = new ArrayList<Integer>(){};
        Arrays.stream(liste).forEach(i -> listeFuerNeFuckingQuickSort.add(i));
        System.out.println(Arrays.toString(bubblesort(liste)));
        System.out.println(Arrays.toString(insertionSort(liste)));
        System.out.println(quicksortInt(listeFuerNeFuckingQuickSort));
    }

    public static int[] insertionSort(int[] sortieren) {
        int temp;
        for (int i = 1; i < sortieren.length; i++) {
            temp = sortieren[i];
            int j = i;
            while (j > 0 && sortieren[j - 1] > temp) {
                sortieren[j] = sortieren[j - 1];
                j--;
            }
            sortieren[j] = temp;
        }
        return sortieren;
    }

    public static int[] bubblesort(int[] input){

        int temp;
        for(int j = 0; j < input.length - 1; j++) {
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] > input[i+1]) {
                    temp = input[i];
                    input[i] = input[i+1];
                    input[i+1] = temp;
                }
            }
        }
        return input;
    }

    public void selectionSort(int arr[], int n)
    {
        int i, j, min_idx;

        // One by one move boundary of unsorted subarray
        for (i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            min_idx = i;
            for (j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first element
            swap(arr[min_idx], arr[i]);
        }
    }

    void swap(int xp, int yp)
    {
        int temp = xp;
    xp = yp;
    yp = temp;
    }

    public static List<Integer> quicksortInt(List<Integer> array)
    {
        //Eine Liste die nur aus einem Element besteht gilt als sortiert, Abbruchkriterium.
        if (array.size() <= 1)
        {
            return array; //An array of Zero ot one elements is already sorted
        }

        //Das Pivot legen wir immer auf das erste Element in einer Liste
        int pivot = 0;
        List<Integer> less = new ArrayList<Integer>();
        List<Integer> greater = new ArrayList<Integer>();

        //Hier teilen wir ein array in ein array mit Elementen die kleiner als das Pivot sind
        //und in eine Liste mit Elementen die größer sind.
        for (int i = 1; i < array.size(); i++)
        {
            if (array.get(i) <= array.get(pivot))
            {
                less.add(array.get(i));
            }
            else
            {
                greater.add(array.get(i));
            }
        }

        //Hier kombinieren wir die Listen und setzen das Pivot dazwischen.
        List<Integer> combined = quicksortInt(less);
        combined.add(array.get(pivot));
        combined.addAll(quicksortInt(greater));

        //Liefert sortierte Liste zurück.
        return combined;
    }
}
