//package queue;
//
//
//import java.util.Scanner;
//
//class No1966 {
//    static class Doc {
//        private boolean isToFind; // 내가 찾으려고 하는 문서인지 확인
//        private int importance; // 문서의 중요도
//        private Doc nextDoc;
//
//        Doc() { this(0, false); };
//        Doc(int importance, boolean isToFind) {
//            this.importance = importance;
//            this.isToFind = isToFind;
//            this.nextDoc = null;
//        }
//
//        boolean getIsToFind() { return this.isToFind; }
//        Doc next() {
//            return nextDoc;
//        }
//        Doc setNext(Doc docToSet) {
//            return this.nextDoc = docToSet;
//        }
//    }
//
//    static class LinkedListOfDocs {
//        private Doc front;
//        private Doc rear;
//        private int cnt;
//
//        LinkedListOfDocs() { init(); }
//
//        void init() {
//            front = rear = new Doc();
//            cnt = 0;
//        }
//
//        void enqueue(Doc docToIn) {
//            if (cnt == 0) {
//                front = rear = docToIn;
//                rear.setNext(null);
//                cnt++;
//                return;
//            }
//            rear.setNext(docToIn);
//            rear = rear.next();
//            rear.setNext(null);
//            cnt++;
//        }
//
//        // dequeue와 같은 역할. 디큐 했을 때 튀어 나온 문서가 찾는 문서라면 true를, 아니거나 큐의 길이가 0이라면 false 리턴
//        boolean print() {
//            if (cnt <= 0) {
//                System.out.println("print에서 걸러");
//                return false;
//            }
//            System.out.println("cnt빼기전: " + cnt);
//            Doc delete = front;
//            front = front.next();
//            cnt--;
//            System.out.println("cnt 뺀 : " + cnt);
//            return delete.getIsToFind();
//        }
//
//        // 파라미터로 들어온 문서의 중요도를 리턴
//        int checkImportance(Doc doc) {
//            return doc.importance;
//        }
//
//        // 제일 앞에 있는 문서의 중요도를 확인하고, 남은 문서 중 중요도가 더 높은 것이 있으면 현재 문서를 tail로 보내는 과정을 반복하여
//        // 중요도를 내림차순으로 정렬한다.
//        boolean move(Doc doc) {
//            int imp = checkImportance(doc);
//            System.out.println("imp: " + imp);
//            // 종료 조건 개선해야
//            for (Doc temp = front; temp != null; temp = temp.next()) {
//                System.out.println("무섭");
//                if (checkImportance(temp) > imp) {
//                    rear.setNext(front);
//                    rear = front;
//                    front = front.next();
//                    rear.setNext(null);
//                    System.out.println("move true / temp.importance: " + checkImportance(temp));
//                    return true;
//                }
//            }
//            System.out.println("move false");
//            return false;
//        }
//    }
//
//    public static void main(String[] args) {
//        LinkedListOfDocs list;
//        Scanner stdIn = new Scanner(System.in);
//
//        int testCase = stdIn.nextInt();             // 테스트 케이스의 개수
//        for (int i = 0; i < testCase; i++) {
//            list = new LinkedListOfDocs();
//            int numDoc = stdIn.nextInt();           // 문서의 개수
//            int docToFind = stdIn.nextInt();        // 찾으려는 문서의 처음 위치수
//
//            // 리스트 생성
//            for (int j = 0; j < numDoc; j++) {
//                System.out.println("리스트 생성 in");
//                int importance = stdIn.nextInt();
//                if (j == docToFind)
//                    list.enqueue(new Doc(importance, true));
//                else
//                    list.enqueue(new Doc(importance, false));
//            }
//
//            // 리스트 순회하면서 찾으면 반환하고 아니면 뒤로 미루면서 원하는 문서를 찾아냄.
//            Doc temp = list.front;
//            while(temp != null) {
//                System.out.println("dd");
//                // list.move(temp)의 결과가 false, 즉 뒤에 더 큰 중요도를 가진 문서가 없는 경우(이럼 인쇄해야함)
//                // && 인쇄하는 문서가 내가 찾는 문서인 경우
//                if(!list.move(temp) && list.print()) {
//                    System.out.println("결과: " + (numDoc - list.cnt));
//                    break;
//                }
//                temp = temp.next();
//            }
//        }
//    }
//}
