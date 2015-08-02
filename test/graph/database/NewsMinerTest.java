package graph.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;
import org.junit.Assert;
import org.junit.Test;

public class NewsMinerTest {

    public NewsMinerTest() {
    }

    @Test
    public void simulate() {
        InputStream modelIn;
        try {
            modelIn = new FileInputStream("en-token.bin");
            TokenizerModel model = new TokenizerModel(modelIn);
            Tokenizer tokenizer = new TokenizerME(model);
            modelIn.close();

            modelIn = new FileInputStream("en-ner-person.bin");
            TokenNameFinderModel nameFinderModel = new TokenNameFinderModel(modelIn);
            NameFinderME nameFinder = new NameFinderME(nameFinderModel);
            modelIn.close();

            String[] sentences = tokenizer.tokenize("Hi, I am Mark and I am Mario was born on 14 February 1994.");
            Span[] nameSpans = nameFinder.find(sentences);
            nameFinder.clearAdaptiveData();

            Assert.assertEquals(2, nameSpans.length);
        } catch (IOException ex) {
            Logger.getLogger(NewsMiner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
