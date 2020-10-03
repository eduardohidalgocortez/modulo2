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
public class PrimerFiltro extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(PrimerFiltro.class);

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
		return 1;
	}
	
	
	@Override
	public Object run() throws ZuulException {
		
		RequestContext context = RequestContext.getCurrentContext();
		context.put("startTime", Instant.now().toEpochMilli());
		final HttpServletRequest request = context.getRequest();

		if (request.getHeader("propiedad") == null || !request.getHeader("propiedad").equals("true")) {
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			context.setResponseBody("{\"error\":\"Rechazado por no tener propiedad requerida.\"}");
			context.setRouteHost(null);
			return null;
		}

		return null;
	}

}
