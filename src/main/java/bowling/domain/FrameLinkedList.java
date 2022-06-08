package bowling.domain;

class FrameLinkedList {
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
    }

    public Frame get() {
        return head;
    }
}