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
public class Article {
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
     * 封面外边框颜色
     */
    private String borderColor;

    /**
     * 文章封面图片路径
     */
    private String cover;

    /**
     * 文章内容 富文本形式
     */
    private String content;

    /**
     * 浏览量
     */
    private Long view;

    /**
     * 留言量
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
