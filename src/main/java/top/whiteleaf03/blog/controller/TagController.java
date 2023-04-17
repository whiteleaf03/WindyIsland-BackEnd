package top.whiteleaf03.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.whiteleaf03.blog.modal.dto.InsertTagDto;
import top.whiteleaf03.blog.modal.dto.TagIdDto;
import top.whiteleaf03.blog.service.tag.TagService;
import top.whiteleaf03.blog.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/api/tag")
public class TagController {
    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping("")
    public ResponseResult insert(@RequestBody InsertTagDto insertTagDto) {
        return tagService.insert(insertTagDto);
    }

    @DeleteMapping("")
    public ResponseResult delete(@RequestBody TagIdDto tagIdDto) {
        return tagService.deleteById(tagIdDto);
    }

    @GetMapping("list")
    public ResponseResult selectIdAndName() {
        return tagService.selectName();
    }


    @GetMapping("info")
    public ResponseResult selectTagNameAndArticleTotal() {
        return tagService.selectTagNameAndArticleTotal();
    }
}
