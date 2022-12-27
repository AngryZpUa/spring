package main;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //First line of code for log4j
        BasicConfigurator.configure();
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Comment comment1 = context.getBean(Comment.class);
        comment1.setAuthor("AngryZpUa");
        comment1.setText("Demo comment");
        context.getBean(UserService.class).publishComment(comment1);
        Comment comment2 = context.getBean(Comment.class);
        comment2.setAuthor("AngryZpUa");
        comment2.setText("TestComment");
        context.getBean(CommentService.class).publishComment(comment2);
        boolean b = comment1 == comment2;
        System.out.println("comment1 == comment2: " + b);
    }
}
