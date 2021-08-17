package br.com.oppus.api.constants;

public class SecurityConstants {
    public static final String SIGN_UP_URL = "/users/register";
    public static final String[] AUTH_LIST = {
            // -- swagger ui
            "**/swagger-resources/**",
            "/swagger-ui.html",
            "/webjars/**",
            "/api/**"

    };
    public static final String KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyLCJpZCI6MTIzfQ.XAGdiUQY-RoLFaeF3CkiZxRtEA5ZKLHwX_8xOx1gy-E";
    public static final String HEADER_NAME = "Authorization";
    public static final long EXPIRATION_TIME = 1000L * 60 * 30;
}
