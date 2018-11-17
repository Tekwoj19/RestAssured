import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

public class RestAssuredFirstTest {

//
//    @Test
//    public void HelloPrefix() {
//        // given
//
//
//        // given, when, then
//        given()
//                .param("firstname", "Wojtek")
//                .param("surname", "Nowy")
//                .param("prefix", "mr")
//                .header("X-USer-ID", "1000")
//                .header("X-Role", "admin").
//
//
//                when()
//                .get("https://safe-plateau-87483.herokuapp.com/hello").
//                then()
//                .log().ifValidationFails()
////                .body("message", equalTo("Hello mr Wojtek Nowy!"))
//                .body("firstname", equalTo("Wojtek"))
//                .body("surname", equalTo("Nowy"))
//                .body("message", containsString("mr"))
//                .body("X-User-ID", containsString("1000"))
//                .body("X-Role", containsString("admin"));
//

//    }



    @Test
    public void shouldCreateNewBookFromDict()
    {
        String isbn = "123l";
        // given
        Map<String, Object> book = new HashMap<>();
        book.put("author", "Bartosz Szulc");
        book.put("category", "software");
        book.put("isbn", "123");
        book.put("title", "quality in software development");
        book.put("href", "/books/123");
        book.put("price", 100000);
        // when
                given()
                        .header("Content-Type", "application/json")
                        .body(book).

               when()
                        .post(("https://safe-plateau-87483.herokuapp.com/book")).



               then()

                        .log()
                        .all()
                        .body("href",equalTo("/books/".concat(isbn)));

    }




    @Test
    public void returnsTotalPriceOfSelectedBooks()
    {
        given().
                get(("https://safe-plateau-87483.herokuapp.com/book")).
                then().
                body("store.book.findAll{ it.title.startsWith(\"S\")}.size",equalTo(3));
    }








}
