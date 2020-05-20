package com.self.vuebackend.module.test.repository;

import com.self.vuebackend.module.test.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 测试Repository
 */
@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

    /**
     * 根据键查询测试实体
     * @param key key
     * @return 测试实体
     */
    Test findTestByKeyEquals(String key);

    /**
     * 根据id更新测试值
     * @param id 主键id
     * @param value 测试值
     * @return 影响数据条数
     */
    @Modifying
    @Query(value = "update t_test t set t.value = ?2 where t.key = ?1 ", nativeQuery = true)
    int updateTestValueById(Integer id, String value);

    /**
     * 根据id删除测试实体
     * @param id 主键id
     * @return 影响数据条数
     */
    @Modifying
    @Query(value = "delete from t_test where id = ?1 ", nativeQuery = true)
    int deleteTestById(Integer id);

}
