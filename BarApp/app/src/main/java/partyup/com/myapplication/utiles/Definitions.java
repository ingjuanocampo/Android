package partyup.com.myapplication.utiles;

import android.os.Environment;

/**
 * Created by user on 19/12/2014.
 */
public class Definitions {
    /* =============== Names for extras tags ===============*/
    public static final String isLogin="isLogin";
    public static final String isBack="isBack";
    public static final String timer="timer";

    /* ============== Share Preferences ====================*/
    //TENER MUCHO CUIDADO CON ID REPETIDO

    public static final String DEVICE_ID="imei";
    public static final String TOKEN="token";
    public static final String USER="user";
    public static final String HASH="hash";
    public static final String VERSION_APP="versionApp";



    //Requests Response

    //* ================= REQUEST ACTIVITY FOR RESULTS =============== *//

    public static final String STEP="Step";
    public static final String TASK="Task";
    public static final String DATA="DATA";
    public static final String Action="ACTION";




    public static final int MAIN_TO_ACTIVITYSTEPS=1;
    public static final int STEP_TO_STEPS=2;
    public static final int MAIN_TO_LOGIN=3;
    public static final int LOGIN_TO_MAIN=4;
    public static final int STEP_TO_TASK=5;
    public static final int STEPS_TO_QUERY=6;


    public static final int NO_OFFLINE_AC=-1;

    public static final int PRESS_SEE_DETAIS=-1;
    public static final int PRESS_CLOSES_SECCION=-2;
    public static final int AGREGAR_PERSONA_INVOLUCRADA=20;
    public static final int AGREGAR_EMPRESA_INVOLUCRADA=21;
    public static final int AGREGAR_VEHICULO_INVOLUCRADA=22;

    public static final int CONSULTAR_PERSONAS =23;
    public static final int CONSULTAR_EMPRESAS =24;
    public static final int CONSULTAR_VEHICULOS =25;
    public static final int CONSULTAR_IMAGENES=26;
    public static final int CONSULTAR_DOCUMENTOS=27;
    public static final int CONSULTAR_DOCUMENTO=28;


    public static final int AGREGAR_PUESTO_CONTROL=1; //30;
    public static final int AGREGAR_VISITA_CONTROL=2;//31;
    public static final int AGREGAR_INSPECCION_PASAJEROS=3;//32;
    public static final int AGREGAR_INSPECCION_CARGA=4;//;
    public static final int CONSULTA_ACCION_DE_CONTROL=34;
    public static final int AGREGAR_IMAGENES=35;
    public static final int AGREGAR_DOCUMENTOS=36;
    public static final int AGREGAR_MERCANCIA=37;


    public static final int ACTUALIZAR_PUESTO_CONTROL=38;
    public static final int ACTUALIZAR_VISITA_CONTROL=39;
    public static final int ACTUALIZAR_INSPECCION_PASAJEROS=40;
    public static final int ACTUALIZAR_INSPECCION_CARGA=41;

    public static final int NO_ITEN=-1;

    public static final String EXTENSION_FOTO=".jpg";


    //* ================= REQUEST OPERATIONS =============== *//


    public static final String OP_LOGIN="User/Login";

    public static final String OP_ADD_COMPANY="Company/Add";
    public static final String OP_QUERY_COMPANY="Company/QueryID";

    public static final String OP_ADD_PERSON="Person/Add";
    public static final String OP_QUERY_PERSON="Person/QueryID";

    public static final String OP_ADD_VEHICLE="Vehicle/Add";
    public static final String OP_QUERY_VEHICLE="Vehicle/QueryID";
    public static final String OP_QUERYID_AC ="Acciones/QueryId";
    public static final String OP_QUERY_AC="Acciones/Query";
    public static final String OP_UPDATE_AC="Acciones/Edit";
    public static final String OP_FILE_UPLOAD="Acciones/FileUpload";
    public static final String OP_HASH="Util";


    public static final String OP_CHECK_RESPONSABLE="Polfa/PoliceResposable";

    public static final String OP_AGREGAR_PUESTO_CONTROL="Acciones/Add/PuestoControl";
    public static final String OP_AGREGAR_VISITA_CONTROL="Acciones/Add/VisitaControl";
    public static final String OP_AGREGAR_INSPECCION_VIAJEROS="Acciones/Add/InspeccionViajeros";
    public static final String OP_AGREGAR_INPECCION_CARGA="Acciones/Add/InspeccionCarga";



    //*================== REQUEST TYPES =================== *//

    public static final String POST="POST";
    public static final String GET="GET";


    //*===================== FILES NAMES =================*//
    public static final String DOMINIOS="dominios";
    public static final String POLFA_PATH= Environment.getExternalStorageDirectory().getPath() + "/POLFA/";
    public static final String DB_OFFLINE="AC_Offline";


    //*=================== DATA BASE =====================*//
    public static final String TABLE_DOMINIOS_POLFA="DOMINIOS_POLFA";
    public static final String TABLE_MERCANCIA="MERCANCIA";
    public static final String TABLET_ESTADO_ACCION="ESTADO_ACCION";
    public static final String TABLET_AC_OFFLINE="AccionesControl";
    public static final String TABLET_ARCHIVOS="Archivos";


    public static final String KEY_ID="ID";
    public static final String KEY_IDELEMENTO="IDELEMENTO";
    public static final String KEY_ETIQUETAELEMENTO="ETIQUETAELEMENTO";
    public static final String KEY_TIPO_MERCANCIA_IDTIPOMECANCIA="TIPO_MERCANCIA_IDTIPOMECANCIA";
    public static final String KEY_NOMBREESTADO="NOMBREESTADO";


    public static final String TABLE_LUGGEO_POLFA="LUGGEO_POLFA";
    public static final String KEY_LUG_GEOID="LUG_GEOID";
    public static final String KEY_NOMBRE="NOMBRE";
    public static final String KEY_FECHA_CREACION="FECHA_CREACION";
    public static final String KEY_VIGENTE="VIGENTE";
    public static final String KEY_LUG_GEOID_PARENT="LUG_GEOID_PARENT";
    public static final String KEY_TIPO="TIPO";


    //BD OFLLINE ACCIONES DE CONTROL

    public static final String KEY_ID_ROW="Id_Row";
    public static final String KEY_DATA="Data";
    public static final String KEY_TOKEN="TokenId";
    public static final String KEY_TIPO_AC="TipoAc";

    //BD OFLLINE ARCHIVOS
    public static final String KEY_ID_LOCAL="Id_Local";
    public static final String KEY_ID_SERVER="Id_Server";


    //*======================== FILTER VALUES ===============================*//
    public static final int LENGHT_PAGE=5;



    //*======================== RE SIZE IMAGE ===============================*//

    public final static int widthImage=866;
    public final static int heightImage=1155;
    public final static int compressFactor=85;


    //*==================== NUMERO DE  ELEMEMTOS POR ACCION =================*//

    public final static double NUM_ELEMENTOS_PUESTO_CONTROL=21;
    public final static double NUM_ELEMENTOS_VISITA_CONTROL=19;
    public final static double NUM_ELEMENTOS_INSPECION_VIAJEROS=16;
    public final static double NUM_ELEMENTOS_INSPECCION_CARGA=21;

    //*====================== SERVICE FREQUENCY ============================*//
    public final static long frequency= 30 * 1000; // in ms







}
