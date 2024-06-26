import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ComputerTest {
    Computer computer = new Computer();


    @Test
    public void getComputerRandomValue() {
        //arr의 랜덤한 값을 배열로 받아오고 길이가 3인지 판단한다.
       int [] arr= computer.getComputerArr();
        System.out.println(arr.length);


       //숫자가 1-9사이인지 판단한다.
        for(int value:arr){
            assertTrue(value>0 && value<=9);
        }

       //각각 다른숫자인지 판단한다.
        int count = 0;
        int numTests = 10;
        while(count < numTests){
            for (int i = 0; i < arr.length-1; i++) {
                assertTrue(arr[i] != arr[i+1]);
            }
            count++;

        }

    }

}