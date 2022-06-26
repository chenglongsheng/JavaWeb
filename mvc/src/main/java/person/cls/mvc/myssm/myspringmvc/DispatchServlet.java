package person.cls.mvc.myssm.myspringmvc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import person.cls.mvc.myssm.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: Servlet调用中心（核心控制器）
 * @author: CLS
 * @date: 2022-06-25-11:02
 * @version: 1.0
 */
@WebServlet("*.do")
public class DispatchServlet extends ViewBaseServlet {

    private Map<String, Object> beanMap = new HashMap<>();

    public DispatchServlet() {
    }

    /**
     * 解析XML文件，通过反射生成对应的controller实例，然后存放到beanMap容器中
     */
    @Override
    public void init() throws ServletException {
        super.init();
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
        } catch (ParserConfigurationException | IOException | SAXException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("UTF-8");
        String servletPath = request.getServletPath();
        // 根据path调度给具体的servlet
        // 把 /*.do -> *
        String name = StringUtils.substringFromPath(servletPath);

        Object beanControllerObj = beanMap.get(name);


        String operate = request.getParameter("operate");
        if (StringUtils.isEmpty(operate)) {
            operate = "index";
        }

        try {
            Method[] methods = beanControllerObj.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (operate.equals(method.getName())) {
                    Parameter[] parameters = method.getParameters();

                    // 取得参数列表
                    Object[] parameterValues = new Object[parameters.length];
                    for (int i = 0; i < parameterValues.length; i++) {
                        Parameter parameter = parameters[i];
                        String parameterName = parameter.getName();
                        // 如果参数名是request，response，session 就不在请求中获取参数
                        switch (parameterName) {
                            case "request":
                                parameterValues[i] = request;
                                break;
                            case "response":
                                parameterValues[i] = response;
                                break;
                            case "session":
                                parameterValues[i] = request.getSession();
                                break;
                            default:
                                String requestParameter = request.getParameter(parameterName);
                                // 处理参数类型不一致异常
                                String typeName = parameter.getType().getName();
                                Object parameterObj = requestParameter;
                                if (parameterObj != null) {
                                    if (typeName.equals("java.lang.Integer")) {
                                        parameterObj = Integer.parseInt(requestParameter);
                                    }
                                    parameterValues[i] = parameterObj;
                                }
                                break;
                        }
                    }

                    method.setAccessible(true);
                    Object methodReturnObj = method.invoke(beanControllerObj, parameterValues);

                    // 视图处理
                    String methodReturnObjStr = (String) methodReturnObj;
                    if (methodReturnObjStr.startsWith("redirect:")) {
                        String redirectStr = methodReturnObjStr.substring("redirect:".length());
                        response.sendRedirect(redirectStr);
                    } else {
                        super.processTemplate(methodReturnObjStr, request, response);
                    }
                }
            }

        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
