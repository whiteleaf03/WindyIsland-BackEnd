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
public class MessageInfoVo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 评论
     */
    private String content;

    /**
     * 评论日期
     */
    private Long updateTime;

    /**
     * 状态 0 未审核 1 已过审 -1 被封禁
     */
    private Integer status;
}
