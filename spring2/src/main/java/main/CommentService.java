package main;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class CommentService implements ServiceInterface{

    @Autowired
    private CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
    private Logger logger = Logger.getLogger(CommentService.class.getName());


    public CommentService(@Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentNotificationProxy = commentNotificationProxy;
        System.out.println("CommentService instance created!");
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }

    public CommentRepository getCommentRepository() {
        return this.commentRepository;
    }
}
