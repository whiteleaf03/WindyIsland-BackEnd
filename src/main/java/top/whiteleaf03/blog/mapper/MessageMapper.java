package top.whiteleaf03.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.whiteleaf03.blog.modal.dto.AuditMessageDto;
import top.whiteleaf03.blog.modal.dto.InsertMessageDto;
import top.whiteleaf03.blog.modal.dto.MessageIdDto;
import top.whiteleaf03.blog.modal.vo.MessageAuditInfoVo;
import top.whiteleaf03.blog.modal.vo.MessageInfoVo;
import top.whiteleaf03.blog.modal.vo.MessagePageSizeVo;
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

    /**
     * 根据id获取邮箱和评论内容
     *
     * @param id 评论id
     * @return 返回邮箱和评论内容
     */
    MessageAuditInfoVo selectEmailAndContentById(Long id);

    /**
     * 统计分页查询时总页数
     *
     * @return 返回页数
     */
    MessagePageSizeVo countPageSizeInPaging();

    /**
     * 分页查询文章列表
     *
     * @param page 分页页号
     * @return 返回分页查询文章列表
     */
    List<MessageInfoVo> selectIdAndNicknameAndEmailAndContentAndUpdateTimeAndStatusInPaging(Integer page);
}
