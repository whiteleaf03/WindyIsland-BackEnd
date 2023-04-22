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
public class MessageAuditInfoVo {
    /**
     * 评论用户邮箱
     */
    private String email;

    /**
     * 评论内容
     */
    private String content;
}
