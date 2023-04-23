package top.whiteleaf03.blog.modal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WhiteLeaf03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertMessageDto {
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

    public void generateArticleInfo() {
        this.updateTime = System.currentTimeMillis();
        this.status = 0;
    }
}
