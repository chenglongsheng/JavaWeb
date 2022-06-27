package person.cls.mvc.myssm.io;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 从配置文中实例化对象
 * @author: CLS
 * @date: 2022-06-26-22:27
 * @version: 1.0
 */
public class ClassPathXmlApplicationContext implements BeanFactory {

    private Map<String, Object> beanMap = new HashMap<>();

    public ClassPathXmlApplicationContext() {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("applicationContext.xml");
            // 1.创建DocumentBuilderFactory对象
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            // 2.DocumentBuilder对象
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            // 3.创建Document对象
            Document document = documentBuilder.parse(is);

            // 4.获取所有的bean节点
            NodeList nodeList = document.getElementsByTagName("bean");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node beanNode = nodeList.item(i);
                if (beanNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element beanElement = (Element) beanNode;
                    String beanId = beanElement.getAttribute("id");
                    String beanClass = beanElement.getAttribute("class");
                    Object beanObj = Class.forName(beanClass).newInstance();
                    beanMap.put(beanId, beanObj);
                }

            }
            // 组装bean之间的依赖关系
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node beanNode = nodeList.item(i);
                if (beanNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element beanElement = (Element) beanNode;
                    String beanId = beanElement.getAttribute("id");
                    NodeList childNodes = beanElement.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node beanChildNode = childNodes.item(j);
                        if (beanChildNode.getNodeType() == Node.ELEMENT_NODE && "property".equals(beanChildNode.getNodeName())) {
                            Element propertyElement = (Element) beanChildNode;
                            String propertyName = propertyElement.getAttribute("id");
                            String propertyRef = propertyElement.getAttribute("ref");
                            // 找到property对应的实例
                            Object refObj = beanMap.get(propertyName);
                            // 将refObj设置到当前bean对应的实例的property属性中
                            Object beanObj = beanMap.get(beanId);
                            Class<?> beanObjClass = beanObj.getClass();
                            Field propertyField = beanObjClass.getDeclaredField(propertyRef);
                            propertyField.setAccessible(true);
                            propertyField.set(beanObj, refObj);
                        }
                    }
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException | ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String id) {
        return beanMap.get(id);
    }
}
