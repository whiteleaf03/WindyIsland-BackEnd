package top.whiteleaf03.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.whiteleaf03.blog.modal.dto.ClassificationIdDto;
import top.whiteleaf03.blog.modal.dto.InsertClassificationDto;
import top.whiteleaf03.blog.modal.entity.ArticleClassification;
import top.whiteleaf03.blog.service.classification.ClassificationService;
import top.whiteleaf03.blog.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/blog/api/classification")
public class ClassificationController {
    private final ClassificationService classificationService;

    @Autowired
    public ClassificationController(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    /**
     * 新增分类
     *
     * @param insertClassificationDto 新增分类的数据
     * @return 返回结果
     */
    @PostMapping("")
    public ResponseResult insert(@RequestBody InsertClassificationDto insertClassificationDto) {
        return classificationService.insert(insertClassificationDto);
    }

    /**
     * 删除分类
     *
     * @param classificationIdDto 分类id
     * @return 返回结果
     */
    @DeleteMapping("")
    public ResponseResult deleteById(@RequestBody ClassificationIdDto classificationIdDto) {
        return classificationService.deleteById(classificationIdDto);
    }

    /**
     * 获取所有分类
     *
     * @return 返回分类id和分类名称
     */
    @GetMapping("list")
    public ResponseResult selectIdAndName() {
        return classificationService.selectIdAndName();
    }

    /**
     * 给文章分配分类
     *
     * @param articleClassification 文章id和分类id
     * @return 返回结果
     */
    @PutMapping("")
    public ResponseResult insertArticleClassification(ArticleClassification articleClassification) {
        return classificationService.insertArticleClassification(articleClassification);
    }

    /**
     * 获取分类名及该分类包含的文章数量
     *
     * @return 返回分类名及该分类包含的文章数量
     */
    @GetMapping("info")
    public ResponseResult selectIdAndNameAndCoverAndTotal() {
        return classificationService.selectIdAndNameAndCoverAndTotal();
    }
}
