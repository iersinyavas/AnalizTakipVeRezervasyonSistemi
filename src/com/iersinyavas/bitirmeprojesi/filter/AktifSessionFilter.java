package com.iersinyavas.bitirmeprojesi.filter;

import java.io.IOException;

import javax.faces.bean.ManagedProperty;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iersinyavas.bitirmeprojesi.mangedbeans.UyeGirisBean;

/**
 * Servlet Filter implementation class AktifSessionFilter
 */
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE
		}
					, 
		urlPatterns = { 
				"/AktifSessionFilter", 
				"/kayit.xhtml",
				"/giris.xhtml",
				"/login.xhtml"
		})
public class AktifSessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AktifSessionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession httpSession = ((HttpServletRequest)request).getSession();
		if(((HttpServletRequest)request).getSession().getAttribute("kullaniciAd")!=null) {
			((HttpServletResponse)response).setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			((HttpServletResponse)response).setHeader("Pragma", "no-cache");
			((HttpServletResponse)response).setHeader("Expires", "0");
			((HttpServletResponse)response).sendRedirect((String) httpSession.getAttribute("yonlendir"));
		}
			
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
