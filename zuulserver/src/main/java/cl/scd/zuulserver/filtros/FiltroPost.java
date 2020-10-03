package cl.scd.zuulserver.filtros;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class FiltroPost extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(FiltroPost.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		long startTime = (Long) ctx.get("startTime");
		logger.info("URL de la Solicitud: " + request.getRequestURL().toString() + ":: Tiempo de la solicitud=" + (Instant.now().toEpochMilli() - startTime) + " ms");
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
