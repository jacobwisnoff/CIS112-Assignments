package MergeLinkedLists;

public class Driver {

    public static void main(String[] args){

        // Instantiate list1
        SortedLL<Integer> list1 = new SortedLL<>();
        list1.add(2);
        list1.add(1);
        list1.add(0);

        // Instantiate list2
        SortedLL<Integer> list2 = new SortedLL<>();
        list2.add(666);
        list2.add(3);
        list2.add(100);

        // Print list1
        System.out.println("List 1:");
        for(Integer i : list1){
            System.out.println(i);
        }
        System.out.println();

        // Print list2
        System.out.println("List 2:");
        for(Integer i : list2){
            System.out.println(i);
        }

        // MergeSortedLL Constructor
        SortedLL<Integer>  mergedList = new SortedLL<>();
        mergedList = mergedList.merge(list1, list2);

        System.out.println();
        System.out.println("Merged List:");
        for(Integer i : mergedList){
            System.out.println(i);
        }

    }
}
