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
public class MessagePageDto {
    /**
     * 分页查询页号
     */
    private Integer page;
}