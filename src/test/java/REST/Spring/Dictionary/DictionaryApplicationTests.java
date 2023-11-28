package REST.Spring.Dictionary;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class DictionaryApplicationTests
{
    @Test
    @DisplayName("Тестик")
    void contextLoads()
    {
        // given
        String test = "abbbcc";

        // when
        Map<Character, Integer> answer = MapCreator.createMap(test);

        // then
        assertThat(answer.size()).isEqualTo(3);
        assertThat(answer.get('a')).isEqualTo(1);
        assertThat(answer.get('b')).isEqualTo(3);
        assertThat(answer.get('c')).isEqualTo(2);
        assertThat(answer.keySet().toString()).isEqualTo("[b, c, a]");
    }

	@Test
	@DisplayName("Тест REST API")
	void restPart()
	{
		// given
		String test = "abbbcc";
		HttpResponse<String> response;
		try (HttpClient client = HttpClient.newHttpClient())
		{
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("http://localhost:8080/api/string"))
					.POST(HttpRequest.BodyPublishers.ofString(test))
					.build();
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		}
        catch (IOException | InterruptedException e)
        {
            throw new RuntimeException(e);
        }


        // when


		// then
		assertThat(response.body()).isEqualTo("{\"b\":3,\"c\":2,\"a\":1}");
	}
}
