package top.whiteleaf03.blog.service.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.whiteleaf03.blog.mapper.MessageMapper;
import top.whiteleaf03.blog.modal.dto.AuditMessageDto;
import top.whiteleaf03.blog.modal.dto.InsertMessageDto;
import top.whiteleaf03.blog.modal.dto.MessageIdDto;
import top.whiteleaf03.blog.modal.dto.MessagePageDto;
import top.whiteleaf03.blog.modal.vo.MessageAuditInfoVo;
import top.whiteleaf03.blog.modal.vo.MessageInfoVo;
import top.whiteleaf03.blog.modal.vo.MessagePageSizeVo;
import top.whiteleaf03.blog.modal.vo.MessageVo;
import top.whiteleaf03.blog.utils.MailUtil;
import top.whiteleaf03.blog.utils.ResponseResult;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Slf4j
@Service
public class MessageServiceImpl implements MessageService {
    private final MessageMapper messageMapper;
    private final MailUtil mailUtil;

    @Autowired
    public MessageServiceImpl(MessageMapper messageMapper, MailUtil mailUtil) {
        this.messageMapper = messageMapper;
        this.mailUtil = mailUtil;
    }

    /**
     * 新增留言
     *
     * @param insertMessageDto 新增的留言
     * @return 返回结果
     */
    @Override
    public ResponseResult insert(InsertMessageDto insertMessageDto) {
        try {
            insertMessageDto.generateArticleInfo();
            messageMapper.insert(insertMessageDto);
            mailUtil.sentMessageToAdmin(insertMessageDto.getNickname(), insertMessageDto.getContent());
        } catch (RuntimeException e) {
            log.info("新增留言失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 删除留言
     *
     * @param messageIdDto 包含留言id
     * @return 返回结果
     */
    @Override
    public ResponseResult deleteById(MessageIdDto messageIdDto) {
        try {
            messageMapper.deleteById(messageIdDto);
        } catch (RuntimeException e) {
            log.info("删除留言失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 审核留言
     *
     * @param auditMessageDto 包含留言审核结果
     * @return 返回结果
     */
    @Override
    public ResponseResult updateSetStatusById(AuditMessageDto auditMessageDto) {
        try {
            messageMapper.updateSetStatusById(auditMessageDto);
            if (auditMessageDto.getStatus() == 1) {
                MessageAuditInfoVo messageAuditInfoVo = messageMapper.selectEmailAndContentById(auditMessageDto.getId());
                mailUtil.sentMessageToUser(messageAuditInfoVo.getEmail(), messageAuditInfoVo.getContent());
            }
        } catch (RuntimeException e) {
            log.info("审核留言失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 查询留言列表
     *
     * @return 返回留言列表
     */
    @Override
    public ResponseResult selectNicknameAndUpdateTimeAndContent() {
        List<MessageVo> messageVoList;
        try {
            messageVoList = messageMapper.selectNicknameAndUpdateTimeAndContent();
        } catch (RuntimeException e) {
            log.info("查询留言列表失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success(messageVoList);
    }

    /**
     * 统计分页查询时总页数
     *
     * @return 返回页数
     */
    @Override
    public ResponseResult countPageSizeInPaging() {
        MessagePageSizeVo messagePageSizeVo;
        try {
            messagePageSizeVo = messageMapper.countPageSizeInPaging();
        } catch (RuntimeException e) {
            log.error("统计留言总页数失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success(messagePageSizeVo);
    }

    /**
     * 后台分页获取留言列表
     *
     * @param messagePageDto 分页页号
     * @return 分页返回留言列表
     */
    @Override
    public ResponseResult selectIdAndNicknameAndEmailAndContentAndUpdateTimeAndStatusInPaging(MessagePageDto messagePageDto) {
        List<MessageInfoVo> messageInfoVos;
        try {
            messageInfoVos = messageMapper.selectIdAndNicknameAndEmailAndContentAndUpdateTimeAndStatusInPaging(messagePageDto.getPage());
        } catch (RuntimeException e) {
            log.error("分页获取留言失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success(messageInfoVos);
    }
}
