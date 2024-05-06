package baseballgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class playgame {
    Scanner scanner = new Scanner(System.in);
    public List<Integer> player_num() {

        System.out.println("Enter Number : ");
        List<Integer> player_num = new ArrayList<>();
        String input = String.valueOf(scanner.nextInt());

        for(int i=0; i<input.length(); i++){
            int digit = Character.getNumericValue(input.charAt(i));
            if (!player_num.contains(digit)) {
                player_num.add(Integer.parseInt(String.valueOf(digit)));
          }
        }

        Length_exception(input);
        return player_num;
    }
    public void Length_exception(String s){
        if(s.length() != 3) {
            throw new IllegalArgumentException("Not a three digit number");
        }
    }

}
