package com.c1221g1.pharmacy.Controller;

import com.c1221g1.pharmacy.dto.employee.EmployeeDto;
import com.c1221g1.pharmacy.dto.employee.PositionDto;
import com.c1221g1.pharmacy.dto.user.UsersDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeController_updateEmployee {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /*
      Created by TamNA
      Time: 13:50:00 30/06/2022
      Function:  update test name
 */
    @Test
    public void updateEmployee_name_13() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setEmployeeId("NV-00004");
        employeeDto.setEmployeeName("null");
        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager-employee/employees/update/{id}","NV-00004")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /*
      Created by TamNA
      Time: 13:55:00 30/06/2022
      Function:  update test name
 */

    @Test
    public void updateEmployee_name_14() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("");
        employeeDto.setEmployeeImage("https:1234");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /*
      Created by TamNA
      Time: 14:00:00 30/06/2022
      Function:  update test name
 */
    @Test
    public void updateEmployee_name_15() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("@l;skd");
        employeeDto.setEmployeeImage("https:1234");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*
  Created by TamNA
  Time: 14:05:00 30/06/2022
  Function:  update test name
*/
    @Test
    public void updateEmployee_name_16() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("sdsadasdkashdkjashdkjashdkjashdjkashdkjashdkashdkashdkashdkashashdaksjd");
        employeeDto.setEmployeeImage("https:1234");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /*
  Created by TamNA
  Time: 14:07:00 30/06/2022
  Function:  update test name
*/
    @Test
    public void updateEmployee_name_17() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("s");
        employeeDto.setEmployeeImage("https:1234");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /*
  Created by TamNA
  Time: 14:10:00 30/06/2022
  Function:  update test name
*/
    @Test
    public void updateEmployee_name_18() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Nguyễn Văn A");
        employeeDto.setEmployeeImage("https:1234");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/manager-employee/employees/update/update{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /*
  Created by TamNA
  Time: 14:10:00 30/06/2022
  Function:  update test image
*/
    @Test
    public void updateEmployee_image_13() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Nguyễn văn A");
        employeeDto.setEmployeeImage("null");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /*
      Created by TamNA
      Time: 15:59:00 30/06/2022
      Function:  update test image
 */

    @Test
    public void updateEmployee_image_14() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Nguyễn Văn A");
        employeeDto.setEmployeeImage("");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /*
      Created by TamNA
      Time: 15:59:00 30/06/2022
      Function:  update test image
 */
    @Test
    public void updateEmployee_image_15() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Tâm");
        employeeDto.setEmployeeImage("https:1234");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

        /*
      Created by TamNA
      Time: 16:01:00 30/06/2022
      Function:  update test image
 */

    @Test
    public void updateEmployee_image_18() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Nguyễn Văn A");
        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /*
   Created by TamNA
   Time: 16:02:00 30/06/2022
   Function:  update test address
*/
    @Test
    public void updateEmployee_address_13() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Nguyễn Văn A");
        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
        employeeDto.setEmployeeAddress("null");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /*
   Created by TamNA
   Time: 16:03:00 29/06/2022
   Function:  update test address
*/
    @Test
    public void updateEmployee_address_14() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Nguyễn Văn A");
        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
        employeeDto.setEmployeeAddress("");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /*
      Created by TamNA
      Time: 16:06:00 29/06/2022
      Function:  update test address
 */
    @Test
    public void updateEmployee_address_15() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Tâm");
        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
        employeeDto.setEmployeeAddress("Quảng");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

        /*
      Created by TamNA
      Time: 16:06:00 30/06/2022
      Function:  update test address
 */

    @Test
    public void updateEmployee_address_18() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Nguyễn Văn A");
        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    /*
  Created by TamNA
  Time: 16:22:00 30/06/2022
  Function:  update test phone
*/
    @Test
    public void updateEmployee_phone_13() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Nguyễn Văn A");
        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("null");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees//{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /*
   Created by TamNA
   Time: 16:23:00 30/06/2022
   Function:  update test phone
*/
    @Test
    public void updateEmployee_phone_14() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Nguyễn Văn A");
        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
        employeeDto.setEmployeeAddress("Quảng nam");
        employeeDto.setEmployeePhone("");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /*
      Created by TamNA
      Time: 16:25:00 30/06/2022
      Function:  update test phone
 */
    @Test
    public void updateEmployee_phone_15() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Tâm");
        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("0905700");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

        /*
      Created by TamNA
      Time: 16:25:00 30/06/2022
      Function:  update test phone
 */

    @Test
    public void updateEmployee_phone_18() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Nguyễn Văn A");
        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



    /*
  Created by TamNA
  Time: 15:25:00 30/06/2022
  Function:  update test DateStart
*/
    @Test
    public void updateEmployee_DateStart_13() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Nguyễn Văn A");
        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("null");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /*
   Created by TamNA
   Time: 16:26:00 30/06/2022
   Function:  update test DateStart
*/
    @Test
    public void updateEmployee_DateStart_14() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Nguyễn Văn A");
        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
        employeeDto.setEmployeeAddress("Quảng nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
            /*
      Created by TamNA
      Time: 16:26:00 30/06/2022
      Function:  update test DateStart
 */

    @Test
    public void updateEmployee_DateStart_18() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Nguyễn Văn A");
        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
        employeeDto.setEmployeeAddress("Quảng Nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2000-12-01");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /*
Created by TamNA
Time: 16:23600 30/06/2022
Function:  update test position
*/
    @Test
    public void updateEmployee_position_14() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Nguyễn Văn A");
        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
        employeeDto.setEmployeeAddress("Quảng nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2002/09/29");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(0);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("nat");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /*
Created by TamNA
Time: 16:27:00 30/06/2022
Function:  update test userName
*/
    @Test
    public void updateEmployee_userName_14() throws Exception {

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setEmployeeName("Nguyễn Văn A");
        employeeDto.setEmployeeImage("https://cdn.tgdd.vn/Files/2019/07/27/1182124/cac-dinh-dang-duoi-file-hinh-anh-pho-bien-hien-nay-7-760x367.jpg");
        employeeDto.setEmployeeAddress("Quảng nam");
        employeeDto.setEmployeePhone("0905700994");
        employeeDto.setEmployeeDateStart("2002/09/29");
        employeeDto.setEmployeeNote("aaaa");


        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(1);
        employeeDto.setPositionDto(positionDto);

        UsersDto usersDto = new UsersDto();
        usersDto.setUsername("");
        employeeDto.setEmployeeUsername(usersDto);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/manager-employee/employees/update/{id}")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}