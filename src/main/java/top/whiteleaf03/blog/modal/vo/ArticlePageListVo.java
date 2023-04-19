package top.whiteleaf03.blog.modal.vo;

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
public class ArticlePageListVo {
    /**
     * 主键
     */
    private Long id;

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
    private List<String> tags;

    /**
     * 封面外边框颜色
     */
    private String borderColor;

    /**
     * 文章封面图片路径
     */
    private String cover;

    /**
     * 浏览量
     */
    private Long view;

    /**
     * 评论量
     */
    private Long comment;

    /**
     * 创建日期
     */
    private Long createTime;

    /**
     * 更新日期
     */
    private Long updateTime;

    /**
     * 是否删除
     */
    private Boolean isDelete;
}
