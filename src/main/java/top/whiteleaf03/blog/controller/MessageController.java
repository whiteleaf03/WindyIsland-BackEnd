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
@RequestMapping("/blog/api/message")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * 新增留言
     *
     * @param insertMessageDto 新增的留言
     * @return 返回结果
     */
    @PostMapping("")
    ResponseResult insert(@RequestBody InsertMessageDto insertMessageDto) {
        return messageService.insert(insertMessageDto);
    }

    /**
     * 删除留言
     *
     * @param messageIdDto 包含留言id
     * @return 返回结果
     */
    @DeleteMapping("")
    ResponseResult deleteById(@RequestBody MessageIdDto messageIdDto) {
        return messageService.deleteById(messageIdDto);
    }

    /**
     * 审核留言
     *
     * @param auditMessageDto 包含留言审核结果
     * @return 返回结果
     */
    @PutMapping("")
    ResponseResult updateSetStatusById(@RequestBody AuditMessageDto auditMessageDto) {
        return messageService.updateSetStatusById(auditMessageDto);
    }

    /**
     * 查询留言列表
     *
     * @return 返回留言列表
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
     * 后台分页获取留言列表
     *
     * @param messagePageDto 分页页号
     * @return 分页返回留言列表
     */
    @GetMapping("list/page")
    ResponseResult selectIdAndNicknameAndEmailAndContentAndUpdateTimeAndStatusInPaging(MessagePageDto messagePageDto) {
        return messageService.selectIdAndNicknameAndEmailAndContentAndUpdateTimeAndStatusInPaging(messagePageDto);
    }
}
