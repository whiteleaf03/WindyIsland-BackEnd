package top.whiteleaf03.blog.modal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateArticleDto {
    /**
     * 文章主键
     */
    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 分类id
     */
    private Long classificationId;

    /**
     * 标签id列表
     */
    private List<Long> tagIds;

    /**
     * 封面图片路径
     */
    private String cover;

    /**
     * 文章简介
     */
    private String describe;

    /**
     * 边框颜色
     */
    private String borderColor;
}
