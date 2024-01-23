package baekjoon;

import java.sql.SQLOutput;
import java.util.*;

/*
 * @Title: 선수과목
 * @Link: https://www.acmicpc.net/problem/14567
 * @Ex: 올해 Z대학 컴퓨터공학부에 새로 입학한 민욱이는 학부에 개설된 모든 전공과목을 듣고 졸업하려는 원대한 목표를 세웠다. 어떤 과목들은 선수과목이 있어 해당되는 모든 과목을 먼저 이수해야만 해당 과목을 이수할 수 있게 되어 있다. 공학인증을 포기할 수 없는 불쌍한 민욱이는 선수과목 조건을 반드시 지켜야만 한다. 민욱이는 선수과목 조건을 지킬 경우 각각의 전공과목을 언제 이수할 수 있는지 궁금해졌다. 계산을 편리하게 하기 위해 아래와 같이 조건을 간소화하여 계산하기로 하였다.

한 학기에 들을 수 있는 과목 수에는 제한이 없다.
모든 과목은 매 학기 항상 개설된다.
모든 과목에 대해 각 과목을 이수하려면 최소 몇 학기가 걸리는지 계산하는 프로그램을 작성하여라.
* 첫 번째 줄에 과목의 수 N(1 ≤ N ≤ 1000)과 선수 조건의 수 M(0 ≤ M ≤ 500000)이 주어진다.
* 선수과목 조건은 M개의 줄에 걸쳐 한 줄에 정수 A B 형태로 주어진다. A번 과목이 B번 과목의 선수과목이다.
* A < B인 입력만 주어진다. (1 ≤ A < B ≤ N)
* 3 2
2 3
1 2
*
* ->1 2 3
*       6 4
        1 2
        1 3
        2 5
        4 5 -> 1 2 2 1 3 1
 * */
public class Prerequisite {

    static int[] answer;

    // [[2,3],[1,2]] -> 1,2,3

    static class Subject {
        int no;
        List<Subject> prev;

        int count;

        public Subject(int no) {
            this.no = no;
            this.prev = new ArrayList<Subject>();
            this.count = 1;
        }

        @Override
        public String toString() {
            return "Subject{" +
                    "no=" + no +
                    ", prev=" + prev +
                    ", count=" + count +
                    '}';
        }
    }

    public int[] solution(int subjectCnt, int conditionLen, int[][] conditions) {

        answer = new int[subjectCnt];
        boolean[] condCheck = new boolean[conditionLen];
        List<Subject> list = new ArrayList<>();

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        };

        for(int i=1; i <= subjectCnt; i++) {
            list.add(new Subject(i));
        }
        Arrays.sort(conditions, comparator);

        Queue<int[]> que = new LinkedList<>();

        for(int i=0; i<conditionLen; i++) {
            que.offer(conditions[i]);

            while(!que.isEmpty()) {
                int[] cur = que.poll();
                int prev = cur[0];
                int next = cur[1];

                Subject nextSubject = list.get(next-1);

                if(!condCheck[i] && conditions[i][1] == next) {
                    condCheck[i] = true;

                    if(nextSubject.count <= list.get(prev -1).count) {
                        nextSubject.count = list.get(prev-1).count + 1;
                    }

                    nextSubject.prev.add(list.get(prev - 1));
                    list.set(next - 1, nextSubject);
                }
            }
        }

        for(Subject sub : list) {
            answer[sub.no-1] = sub.count;
        }

        return answer;
    }

    public static void main(String[] args) {
        Prerequisite prerequisite = new Prerequisite();

        System.out.println(Arrays.toString(prerequisite.solution(3,2, new int[][]{{2,3},{1,2}}))); // 1 2 3
        System.out.println(Arrays.toString(prerequisite.solution(6,4, new int[][]{{1,2},{1,3},{2,5},{4,5}}))); // 1 2 2 1 3 1

    }
}
