package top.whiteleaf03.blog.service.message;

import top.whiteleaf03.blog.modal.dto.AuditMessageDto;
import top.whiteleaf03.blog.modal.dto.InsertMessageDto;
import top.whiteleaf03.blog.modal.dto.MessageIdDto;
import top.whiteleaf03.blog.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface MessageService {
    /**
     * 新增评论
     *
     * @param insertMessageDto 新增的评论
     * @return 返回结果
     */
    ResponseResult insert(InsertMessageDto insertMessageDto);

    /**
     * 删除评论
     *
     * @param messageIdDto 包含评论id
     * @return 返回结果
     */
    ResponseResult deleteById(MessageIdDto messageIdDto);

    /**
     * 审核评论
     *
     * @param auditMessageDto 包含评论审核结果
     * @return 返回结果
     */
    ResponseResult updateSetStatusById(AuditMessageDto auditMessageDto);

    /**
     * 查询评论列表
     *
     * @return 返回评论列表
     */
    ResponseResult selectNicknameAndUpdateTimeAndContent();
}
