package com.framework.core.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户对象
 *
 * @Author: FengJie
 * @Date: 2019/4/29 15:51
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSession {

    private String id;
}
