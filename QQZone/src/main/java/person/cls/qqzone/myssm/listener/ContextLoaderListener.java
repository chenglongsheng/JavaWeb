package person.cls.qqzone.myssm.listener;

import person.cls.qqzone.myssm.ioc.BeanFactory;
import person.cls.qqzone.myssm.ioc.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @description: 监听tomcat启动时在上下文中初始化bean工厂
 * @author: CLS
 * @date: 2022-07-03-8:22
 * @version: 1.0
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext();
        ServletContext application = sce.getServletContext();
        application.setAttribute("beanFactory", beanFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
