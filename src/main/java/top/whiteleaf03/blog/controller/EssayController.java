package top.whiteleaf03.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.whiteleaf03.blog.modal.dto.EssayIdDto;
import top.whiteleaf03.blog.modal.dto.InsertEssayDto;
import top.whiteleaf03.blog.service.essay.EssayService;
import top.whiteleaf03.blog.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/api/essay")
public class EssayController {
    private final EssayService essayService;

    @Autowired
    public EssayController(EssayService essayService) {
        this.essayService = essayService;
    }

    /**
     * 新增随笔
     *
     * @param insertEssayDto 新增随笔的内容
     * @return 返回结果
     */
    @PostMapping("")
    ResponseResult insert(@RequestBody InsertEssayDto insertEssayDto) {
        return essayService.insert(insertEssayDto);
    }

    /**
     * 删除随笔
     *
     * @param essayIdDto 包含随笔id
     * @return 返回结果
     */
    @DeleteMapping("")
    ResponseResult deleteById(@RequestBody EssayIdDto essayIdDto) {
        return essayService.deleteById(essayIdDto);
    }

    /**
     * 查询随笔列表
     *
     * @return 返回结果
     */
    @GetMapping("list")
    ResponseResult selectTitleAndDescribeAndCoverAndUpdateTime() {
        return essayService.selectTitleAndDescribeAndCoverAndUpdateTime();
    }

    /**
     * 前台根据id获取随笔内容
     *
     * @param essayIdDto 包含随笔id
     * @return 返回结果
     */
    @GetMapping("")
    ResponseResult selectTitleAndDescribeAndCoverAndContentAndUpdateTime(EssayIdDto essayIdDto) {
        return essayService.selectTitleAndDescribeAndCoverAndContentAndUpdateTimeById(essayIdDto);
    }
}
