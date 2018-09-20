package cn.faury.fwmf.module.service.code.service;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.code.bean.CodeGroupInfoBean;
import cn.faury.fwmf.module.api.code.service.CodeGroupInfoService;
import cn.faury.fwmf.module.api.code.service.CodeInfoService;
import cn.faury.fwmf.module.service.code.mapper.CodeGroupInfoMapper;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现：数据字典分组表
 * <p>
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了CodeGroupInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class CodeGroupInfoServiceImpl extends CrudBaseServiceImpl<CodeGroupInfoBean, Long> implements CodeGroupInfoService {

    @Autowired(required = false)
    CodeInfoService codeInfoService;

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public CodeGroupInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, CodeGroupInfoMapper.class);
    }

    @Override
    @Transactional
    public Long insert(CodeGroupInfoBean bean) {
        Long id = super.insert(bean);
        if (codeInfoService != null && bean.getCodeInfos() != null && bean.getCodeInfos().size() > 0) {
            bean.getCodeInfos().forEach(code -> {
                code.setCodeGroupId(id);
                codeInfoService.insert(code);
            });
        }
        return id;
    }

    @Override
    @Transactional
    public int update(CodeGroupInfoBean bean) {
        int count = super.update(bean);
        if (codeInfoService != null && bean.getCodeInfos() != null && bean.getCodeInfos().size() > 0) {
            // 全部删除
            codeInfoService.deleteByGroupId(bean.getCodeGroupId());
            // 重新插入
            bean.getCodeInfos().forEach(code -> {
                code.setCodeGroupId(bean.getCodeGroupId());
                codeInfoService.insert(code);
            });
        }
        return count;
    }

    @Override
    @Transactional
    public int deleteById(Long primaryKey) {
        int delete = super.deleteById(primaryKey);
        if (codeInfoService != null) {
            codeInfoService.deleteByGroupId(primaryKey);
        }
        return delete;
    }

    @Override
    public CodeGroupInfoBean getBeanById(Long primaryKey) {
        CodeGroupInfoBean group = super.getBeanById(primaryKey);
        if (codeInfoService != null && group != null && StringUtil.isNotEmpty(group.getCodeGroupCode())) {
            group.setCodeInfos(codeInfoService.getCodeListByGroupCode(group.getCodeGroupCode()));
        }
        return group;
    }
}