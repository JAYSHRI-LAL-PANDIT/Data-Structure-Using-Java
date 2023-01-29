public class BinarySearchItirative {
    public static int binarySearch(int[] arr, int key){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low + high)/2;
            if(arr[mid] == key){
                return mid;
            }
            if(key < arr[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {11,22,33,44,55,66,77};
        System.out.println("Key index is :"+binarySearch(arr, 11));
    }
    
}
