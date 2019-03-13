/*********************************************
 *
 * Copyright (C) 2018 IBM All rights reserved.
 *
 ********* K*I*N*G ********** B*A*C*K *******/
package com.ibm.mosesboot.report.util;

/**
 * @author Moses *
 * @Date 2019/3/12 9:33
 */
public class DocTypeTest {

    /**
     * type: 是TypeEnum类实例化对象
     * typeName：实例化对象type的值
     * ordinal：实例化对象type的序号（int）     排序值(默认自带的属性 ordinal 的值)
     * name：实化对象的名字（String）     枚举名称(即默认自带的属性 name 的值)
     */
    @org.junit.Test
    public void typeTest() {
        String typeName = "pdf";
        DocType type = DocType.fromTypeName(typeName);
        System.out.println(type + ",typeName:" + type.getTypeName() + ",ordinal:" + type.ordinal() + ",name:" + type.name());
    }

}
