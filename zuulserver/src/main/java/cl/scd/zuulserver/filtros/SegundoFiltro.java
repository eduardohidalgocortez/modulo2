package cl.scd.zuulserver.filtros;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class SegundoFiltro extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(SegundoFiltro.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 2;
	}

	
	@Override
	public Object run() throws ZuulException {
		final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		
		logger.info("{} {}", request.getRequestURL().toString(), request.getMethod());

		return null;

	}

}
