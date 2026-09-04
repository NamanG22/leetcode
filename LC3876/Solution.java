class Solution {
    public boolean uniformArray(int[] nums1) {
        if(nums1.length==1) return true;
        int smallest_odd = Integer.MAX_VALUE;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2!=0){
                smallest_odd = Math.min(smallest_odd,nums1[i]);
            }
        }
        if(smallest_odd==Integer.MAX_VALUE) return true;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2==0){
                if(nums1[i]-smallest_odd<1){
                    return false;
                }
            }
        }
        return true;
    }
}
