package partyup.com.myapplication.Provider;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.Objects.BarFragmentObject;
import partyup.com.myapplication.Objects.Bar_week_shedules;
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
    private Bar_week_shedules mockShedule;
    private ArrayList<Bar_week_shedules>  schedulee= new ArrayList<>();
    public static ProviderBase getInstance(){
        if(instance==null){
            instance = new MockProvider();
        }

        return instance;

    }


    /**
     * Bar: ColorsTheme.BROWN
     * Casinos: ColorsTheme.RED
     *
     *
     * @param category
     * @param activity
     */

    @Override
    public void getBars(Category category, final OnProviderResponse activity,int page) {

        mockShedule = new Bar_week_shedules();
        mockShedule.setStart_day_time("Lunes");
        mockShedule.setEnd_day_time("Sabado");
        schedulee.add(mockShedule);

        if (category==BarCategory){
            if(page==0){
                activity.onSucessResponse(getBars());
            }else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Thread.sleep(1000);
                            activity.onSucessResponse(getDiscos());

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

        }else if(category==DiscoCategory){
            activity.onSucessResponse(getDiscos());

        }else if(category==CasinoCategory){
            activity.onSucessResponse(getCasinos());

        }else if (category==RestauranCategory){
            activity.onSucessResponse(getRestaurants());

        }else {
            Bar mBar= new Bar();
            mBar.setmAddress("ZONA T");
            mBar.setmName("FONETICA BAR");
            mBar.setBars_week_schedules(schedulee);
            mBar.setCategory("Bar-Cafe");
            mBar.setColor(ColorsTheme.RED.name());
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
            mBar.setBars_week_schedules(schedulee);
            mBar.setCategory("Discoteca");
            mBar.setColor(ColorsTheme.BROWN.name());
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
            mBar.setBars_week_schedules(schedulee);
            mBar.setCategory("Bar-Cafe");
            mBar.setColor(ColorsTheme.PURPLE.name());
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
            mBar.setBars_week_schedules(schedulee);
            mBar.setCategory("Bar-Cafe");
            mBar.setColor(ColorsTheme.CYAN.name());
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
            mBar.setBars_week_schedules(schedulee);
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
            mBar.setBars_week_schedules(schedulee);
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
            mBar.setBars_week_schedules(schedulee);
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
            mBar.setBars_week_schedules(schedulee);
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
            mBar.setBars_week_schedules(schedulee);
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
            mBar.setBars_week_schedules(schedulee);
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

    }

    private ArrayList<Bar> getRestaurants() {




        Bar mBar= new Bar();
        mBar.setmAddress("ZONA T");
        mBar.setmName("FONETICA BAR");
        mBar.setBars_week_schedules(schedulee);
        mBar.setCategory("Bar-Cafe");
        mBar.setColor(ColorsTheme.CYAN.name());
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
        mBar.setBars_week_schedules(schedulee);
        mBar.setCategory("Discoteca");
        mBar.setColor(ColorsTheme.CYAN.name());
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
        mBar.setBars_week_schedules(schedulee);
        mBar.setCategory("Bar-Cafe");
        mBar.setColor(ColorsTheme.CYAN.name());
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
        mBar.setBars_week_schedules(schedulee);
        mBar.setCategory("Bar-Cafe");
        mBar.setColor(ColorsTheme.CYAN.name());
        mBar.setWebSite("www.paradice.com");
        mBar.setPhones("+(52) 3131331313");
        mBar.setPaymentsSystem("Tarjeta - Efectivo - Credito");
        mBar.setMusicStyle("#Electronica");
        mBar.setDescription("Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per.");
        mBar.setImage_url("https://www.saproto.nl/wordpress/wp-content/uploads/2015/04/Party-11.jpg");

        mBar.setCordinates("4.671160", "-74.057532");

        mBars.add(mBar);

        return mBars;

    }

    private ArrayList<Bar> getCasinos() {
        Bar mBar= new Bar();
        mBar.setmAddress("ZONA T");
        mBar.setmName("FONETICA BAR");
        mBar.setBars_week_schedules(schedulee);
        mBar.setCategory("Bar-Cafe");
        mBar.setColor(ColorsTheme.RED.name());
        mBar.setWebSite("www.fonetica.com");
        mBar.setPhones("+52 3131331313");
        mBar.setPaymentsSystem("Tarjeta - Efectivo - Credito");
        mBar.setMusicStyle("#Electronica #Reggetoon #Salsa #Variado");
        mBar.setDescription("Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per.");

        mBar.setImage_url("https://www.saproto.nl/wordpress/wp-content/uploads/2015/04/Party-11.jpg");

        mBar.setCordinates("4.676464", "-74.053347");


        ArrayList<Bar> mBars= new ArrayList<>();
        mBars.add(mBar);




        return mBars;
    }

    private ArrayList<Bar> getDiscos() {
        Bar mBar= new Bar();


        ArrayList<Bar> mBars= new ArrayList<>();

        mBar= new Bar();
        mBar.setmAddress("Galerias");
        mBar.setmName("TABU BAR");
        mBar.setBars_week_schedules(schedulee);
        mBar.setCategory("Discoteca");
        mBar.setColor(ColorsTheme.PURPLE.name());
        mBar.setWebSite("www.tabu.com");
        mBar.setPhones("+(52) 3131331313");
        mBar.setPaymentsSystem("Tarjeta - Efectivo - Credito");
        mBar.setMusicStyle("#Electronica #Reggetoon #Salsa #Variado");
        mBar.setDescription("Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per.");
        mBar.setImage_url("http://www.boolalacostumes.com/wp-content/uploads/2013/09/shopping-party-dance.jpg");

        mBar.setCordinates("4.671160", "-74.057532");


        mBars.add(mBar);

        mBar= new Bar();

        mBar.setmAddress("Zona T, Calle 85-15 #3");
        mBar.setmName("Paradise");
        mBar.setBars_week_schedules(schedulee);
        mBar.setCategory("Bar-Cafe");
        mBar.setColor(ColorsTheme.PURPLE.name());
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
        mBar.setBars_week_schedules(schedulee);
        mBar.setCategory("Discoteca");
        mBar.setColor(ColorsTheme.PURPLE.name());
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
        mBar.setBars_week_schedules(schedulee);
        mBar.setCategory("Discoteca");
        mBar.setColor(ColorsTheme.PURPLE.name());
        mBar.setWebSite("www.level5.com");
        mBar.setPhones("+(52) 3131331313");
        mBar.setPaymentsSystem("Tarjeta - Efectivo - Credito");
        mBar.setMusicStyle("#ClassicMusic #Ochentera");
        mBar.setDescription("Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per.");

        mBar.setImage_url("http://howtoparty.in/wp-content/uploads/2015/01/party-image.jpg");

        mBar.setCordinates("4.675138", "-74.050730");


        mBars.add(mBar);


       mBar= new Bar();


        mBar.setmAddress("Calle 80 21#12");
        mBar.setmName("ELQierubin");
        mBar.setBars_week_schedules(schedulee);
        mBar.setCategory("Bar");
        mBar.setColor(ColorsTheme.PURPLE.name());
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
        mBar.setBars_week_schedules(schedulee);
        mBar.setCategory("Bar");
        mBar.setColor(ColorsTheme.PURPLE.name());
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
        mBar.setBars_week_schedules(schedulee);
        mBar.setCategory("Bar");
        mBar.setColor(ColorsTheme.PURPLE.name());
        mBar.setWebSite("www.querubin.com");
        mBar.setPhones("+(52) 3131331313");
        mBar.setPaymentsSystem("Tarjeta - Efectivo - Credito");
        mBar.setMusicStyle("#CrossOver");
        mBar.setDescription("Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per.");

        mBar.setImage_url("http://www.freevector.com/site_media/preview_images/FreeVector-Disco-Party-Footage.jpg");

        mBar.setCordinates("4.668487", "-74.054120");


        mBars.add(mBar);

        return mBars;

    }

    private ArrayList<Bar> getBars() {

        Bar mBar= new Bar();
        mBar.setmAddress("ZONA T");
        mBar.setmName("FONETICA BAR");
        mBar.setBars_week_schedules(schedulee);
        mBar.setCategory("Bar-Cafe");
        mBar.setColor(ColorsTheme.BROWN.name());
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
        mBar.setBars_week_schedules(schedulee);
        mBar.setCategory("Discoteca");
        mBar.setColor(ColorsTheme.BROWN.name());
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
        mBar.setBars_week_schedules(schedulee);
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


        mBar.setmAddress("Norte, Calle 180 21 #12");
        mBar.setmName("Casa de la cerveza");
        mBar.setBars_week_schedules(schedulee);
        mBar.setCategory("Discoteca");
        mBar.setColor(ColorsTheme.BROWN.name());
        mBar.setWebSite("www.level5.com");
        mBar.setPhones("+(52) 3131331313");
        mBar.setPaymentsSystem("Tarjeta - Efectivo - Credito");
        mBar.setMusicStyle("#CrossOver");
        mBar.setDescription("Lorem ipsum ad his scripta blandit partiendo, eum fastidii accumsan euripidis in, eum liber hendrerit an. Qui ut wisi vocibus suscipiantur, quo dicit ridens inciderint id. Quo mundi lobortis reformidans eu, legimus senserit definiebas an eos. Eu sit tincidunt incorrupte definitionem, vis mutat affert percipit cu, eirmod consectetuer signiferumque eu per. In usu latine equidem dolores. Quo no falli viris intellegam, ut fugit veritus placerat per.");

        mBar.setImage_url("https://marcelasarmiento.files.wordpress.com/2014/12/cerveza2.jpg");


        mBar.setCordinates("4.674710", "-74.047468");


        mBars.add(mBar);



        return mBars;
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
