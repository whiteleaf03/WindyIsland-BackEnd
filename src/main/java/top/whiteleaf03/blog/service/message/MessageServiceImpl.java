package top.whiteleaf03.blog.service.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.whiteleaf03.blog.mapper.MessageMapper;
import top.whiteleaf03.blog.modal.dto.AuditMessageDto;
import top.whiteleaf03.blog.modal.dto.InsertMessageDto;
import top.whiteleaf03.blog.modal.dto.MessageIdDto;
import top.whiteleaf03.blog.modal.vo.MessageVo;
import top.whiteleaf03.blog.utils.ResponseResult;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Slf4j
@Service
public class MessageServiceImpl implements MessageService {
    private final MessageMapper messageMapper;

    @Autowired
    public MessageServiceImpl(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    /**
     * 新增评论
     *
     * @param insertMessageDto 新增的评论
     * @return 返回结果
     */
    @Override
    public ResponseResult insert(InsertMessageDto insertMessageDto) {
        try {
            insertMessageDto.generateArticleInfo();
            messageMapper.insert(insertMessageDto);
        } catch (RuntimeException e) {
            log.info("新增评论失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 删除评论
     *
     * @param messageIdDto 包含评论id
     * @return 返回结果
     */
    @Override
    public ResponseResult deleteById(MessageIdDto messageIdDto) {
        try {
            messageMapper.deleteById(messageIdDto);
        } catch (RuntimeException e) {
            log.info("删除评论失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 审核评论
     *
     * @param auditMessageDto 包含评论审核结果
     * @return 返回结果
     */
    @Override
    public ResponseResult updateSetStatusById(AuditMessageDto auditMessageDto) {
        try {
            messageMapper.updateSetStatusById(auditMessageDto);
        } catch (RuntimeException e) {
            log.info("审核评论失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return null;
    }

    /**
     * 查询评论列表
     *
     * @return 返回评论列表
     */
    @Override
    public ResponseResult selectNicknameAndUpdateTimeAndContent() {
        List<MessageVo> messageVoList;
        try {
            messageVoList = messageMapper.selectNicknameAndUpdateTimeAndContent();
        } catch (RuntimeException e) {
            log.info("查询评论列表失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success(messageVoList);
    }
}
