public class User {
//        -유저
//    변수:사용자 입력값->값1,값2, 값3
//    사용자 게임종료 또는 재실행 변수
//    입력값 처리하는 메서드(랜덤)
    int[] userInput = new int[3];

    public User(){}

    public int[] getUserArr(String userInputArr){

        for (int i = 0; i < userInputArr.length()-1; i++){
           userInput[i]=Integer.parseInt(userInputArr.substring(i, i+1));

        }
        //유저입력값의 길이가 3인지 확인
        isPermitLength(userInput);
        //각각 다른 값인지 확인
        isPermitDifferent(userInput);
        //숫자가 1-9인지 확인
        isPermitNum(userInput);

        return userInput;
    }

    public boolean isPermitLength(int[] arr){
        if(arr.length!=3)return false;
        return true;
    }
    public boolean isPermitDifferent(int[]arr){
       if(arr[0] == arr[1] || arr[1]== arr[2] || arr[0]==arr[2]) return false;
       return true;
    }
    public boolean isPermitNum(int[] arr){
        if((arr[0]>0 && arr[0] <= 9)&& (arr[1] > 0 && arr[1] <= 9) && (arr[2]>0 && arr[2] <= 9))return false;
        return true;
    }





}
