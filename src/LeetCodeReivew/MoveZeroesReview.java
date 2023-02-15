package LeetCodeReivew;

public class MoveZeroesReview {
    public static int[] solution(int[] nums){
        int[] moveZerosList = nums;
        int count = 0;
        for(int i=0; i<moveZerosList.length; i++){
            if(moveZerosList[i] == 0){
                count++;
            } else{
                if(count>0){
                    int temp = moveZerosList[i];
                    moveZerosList[i] = moveZerosList[i-count];
                    moveZerosList[i-count] = temp;
                }
            }
        }
        return moveZerosList;
    }
    public static int[] solution2(int[] nums){
        int[] moveZerosList = nums;
        int[] temp = nums;
        int tempCount = 0;
        for(int i=0; i<moveZerosList.length; i++){
            if(moveZerosList[i] != 0){
                temp[tempCount++] = moveZerosList[i];
            }
        }
        for(int i = tempCount; i<moveZerosList.length; i++){
            temp[i] = 0;
        }
        moveZerosList = temp;
        return moveZerosList;
    }
    public static void main(String[] args) {
        int nums[] = {0,1,0,3,12};
        for(int i : solution2(nums)){
            System.out.print(i + " ");
        };
        System.out.println();
        nums = solution2(nums);
        System.out.print("[");
        for(int i=0; i< nums.length-1; i++){
            System.out.print(nums[i] + ", ");
        }
        System.out.println(nums[nums.length-1]+"]");
    }
}
