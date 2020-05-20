package com.self.vuebackend.module.test.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.self.vuebackend.module.test.domain.Test;
import com.self.vuebackend.module.test.service.TestService;
import com.self.vuebackend.module.test.vo.TestVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 测试接口层
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;

    /**
     * 根据条件分页查询测试列表
     * @param paramJson 参数json
     * @param pageNum 页数
     * @param pageSize 页面大小
     * @return 测试列表
     */
    @RequestMapping(value = "/testPage", method = RequestMethod.GET)
    public List<TestVo> getTestListByParamForPage(String paramJson, Integer pageNum, Integer pageSize){
        List<TestVo> resultList = new ArrayList<>();
        List<Test> list = new ArrayList<>();

        if(StringUtils.isNotBlank(paramJson)){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Map<String, Object> paramMap = objectMapper.readValue(paramJson, Map.class);
                list = testService.getTestListByParamForPage(paramMap, pageNum, pageSize);
            } catch (JsonProcessingException e) {
                log.error("解析参数失败，接口名：getTestListByParamForPage,参数：{}", paramJson);
            }
        }else{
            list = testService.getTestListByParamForPage(null, pageNum, pageSize);
        }

        //重构Vo
        for (Test test : list) {
            TestVo vo = new TestVo();
            vo.setId(test.getId());
            vo.setKey(test.getKey());
            vo.setValue(test.getValue());
            vo.setDesc(test.getKey() + "-" + test.getValue());

            resultList.add(vo);
        }

        return resultList;
    }

}
