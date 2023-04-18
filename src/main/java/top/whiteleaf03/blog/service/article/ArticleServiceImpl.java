package top.whiteleaf03.blog.service.article;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.whiteleaf03.blog.mapper.ArticleClassificationMapper;
import top.whiteleaf03.blog.mapper.ArticleMapper;
import top.whiteleaf03.blog.mapper.ArticleTagMapper;
import top.whiteleaf03.blog.modal.dto.ArticleIdDto;
import top.whiteleaf03.blog.modal.dto.InsertArticleDto;
import top.whiteleaf03.blog.modal.entity.ArticleClassification;
import top.whiteleaf03.blog.modal.entity.ArticleTag;
import top.whiteleaf03.blog.modal.vo.ArticleDetailVo;
import top.whiteleaf03.blog.modal.vo.ArticleListVo;
import top.whiteleaf03.blog.service.system.SystemServiceImpl;
import top.whiteleaf03.blog.utils.ResponseResult;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {
    private final SystemServiceImpl systemServiceImpl;
    private final ArticleMapper articleMapper;
    private final ArticleTagMapper articleTagMapper;
    private final ArticleClassificationMapper articleClassificationMapper;

    @Autowired
    public ArticleServiceImpl(SystemServiceImpl systemServiceImpl, ArticleMapper articleMapper, ArticleTagMapper articleTagMapper, ArticleClassificationMapper articleClassificationMapper) {
        this.systemServiceImpl = systemServiceImpl;
        this.articleMapper = articleMapper;
        this.articleTagMapper = articleTagMapper;
        this.articleClassificationMapper = articleClassificationMapper;
    }

    /**
     * 新增新文章
     *
     * @param insertArticleDto 新文章内容
     * @return 返回结果
     */
    @Override
    public ResponseResult insert(InsertArticleDto insertArticleDto) {
        try {
            List<Long> tagIds = insertArticleDto.getTagIds();
            insertArticleDto.generateArticleInfo();
            Long articleId = articleMapper.insertArticle(insertArticleDto);
            articleClassificationMapper.insert(new ArticleClassification(articleId, insertArticleDto.getClassificationId()));
            for (Long tagId : tagIds) {
                articleTagMapper.insert(new ArticleTag(articleId, tagId));
            }
            systemServiceImpl.generateArticleStaticFileAndDirectory();
        } catch (RuntimeException e) {
            log.error("新增文章出错");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 删除文章
     *
     * @param articleIdDto 包含文章id
     * @return 返回结果
     */
    @Override
    public ResponseResult deleteById(ArticleIdDto articleIdDto) {
        try {
            articleMapper.deleteById(articleIdDto);
        } catch (RuntimeException e) {
            log.error("删除文章出错");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 查询文章列表
     *
     * @return 返回结果
     */
    @Override
    public ResponseResult selectIdAndAuthorAndTitleAndDescribeAndBorderColorAndCoverAndViewAndCommentAndUpdateTime() {
        List<ArticleListVo> articleListVos;
        try {
            articleListVos = articleMapper.selectIdAndAuthorAndTitleAndDescribeAndBorderColorAndCoverAndViewAndCommentAndPathAndUpdateTime();
        } catch (RuntimeException e) {
            log.info("查询文章列表出错");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success(articleListVos);
    }

    /**
     * 前台根据id获取文章内容
     *
     * @param articleIdDto 包含文章id
     * @return 返回结果
     */
    @Override
    public ResponseResult selectAuthorAndTitleAndDescribeAndCoverAndContentAndFilePathAndUpdateTimeById(ArticleIdDto articleIdDto) {
        ArticleDetailVo articleDetailVo;
        try {
            articleDetailVo = articleMapper.selectAuthorAndTitleAndDescribeAndClassificationAndTagsAndCoverAndContentAndFilePathAndUpdateTimeById(articleIdDto);
        } catch (RuntimeException e) {
            log.info("查询文章详情失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success(articleDetailVo);
    }
}
