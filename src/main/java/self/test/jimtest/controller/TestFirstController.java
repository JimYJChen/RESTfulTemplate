package self.test.jimtest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import self.test.jimtest.beans.TestRequest;
import self.test.jimtest.beans.TestResponse;

@RestController
@RequestMapping("/api")
@Slf4j
public class  TestFirstController extends BasicController{

    @RequestMapping(value = "test", method = RequestMethod.POST)
    public TestResponse testHandler(@RequestBody TestRequest testRequest){
        TestResponse testResponse = new TestResponse();
        testResponse.setName("Jimtest");
        testResponse.setValue("zzz");
        log.info(testRequest.toString());
        return testResponse;
    }
}
