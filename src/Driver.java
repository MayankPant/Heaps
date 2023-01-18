import java.util.Scanner;

public class Driver {
    // class to test the heap
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Heap<Integer> heap = new Heap<>((o1, o2) -> Integer.compare(o1, o2));
        int arr[] = {64,81,42,27,11,78,87,91,19};

        for(int ele : arr)
            heap.add(ele);

        while (!heap.isEmpty()){
            System.out.print(heap.remove() + " ");
        }
        System.out.println();

        String[] words = {"Xenoblade-Chronicals","Alphonse", "Elric", "Jupyter", "Wednesday", "Woodpecker", "Van-Helsing", "Van-der-Waals"};

        Heap<String> heap1 = new Heap<>((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1, o2));

        for(String word : words)
            heap1.add(word);

        while (!heap1.isEmpty())
            System.out.print(heap1.remove() + " ");

    }
}
