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
public class Picture {
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

    /**
     * 是否删除
     */
    private Boolean isDelete;

    public Picture(String name, Long updateTime) {
        this.name = name;
        this.updateTime = updateTime;
    }
}

