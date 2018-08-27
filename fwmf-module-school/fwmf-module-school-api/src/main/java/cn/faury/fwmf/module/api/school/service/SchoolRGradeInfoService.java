package cn.faury.fwmf.module.api.school.service;

import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeInfoBean;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeRClassInfoBean;

import java.util.List;

/**
 * 通用增删改查基础服务接口，可以根据业务需要进一步扩展
 * 只需生成一次，后面不需要再生成
 */
public interface SchoolRGradeInfoService extends CrudBaseService<SchoolRGradeInfoBean, Long> {

    /**
     * 根据学校ID获取年级列表
     *
     * @param schoolId 学校ID
     * @return 年级列表
     */
    public List<SchoolRGradeInfoBean> getGradeListBySchoolId(final Long schoolId);

}