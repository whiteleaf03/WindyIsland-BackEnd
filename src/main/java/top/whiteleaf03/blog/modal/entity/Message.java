package top.whiteleaf03.blog.modal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WhiteLeaf03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
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
     * 留言
     */
    private String content;

    /**
     * 留言日期
     */
    private Long updateTime;

    /**
     * 状态 0 未审核 1 已过审 -1 被封禁
     */
    private Integer status;

    /**
     * 是否删除
     */
    private Boolean isDelete;
}
