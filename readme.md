# annotation

-   @RestController : restApi 기능을 하는 클래스를 지정한다.

-   @RequestMapping("/api") : 이 주소로 오는 일들을 처리한다.

-   @GetMapping(path="/hello") : GET 메소드를 호출한다.

## getMapping

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
