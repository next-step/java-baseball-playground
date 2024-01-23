package baekjoon;

import java.util.*;
import java.util.stream.Collectors;

/*

당신에게 3x3 크기의 보드가 주어진다. 각각의 칸은 처음에 흰색 혹은 검은색이다.
만약 당신이 어떤 칸을 클릭한다면 당신이 클릭한 칸과 그 칸에 인접한 동서남북 네 칸이 (존재한다면) 검은색에서 흰색으로, 혹은 흰색에서 검은색으로 변할 것이다.
당신은 모든 칸이 흰색인 3x3 보드를 입력으로 주어지는 보드의 형태로 바꾸려고 한다. 보드를 회전시킬수는 없다.
첫 줄에는 테스트 케이스의 숫자 P(0 < P ≤ 50)이 주어진다.
각각의 테스트 케이스에 대해서 세 줄에 걸쳐 한 줄에 세 글자씩이 입력으로 들어온다. "*"은 검은색을 뜻하며 "."은 흰색을 뜻한다.
각각의 테스트 케이스에 대해서 흰 보드를 입력에 주어진 보드로 바꾸는 데 필요한 최소 클릭의 횟수를 구하여라.
-> 1
3

 */
public class CrossReverse {

    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    static boolean check(int[] node, String[] boards) {
        int nx = node[0];
        int ny = node[1];

        if(ny > 0) {
            if(boards[ny+1].charAt(nx) != '.') return false;
        }

        if(ny < 3) {
            if(boards[ny-1].charAt(nx) != '.') return false;
        }

        if(nx > 0) {
            if(boards[ny].charAt(nx-1) != '.') return false;
        }

        if(nx < 3) {
            if(boards[ny].charAt(nx+1) != '.') return false;
        }

        return true;
    }

    public int solution(String[] boards) {
        int answer = Integer.MAX_VALUE;

        boolean[][] visited = new boolean[][]{};
        List<List<String>> list = new ArrayList<>();
        Queue<int[]> que = new LinkedList<>();

//        for(String board : boards) {
//            List<String> str = Arrays.stream(board.split("")).collect(Collectors.toList());
//            list.add(str);
//        }

        que.add(new int[]{0,0});
        String[] changedBoard = boards.clone();
        int cnt = 0;

        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];

            if(!check(new int[]{cx, cy}, changedBoard)) {
                if (cy > 0) {
                    StringBuilder changedLine =  new StringBuilder(changedBoard[cy + 1]);
                    changedLine.setCharAt(cx, '.');
                    changedBoard[cy + 1] = changedLine.toString();
                }
                if(cy < 3) {
                    StringBuilder changedLine =  new StringBuilder(changedBoard[cy - 1]);
                    changedLine.setCharAt(cx, '.');
                    changedBoard[cy - 1] = changedLine.toString();
                }

                if(cx > 0) {
                    StringBuilder changedLine =  new StringBuilder(changedBoard[cy]);
                    changedLine.setCharAt(cx-1, '.');
                    changedBoard[cy] = changedLine.toString();
                }

                if(cx < 3) {
                    StringBuilder changedLine =  new StringBuilder(changedBoard[cy]);
                    changedLine.setCharAt(cx+1, '.');
                    changedBoard[cy] = changedLine.toString();
                }
                cnt++;
            }

            for(int i=0; i <dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < 3 && ny >= 0 && ny < 3 && !visited[ny][nx]) {
                    if(!check(new int[]{nx, ny}, changedBoard)) {

                    }
                }
            }
        }





        return answer;
    }

    public static void main(String[] args) {
        CrossReverse crossReverse = new CrossReverse();

        System.out.println(crossReverse.solution(new String[]{"*..", "**.", "*.."})); // 1
        System.out.println(crossReverse.solution(new String[]{"***", "*..","..*"})); // 3
    }
}
