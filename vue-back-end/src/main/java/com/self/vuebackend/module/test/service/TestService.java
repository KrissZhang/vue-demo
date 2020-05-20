package com.self.vuebackend.module.test.service;

import com.self.vuebackend.module.test.domain.Test;

import java.util.List;
import java.util.Map;

/**
 * 测试Service
 */
public interface TestService {

    /**
     * 获取测试全表数据
     * @return 测试列表
     */
    List<Test> getAllTestList();

    /**
     * 根据参数分页获取数据列表
     * @param pageNum 页数
     * @param pageSize 页面大小
     * @return 分页数据列表
     */
    List<Test> getTestListByParamForPage(Map<String, Object> paramMap, Integer pageNum, Integer pageSize);

    /**
     * 根据key获取测试
     * @param key 测试键
     * @return 测试
     */
    Test getTestByKey(String key);

    /**
     * 根据主键id更新测试值
     * @param id 主键id
     * @param value 测试值
     * @return 更新数据条数
     */
    boolean modifyTestValueById(Integer id, String value);

    /**
     * 添加测试
     * @param test 单条测试
     * @return 添加数据条数
     */
    boolean addTest(Test test);

    /**
     * 批量添加测试列表
     * @param list 测试列表
     * @return 添加数据条数
     */
    void batchAddTestList(List<Test> list);

    /**
     * 删除测试
     * @param id 主键id
     * @return 删除数据条数
     */
    boolean removeTestById(Integer id);

}
