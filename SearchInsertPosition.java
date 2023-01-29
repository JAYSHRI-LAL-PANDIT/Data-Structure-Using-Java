public class SearchInsertPosition {
    public static int searchInsert(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        while(low<=high){
            int mid = low + (high -low)/2;
            if(arr[mid] == target)
                return mid;
            if(target < arr[mid]){
                high = mid -1;
            }else{
                low = mid + 1;
            }    
        }
        return low;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        System.out.println("Target element index is :"+searchInsert(arr, 0));
    }
}
