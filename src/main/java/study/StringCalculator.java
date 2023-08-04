package study;

public class StringCalculator {

    public StringCalculator(){
    }

    public String[] split(String s){
        return s.split(" ");
    }

    public int calculate(String[] strings){

        int[] nums = new int[strings.length/2 + 1];
        String[] oper = new String[strings.length/2];

        int numsI = 0;
        int operI = 0;
        for(String s : strings){

            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                oper[operI++] = s;
            }else{
                nums[numsI++] = Integer.parseInt(s);
            }
        }

        int sum = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            if(oper[i-1].equals("+")){
                sum += nums[i];
            }else if(oper[i-1].equals("-")){
                sum -= nums[i];
            }else if(oper[i-1].equals("*")){
                sum *= nums[i];
            }else if(oper[i-1].equals("/")){
                sum /= nums[i];
            }
        }

        return sum;
    }





}
