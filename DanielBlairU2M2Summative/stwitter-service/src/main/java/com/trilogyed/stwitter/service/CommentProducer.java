package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Component
public class CommentProducer {

    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "comment.create.#";
    public static final String SAVE_QUEUED_MSG = "Comment(s) queued for save";
    public static final String UPDATE_QUEUED_MSG = "Comment(s) queued for update";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public CommentProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public String createComment(@RequestBody @Valid Comment comment) {
        Comment msg = new Comment(0, comment.getPostId(), comment.getCreateDate(), comment.getCommenterName(), comment.getComment());
        System.out.println("Sending comment...");
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, msg);
        System.out.println("Comment Sent");
        return SAVE_QUEUED_MSG;
    }

    @PutMapping(value = "/comments/{comment_id}")
    public String updateComment(@PathVariable int comment_id, @RequestBody Comment comment) {

        Comment msg = new Comment(comment_id, comment.getPostId(), comment.getCreateDate(), comment.getCommenterName(), comment.getComment());
        System.out.println("Sending comment...");
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, msg);
        System.out.println("Comment update sent");

        return UPDATE_QUEUED_MSG;
    }
}
