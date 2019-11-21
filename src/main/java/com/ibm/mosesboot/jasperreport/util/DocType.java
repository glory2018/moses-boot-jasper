/*********************************************
 *
 * Copyright (C) 2018 IBM All rights reserved.
 *
 ********* K*I*N*G ********** B*A*C*K *******/
package com.ibm.mosesboot.jasperreport.util;

/**
 * @author Moses *
 * @Date 2019/3/11 17:59
 */
public enum DocType {
    PDF("pdf", "application/pdf", ".pdf"),
    HTML("html", "application/html", ".html"),
    XLS("xls", "application/vnd.ms-excel", ".xls"),
    XLSX("xlsx", "application/vnd.ms-excel", ".xlsx"),
    DOC("doc", "application/msword;charset=utf-8", ".doc"),
    DOCX("docx", "application/msword;charset=utf-8", ".docx"),
    XML("xml", "application/pdf", ".xml"),
    RTF("rtf", "application/pdf", ".rtf");
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 类型内容
     */
    private String typeContent;
    /**
     * 类型后缀
     */
    private String typeSuffix;

    DocType(String typeName) {
        this.typeName = typeName;
    }

    DocType(String typeName, String typeContent, String typeSuffix) {
        this.typeName = typeName;
        this.typeContent = typeContent;
        this.typeSuffix = typeSuffix;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeContent() {
        return typeContent;
    }

    public void setTypeContent(String typeContent) {
        this.typeContent = typeContent;
    }

    public String getTypeSuffix() {
        return typeSuffix;
    }

    public void setTypeSuffix(String typeSuffix) {
        this.typeSuffix = typeSuffix;
    }

    /**
     * 根据类型的名称，返回类型的枚举实例。
     *
     * @param typeName 类型名称
     * @return
     */
    public static DocType fromTypeName(String typeName) {
        for (DocType docType : DocType.values()) {
            if (docType.getTypeName().equals(typeName)) {
                return docType;
            }
        }
        return null;
    }
}