package com.framework.basic.base;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: FengJie
 * @Date: 2019/4/10 17:16
 * @Description: 基础实体类
 */
@Data
public class BaseEntity {

    public static final Integer ON = 1;
    public static final Integer OFF = 2;

    private Long createBy;
    private Long updateBy;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer enableFlag;

    public static BaseEntity of() {
        return new BaseEntity();
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseEntity> T withCreateBy(Long createBy) {
        setCreateBy(createBy);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseEntity> T withUpdateBy(Long updateBy) {
        setUpdateBy(updateBy);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseEntity> T withCreateTime(LocalDateTime createTime) {
        setCreateTime(createTime);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseEntity> T withUpdateTime(LocalDateTime updateTime) {
        setUpdateTime(updateTime);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public <T extends BaseEntity> T withEnableFlag(Integer enableFlag) {
        setEnableFlag(enableFlag);
        return (T) this;
    }
}
