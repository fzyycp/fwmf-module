package cn.faury.fwmf.module.service.school.service;

import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeInfoBean;
import cn.faury.fwmf.module.api.school.service.SchoolRGradeInfoService;
import cn.faury.fwmf.module.api.school.service.SchoolRGradeRClassInfoService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.school.mapper.SchoolRGradeInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolRGradeInfoServiceImpl extends CrudBaseServiceImpl<SchoolRGradeInfoBean,Long> implements SchoolRGradeInfoService {

    @Autowired(required = false)
    private SchoolRGradeRClassInfoService schoolRGradeRClassInfoService;

    public SchoolRGradeInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, SchoolRGradeInfoMapper.class);
    }

    /**
     * 根据学校ID获取年级列表
     *
     * @param schoolId 学校ID
     * @return 年级列表
     */
    @Override
    public List<SchoolRGradeInfoBean> getGradeListBySchoolId(Long schoolId) {
        Map<String, Object> params = new HashMap<>();
        params.put(PageParam.KEY.KEY_PAGE_NO, 1);
        params.put(PageParam.KEY.KEY_PAGE_SIZE, Integer.MAX_VALUE);
        params.put("schoolId", schoolId);
        return this.search(params).getList();
    }

    @Transactional
    @Override
    public int deleteById(Long primaryKey) {
        // 先删除班级
        schoolRGradeRClassInfoService.deleteByGradeId(primaryKey);
        // 在删除年级
        return super.deleteById(primaryKey);
    }
}
