package baekjoon;

import java.util.*;
import java.util.stream.Collectors;
/*
@Title: 십자 뒤집기
@Link: https://www.acmicpc.net/problem/10472
 */

public class CrossReverse {

    static String changeToBinary(String[] boards) {
        String bit = "";

        for(int i=0; i< boards.length; i++) {
            for(int j=0; j < boards[i].length(); j++) {
                bit += boards[i].charAt(j) == '*' ? 0 : 1;
            }
        }

        return bit;
    }

    static char changed(char point) {
        return point == '0' ? '1' : '0';
    }

    static String click(String bit, int idx) {
        StringBuffer sb = new StringBuffer(bit);
        sb.setCharAt(idx, changed(bit.charAt(idx)));
        if(idx+1  < bit.length() && ((idx % 3) != 2)) sb.setCharAt(idx+1, changed(bit.charAt(idx+1)));
        if(idx-1 >= 0 && ((idx % 3) != 0)) sb.setCharAt(idx-1, changed(bit.charAt(idx-1)));
        if(idx+3 < bit.length()) sb.setCharAt(idx+3, changed(bit.charAt(idx+3)));
        if(idx-3 >= 0) sb.setCharAt(idx-3, changed(bit.charAt(idx-3)));

        return sb.toString();
    }

    public int solution(String[] boards) {
        int answer = Integer.MAX_VALUE;
        Boolean[] isDup = new Boolean[Integer.parseInt("111111111",2)+1];
        Arrays.fill(isDup, false);

        Queue<String[]> que = new LinkedList<>();
        que.offer(new String[]{changeToBinary(boards),"0"});

        while(!que.isEmpty()) {
            String[] item = que.poll();
            String cur = item[0];
            Integer cnt = Integer.parseInt(item[1]);

            isDup[Integer.parseInt(cur, 2)] = true;

            for(int i=0; i < cur.length(); i++) {
                String next = click(cur, i);
                if(next.equals("111111111")) return answer > cnt+1 ? cnt+1 : answer;

                if(!isDup[Integer.parseInt(next,2)]) {
                    que.offer(new String[]{next, String.valueOf(cnt+1)});
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        CrossReverse crossReverse = new CrossReverse();

        System.out.println(crossReverse.solution(new String[]{"*..", "**.", "*.."})); // 1
        System.out.println("*********");
        System.out.println(crossReverse.solution(new String[]{"***", "*..","..*"})); // 3
    }
}
