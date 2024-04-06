package lld.in_memory_pub_sub_distributed_queue.model;

import lld.in_memory_pub_sub_distributed_queue.inter.ISubscriber;

import java.util.concurrent.atomic.AtomicInteger;

public class TopicSubscriber {

    private final AtomicInteger offset;
    private final ISubscriber subscriber;

    public TopicSubscriber(ISubscriber subscriber) {
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }

    public AtomicInteger getOffset() {
        return offset;
    }

    public ISubscriber getSubscriber() {
        return subscriber;
    }
}
