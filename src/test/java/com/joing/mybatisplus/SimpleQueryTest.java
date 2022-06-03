package com.joing.mybatisplus;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import com.joing.mybatisplus.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/05/31 20:48
 */
@SpringBootTest
public class SimpleQueryTest {

    @Test
    public void keyMap() {
        // 以list转map
        Map<Long, User> longUserMap = SimpleQuery.keyMap(Wrappers.<User>lambdaQuery().eq(User::getId, 1L), User::getId);
        System.out.println(longUserMap);
    }

    @Test
    public void groupList() {
        // 获取Map<name,List<id>>
        Map<String, List<Long>> nameIdMap = SimpleQuery.group(Wrappers.lambdaQuery(), User::getName, Collectors.mapping(User::getId, Collectors.toList()));
        System.out.println(nameIdMap);

    }

    @Test
    public void groupCount() {
        // 获取Map<name,个数>
        Map<String, Long> nameCountMap = SimpleQuery.group(Wrappers.lambdaQuery(), User::getName, Collectors.counting());
        System.out.println(nameCountMap);
    }

    @Test
    public void list() {
        // 获取nameList
        List<String> nameList = SimpleQuery.list(Wrappers.lambdaQuery(), User::getName, true, name -> name.setName(name.getName() + "1"), System.out::println);
        System.out.println(nameList);
    }

    /**
     *
     */
    @Test
    public void selectUserToMap() {
        // 如果我只想要id和name组成的map
        Map<Long, String> idNameMap = SimpleQuery.map(Wrappers.lambdaQuery(), User::getId, User::getName);
        // 校验结果
        int initialCapacity = 1 << 2;
        Map<Long, String> map = new HashMap<>(initialCapacity);
        map.put(1L, "Jone");
        map.put(2L, "Jack");
        Assert.isFalse(idNameMap.equals(map), "Ops!");
    }

}
