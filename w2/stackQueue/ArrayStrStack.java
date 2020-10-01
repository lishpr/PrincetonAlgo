package stackQueue;

public class ArrayStrStack implements StackOfStrings {
    private String[] stack;
    private int size;
    private int endPointer;

    public ArrayStrStack() {
        stack = new String[16];
        size = 16;
        endPointer = 0;
    }

    public void printStack() {
        for (int i = 0; i < endPointer; i++) {
            System.out.printf("[%s]", stack[i]);
        }
        System.out.println();
    }

    public void push(String item) {
        if (endPointer == size) {
            String[] a = new String[size * 2];
            for (int i = 0; i < size; i++) {
                a[i] = stack[i];
            }
            stack = a;
            size *= 2;
        }
        stack[endPointer] = item;
        endPointer++;
    }

    public String pop() {
        if (isEmpty()) return null;
        return stack[--endPointer];
    }

    public boolean isEmpty() {
        if (endPointer == 0) return true;
        else return false;
    }

    public int size() {
        return endPointer;
    }


}
