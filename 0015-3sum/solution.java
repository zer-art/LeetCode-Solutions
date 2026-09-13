class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  out = new ArrayList<List<Integer>>() ; 
        int len = nums.length ; 
        if (len < 3){ 
            return out ; 
        }
        Arrays.sort(nums) ; 
        int i = 0 ; 
        while ( i < len -2 ){
            int j = i + 1 ; 
            int k = len - 1 ; 
            while ( j  <  k ){ 
                if (nums[i] > 0) break;
                if (nums [j] + nums [k] ==  (-nums[i])){ 
                    out.add(new ArrayList<>(List.of(nums[i],nums[j],nums[k]))) ; 
                    j ++ ; 
                    k -- ; 
                    while ( j < k && nums [j] == nums[j-1 ]){ 
                        j++ ; 
                    }
                    while ( k > j && nums [k] == nums [k+1 ]){ 
                        k-- ; 
                    }
                } else if (nums [j] + nums [k] > (-nums[i])) {
                    k-- ; 
                }
                else { 
                    j ++ ; 
                }
            }
            i++ ; 
            while ( i < len &&  nums [i] == nums [i-1]){
                i++ ; 
            }
        }
        return out ; 
    }
}
