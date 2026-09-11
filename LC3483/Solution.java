class Solution {
    public int totalNumbers(int[] digits) {
        int hash[] = new int[10];
        for(int i=0;i<digits.length;i++){
            hash[digits[i]]++;
        }
        int res = 0;
        for(int i=1;i<hash.length;i++){
            if(hash[i]>0){
                hash[i]--;
                for(int j=0;j<hash.length;j++){
                    if(hash[j]>0){
                        hash[j]--;
                        for(int k=0;k<hash.length;k+=2){
                            if(hash[k]>0){
                                res++;
                            }
                        }
                        hash[j]++;
                    }
                }
                hash[i]++;
            }
        }
        return res;
    }
}
