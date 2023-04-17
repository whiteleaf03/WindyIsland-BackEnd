package top.whiteleaf03.blog.service.classification;

import top.whiteleaf03.blog.modal.dto.ClassificationIdDto;
import top.whiteleaf03.blog.modal.dto.InsertClassificationDto;
import top.whiteleaf03.blog.modal.entity.ArticleClassification;
import top.whiteleaf03.blog.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface ClassificationService {
    /**
     * 新增分类
     *
     * @param insertClassificationDto 新增分类的数据
     * @return 返回结果
     */
    ResponseResult insert(InsertClassificationDto insertClassificationDto);

    /**
     * 删除分类
     *
     * @param classificationIdDto 分类id
     * @return 返回结果
     */
    ResponseResult deleteById(ClassificationIdDto classificationIdDto);

    /**
     * 获取所有分类
     *
     * @return 返回分类id和分类名称
     */
    ResponseResult selectIdAndName();

    /**
     * 给文章分配分类
     *
     * @param articleClassification 文章id和分类id
     * @return 返回结果
     */
    ResponseResult insertArticleClassification(ArticleClassification articleClassification);

    /**
     * 获取分类名及该分类包含的文章数量
     *
     * @return 返回分类名及该分类包含的文章数量
     */
    ResponseResult selectTagNameAndArticleTotal();
}
