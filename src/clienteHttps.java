import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class clienteHttps {
    public String buscaDados(String URL) {


        try{
        //String endereco = "https://api.nasa.gov/planetary/apod?api_key=gcKs98P5Mgh1NqmmvXPFZD1DF0aXlENbuyPNXbj7&start_date=2022-06-12&end_date=2022-06-14";
        URI endereco = URI.create(URL);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        return body;
        }
       catch (IOException | InterruptedException ex){
            throw new RuntimeException(ex);

       }

       
    }
}
