package top.whiteleaf03.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.whiteleaf03.blog.modal.dto.ArticleIdDto;
import top.whiteleaf03.blog.modal.dto.InsertArticleDto;
import top.whiteleaf03.blog.service.article.ArticleService;
import top.whiteleaf03.blog.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    /**
     * 新增新文章
     *
     * @param insertArticleDto 新文章内容
     * @return 返回结果
     */
    @RequestMapping("insert")
    ResponseResult insertArticle(@RequestBody InsertArticleDto insertArticleDto) {
        return articleService.insert(insertArticleDto);
    }

    /**
     * 删除文章
     *
     * @param articleIdDto 包含文章id
     * @return 返回结果
     */
    ResponseResult deleteById(ArticleIdDto articleIdDto) {
        return articleService.deleteById(articleIdDto);
    }

    /**
     * 查询文章列表
     *
     * @return 返回结果
     */
    ResponseResult selectIdAndAuthorAndTitleAndDescribeAndBorderColorAndCoverAndViewAndCommentAndUpdateTime() {
        return articleService.selectIdAndAuthorAndTitleAndDescribeAndBorderColorAndCoverAndViewAndCommentAndUpdateTime();
    }

    /**
     * 前台根据id获取文章内容
     *
     * @param articleIdDto 包含文章id
     * @return 返回结果
     */
    ResponseResult selectAuthorAndTitleAndDescribeAndCoverAndContentAndFilePathAndUpdateTimeById(ArticleIdDto articleIdDto) {
        return articleService.selectAuthorAndTitleAndDescribeAndCoverAndContentAndFilePathAndUpdateTimeById(articleIdDto);
    }
}
