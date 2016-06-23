/**
 * Copyright 2016-06-22 the original author or authors.
 */
package pl.atlkom.security.ex02;

/**
 * @author Adrian Lapierre {@literal <adrian@soft-project.pl>}
 */
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class CsrfSecurityRequestMatcher implements RequestMatcher{

    private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
    private String prefix = "^/rest";

    public boolean matches(HttpServletRequest request) {

        if(allowedMethods.matcher(request.getMethod()).matches()){
            return false;
        }

        boolean result = ! request.getRequestURI().matches( prefix + "/.+");

        return result;


    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}