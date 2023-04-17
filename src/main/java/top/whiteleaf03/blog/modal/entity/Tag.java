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
public class Tag {
    /**
     * 主键自增
     */
    private Long id;

    /**
     * 标签名
     */
    private String name;

    /**
     * 上传时间
     */
    private Long updateTime;

    /**
     * 是否删除
     */
    private Boolean isDelete;
}
