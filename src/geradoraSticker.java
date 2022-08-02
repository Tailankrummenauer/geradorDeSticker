import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.plaf.FontUIResource;

import org.apache.commons.io.FileUtils;



public class geradoraSticker {
    public void criar(InputStream inputStream, String nomeArquivo) throws Exception{

    //public void criar(InputStream inputStream, String nomeArquivo, Double imdbRating) throws Exception{
        //leitura da imagem
  
    
     BufferedImage imagemOriginal =  ImageIO.read(inputStream);

        //cria nova imagem em memoria com transparencia e com tamanho novo

    int largura = imagemOriginal.getWidth();
    int altura   = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImage = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
      
    //copiar imagem original para nova imagem (em memoria)
    Graphics2D graphics =(Graphics2D) novaImage.getGraphics();
    graphics.drawImage(imagemOriginal,  0, 0, null);
      
    //Configurar a fonte
    Font font = Font.createFont(Font.TRUETYPE_FONT,new File("C:/Users/Usuario/Documents/appJava/Fontes/comic.ttf"));
    graphics.setFont(font.deriveFont(Font.BOLD,80));
    graphics.setColor(Color.green);
    


    //Escrever um texto na nova imagem
    //if(imdbRating >= 9.5){
       // graphics.drawString("Perfeito", largura/3, novaAltura-85);
//}
  //  else{
        graphics.drawString("Topzera", largura/3, novaAltura-85);
    //}
    
    
    //escrever a nova imagem num arquivo
    File directory = new File("C:/Users/Usuario/Documents/appJava/saida");
    FileUtils.forceMkdir(directory);
    ImageIO.write(novaImage, "png", new File(directory,nomeArquivo));
    
    }
    
}
