package stringCalculator;

public class StringToInt {

    StringSplitter split = new StringSplitter();

    int[] number = new int[split.strToSplit.length / 2 + 1];
    String[] operator = new String[split.strToSplit.length / 2];

    //숫자만 int형으로
    public int[] toInt(String[] strToSplit) {
        int orderOfNum = 0;
        int orderOfStr = 0;

        for (int i = 0; i < strToSplit.length; i++) {
            if (i % 2 == 0) {
                number[orderOfNum] = Integer.parseInt(strToSplit[i]);
                orderOfNum++;
            }
            if (i % 2 != 0) {
                operator[orderOfStr] = strToSplit[i];
                orderOfStr++;
            }
        }
        return number;
    }

}
