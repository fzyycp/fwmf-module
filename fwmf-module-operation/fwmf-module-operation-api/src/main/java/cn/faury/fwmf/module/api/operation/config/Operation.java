package cn.faury.fwmf.module.api.operation.config;

import java.lang.annotation.*;
import java.util.Arrays;
import java.util.Optional;

/**
 * 操作注解
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Operation {
    /**
     * 菜单名称
     *
     * @return
     */
    String menu();

    /**
     * 功能按钮名称
     *
     * @return
     */
    String function();

    /**
     * 操作类型
     *
     * @return
     */
    Type type();

    /**
     * 操作类型枚举
     */
    enum Type {
        /**
         * 新增操作：0001
         */
        ADD(1, "add", "新增"),
        /**
         * 删除操作：0010
         */
        DEL(2, "del", "删除"),
        /**
         * 修改操作：0100
         */
        MOD(4, "mod", "修改"),
        /**
         * 查看操作：1000
         */
        VIEW(8, "view", "查看");

        /**
         * 操作级别2进制位表示
         */
        private int level;

        /**
         * 编码
         */
        private String code;

        /**
         * 描述
         */
        private String desc;

        Type(int level, String code, String desc) {
            this.level = level;
            this.code = code;
            this.desc = desc;
        }

        public static Optional<Type> parse(String code) {
            return Arrays.stream(Type.values()).filter(type -> type.getCode().equals(code)).findFirst();
        }

        public int getLevel() {
            return level;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }

}
