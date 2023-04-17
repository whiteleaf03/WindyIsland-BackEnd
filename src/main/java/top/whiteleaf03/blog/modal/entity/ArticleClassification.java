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
public class ArticleClassification {
    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 分类id
     */
    private Long classificationId;
}
