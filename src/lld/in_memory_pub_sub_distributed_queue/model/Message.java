package lld.in_memory_pub_sub_distributed_queue.model;

public class Message {
    private final String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
