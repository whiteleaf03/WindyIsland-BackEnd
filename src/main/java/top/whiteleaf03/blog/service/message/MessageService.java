package top.whiteleaf03.blog.service.message;

import top.whiteleaf03.blog.modal.dto.AuditMessageDto;
import top.whiteleaf03.blog.modal.dto.InsertMessageDto;
import top.whiteleaf03.blog.modal.dto.MessageIdDto;
import top.whiteleaf03.blog.modal.dto.MessagePageDto;
import top.whiteleaf03.blog.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface MessageService {
    /**
     * 新增留言
     *
     * @param insertMessageDto 新增的留言
     * @return 返回结果
     */
    ResponseResult insert(InsertMessageDto insertMessageDto);

    /**
     * 删除留言
     *
     * @param messageIdDto 包含留言id
     * @return 返回结果
     */
    ResponseResult deleteById(MessageIdDto messageIdDto);

    /**
     * 审核留言
     *
     * @param auditMessageDto 包含留言审核结果
     * @return 返回结果
     */
    ResponseResult updateSetStatusById(AuditMessageDto auditMessageDto);

    /**
     * 查询留言列表
     *
     * @return 返回留言列表
     */
    ResponseResult selectNicknameAndUpdateTimeAndContent();

    /**
     * 统计分页查询时总页数
     *
     * @return 返回页数
     */
    ResponseResult countPageSizeInPaging();

    /**
     * 后台分页获取留言列表
     *
     * @param messagePageDto 分页页号
     * @return 分页返回留言列表
     */
    ResponseResult selectIdAndNicknameAndEmailAndContentAndUpdateTimeAndStatusInPaging(MessagePageDto messagePageDto);
}
