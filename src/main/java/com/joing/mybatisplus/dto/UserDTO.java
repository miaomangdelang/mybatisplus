package com.joing.mybatisplus.dto;

import com.joing.mybatisplus.entity.User;
import lombok.Data;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/06/01 15:30
 */
@Data
public class UserDTO extends User {

    private static final long serialVersionUID = 5146503071667715338L;

    private String pName;
}
