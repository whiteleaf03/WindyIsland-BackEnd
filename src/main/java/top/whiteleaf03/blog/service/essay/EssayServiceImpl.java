package top.whiteleaf03.blog.service.essay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.whiteleaf03.blog.mapper.EssayMapper;
import top.whiteleaf03.blog.modal.dto.EssayIdDto;
import top.whiteleaf03.blog.modal.dto.InsertEssayDto;
import top.whiteleaf03.blog.modal.vo.EssayListVo;
import top.whiteleaf03.blog.service.system.SystemServiceImpl;
import top.whiteleaf03.blog.utils.ResponseResult;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Slf4j
@Service
public class EssayServiceImpl implements EssayService {
    private final EssayMapper essayMapper;
    private final SystemServiceImpl systemService;

    @Autowired
    public EssayServiceImpl(EssayMapper essayMapper, SystemServiceImpl systemService) {
        this.essayMapper = essayMapper;
        this.systemService = systemService;
    }

    /**
     * 新增随笔
     *
     * @param insertEssayDto 新增随笔的内容
     * @return 返回结果
     */
    @Override
    public ResponseResult insert(InsertEssayDto insertEssayDto) {
        try {
            insertEssayDto.generateEssayInfo();
            essayMapper.insert(insertEssayDto);
            systemService.generateEssayStaticFileAndDirectory();
        } catch (RuntimeException e) {
            log.error("新增随笔失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 删除随笔
     *
     * @param essayIdDto 包含随笔id
     * @return 返回结果
     */
    @Override
    public ResponseResult deleteById(EssayIdDto essayIdDto) {
        try {
            essayMapper.deleteById(essayIdDto);
        } catch (RuntimeException e) {
            log.error("删除随笔失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }

    /**
     * 查询随笔列表
     *
     * @return 返回结果
     */
    @Override
    public ResponseResult selectTitleAndDescribeAndCoverAndUpdateTime() {
        List<EssayListVo> essayListVos;
        try {
            essayListVos = essayMapper.selectTitleAndDescribeAndCoverAndUpdateTime();
        } catch (RuntimeException e) {
            log.error("查询随笔列表失败");
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success(essayListVos);
    }

    /**
     * 前台根据id获取随笔内容
     *
     * @param essayIdDto 包含随笔id
     * @return 返回结果
     */
    @Override
    public ResponseResult selectTitleAndDescribeAndCoverAndContentAndUpdateTimeById(EssayIdDto essayIdDto) {
        try {
            essayMapper.selectTitleAndDescribeAndCoverAndContentAndUpdateTimeById(essayIdDto);
        } catch (RuntimeException e) {
            log.error("获取随笔[{}]内容失败", essayIdDto.getId());
            e.printStackTrace();
            return ResponseResult.error();
        }
        return ResponseResult.success();
    }
}
