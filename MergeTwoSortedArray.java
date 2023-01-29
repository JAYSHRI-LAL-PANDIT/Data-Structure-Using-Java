public class MergeTwoSortedArray {
    public int[] merge(int[] arr1, int[] arr2, int n, int m){
        int result[]=new int[n+m];
        int i=0;
        int j=0;
        int k=0;
        while(i<n && j<m){
            if(arr1[i]<arr2[j]){
                result[k]=arr1[i];
                i++;
            }else{
                result[k]=arr2[j];
                j++;
            }
            k++;
        }
        while(i<n){
            result[k]=arr1[i];
            i++;
            k++;
        }
        while(j<m){
            result[k]=arr2[j];
            j++;
            k++;
        }
        return result;
       
    }
    public static void main(String[] args) {
        MergeTwoSortedArray mts = new MergeTwoSortedArray();
        int arr1[]={0,1,5,7};
        int arr2[]={3,3,6,8};
        int result[]=mts.merge(arr1,arr2,arr1.length,arr2.length);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
}
