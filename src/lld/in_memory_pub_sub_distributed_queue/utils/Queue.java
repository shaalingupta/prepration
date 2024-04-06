package lld.in_memory_pub_sub_distributed_queue.utils;

import lld.in_memory_pub_sub_distributed_queue.handler.TopicHandler;
import lld.in_memory_pub_sub_distributed_queue.inter.ISubscriber;
import lld.in_memory_pub_sub_distributed_queue.model.Message;
import lld.in_memory_pub_sub_distributed_queue.model.Topic;
import lld.in_memory_pub_sub_distributed_queue.model.TopicSubscriber;

import javax.annotation.Nonnull;
import java.util.*;

public class Queue {
    private final Map<String, TopicHandler> topicProcessors;

    public Queue() {
        this.topicProcessors = new HashMap<>();
    }

    public Topic createTopic(@Nonnull final String topicName){
        final Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler = new TopicHandler(topic);
        topicProcessors.put(topic.getTopicId(), topicHandler);
        System.out.println("Created topic :" + topic.getTopicName());
        return topic;
    }

    public void subscribe(@Nonnull final ISubscriber subscriber, @Nonnull final Topic topic){
        topic.addSubscriber(new TopicSubscriber(subscriber));
        System.out.println(subscriber.getId() + " Subscriber to topic : "+ topic.getTopicName());
    }

    public void publish(@Nonnull final Topic topic, @Nonnull final Message message){
        topic.addMessage(message);
        System.out.println(message.getContent() + " published to topic : "+ topic.getTopicName());
        new Thread(() -> topicProcessors.get(topic.getTopicId()).publish()).start();
    }

    public void resetOffset(@Nonnull final Topic topic, @Nonnull final ISubscriber subscriber, @Nonnull final Integer newOffset){
        for (TopicSubscriber topicSubscriber : topic.getSubscribers()){
            if (topicSubscriber.getSubscriber().equals(subscriber)){
                topicSubscriber.getOffset().set(newOffset);
                System.out.println(topicSubscriber.getSubscriber().getId()+" offset reset to: "+newOffset);
                new Thread(() -> topicProcessors.get(topic.getTopicId()).startSubscriberWorker(topicSubscriber)).start();
                break;
            }
        }
    }
}
