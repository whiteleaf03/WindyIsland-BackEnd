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
public class ClassificationIdAndNameAndCoverAndTotalVo {
    /**
     * 分类id
     */
    private Long id;

    /**
     * 分类名
     */
    private String name;

    /**
     * 分类封面
     */
    private String cover;

    /**
     * 文章数量
     */
    private Integer total;
}
