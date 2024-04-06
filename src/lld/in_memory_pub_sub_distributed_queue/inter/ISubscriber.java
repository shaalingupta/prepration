package lld.in_memory_pub_sub_distributed_queue.inter;

import lld.in_memory_pub_sub_distributed_queue.model.Message;

public interface ISubscriber {
    String getId();
    void consume(Message message) throws InterruptedException;
}
