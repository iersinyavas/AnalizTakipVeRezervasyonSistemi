package com.iersinyavas.bitirmeprojesi.filter;

import java.io.IOException;
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

import com.iersinyavas.bitirmeprojesi.helper.Database;
import com.iersinyavas.bitirmeprojesi.helper.Util;

/**
 * Servlet Filter implementation class AnasayfaCacheCleanFilter
 */
@WebFilter(
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE
		}
					, 
		urlPatterns = { 
				"/AnasayfaCacheCleanFilter", 
				"/analizdurum.xhtml",
				"/analizfiyatlari.xhtml",
				"/anasayfa.xhtml",
				"/baslayananalizler.xhtml",
				"/guncellemeler.xhtml",
				"/rezervasyon.xhtml",
				"/rezervasyonlarim.xhtml",
				"/takvim.xhtml",
				"/uyebilgileri.xhtml",
				"/yetkilibaslayananalizler.xhtml",
				"/yetkilikullanicianasayfa.xhtml",
				"/yetkilirezervasyon.xhtml",
				"/yetkilirezervasyonlarim.xhtml",
				"/yetkilitakvim.xhtml",
				"/yetkilitumuyeler.xhtml",
				"/yetkiliuyebilgileri.xhtml",
				"/yetkilizamanigecenler.xhtml",
				"/yetkilizgguncelle.xhtml",
				"/zamanigecenler.xhtml"
		})
public class AnasayfaCacheCleanFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AnasayfaCacheCleanFilter() {
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
		((HttpServletResponse)response).setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		((HttpServletResponse)response).setHeader("Pragma", "no-cache");
		((HttpServletResponse)response).setHeader("Expires", "0");
		((HttpServletResponse)response).setDateHeader("Expires", 0);
		if(((HttpServletRequest)request).getSession().getAttribute("kullaniciAd")==null) {
			((HttpServletResponse)response).sendRedirect("login.xhtml");
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
