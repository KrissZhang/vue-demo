package com.self.vuebackend.module.test.service.impl;

import com.self.vuebackend.module.test.domain.Test;
import com.self.vuebackend.module.test.repository.TestRepository;
import com.self.vuebackend.module.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * 测试Service实现
 */
@Service
@Scope("singleton")
@Slf4j
public class TestServiceImpl implements TestService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TestRepository testRepository;

    /**
     * 获取测试全表数据
     * @return 测试列表
     */
    @Override
    public List<Test> getAllTestList() {
        return testRepository.findAll();
    }

    /**
     * 根据参数分页获取数据列表
     * @param pageNum 页数
     * @param pageSize 页面大小
     * @return 分页数据列表
     */
    @Override
    public List<Test> getTestListByParamForPage(Map<String, Object> paramMap, Integer pageNum, Integer pageSize) {
        StringBuilder builder = new StringBuilder();
        builder.append("select t.* from t_test t where 1 = 1 ");

        if(paramMap != null && paramMap.size() > 0){
            for(Map.Entry<String, Object> entry : paramMap.entrySet()){
                builder.append("and t." + entry.getKey() + " = '" + entry.getValue() + "' ");
            }
        }

        builder.append("order by t.id asc ");

        if(pageNum != null && pageSize != null){
            int startIndex = (pageNum - 1) * pageSize;

            if(startIndex < 0){
                startIndex = 0;
            }

            builder.append("limit " + startIndex + "," + pageSize);
        }

        Query testListQuery = entityManager.createNativeQuery(builder.toString(), Test.class);
        List<Test> list = testListQuery.getResultList();

        return list;
    }

    /**
     * 根据key获取测试实体
     * @param key 测试键
     * @return 测试实体
     */
    @Override
    public Test getTestByKey(String key) {
        return testRepository.findTestByKeyEquals(key);
    }

    /**
     * 根据主键id更新测试值
     * @param id 主键id
     * @param value 测试值
     * @return 影响数据条数
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean modifyTestValueById(Integer id, String value) {
        int num = testRepository.updateTestValueById(id, value);
        return num > 0;
    }

    /**
     * 添加测试实体
     * @param test 测试实体
     * @return 影响数据条数
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addTest(Test test) {
        Test returnTest = testRepository.saveAndFlush(test);
        return returnTest != null;
    }

    /**
     * 批量添加测试列表
     * @param list 测试列表
     * @return 影响数据条数
     */
    @Override
    public void batchAddTestList(List<Test> list) {
        try{
            testRepository.saveAll(list);
        }catch (Exception e){
            log.error("批量保存测试列表失败");
            for (Test test : list) {
                try{
                    testRepository.saveAndFlush(test);
                }catch(Exception ex){
                    log.error("保存测试失败，id：{}", test.getId());
                }
            }
        }
    }

    /**
     * 删除测试
     * @param id 主键id
     * @return 影响数据条数
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean removeTestById(Integer id) {
        int num = testRepository.deleteTestById(id);
        return num > 0;
    }

}
