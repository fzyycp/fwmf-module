package cn.faury.fwmf.module.service.school.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeInfoBean;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeRClassInfoBean;
import cn.faury.fwmf.module.api.school.service.SchoolRGradeInfoService;
import cn.faury.fwmf.module.api.school.service.SchoolRGradeRClassInfoService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.school.mapper.SchoolRGradeRClassInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 服务实现：学校年级班级信息表
 * <p>
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了SchoolRGradeRClassInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class SchoolRGradeRClassInfoServiceImpl extends CrudBaseServiceImpl<SchoolRGradeRClassInfoBean, Long> implements SchoolRGradeRClassInfoService {

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
        params.put("gradeId", gradeId);
        params.put("ORDER_BY", "CLASS_CODE,ASC");
        return this.query(params);
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
        params.put("schoolId", schoolId);
        params.put("ORDER_BY", "CLASS_CODE,ASC");
        return this.query(params);
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
