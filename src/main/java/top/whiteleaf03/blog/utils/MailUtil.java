package top.whiteleaf03.blog.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author WhiteLeaf03
 */
@Component
public class MailUtil {
    private final JavaMailSender javaMailSender;

    @Autowired
    public MailUtil(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * 发送审核提醒邮件
     *
     * @param message 留言内容
     */
    public void sentMessageToAdmin(String nickname, String message) {
        javaMailSender.send(new SimpleMailMessage() {{
            setSubject("[风之屿博客]来自用户[" + nickname + "]的新评论");
            setText(message);
            setFrom("whiteleaf03@163.com");
            setTo("2876202234@qq.com");
        }});
    }

    /**
     * 发送评论过审邮件
     *
     * @param target 目标用户邮箱
     * @param message 留言内容
     */
    public void sentMessageToUser(String target, String message) {
        javaMailSender.send(new SimpleMailMessage() {{
            setSubject("[风之屿博客]评论过审通知");
            setText("您的评论[" + message + "]管理员已通过审核");
            setFrom("whiteleaf03@163.com");
            setTo(target);
        }});
    }
}
