package neetCode150.LinkedList;

public class Find_The_Duplicate_Number {
    // WoW very smart solution !!!
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }
        int check = 0;
        while (true) {
            slow = nums[slow];
            check = nums[check];
            if (slow == check) break;;
        }
        return check;
    }

    public int findDuplicate2(int[] nums) {
        int slow = 0;
        int fast = 0;
        int check = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        do {
            slow = nums[slow];
            check = nums[check];
        }while (slow != check);
        return check;
    }
    public static void main(String[] args) {

    }
}
