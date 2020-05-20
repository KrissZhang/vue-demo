package com.self.vuebackend.module.test.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 测试实体
 */
@Entity
@Table(name = "T_TEST")
@Data
public class Test {

    /**
     * 自增主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "KEY")
    private String key;

    @Column(name = "VALUE")
    private String value;

}
