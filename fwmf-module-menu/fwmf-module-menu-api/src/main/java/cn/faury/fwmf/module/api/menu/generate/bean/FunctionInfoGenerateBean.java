/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-09-26 11:34:22
 */
package cn.faury.fwmf.module.api.menu.generate.bean;

/**
 * Database Table Remarks:
 *   功能按钮信息表
 *
 * This class was generated by Fwmf Generated.
 * This class corresponds to the database table sys_t_function_info
 *
 * @fwmf.generated 2018-09-26 11:34:22
 */
public class FunctionInfoGenerateBean {
    /**
     * Database Column Remarks:
     *   功能ID
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_function_info.FUNCTION_ID
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    private Long functionId;

    /**
     * Database Column Remarks:
     *   功能名称
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_function_info.FUNCTION_NAME
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    private String functionName;

    /**
     * Database Column Remarks:
     *   功能编码
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_function_info.FUNCTION_CODE
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    private String functionCode;

    /**
     * Database Column Remarks:
     *   所属菜单ID
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_function_info.MENU_ID
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    private Long menuId;

    /**
     * Database Column Remarks:
     *   是否可用【N:否 Y:是】
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_function_info.IS_AVAILABLE
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    private String isAvailable;

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_function_info.FUNCTION_ID
     *
     * @return the value of sys_t_function_info.FUNCTION_ID
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    public Long getFunctionId() {
        return functionId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_function_info.FUNCTION_ID
     *
     * @param functionId the value for sys_t_function_info.FUNCTION_ID
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_function_info.FUNCTION_NAME
     *
     * @return the value of sys_t_function_info.FUNCTION_NAME
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    public String getFunctionName() {
        return functionName;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_function_info.FUNCTION_NAME
     *
     * @param functionName the value for sys_t_function_info.FUNCTION_NAME
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_function_info.FUNCTION_CODE
     *
     * @return the value of sys_t_function_info.FUNCTION_CODE
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    public String getFunctionCode() {
        return functionCode;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_function_info.FUNCTION_CODE
     *
     * @param functionCode the value for sys_t_function_info.FUNCTION_CODE
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode == null ? null : functionCode.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_function_info.MENU_ID
     *
     * @return the value of sys_t_function_info.MENU_ID
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_function_info.MENU_ID
     *
     * @param menuId the value for sys_t_function_info.MENU_ID
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_function_info.IS_AVAILABLE
     *
     * @return the value of sys_t_function_info.IS_AVAILABLE
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    public String getIsAvailable() {
        return isAvailable;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_function_info.IS_AVAILABLE
     *
     * @param isAvailable the value for sys_t_function_info.IS_AVAILABLE
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable == null ? null : isAvailable.trim();
    }
}