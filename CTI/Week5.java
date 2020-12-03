import java.util.ArrayList;

public class Week5 {
    
    public static void main(String[] args) {
        
        // int[] arr = { 4, 3, 2, 1, 5 };

        // for (int i = 5; i >= 1; i--) {
        //     arr[5 - i] = i; 
        // }

        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i]);
        // }

        // int[] sohum = {5, 1, 2, -6, 3, 9};
        // int total = 0;
        // for (int i = 0; i < sohum.length; i++) {
        //   total += sohum[i];
        // }
        // System.out.println(total);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        System.out.println(list);
        list.remove(Integer.valueOf(3));
        System.out.println(list);
        list.add(4);
        list.add(-1);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        list.add(1, 3);
        System.out.println(list);

        // for (int i = 0; i < list.size(); i++) {
        //     System.out.println(list.get(i));
        // }

        for (int number : list) {
            System.out.println(number);
        }

        /*
        asd
        as
        d
        sa
        d
        sa
        d
        sa
        */

        ArrayList<ArrayList<Integer>> list2d = new ArrayList<>();
        list2d.add(new ArrayList<Integer>());
        list2d.get(0).add(3);
        System.out.println(list2d);

        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(10);
        myNumbers.add(15);
        myNumbers.add(20);
        myNumbers.add(25);
        for (int i : myNumbers) {
        System.out.println(i);
        }





        int[] arr = {5, 1, 2, -6, 3, 9};
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            list3.add(arr[i]);
        }
        System.out.println(list3);

    }

}
