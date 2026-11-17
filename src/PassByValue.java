public class PassByValue {
    public static void main(String[] args){
        int num = 10;
        int[] nums = {1, 2, 3};
        modify(num);
        modifyArray(nums);
        System.out.println("First num: " + num);
        System.out.println("Array of  nums: ");
        for(int value:nums){
            System.out.println(value);
        }

    }
    public static void modify(int num) {
        num = num * 2;
    }
    public static void modifyArray(int[] nums) {
        nums[1] = 10;
    }

}
