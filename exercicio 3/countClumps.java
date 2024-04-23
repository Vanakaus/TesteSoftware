public static int countClumps(int[] nums) {
  // If null or empty (pre-condition), return 0 right away.
  if (nums == null || nums.length == 0) { 
     return 0; 
  }
  int count = 0;
  int prev = nums[0];
  boolean inClump = false;
  for (int i = 1; i < nums.length; i++) {
    // If the current number is the same as the previous number, we have identified a clump.
    if (nums[i] == prev && !inClump) {
      inClump = true;
      count += 1;
    }
    //If the current number differs from the previous one, we are not in a clump.
    if (nums[i] != prev) {
      prev = nums[i];
      inClump = false;
    }
  }
  return count;
}