public class BinarySearchRecursive {
    public static int binarySearch(int arr[], int low, int high, int key){
        if(low<=high){
            int mid=low+(high-low)/2;  
            if(arr[mid]==key)
                return mid; 
            if(key<arr[mid])
                return binarySearch(arr, low, mid-1, key) ;
            else
                return binarySearch(arr, low, mid+1, key) ;      
        }
       return -1; 
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        int index=binarySearch(arr, 0, arr.length-1, 5);
        if(index==-1)
            System.out.println("Element is not found in the list.");
        else
            System.out.println("Element is found at the Position is:"+index);    
    }
}
