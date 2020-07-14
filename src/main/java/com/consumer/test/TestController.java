package com.consumer.test;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Reference;
import com.server.model.User;
import com.server.service.TestService;
import com.server.service.XmlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouxuan
 * @date 2020/7/7 17:58
 */
@RestController
public class TestController {

    @Reference
    private TestService testService;

    @Reference
    private XmlService xmlService;

    @GetMapping("test")
    public void test() {
        List<String> list = testService.test();
        System.out.println(list);
    }

    @GetMapping("testXml")
    public void testXml() {

        xmlService.test();
    }

    @GetMapping("testUser")
    public void testUser() {
        User user = testService.testUser();
        System.out.println(user.getName());
    }
}
