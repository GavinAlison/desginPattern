package Strategy.sample01;

public class Client {
    public static void main(String args[]) {
        int arr[] = {1, 4, 6, 2, 5, 3, 7, 10, 9};
        int result[];
        ArrayHandler ah = new ArrayHandler();

//        Sort sort ;
//        sort = (Sort) XMLUtil.getBean();
        Sort sort = new SelectionSort();
        ah.setSortObj(sort);
        result = ah.sort(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
    }
}