package list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No17827 {
    // 달팽이 리스트 (시간 제한: 1초, 메모리 제한: 256MB)
    // 정답
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 노드, 질문의 숫자와 마지막 노드가 가리키는 노드의 인덱스 번호를 입력받는 구간
        String[] firstLine = br.readLine().split(" ");
        int nodeNum = Integer.parseInt(firstLine[0]);
        int questionNum = Integer.parseInt(firstLine[1]);
        int lastIndex = Integer.parseInt(firstLine[2]);

        int[] nodes = new int[nodeNum];
        // 각 노드의 값을 받는 두번째 입력문
        String[] secondLine = br.readLine().split(" ");
        for (int i = 0; i < nodeNum; i++) {
            nodes[i] = Integer.parseInt(secondLine[i]);
        }

        // 질문들이 입력되는 부분(x번 움직였을 때의 값을 저장해야 한다.)
        for (int i = 0; i < questionNum; i++) {
            int move = Integer.parseInt(br.readLine());
            if (move > lastIndex - 1) {
                int cycleNum = nodeNum - lastIndex + 1;
                int moveBeforeCycle = lastIndex - 1;
                move = moveBeforeCycle + ((move - moveBeforeCycle) % cycleNum);
            }
            int value = nodes[move];
            sb.append(value + "\n");
        }

        System.out.println(sb);
    }
}
