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
public class ArticleTag {
    /**
     * 博客id
     */
    private Long articleId;

    /**
     * 标签id
     */
    private Long tagId;
}
