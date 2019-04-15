package com.framework.basic.session;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: FengJie
 * @Date: 2019/4/10 17:40
 * @Description: 用户session 实体
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSession {

    private Long userId;
}
