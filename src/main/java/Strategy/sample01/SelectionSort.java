package Strategy.sample01;

public class SelectionSort implements Sort {
    public int[] sort(int arr[]) {
        int len = arr.length;
        int temp;
        for (int i = 0; i < len; i++) {
            temp = arr[i]; ///最小值变量  
            int j;
            int samllestLocation = i; // 最小值索引变量  
            for (j = i + 1; j < len; j++) {
                if (arr[j] < temp) {// 找到最小值  
                    temp = arr[j];
                    samllestLocation = j;
                }
            }
            arr[samllestLocation] = arr[i];// 交换两数值  
            arr[i] = temp;
        }
        return arr;
    }
}