package au.com.vb.springboot.controller;

import au.com.vb.springboot.model.Course;
import au.com.vb.springboot.service.StudentService;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class, secure = false)
public class StudentControllerTest {

  Course mockCourse = new Course("Course1", "Spring", "10Steps",
          Arrays.asList("Learn Maven", "Import Project", "First Example",
                  "Second Example"));
  String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private StudentService studentService;

  @Test
  public void retrieveDetailsForCourse() throws Exception {

    Mockito.when(
            studentService.retrieveCourse(Mockito.anyString(),
                    Mockito.anyString())).thenReturn(mockCourse);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
            "/students/Student1/courses/Course1").accept(
            MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(result.getResponse());
    String expected = "{id:Course1,name:Spring,description:10Steps}";

    // {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

    JSONAssert.assertEquals(expected, result.getResponse()
            .getContentAsString(), false);
  }

}
