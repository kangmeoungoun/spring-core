package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController{
    private final LogDemoService logDemoService;

    private final MyLogger myLogger;

    @GetMapping("log-demo")
    public ResponseEntity<String>  logDemo(HttpServletRequest request) throws InterruptedException{
        String requestURL = request.getRequestURL().toString();
        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        Thread.sleep(1000);
        logDemoService.logic("testID");
        return ResponseEntity.ok().body("OK");
    }
}
