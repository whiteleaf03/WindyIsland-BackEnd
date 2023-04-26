package top.whiteleaf03.blog.service.classification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.whiteleaf03.blog.mapper.ArticleClassificationMapper;
import top.whiteleaf03.blog.mapper.ClassificationMapper;
import top.whiteleaf03.blog.modal.dto.ClassificationIdDto;
import top.whiteleaf03.blog.modal.dto.InsertClassificationDto;
import top.whiteleaf03.blog.modal.entity.ArticleClassification;
import top.whiteleaf03.blog.modal.vo.ClassificationIdAndNameAndCoverAndTotalVo;
import top.whiteleaf03.blog.modal.vo.ClassificationListVo;
import top.whiteleaf03.blog.utils.ResponseResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Slf4j
@Service
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationMapper classificationMapper;
    private final ArticleClassificationMapper articleClassificationMapper;

    @Autowired
    public ClassificationServiceImpl(ClassificationMapper classificationMapper, ArticleClassificationMapper articleClassificationMapper) {
        this.classificationMapper = classificationMapper;
        this.articleClassificationMapper = articleClassificationMapper;
    }

    /**
     * 新增分类
     *
     * @param insertClassificationDto 新增分类的数据
     * @return 返回结果
     */
    @Override
    public ResponseResult insert(InsertClassificationDto insertClassificationDto) {
        try {
            insertClassificationDto.generate();
            classificationMapper.insert(insertClassificationDto);
        } catch (RuntimeException e) {
            log.error("新增分类失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 删除分类
     *
     * @param classificationIdDto 分类id
     * @return 返回结果
     */
    @Override
    public ResponseResult deleteById(ClassificationIdDto classificationIdDto) {
        try {
            classificationMapper.deleteById(classificationIdDto);
        } catch (RuntimeException e) {
            log.error("删除分类失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 获取所有分类
     *
     * @return 返回分类id和分类名称
     */
    @Override
    public ResponseResult selectIdAndName() {
        List<ClassificationListVo> classificationListVos;
        try {
            classificationListVos = classificationMapper.selectIdAndNameAndCover();
        } catch (RuntimeException e) {
            log.error("获取所有分类失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success(classificationListVos);
    }

    /**
     * 给文章分配分类
     *
     * @param articleClassification 文章id和分类id
     * @return 返回结果
     */
    @Override
    public ResponseResult insertArticleClassification(ArticleClassification articleClassification) {
        try {
            articleClassificationMapper.insert(articleClassification);
        } catch (RuntimeException e) {
            log.error("给文章分配分类失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 获取分类名及该分类包含的文章数量
     *
     * @return 返回分类名及该分类包含的文章数量
     */
    @Override
    public ResponseResult selectIdAndNameAndCoverAndTotal() {
        List<ClassificationIdAndNameAndCoverAndTotalVo> classificationIdAndNameAndCoverAndTotalVos = new ArrayList<>();
        try {
            List<ClassificationListVo> classificationListVos = classificationMapper.selectIdAndNameAndCover();
            for (ClassificationListVo classificationListVo: classificationListVos) {
                classificationIdAndNameAndCoverAndTotalVos.add(new ClassificationIdAndNameAndCoverAndTotalVo(classificationListVo.getId(), classificationListVo.getName(), classificationListVo.getCover(), articleClassificationMapper.countArticleTotalByClassificationId(classificationListVo.getId())));
            }
        } catch (RuntimeException e) {
            log.error("获取分类名及该分类包含的文章数量失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success(classificationIdAndNameAndCoverAndTotalVos);
    }
}
