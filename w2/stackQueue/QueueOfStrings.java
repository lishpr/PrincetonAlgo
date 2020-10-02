package stackQueue;

public interface QueueOfStrings<Item> {
    void enqueue(Item item);
    Item deque();
    int size();
    void printQueue();
}
