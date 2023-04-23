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
     * 新增留言
     *
     * @param insertMessageDto 新增的留言
     */
    void insert(InsertMessageDto insertMessageDto);

    /**
     * 删除留言
     *
     * @param messageIdDto 包含留言id
     */
    void deleteById(MessageIdDto messageIdDto);

    /**
     * 审核留言
     *
     * @param auditMessageDto 包含留言审核结果
     */
    void updateSetStatusById(AuditMessageDto auditMessageDto);

    /**
     * 查询留言列表
     *
     * @return 返回结果
     */
    List<MessageVo> selectNicknameAndUpdateTimeAndContent();

    /**
     * 根据id获取邮箱和留言内容
     *
     * @param id 留言id
     * @return 返回邮箱和留言内容
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
