package createrandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateRandomThreeDigits {

    private final int LIST_SIZE = 3;

    public void main(String[] args) {
        randomNumbers();
        System.out.println(randomNumbers());
    }

    public ArrayList<Integer> randomNumbers() {

        ArrayList<Integer> list = new ArrayList<>();
        while (list.size() < LIST_SIZE) {
            checkRandomNo(list);
        }
        return list;
    }

    private void checkRandomNo(ArrayList<Integer> list) {
        int randomNo = new Random().nextInt(9) + 1;
        if (!list.contains(randomNo)) {
            list.add(randomNo);
        }
    }

    public boolean checkDuplicate(List<Integer> asList) {

        if (asList.get(0).equals(asList.get(1))
                || asList.get(0).equals(asList.get(2))
                || asList.get(1).equals(asList.get(2))) {
            return false;
        }

        return true;
    }

    public boolean checkThreeDigits(List<Integer> asList) {

        return asList.size() == LIST_SIZE;
    }
}
