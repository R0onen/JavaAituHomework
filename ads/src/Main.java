import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //problem1();
        //problem2();
        //problem3();
        //problem4();
        //problem5();
        //problem6();
        problem7();
        //problem8();
        //problem9();
        //problem10();
    }
    public static void problem1(){
        int n = scanner.nextInt();
        int[] nums = new int[n];
        fillArray(nums, 0);
        System.out.print(minimum(nums, 0, nums[0]));
    }
    public static int[] fillArray(int[] nums, int index){
        if(index >= nums.length){
            return nums;
        }
        nums[index] = scanner.nextInt();
        return fillArray(nums, index+1);
    }
    public static int minimum(int[] nums, int index, int min){
        if(index >= nums.length){
            return min;
        }
        if(nums[index] < min) {
            min = nums[index];
        }
        return minimum(nums, index+1, min);
    }
    public static void problem2(){
        int n = scanner.nextInt();
        int[] nums = new int[n];
        fillArray(nums, 0);
        System.out.print(average(nums, 0, 0));
    }
    public static double average(int[] nums, int index, double sum){
        if(index >= nums.length){
            return sum/nums.length;
        }
        sum += nums[index];
        return average(nums, index+1, sum);
    }

    public static void problem3(){
        int n = scanner.nextInt();
        if(prime(n, n/2)){
            System.out.print("Prime");
        }
        else{
            System.out.print("Composite");
        }
    }
    public static boolean prime(int n, int divisor){
        if(n <= 1){
            return false;
        }
        if(divisor == 1){
            return true;
        }
        if(n%divisor == 0){
            return false;
        }
        return prime(n, divisor-1);
    }
    public static void problem4(){
        int n = scanner.nextInt();
        System.out.print(factorial(n));
    }
    public static long factorial(int n){
        if(n <= 1){
            return 1;
        }
        return n * factorial(n - 1);
    }
    public static void problem5(){
        int n = scanner.nextInt();
        System.out.print(fibonacci(n));
    }
    public static int fibonacci(int n){
        if(n <= 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    public static void problem6(){
        int a = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.print(degree(n, a));
    }
    public static int degree(int n, int a) {
        if (n == 0) {
            return 1;
        } else {
            return a * degree(n - 1, a);
        }
    }
    public static void problem7(){
        String str = scanner.next();
    }
    public static void problem8(){
        String str = scanner.next();
        if(onlyDigits(str)){
            System.out.print("Yes");
        }
        else{
            System.out.print("No");
        }
    }
    public static boolean onlyDigits(String str){
        if(str.isEmpty()){
            return true;
        }
        char firstSymbol = str.charAt(0);
        if(!Character.isDigit(firstSymbol)){
            return false;
        }
        return onlyDigits(str.substring(1));
    }
    public static void problem9(){
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.print(binomial(n, k));
    }
    public static long binomial(int n, int k){
        if(k == 0 || k == n){
            return 1;
        }
        return binomial(n - 1, k - 1) + binomial(n - 1, k);
    }
    public static void problem10(){
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.print(gcd(a, b));
    }
    public static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a, a);
    }
}