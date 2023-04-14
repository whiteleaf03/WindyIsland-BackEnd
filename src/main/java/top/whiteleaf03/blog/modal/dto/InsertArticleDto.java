package top.whiteleaf03.blog.modal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author WhiteLeaf03
 */
@Data
@AllArgsConstructor
public class InsertArticleDto {
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
     * 创建日期
     */
    private Long createTime;

    /**
     * 更新日期
     */
    private Long updateTime;

    public void generateArticleInfo() {
        this.createTime = System.currentTimeMillis();
        this.updateTime = this.createTime;
    }
}
