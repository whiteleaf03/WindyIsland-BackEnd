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
public class TagListVo {
    /**
     * 主键自增
     */
    private Long id;

    /**
     * 标签名
     */
    private String name;
}
