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
public class EssayListVo {
    /**
     * 随笔主键
     */
    private Long id;

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
     * 更新日期
     */
    private Long updateTime;

    /**
     * 文件名
     */
    private String filename;
}
