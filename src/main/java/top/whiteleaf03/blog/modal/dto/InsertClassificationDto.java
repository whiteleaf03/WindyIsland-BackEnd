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
public class InsertClassificationDto {
    /**
     * 分类名
     */
    private String name;

    /**
     * 上传时间
     */
    private Long updateTime;

    public void generate() {
        this.updateTime = System.currentTimeMillis();
    }
}
