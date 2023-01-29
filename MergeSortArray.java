public class MergeSortArray {
    public int[] sort(int[] arr,int[] temp, int low, int high){
        if(low<high){
            int mid = low +(high - low)/2;
                sort(arr, temp, low, mid);
                sort(arr, temp, mid+1, high);
                merge(arr,temp,low,mid,high);
        }
        return arr;
    }

    private void merge(int[] arr, int[] temp, int low, int mid, int high) {
        for(int i=low; i<=high; i++){
            temp[i]=arr[i];
        }
        int i=low;
        int j=mid+1;
        int k=low;
        while(i<=mid && j<=high){
            if(temp[i] <= temp[j]){
                arr[k]=temp[i];
                i++;
            }else{
                arr[k]=temp[j];
                j++;
            }
          k++;
        }
        while(i<=mid){
            arr[k]=temp[i];
            k++;
            i++;
        }
    }
    public static void main(String[] args) {
        int arr[]=new int[]{4,3,9,1,8,0,6};
        MergeSortArray ms = new MergeSortArray();
        int[] result=ms.sort(arr, new int[arr.length],0,arr.length-1);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }

    }

    
}
