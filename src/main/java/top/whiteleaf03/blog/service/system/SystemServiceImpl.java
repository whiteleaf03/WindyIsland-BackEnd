package top.whiteleaf03.blog.service.system;

import cn.hutool.core.io.file.FileWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import top.whiteleaf03.blog.config.GlobalConfig;
import top.whiteleaf03.blog.mapper.ArticleMapper;
import top.whiteleaf03.blog.modal.dto.ArticleIdDto;
import top.whiteleaf03.blog.modal.vo.ArticleDetailVo;
import top.whiteleaf03.blog.modal.vo.ArticleListVo;
import top.whiteleaf03.blog.utils.ArticleJsonUtil;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Slf4j
@Service
public class SystemServiceImpl implements ApplicationRunner {
    private final ArticleMapper articleMapper;
    private final GlobalConfig globalConfig;

    @Autowired
    public SystemServiceImpl(ArticleMapper articleMapper, GlobalConfig globalConfig) {
        this.articleMapper = articleMapper;
        this.globalConfig = globalConfig;
    }

    @Override
    public void run(ApplicationArguments args) {
        log.info("系统初始化中...");
        this.generateArticleStaticFileAndDirectory();
        log.info("系统初始化完毕!");
    }

    public void generateArticleStaticFileAndDirectory() {
        //目录写入
        log.info("目录写入...");
        List<ArticleListVo> articleListVos;
        try {
            articleListVos = articleMapper.selectIdAndAuthorAndTitleAndDescribeAndClassificationAndTagsAndBorderColorAndCoverAndViewAndCommentAndPathAndUpdateTime();
            ArticleJsonUtil.writeDirectory(globalConfig.getArticlePath(), articleListVos);
        } catch (Exception e) {
            log.info("文章目录写入失败!");
            e.printStackTrace();
            return;
        }
        //类别写入
        log.info("类别写入...");
        String[] classifications;
        try {
            classifications = articleMapper.selectClassificationDistinct();
            ArticleJsonUtil.writeClassifications(globalConfig.getArticlePath(), classifications);
        } catch (Exception e) {
            log.error("类别写入失败!");
            e.printStackTrace();
            return;
        }
        //文章写入
        log.info("文章写入...");
        ArticleDetailVo articleDetailVo;
        FileWriter fileWriter;
        for (ArticleListVo articleListVo : articleListVos) {
            try {
                ArticleJsonUtil.writeArticle(globalConfig.getArticlePath(), articleMapper.selectAuthorAndTitleAndDescribeAndClassificationAndTagsAndCoverAndContentAndFilePathAndUpdateTimeById(new ArticleIdDto(articleListVo.getId())));
            } catch (Exception e) {
                log.info("文章[{}]写入失败!", articleListVo.getTitle() + articleListVo.getUpdateTime() + ".json");
                e.printStackTrace();
            }
        }
        log.info("生成完毕!共加载了{}篇文章", articleListVos.size());
    }
}
