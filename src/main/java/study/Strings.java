package study;

public class Strings {
    public String splitNoParenthesis(String value) {
        if (Character.toString(value.charAt(0)).equals("(")
                && Character.toString(value.charAt(value.length()-1)).equals(")")){
            return value.substring(1, value.length()-1);
        }
        return value;
    }

}
