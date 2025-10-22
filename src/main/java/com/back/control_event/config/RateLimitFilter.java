package com.back.control_event.config;
// package com.sena.crud_basic.config;


// import java.io.IOException;
// import java.util.Map;
// import java.util.concurrent.ConcurrentHashMap;

// import jakarta.servlet.Filter;
// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.ServletRequest;
// import jakarta.servlet.ServletResponse;
// import jakarta.servlet.http.HttpServletRequest;

// public class RateLimitFilter implements Filter {

//     private final Map<String, RequestCounter> ipRequestMap = new ConcurrentHashMap<>();
//     private static final int MAX_REQUESTS = 10;
//     private static final long TIME_WINDOW = 60_000; // 1 minuto en milisegundos

//     @Override
//     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//             throws IOException, ServletException {

//         HttpServletRequest req = (HttpServletRequest) request;
//         String ipAddress = req.getRemoteAddr();

//         synchronized (ipRequestMap.computeIfAbsent(ipAddress, k -> new RequestCounter(0, System.currentTimeMillis()))) {
//             long currentTime = System.currentTimeMillis();
//             RequestCounter counter = ipRequestMap.get(ipAddress);

//             if (currentTime - counter.startTime > TIME_WINDOW) {
//                 counter.startTime = currentTime;
//                 counter.requestCount = 0;
//             }

//             counter.requestCount++;

//             if (counter.requestCount > MAX_REQUESTS) {
//                 ((jakarta.servlet.http.HttpServletResponse) response).setStatus(429);
//                 response.setContentType("text/plain");
//                 response.setCharacterEncoding("UTF-8");
//                 response.getWriter().write("Too many requests. Try again later.");
//                 return;
//             }
//         }

//         chain.doFilter(request, response);
//     }

//     private static class RequestCounter {
//         int requestCount;
//         long startTime;

//         RequestCounter(int requestCount, long startTime) {
//             this.requestCount = requestCount;
//             this.startTime = startTime;
//         }
//     }
// }
