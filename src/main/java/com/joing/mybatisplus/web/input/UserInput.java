package com.joing.mybatisplus.web.input;

import com.joing.mybatisplus.enums.SexEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/06/02 16:33
 */
@Data
public class UserInput implements Serializable {

    private static final long serialVersionUID = 3772558507490997956L;

    private SexEnum sex;

}
