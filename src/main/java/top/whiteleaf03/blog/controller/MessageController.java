package top.whiteleaf03.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.whiteleaf03.blog.modal.dto.AuditMessageDto;
import top.whiteleaf03.blog.modal.dto.InsertMessageDto;
import top.whiteleaf03.blog.modal.dto.MessageIdDto;
import top.whiteleaf03.blog.modal.dto.MessagePageDto;
import top.whiteleaf03.blog.service.message.MessageService;
import top.whiteleaf03.blog.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/api/message")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * 新增评论
     *
     * @param insertMessageDto 新增的评论
     * @return 返回结果
     */
    @PostMapping("")
    ResponseResult insert(@RequestBody InsertMessageDto insertMessageDto) {
        return messageService.insert(insertMessageDto);
    }

    /**
     * 删除评论
     *
     * @param messageIdDto 包含评论id
     * @return 返回结果
     */
    @DeleteMapping("")
    ResponseResult deleteById(@RequestBody MessageIdDto messageIdDto) {
        return messageService.deleteById(messageIdDto);
    }

    /**
     * 审核评论
     *
     * @param auditMessageDto 包含评论审核结果
     * @return 返回结果
     */
    @PutMapping("")
    ResponseResult updateSetStatusById(@RequestBody AuditMessageDto auditMessageDto) {
        return messageService.updateSetStatusById(auditMessageDto);
    }

    /**
     * 查询评论列表
     *
     * @return 返回评论列表
     */
    @GetMapping("")
    ResponseResult selectNicknameAndUpdateTimeAndContent() {
        return messageService.selectNicknameAndUpdateTimeAndContent();
    }

    /**
     * 统计分页查询时总数
     *
     * @return 返回总数
     */
    @GetMapping("list/page/size")
    ResponseResult countPageSizeInPaging() {
        return messageService.countPageSizeInPaging();
    }

    /**
     * 后台分页获取评论列表
     *
     * @param messagePageDto 分页页号
     * @return 分页返回评论列表
     */
    @GetMapping("list/page")
    ResponseResult selectIdAndNicknameAndEmailAndContentAndUpdateTimeAndStatusInPaging(MessagePageDto messagePageDto) {
        return messageService.selectIdAndNicknameAndEmailAndContentAndUpdateTimeAndStatusInPaging(messagePageDto);
    }
}
