package partyup.com.myapplication.Provider;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.Objects.BarFragmentObject;
import partyup.com.myapplication.Objects.Category;
import partyup.com.myapplication.Objects.ColorsTheme;
import partyup.com.myapplication.RequestManager.ManagerAsynTask;
import partyup.com.myapplication.RequestManager.ServicesConsumer;
import partyup.com.myapplication.utiles.Definitions;
import partyup.com.myapplication.utiles.GsonConverter;

/**
 * Created by juan.ocampo on 17/06/2015.
 */
public class MockProvider extends ProviderBase {

    private static ProviderBase instance;
    public static ProviderBase getInstance(){
        if(instance==null){
            instance = new MockProvider();
        }

        return instance;

    }



    @Override
    public void getBars(Category category,OnProviderResponse activity) {

        Bar mBar= new Bar();
        mBar.setmAddress("ZONA T");
        mBar.setmName("FONETICA BAR");
        mBar.setmSchedule("7pm - 12am");
        mBar.setCategory("Bar-Cafe");
        mBar.setColor(ColorsTheme.PINK.name());
        mBar.setWebSite("www.fonetica.com");
        mBar.setPhones("+52 3131331313");
        mBar.setPaymentsSystem("Tarjeta - Efectivo - Credito");
        mBar.setMusicStyle("#Electronica #Reggetoon #Salsa #Variado");
        mBar.setDescription("Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per.");

        mBar.setImage_url("https://www.saproto.nl/wordpress/wp-content/uploads/2015/04/Party-11.jpg");

        mBar.setCordinates("4.676464", "-74.053347");


        ArrayList<Bar> mBars= new ArrayList<>();
        mBars.add(mBar);

        mBar= new Bar();
        mBar.setmAddress("Galerias");
        mBar.setmName("TABU BAR");
        mBar.setmSchedule("7pm - 12am");
        mBar.setCategory("Discoteca");
        mBar.setColor(ColorsTheme.PURPLE_B.name());
        mBar.setWebSite("www.tabu.com");
        mBar.setPhones("+(52) 3131331313");
        mBar.setPaymentsSystem("Tarjeta - Efectivo - Credito");
        mBar.setMusicStyle("#Electronica #Reggetoon #Salsa #Variado");
        mBar.setDescription("Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per.");
        mBar.setImage_url("http://www.boolalacostumes.com/wp-content/uploads/2013/09/shopping-party-dance.jpg");

        mBar.setCordinates("4.671160", "-74.057532");


        mBars.add(mBar);

        mBar= new Bar();

        mBar.setmAddress("Calle 127 # 12-15");
        mBar.setmName("BBC");
        mBar.setmSchedule("7pm - 12am");
        mBar.setCategory("Bar-Cafe");
        mBar.setColor(ColorsTheme.BROWN.name());
        mBar.setWebSite("www.bbc.com");
        mBar.setPhones("+(52) 3131331313");
        mBar.setPaymentsSystem("Tarjeta - Efectivo - Credito");
        mBar.setMusicStyle("#Electronica #Reggetoon #Salsa #Variado");
        mBar.setDescription("Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per.");
        mBar.setImage_url("http://atlas.marcohern.com/img/bar-headers/bbc-salitre-hd.png");
        mBar.setCordinates(".670433", "-74.056287");


        mBars.add(mBar);

        mBar= new Bar();

        mBar.setmAddress("Zona T, Calle 85-15 #3");
        mBar.setmName("Paradise");
        mBar.setmSchedule("7pm - 12am");
        mBar.setCategory("Bar-Cafe");
        mBar.setColor(ColorsTheme.DEEP_ORANGE.name());
        mBar.setWebSite("www.paradice.com");
        mBar.setPhones("+(52) 3131331313");
        mBar.setPaymentsSystem("Tarjeta - Efectivo - Credito");
        mBar.setMusicStyle("#Electronica");
        mBar.setDescription("Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per.");
        mBar.setImage_url("https://www.saproto.nl/wordpress/wp-content/uploads/2015/04/Party-11.jpg");

        mBar.setCordinates("4.671160", "-74.057532");

        mBars.add(mBar);
        mBar= new Bar();


        mBar.setmAddress("Norte, Calle 170 21 #12");
        mBar.setmName("Level5");
        mBar.setmSchedule("7pm - 12am");
        mBar.setCategory("Discoteca");
        mBar.setColor(ColorsTheme.GRAY.name());
        mBar.setWebSite("www.level5.com");
        mBar.setPhones("+(52) 3131331313");
        mBar.setPaymentsSystem("Tarjeta - Efectivo - Credito");
        mBar.setMusicStyle("#ClassicMusic #Ochentera");
        mBar.setDescription("Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per.");
        mBar.setImage_url("http://www.bearsbaripswich.co.uk/wp-content/uploads/2015/01/hen-party-ideas.jpg");


        mBar.setCordinates("4.676335", "-74.052146");


        mBars.add(mBar);
        mBar= new Bar();


        mBar.setmAddress("Norte, Calle 170 21 #12");
        mBar.setmName("V.I.P Party");
        mBar.setmSchedule("7pm - 12am");
        mBar.setCategory("Discoteca");
        mBar.setColor(ColorsTheme.BLUE.name());
        mBar.setWebSite("www.level5.com");
        mBar.setPhones("+(52) 3131331313");
        mBar.setPaymentsSystem("Tarjeta - Efectivo - Credito");
        mBar.setMusicStyle("#ClassicMusic #Ochentera");
        mBar.setDescription("Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per.");

        mBar.setImage_url("http://howtoparty.in/wp-content/uploads/2015/01/party-image.jpg");

        mBar.setCordinates("4.675138", "-74.050730");


        mBars.add(mBar);


        mBar= new Bar();


        mBar.setmAddress("Norte, Calle 180 21 #12");
        mBar.setmName("Casa de la cerveza");
        mBar.setmSchedule("7pm - 12am");
        mBar.setCategory("Discoteca");
        mBar.setColor(ColorsTheme.RED.name());
        mBar.setWebSite("www.level5.com");
        mBar.setPhones("+(52) 3131331313");
        mBar.setPaymentsSystem("Tarjeta - Efectivo - Credito");
        mBar.setMusicStyle("#CrossOver");
        mBar.setDescription("Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per.");

        mBar.setImage_url("https://marcelasarmiento.files.wordpress.com/2014/12/cerveza2.jpg");


        mBar.setCordinates("4.674710", "-74.047468");


        mBars.add(mBar);

        mBar= new Bar();


        mBar.setmAddress("Calle 80 21#12");
        mBar.setmName("ELQierubin");
        mBar.setmSchedule("7pm - 12am");
        mBar.setCategory("Bar");
        mBar.setColor(ColorsTheme.PURPLE_B.name());
        mBar.setWebSite("www.querubin.com");
        mBar.setPhones("+(52) 3131331313");
        mBar.setPaymentsSystem("Tarjeta - Efectivo - Credito");
        mBar.setMusicStyle("#CrossOver");
        mBar.setDescription("Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per.");

        mBar.setImage_url("http://www.lets-party.in/wp-content/uploads/2015/03/slide1.jpg");


        mBar.setCordinates("4.672636", "-74.048519");


        mBars.add(mBar);


        mBar= new Bar();


        mBar.setmAddress("Calle 80 21#12");
        mBar.setmName("ELQierubin");
        mBar.setmSchedule("7pm - 12am");
        mBar.setCategory("Bar");
        mBar.setColor(ColorsTheme.CYAN.name());
        mBar.setWebSite("www.querubin.com");
        mBar.setPhones("+(52) 3131331313");
        mBar.setPaymentsSystem("Tarjeta - Efectivo - Credito");
        mBar.setMusicStyle("#CrossOver");
        mBar.setDescription("Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per.");

        mBar.setImage_url("http://www.lets-party.in/wp-content/uploads/2015/03/slide1.jpg");

        mBar.setCordinates("4.674004", "-74.051609");


        mBars.add(mBar);

        mBar= new Bar();


        mBar.setmAddress("Calle 80 21#12");
        mBar.setmName("ELQierubin");
        mBar.setmSchedule("7pm - 12am");
        mBar.setCategory("Bar");
        mBar.setColor(ColorsTheme.BLUE_C.name());
        mBar.setWebSite("www.querubin.com");
        mBar.setPhones("+(52) 3131331313");
        mBar.setPaymentsSystem("Tarjeta - Efectivo - Credito");
        mBar.setMusicStyle("#CrossOver");
        mBar.setDescription("Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per.");

        mBar.setImage_url("http://www.freevector.com/site_media/preview_images/FreeVector-Disco-Party-Footage.jpg");

        mBar.setCordinates("4.668487", "-74.054120");


        mBars.add(mBar);





        activity.onSucessResponse(mBars);

    }

    @Override
    public void getCitiesStrings(OnProviderResponse activity) {

        List<String> mString = new ArrayList<>();

        mString.add("Bogota");
        mString.add("Medellin");
        mString.add("Cali");
        mString.add("Armenia");
        mString.add("Santa Marta");
        mString.add("Barranquilla");



        activity.onSucessResponse(mString);


    }

}
