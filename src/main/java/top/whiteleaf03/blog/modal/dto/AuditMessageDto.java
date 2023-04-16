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
public class AuditMessageDto {
    /**
     * 评论主键
     */
    private Long id;

    /**
     * 状态 0 未审核 1 已过审 -1 被封禁
     */
    private Long status;
}
