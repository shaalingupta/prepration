package lld.in_memory_pub_sub_distributed_queue.handler;

import lld.in_memory_pub_sub_distributed_queue.model.Message;
import lld.in_memory_pub_sub_distributed_queue.model.Topic;
import lld.in_memory_pub_sub_distributed_queue.model.TopicSubscriber;

import javax.annotation.Nonnull;

public class SubscriberWorker implements Runnable{
    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberWorker(@Nonnull final Topic topic, @Nonnull final TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }


    @Override
    public void run() {
        synchronized (topicSubscriber) {
            do {
                try {
                    int currentOffset = topicSubscriber.getOffset().get();
                    while (currentOffset >= topic.getMessages().size()) {
                        topicSubscriber.wait();
                    }
                    Message message = topic.getMessages().get(currentOffset);
                    topicSubscriber.getSubscriber().consume(message);

                    topicSubscriber.getOffset().compareAndSet(currentOffset, currentOffset+1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } while (true);
        }
    }

    synchronized public void wakeUpIfNeeded(){
        synchronized (topicSubscriber){
            topicSubscriber.notify();
        }
    }
}
