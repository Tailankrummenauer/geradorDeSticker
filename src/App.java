import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes

        String url = "https://api.nasa.gov/planetary/apod?api_key=gcKs98P5Mgh1NqmmvXPFZD1DF0aXlENbuyPNXbj7&start_date=2022-06-12&end_date=2022-06-14";
     //   String url = "https://imdb-api.com/en/API/Top250Movies/k_t2vedt83";
        


        var http = new clienteHttps();
        String json = http.buscaDados(url);
        

              // exibir e manipular os dados
        extratordeConteudo extrator = new extratorNasa();
       // List<Conteudo> conteudos = extrator.extraiConteudos(json);
       
       //extratordeConteudo extrator = new extratorIMDB();
       List<conteudo>conteudos =  extrator.extraiConteudos(json);
        
       var geradora = new geradoraSticker();

        for (int i = 0; i < 3; i++) {
           conteudo conteudo = conteudos.get(i);
               
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = conteudo.getTitulo() + ".png";

            geradora.criar(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}
