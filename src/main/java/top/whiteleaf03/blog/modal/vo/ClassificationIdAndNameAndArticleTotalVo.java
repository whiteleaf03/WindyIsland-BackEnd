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
public class ClassificationIdAndNameAndArticleTotalVo {
    /**
     * 分类id
     */
    private Long id;

    /**
     * 分类名
     */
    private String name;

    /**
     * 文章数量
     */
    private Integer total;
}
