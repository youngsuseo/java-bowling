package bowling.domain;

public class FrameLinkedList {
    private static final int INITIAL_SIZE = 1;

    private int size;
    private Frame head;

    FrameLinkedList() {
        this.head = new NormalFrame();
        this.size = INITIAL_SIZE;
    }

    void add(Frame newFrame) {
        Frame tempHead = this.head;
        while (tempHead.next != null) {
            tempHead = tempHead.next;
        }
        tempHead.next = newFrame;
        this.size++;
    }

    Frame get() {
        return head;
    }

    public Frame get(int index) {
        return search(index);
    }

    private Frame search(int index) {

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