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
public class InsertEssayDto {
    /**
     * 随笔标题
     */
    private String title;

    /**
     * 随笔副标题
     */
    private String describe;

    /**
     * 随笔封面图片路径
     */
    private String cover;

    /**
     * 随笔内容 富文本形式
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

    public void generateEssayInfo() {
        this.createTime = System.currentTimeMillis();
        this.updateTime = this.createTime;
    }
}
