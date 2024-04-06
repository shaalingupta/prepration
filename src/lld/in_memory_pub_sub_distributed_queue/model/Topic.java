package lld.in_memory_pub_sub_distributed_queue.model;


import javax.annotation.Nonnull;
import java.util.*;

public class Topic {
    private final String topicName;
    private final String topicId;
    private final List<Message> messages;
    private final List<TopicSubscriber> subscribers;

    public Topic(@Nonnull String topicName, @Nonnull String topicId) {
        this.topicName = topicName;
        this.topicId = topicId;
        this.messages = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public  synchronized void addMessage(@Nonnull final Message message){
        this.messages.add(message);
    }

    public void addSubscriber(@Nonnull final TopicSubscriber subscriber){
        this.subscribers.add(subscriber);
    }

    public String getTopicName() {
        return topicName;
    }

    public String getTopicId() {
        return topicId;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<TopicSubscriber> getSubscribers() {
        return subscribers;
    }


}
