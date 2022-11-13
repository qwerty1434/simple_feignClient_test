# simple_feignClient_test

## 1. 설명
해당 예제는 Hobby-service에서 FeignClient를 이용해 User-service의 정보를 가져오는 내용입니다. </br>
일반적인 mvc패턴과 다른 몇 가지 내용을 살펴보겠습니다. <br>

1. Hobby-service의 HobbyApplication에 `@EnableFeignClients`어노테이션이 필요합니다.
```java
package com.example.hobby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HobbyApplication {

   public static void main(String[] args) {
      SpringApplication.run(HobbyApplication.class, args);
   }

}

```
2. `@FeignClient`를 선언한 인터페이스를 작성해야 합니다. 이때 통신하기를 희망하는 상대 서버(예제에서는 User-service)의 메서드 및 경로를 설정해줘야 합니다.  
```java
package com.example.hobby.client;

import com.example.hobby.dto.ResponseDto;
import com.example.hobby.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="user-service")
public interface UserServiceClient {
    @GetMapping("/findUser/{userId}")
    UserEntity getUser(@PathVariable Long userId);

    @GetMapping("/findAll")
    List<UserEntity> getAll();

}
```

## 2. application.yml 수정
본인에 맞게 환경 설정을 해주면 됩니다. 저는 DB로 mysql을 사용했습니다. <br>
yml파일에서 설정한 테이블이 실제 DB에 존재해야 합니다.

## 3. 테스트
- 유레카 서버 → 게이트웨이 서버 → User 서버, Hobby 서버 순서로 서버를 작동시켜 줍니다.
- 테스트를 위해 user_db에 값을 추가합니다.
![image](https://user-images.githubusercontent.com/25142537/201511542-806a885b-829e-4ee1-8db5-6223562360ea.png)
- hobby-service에서 user를 조회하는 api를 호출해 봅니다.
![image](https://user-images.githubusercontent.com/25142537/201511549-8b8c6ce7-04d8-4892-ba3c-182c56d66df8.png)
