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
public class ArticleDetailVo {
    /**
     * 作者
     */
    private String author;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章副标题
     */
    private String describe;

    /**
     * 文章所属分类
     */
    private String classification;

    /**
     * 标签 多个标签以空格分割
     */
    private String tags;

    /**
     * 文章封面图片路径
     */
    private String cover;

    /**
     * 文章内容 富文本形式
     */
    private String content;

    /**
     * 更新日期
     */
    private Long updateTime;
}
