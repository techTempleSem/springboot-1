# tool

talend api tester :크롬 확장 프로그램. 직접 쿼리를 날릴 수 있다. 

# annotation

-   @RestController : restApi 기능을 하는 클래스를 지정한다.
- @Controller : json 응답이 아니라 모든 응답을 내릴 수 있다.
- @ResponseBody : @Controller가 있을 때 json으로 응답을 내리겠다고 명시해 준다.

-   @RequestMapping("/api") : 이 주소로 오는 일들을 처리한다.

-   @GetMapping(path="/hello") : GET 메소드를 호출한다.
- @Data : get, set, 기본 생성자를 만들어 준다. 롬복의 기능 
- @AllArgsConstructor : 모든 파라미터를 받는 생성자를 만든다. @Data와 함께 쓰면 기본 생성자는 사라진다.
- @NoArgsConstructor : 기본 생성자를 만들어 준다.
- @Slf4j : 로그 기록
- @Autowired: 스프링에서 관리하는 빈 들 중에 자동으로 생성되는 오브젝트를 가져온다.

# Mapping

## getMapping

### @PathVariable
다음과 같은 식으로 변수를 넘길 수 있다. 이때 이름은 같아야 한다.
```
@GetMapping(path = "/echo/{message}")
public String echo(
        @PathVariable String message
){
```
다른 이름을 쓰고 싶으면 @PathVariable(name="message")로 이름을 지정해 줄 수 있다.
```
@GetMapping(path = "/echo/{message}")
public String echo(
        @PathVariable(name="message") String msg
){
```

### @RequestParam
url?변수명1=값1&변수명2=값2 형식으로 값을 넘겨준다.

```
url : http://localhost:8080/api/book?category=aaa&issuedYear=10&issued-month=9&issued_day=8

@GetMapping(path = "/book")
public String book(
        @RequestParam String category,
        @RequestParam String issuedYear,
        @RequestParam(name="issued-month") String issuedMonth,
        @RequestParam String issued_day
)
```

객체를 이용해서 받을 수 있다. 이때는 @RequestParam을 쓰지 않는다.
```
@GetMapping(path = "/book2")
public String book2(
        BookQueryParam bookQueryParam
){
```

## postMapping

데이터가 없으면 넣고  이미 있으면 그대로

post는 객체를 받는다

- @RequestBody: http body로 들어오는 데이터를 해당 객체에 받는다.
- @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class): 스케니크 케이스로 넘겨줘도 객체에서는 카멜로 받음

## putMapping

데이터가 없으면 넣고  이미 있으면 업데이트

boolean isKorean 이런 식으로 불리언 변수명에 is가 앞에 붙으면 setIsKorean이 아니라 setKorean으로 인식함.

해결책
1. korean으로 요청
2. Boolean으로 선언

## deleteMapping

위와 같다

get, post, put, delete 모두 비슥한 형식을 띈다.

다음처럼 여러 uri를 쓰게 할 수 있다.
```
@DeleteMapping(path = {
"/user/{userName}/delete",
"/user/{userName}/del"
})
```

# 직열화, 역직열화

```
@Autowired
private ObjectMapper objectMapper;
```

꼭 선언해야 함

- 직열화 : var json = objectMapper.writeValueAsString(user);

변수가 아니라 get메소드에 영향을 받는다. userName 변수가 있고 getPersonUser(){return userName} 이 있으면 person_user으로 직열화 된다.

@JsonIgnore: 직열화 할 때 영향을 미치지 않게 하겠다.

@JsonProperty("asd"): 해당 변수를 "asd"로 바꾸겠다.

- 역직열화 : var dto = objectMapper.readValue(json, UserRequest.class);
