package com.huhuamin.mybatis.gernerator;

import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;

import java.util.List;

/**
 * @Auther: Huhuamin
 * @Date: 2019/8/26 20:08
 * @Description:
 */
public class InsoIntrospectedTable extends IntrospectedTableMyBatis3Impl {
    @Override
    protected void calculateXmlMapperGenerator(AbstractJavaClientGenerator javaClientGenerator, List<String> warnings, ProgressCallback progressCallback) {
        if (javaClientGenerator == null) {
            if (this.context.getSqlMapGeneratorConfiguration() != null) {
                this.xmlMapperGenerator = new HhmSimpleXMLMapperGenerator();
            }
        } else {
            this.xmlMapperGenerator = new HhmSimpleXMLMapperGenerator();
        }

        this.initializeAbstractGenerator(this.xmlMapperGenerator, warnings, progressCallback);
    }


    @Override
    protected AbstractJavaClientGenerator createJavaClientGenerator() {
        if (context.getJavaClientGeneratorConfiguration() == null) {
            return null;
        }

        String type = context.getJavaClientGeneratorConfiguration()
                .getConfigurationType();

        AbstractJavaClientGenerator javaGenerator = new HhmJavaMapperGenerator(true);
//        if ("XMLMAPPER".equalsIgnoreCase(type)) { //$NON-NLS-1$
//            javaGenerator = new JavaMapperGenerator();
//        } else if ("MIXEDMAPPER".equalsIgnoreCase(type)) { //$NON-NLS-1$
//            javaGenerator = new MixedClientGenerator();
//        } else if ("ANNOTATEDMAPPER".equalsIgnoreCase(type)) { //$NON-NLS-1$
//            javaGenerator = new AnnotatedClientGenerator();
//        } else if ("MAPPER".equalsIgnoreCase(type)) { //$NON-NLS-1$
//            javaGenerator = new JavaMapperGenerator();
//        } else {
//            javaGenerator = (AbstractJavaClientGenerator) ObjectFactory
//                    .createInternalObject(type);
//        }

        return javaGenerator;
    }




}
