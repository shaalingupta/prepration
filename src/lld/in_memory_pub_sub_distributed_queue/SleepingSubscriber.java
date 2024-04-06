package lld.in_memory_pub_sub_distributed_queue;

import lld.in_memory_pub_sub_distributed_queue.inter.ISubscriber;
import lld.in_memory_pub_sub_distributed_queue.model.Message;

public class SleepingSubscriber implements ISubscriber {

    private final String id;
    private final int sleepTimeInMillis;

    public SleepingSubscriber(String id, int sleepTimeInMillis) {
        this.id = id;
        this.sleepTimeInMillis = sleepTimeInMillis;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void consume(Message message) throws InterruptedException {
        System.out.println("Subscriber : " + this.id + " started consuming: "+ message.getContent());
        Thread.sleep(sleepTimeInMillis);
        System.out.println("Subscriber : "+ this.id + " done consuming: "+ message.getContent());
    }
}
