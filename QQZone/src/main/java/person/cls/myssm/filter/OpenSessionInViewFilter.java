package person.cls.myssm.filter;

import person.cls.myssm.trans.TransactionManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @description: 事务管理过滤器
 * @author: CLS
 * @date: 2022-07-03-16:16
 * @version: 1.0
 */
@WebFilter("*.do")
public class OpenSessionInViewFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            TransactionManager.beginTransaction();
            chain.doFilter(request, response);
            TransactionManager.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                TransactionManager.rollbackTransaction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {
    }
}
