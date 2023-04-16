package top.whiteleaf03.blog.modal.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WhiteLeaf03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageVo {
    /**
     * 昵称
     */
    private String nickname;

    /**
     * 评论
     */
    private String content;

    /**
     * 评论日期
     */
    private Long updateTime;
}
