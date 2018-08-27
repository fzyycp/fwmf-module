package cn.faury.fwmf.module.service.school.service;

import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeRClassInfoBean;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.school.mapper.SchoolRGradeRClassInfoMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolRGradeRClassInfoServiceImpl extends CrudBaseServiceImpl<SchoolRGradeRClassInfoBean, Long> implements cn.faury.fwmf.module.api.school.service.SchoolRGradeRClassInfoService {
    public SchoolRGradeRClassInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, SchoolRGradeRClassInfoMapper.class);
    }

    /**
     * 根据年级ID获取班级列表
     *
     * @param gradeId 年级ID
     * @return 班级列表
     */
    @Override
    public List<SchoolRGradeRClassInfoBean> getClassListByGradeId(Long gradeId) {
        Map<String, Object> params = new HashMap<>();
        params.put(PageParam.KEY.KEY_PAGE_NO, 1);
        params.put(PageParam.KEY.KEY_PAGE_SIZE, Integer.MAX_VALUE);
        params.put("gradeId", gradeId);
        return this.search(params).getList();
    }

    /**
     * 根据学校ID获取班级列表
     *
     * @param schoolId 学校ID
     * @return 班级列表
     */
    @Override
    public List<SchoolRGradeRClassInfoBean> getClassListBySchoolId(Long schoolId) {
        Map<String, Object> params = new HashMap<>();
        params.put(PageParam.KEY.KEY_PAGE_NO, 1);
        params.put(PageParam.KEY.KEY_PAGE_SIZE, Integer.MAX_VALUE);
        params.put("schoolId", schoolId);
        return this.search(params).getList();
    }

    /**
     * 根据年级ID删除所有的班级信息
     *
     * @param gradeId 年级ID
     * @return 成功删除条数
     */
    @Override
    public int deleteByGradeId(Long gradeId) {
        String state = this.mapper.getName() + ".deleteByGradeId";
        return this.commonDao.delete(state, gradeId);
    }
}
