# annotation

-   @RestController : restApi 기능을 하는 클래스를 지정한다.

-   @RequestMapping("/api") : 이 주소로 오는 일들을 처리한다.

-   @GetMapping(path="/hello") : GET 메소드를 호출한다.
- @Data : get, set, 기본 생성자를 만들어 준다. 롬복의 기능 
- @AllArgsConstructor : 모든 파라미터를 받는 생성자를 만든다. @Data와 함께 쓰면 기본 생성자는 사라진다.
- @NoArgsConstructor : 기본 생성자를 만들어 준다.

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