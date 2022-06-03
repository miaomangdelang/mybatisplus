package com.joing.mybatisplus;

import com.joing.mybatisplus.dto.JsonInfo;
import com.joing.mybatisplus.entity.JsonTest;
import com.joing.mybatisplus.mapper.JsonTestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/06/01 17:10
 */
@SpringBootTest
public class JsonInfoTest {

    @Resource
    private JsonTestMapper jsonTestMapper;

    @Test
    public void json() {
        JsonTest jsonTest = new JsonTest();
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setId(1L);
        jsonInfo.setName("nihao");
        jsonTest.setJsonInfo(jsonInfo);
        List<JsonInfo> jsonList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            jsonList.add(jsonInfo);
        }
        jsonTest.setJsonList(jsonList);
        int insert = jsonTestMapper.insert(jsonTest);
        System.out.println(insert);
        System.out.println(jsonTest);
    }

}
