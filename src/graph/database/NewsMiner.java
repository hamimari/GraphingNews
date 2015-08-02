package graph.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

/**
 * class ini bertanggung jawab untuk proses mining dari text
 */
public class NewsMiner {

    /**
     * method yang digunakan untuk menemukan title yang telah terdefinisi dari
     * variable text <br/>IS : variable text sudah terdefinisi <br/>FS : return
     * title yang ditemukan jika ditemukan atau null jika tidak
     *
     * @param text
     * @return judul berita
     */
    public String getTitle(String text) {
        String title = null;
        return title;
    }

    /**
     * method yang digunakan untuk menemukan author yang telah terdefinisi dari
     * variable text <br/>IS : variable text sudah terdefinisi <br/>FS : return
     * author yang ditemukan jika ditemukan atau null jika tidak
     *
     * @param text
     * @return author dari berita
     */
    public String getAuthor(String text) {
        InputStream modelIn;
        try {
            modelIn = new FileInputStream("en-ner-person.bin");
            TokenNameFinderModel model = new TokenNameFinderModel(modelIn);
            NameFinderME nameFinder = new NameFinderME(model);
            modelIn.close();

            String[] sentence = new String[]{
                "Adam", "Levine", "is", "a", "singer"
            };

            Span[] nameSpans = nameFinder.find(sentence);
            for (Span s : nameSpans) {
                System.out.println(s.toString());
            }
            nameFinder.clearAdaptiveData();
        } catch (IOException ex) {
            Logger.getLogger(NewsMiner.class.getName()).log(Level.SEVERE, null, ex);
        }

        String author = null;
        return author;
    }

    /**
     * method yang digunakan untuk menemukan date yang telah terdefinisi dari
     * variable text <br/>IS : variable text sudah terdefinisi <br/>FS : return
     * author yang ditemukan jika ditemukan atau null jika tidak
     *
     * @param text
     * @return tanggal publish berita
     */
    public String getDate(String text) {
        String date = null;
        return date;
    }

    /**
     * method yang digunakan untuk menemukan article yang telah terdefinisi dari
     * variable text <br/>IS : variable text sudah terdefinisi <br/>FS : return
     * author yang ditemukan jika ditemukan atau null jika tidak
     *
     * @param text
     * @return artikel dalam berita
     */
    public String getArticle(String text) {
        String article = null;
        return article;
    }
}
