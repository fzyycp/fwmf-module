/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-11-14 21:26:24
 */
package cn.faury.fwmf.module.api.qa.generate.bean;

/**
 * Database Table Remarks:
 *   常见问题txt
 *
 * This class was generated by Fwmf Generated.
 * This class corresponds to the database table sys_t_qa_txt
 *
 * @fwmf.generated 2018-11-14 21:26:24
 */
public class QaTxtGenerateBeanWithBLOBs extends QaTxtGenerateBean {
    /**
     * Database Column Remarks:
     *   问题解决json
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_qa_txt.CONTENT_JSON
     *
     * @fwmf.generated 2018-11-14 21:26:24
     */
    private String contentJson;

    /**
     * Database Column Remarks:
     *   问题解决html
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_qa_txt.CONTENT_HTML
     *
     * @fwmf.generated 2018-11-14 21:26:24
     */
    private String contentHtml;

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_qa_txt.CONTENT_JSON
     *
     * @return the value of sys_t_qa_txt.CONTENT_JSON
     *
     * @fwmf.generated 2018-11-14 21:26:24
     */
    public String getContentJson() {
        return contentJson;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_qa_txt.CONTENT_JSON
     *
     * @param contentJson the value for sys_t_qa_txt.CONTENT_JSON
     *
     * @fwmf.generated 2018-11-14 21:26:24
     */
    public void setContentJson(String contentJson) {
        this.contentJson = contentJson == null ? null : contentJson.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_qa_txt.CONTENT_HTML
     *
     * @return the value of sys_t_qa_txt.CONTENT_HTML
     *
     * @fwmf.generated 2018-11-14 21:26:24
     */
    public String getContentHtml() {
        return contentHtml;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_qa_txt.CONTENT_HTML
     *
     * @param contentHtml the value for sys_t_qa_txt.CONTENT_HTML
     *
     * @fwmf.generated 2018-11-14 21:26:24
     */
    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml == null ? null : contentHtml.trim();
    }
}