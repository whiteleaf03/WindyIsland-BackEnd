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
public class PictureDetailVo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 文件名
     */
    private String name;

    /**
     * 上传日期
     */
    private Long updateTime;
}
