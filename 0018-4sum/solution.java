import java.util.List; 
import java.util.ArrayList; 
import java.util.Arrays; 

class Solution { 
    
    
    private static void twoSum(int[] nums, int target, int i, int j, List<List<Integer>> result) { 
        int l = j + 1; 
        int r = nums.length - 1; 
        
        while (l < r) { 
            long sum = (long) nums[i] + nums[j] + nums[l] + nums[r]; 
            
            if (sum == target) { 
                // FIX 2: Use commas, not plus signs
                result.add(new ArrayList<>(List.of(nums[i], nums[j], nums[l], nums[r]))); 
                l++; 
                r--;
                
                while (l < r && nums[l] == nums[l - 1]) l++;
                while (l < r && nums[r] == nums[r + 1]) r--;
                
            } else if (sum > target) { 
                r--; 
            } else { 
                l++; 
            }
        }
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) { 
        List<List<Integer>> fourSum = new ArrayList<>();
        if (nums.length < 4) return fourSum; 
        Arrays.sort(nums); 
        
        int n = nums.length; 
        
        for (int i = 0; i < n - 3; i++) { 
            
            if (i > 0 && nums[i] == nums[i - 1]) continue;  
            
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if ((long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue; 

            for (int j = i + 1; j < n - 2; j++) { 
                
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; 

                // pruning
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if ((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;
                
                twoSum(nums, target, i, j, fourSum);
            }
        } 
        return fourSum; 
    }
}
