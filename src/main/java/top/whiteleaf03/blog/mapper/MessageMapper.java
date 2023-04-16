package top.whiteleaf03.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.whiteleaf03.blog.modal.dto.AuditMessageDto;
import top.whiteleaf03.blog.modal.dto.InsertMessageDto;
import top.whiteleaf03.blog.modal.dto.MessageIdDto;
import top.whiteleaf03.blog.modal.vo.MessageVo;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface MessageMapper {
    /**
     * 新增评论
     *
     * @param insertMessageDto 新增的评论
     */
    void insert(InsertMessageDto insertMessageDto);

    /**
     * 删除评论
     *
     * @param messageIdDto 包含评论id
     */
    void deleteById(MessageIdDto messageIdDto);

    /**
     * 审核评论
     *
     * @param auditMessageDto 包含评论审核结果
     */
    void updateSetStatusById(AuditMessageDto auditMessageDto);

    /**
     * 查询评论列表
     *
     * @return 返回结果
     */
    List<MessageVo> selectNicknameAndUpdateTimeAndContent();
}
