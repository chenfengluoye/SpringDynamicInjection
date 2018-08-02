package com.ckj.projects.registry;
import com.ckj.projects.proxy.MyProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * created by ChenKaiJu on 2018/8/2  10:18
 */

@Component
public class MyBeanRegister implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        try {
            Class cls=Class.forName("com.ckj.projects.api.IntMsgService");
            BeanDefinitionBuilder definitionBuilder=BeanDefinitionBuilder.genericBeanDefinition(MyProxyFactory.class);
            GenericBeanDefinition beanDefinition= (GenericBeanDefinition) definitionBuilder.getBeanDefinition();
            beanDefinition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
            beanDefinition.getPropertyValues().add("realClass",cls);
            String name=cls.getSimpleName();
            if(name.length()>1){
                beanDefinitionRegistry.registerBeanDefinition(Character.toLowerCase(name.charAt(0))+name.substring(1), beanDefinition);
            }else {
                beanDefinitionRegistry.registerBeanDefinition(Character.toLowerCase(name.charAt(0))+"", beanDefinition);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
