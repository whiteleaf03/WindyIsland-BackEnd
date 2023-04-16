package top.whiteleaf03.blog.service.system;

import cn.hutool.core.io.file.FileWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import top.whiteleaf03.blog.config.GlobalConfig;
import top.whiteleaf03.blog.mapper.ArticleMapper;
import top.whiteleaf03.blog.mapper.EssayMapper;
import top.whiteleaf03.blog.modal.dto.ArticleIdDto;
import top.whiteleaf03.blog.modal.vo.*;
import top.whiteleaf03.blog.utils.ArticleJsonUtil;
import top.whiteleaf03.blog.utils.EssayJsonUtil;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Slf4j
@Service
public class SystemServiceImpl implements ApplicationRunner {
    private final ArticleMapper articleMapper;
    private final EssayMapper essayMapper;
    private final GlobalConfig globalConfig;

    @Autowired
    public SystemServiceImpl(ArticleMapper articleMapper, EssayMapper essayMapper, GlobalConfig globalConfig) {
        this.articleMapper = articleMapper;
        this.essayMapper = essayMapper;
        this.globalConfig = globalConfig;
    }

    @Override
    public void run(ApplicationArguments args) {
        log.info("系统初始化中...");
        this.generateArticleStaticFileAndDirectory();
        this.generateEssayStaticFileAndDirectory();
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
        List<ClassificationVo> classificationVos;
        try {
             classificationVos = articleMapper.selectClassificationAndTotal();
            ArticleJsonUtil.writeClassifications(globalConfig.getArticlePath(), classificationVos);
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
                ArticleJsonUtil.writeArticle(globalConfig.getArticlePath(), articleMapper.selectAuthorAndTitleAndDescribeAndClassificationAndTagsAndCoverAndContentAndFilePathAndUpdateTimeById(articleListVo.getId()));
            } catch (Exception e) {
                log.info("文章[{}]写入失败!", articleListVo.getTitle() + articleListVo.getUpdateTime() + ".json");
                e.printStackTrace();
            }
        }
        log.info("生成完毕!共加载了{}篇文章", articleListVos.size());
    }

    public void generateEssayStaticFileAndDirectory() {
        //目录写入
        log.info("随笔目录写入...");
        List<EssayListVo> essayListVos;
        try {
            essayListVos = essayMapper.selectTitleAndDescribeAndCoverAndUpdateTime();
            EssayJsonUtil.writeDirectory(globalConfig.getEssayPath(), essayListVos);
        } catch (Exception e) {
            log.error("随笔目录写入失败!");
            e.printStackTrace();
            return;
        }
        //随笔写入
        for (EssayListVo essayListVo : essayListVos) {
            try {
                EssayJsonUtil.writeEssay(globalConfig.getEssayPath(), essayMapper.selectTitleAndDescribeAndCoverAndContentAndUpdateTime(essayListVo.getId()));
            } catch (Exception e) {
                log.info("随笔[{}]写入失败!", essayListVo.getTitle() + essayListVo.getUpdateTime() + ".json");
                e.printStackTrace();
            }
        }
        log.info("随笔生成完毕!共加载了{}篇文章", essayListVos.size());
    }
}
