package com.huhuamin.mybatis.gernerator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

/**
 * @Author 胡化敏
 * @Description: 接口备注
 * @Date Create 2017/11/28 09:45
 * @Modified By:
 * @Since:
 */
public class HhmMyCommentGenerator extends DefaultCommentGenerator {


    @Override
    public void addConfigurationProperties(Properties properties) {
        properties.setProperty("useInformationSchema", "true");

        super.addConfigurationProperties(properties);

    }


    @Override
    public void addGeneralMethodComment(Method method,
                                        IntrospectedTable introspectedTable) {
        System.out.println(method.getName());
        method.addJavaDocLine("/**"); //$NON-NLS-1$
        StringBuilder sb = new StringBuilder();
        sb.append(" * " + introspectedTable.getFullyQualifiedTable());
        if ("deleteByPrimaryKey".equalsIgnoreCase(method.getName())) {
            sb.append(" 根据主键删除 "); //$NON-NLS-1$
            method.addJavaDocLine(sb.toString());
        } else if ("selectByPrimaryKey".equalsIgnoreCase(method.getName())) {
            sb.append(" 根据主键查询 "); //$NON-NLS-1$
            method.addJavaDocLine(sb.toString());
        } else if ("insertSelective".equalsIgnoreCase(method.getName())) {
            sb.append("  动态插入 "); //$NON-NLS-1$
            method.addJavaDocLine(sb.toString());

        } else if ("selectSelective".equalsIgnoreCase(method.getName())) {
            sb.append("  动态查询 "); //$NON-NLS-1$
            method.addJavaDocLine(sb.toString());
        } else if ("updateByPrimaryKeySelective".equalsIgnoreCase(method.getName())) {
            sb.append("  根据主键动态修改 "); //$NON-NLS-1$
            method.addJavaDocLine(sb.toString());

        } else if ("updateByPrimaryKey".equalsIgnoreCase(method.getName())) {
            sb.append(" 根据主键修改 "); //$NON-NLS-1$
            method.addJavaDocLine(sb.toString());

        } else if ("selectAll".equalsIgnoreCase(method.getName())) {
            sb.append(" 查找所有 "); //$NON-NLS-1$
            method.addJavaDocLine(sb.toString());

        }


        addJavadocTag(method, false);

        method.addJavaDocLine(" */"); //$NON-NLS-1$

    }


    @Override
    public void addModelClassComment(TopLevelClass topLevelClass,
                                     IntrospectedTable introspectedTable) {


        StringBuilder sb = new StringBuilder();

        topLevelClass.addJavaDocLine("/**"); //$NON-NLS-1$

        String remarks = introspectedTable.getRemarks();
        if (StringUtility.stringHasValue(remarks)) {
            topLevelClass.addJavaDocLine(" * 表备注:");
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));  //$NON-NLS-1$
            for (String remarkLine : remarkLines) {
                topLevelClass.addJavaDocLine(" *   " + remarkLine);  //$NON-NLS-1$
            }
        }
        topLevelClass.addJavaDocLine(" *"); //$NON-NLS-1$

        topLevelClass
                .addJavaDocLine(" * 胡化敏代码生成器."); //$NON-NLS-1$

        sb.append(" * 数据库表名 "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        topLevelClass.addJavaDocLine(sb.toString());

        addJavadocTag(topLevelClass, true);

        topLevelClass.addJavaDocLine(" */"); //$NON-NLS-1$
    }


    @Override
    public void addClassComment(InnerClass innerClass,
                                IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {


        StringBuilder sb = new StringBuilder();

        innerClass.addJavaDocLine("/**"); //$NON-NLS-1$
        innerClass
                .addJavaDocLine(" * 胡化敏代码生成器."); //$NON-NLS-1$

        sb.append(" *  数据库表名 "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerClass.addJavaDocLine(sb.toString());

        addJavadocTag(innerClass, markAsDoNotDelete);

        innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
    }


    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {


        field.addJavaDocLine("/**"); //$NON-NLS-1$

        String remarks = introspectedColumn.getRemarks();
        if (StringUtility.stringHasValue(remarks)) {
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));  //$NON-NLS-1$
            for (String remarkLine : remarkLines) {
                field.addJavaDocLine(" *   " + remarkLine);  //$NON-NLS-1$
            }
        }

        field.addJavaDocLine(" *"); //$NON-NLS-1$

        StringBuilder sb = new StringBuilder();
        sb.append(" * 数据库字段名:"); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        field.addJavaDocLine(sb.toString());

        addJavadocTag(field, false);

        field.addJavaDocLine(" */"); //$NON-NLS-1$

    }

    @Override
    public void addGetterComment(Method method,
                                 IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {

        StringBuilder sb = new StringBuilder();

        method.addJavaDocLine("/**"); //$NON-NLS-1$

        String remarks = introspectedColumn.getRemarks();

        sb.append(" * 数据库字段：".concat(remarks)); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());

        method.addJavaDocLine(" *"); //$NON-NLS-1$

        sb.setLength(0);
        sb.append(" * @return  the value of "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());

        addJavadocTag(method, false);

        method.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    @Override
    public void addSetterComment(Method method,
                                 IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {

        StringBuilder sb = new StringBuilder();

        method.addJavaDocLine("/**"); //$NON-NLS-1$
        String remarks = introspectedColumn.getRemarks();
        sb.append(" * 数据库字段：".concat(remarks)); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());


        Parameter parm = method.getParameters().get(0);
        sb.setLength(0);
        sb.append(" * @param "); //$NON-NLS-1$
        sb.append(parm.getName());
        sb.append(" the value for "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());

        addJavadocTag(method, false);

        method.addJavaDocLine(" */"); //$NON-NLS-1$
    }
}
