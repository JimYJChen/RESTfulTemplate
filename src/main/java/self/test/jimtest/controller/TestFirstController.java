package self.test.jimtest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import self.test.jimtest.beans.TestRequest;
import self.test.jimtest.beans.TestResponse;
import self.test.jimtest.common.annotations.LogAnnotations;

@RestController
@RequestMapping("/api")
@Slf4j
public class TestFirstController {

    @RequestMapping(value = "test", method = RequestMethod.POST)
    @LogAnnotations(action = "jimtest")
    public TestResponse testHandler(@RequestBody TestRequest testRequest){
        TestResponse testResponse = new TestResponse();
        testResponse.setName("Jimtest");
        testResponse.setValue("zzz");
        log.info(testRequest.toString());
        return testResponse;
    }


}
