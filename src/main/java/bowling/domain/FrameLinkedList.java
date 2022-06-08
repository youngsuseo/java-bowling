package bowling.domain;

public class FrameLinkedList {
    private int size;
    private Frame head;

    FrameLinkedList() {
        this.head = new NormalFrame();
    }

    void add(Frame newFrame) {
        Frame tempHead = this.head;
        while (tempHead.next != null) {
            tempHead = tempHead.next;
        }
        tempHead.next = newFrame;
        this.size++;
    }

    public Frame get() {
        return head;
    }

    public Frame get(int index) {
        return search(index);
    }

    // 특정 위치의 노드를 반환하는 메소드
    private Frame search(int index) {

        // 범위 밖(잘못된 위치)일 경우 예외 던지기
//        if(index < 0 || index >= size) {
//            throw new IndexOutOfBoundsException();
//        }

        Frame start = head; // head부터 시작

        for (int i = 0; i < index; i++) {
            start = start.next; // x노드의 다음 노드를 x에 저장한다.
        }
        return start;
    }

    public int size() {
        return size;
    }
}