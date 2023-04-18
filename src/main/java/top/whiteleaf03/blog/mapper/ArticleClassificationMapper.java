package top.whiteleaf03.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.whiteleaf03.blog.modal.entity.ArticleClassification;
import top.whiteleaf03.blog.modal.vo.ClassificationIdAndNameAndArticleTotalVo;
import top.whiteleaf03.blog.modal.vo.ClassificationListVo;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface ArticleClassificationMapper {
    /**
     * 给文章分配分类
     *
     * @param articleClassification 文章id和分类id
     */
    void insert(ArticleClassification articleClassification);

    /**
     * 修改分类
     *
     * @param articleClassification 要修改的文章id及分类id
     */
    void update(ArticleClassification articleClassification);

    /**
     * 根据分类id获取该分类所包含的文章数量
     *
     * @param classificationId 分类id
     * @return 返回包含的文章数量
     */
    Integer countArticleTotalByClassificationId(Long classificationId);

    /**
     * 根据分类id查询所包含的博客id
     *
     * @param classificationId 分类id
     * @return 返回该分类所包含的文章的id
     */
    List<Long> selectArticleIdByClassificationId(Long classificationId);

    /**
     * 根据博客id获取分类id
     *
     * @param articleId 博客
     * @return 返回该博客所属分类的id
     */
    Long selectClassificationIdByArticleId(Long articleId);
}
