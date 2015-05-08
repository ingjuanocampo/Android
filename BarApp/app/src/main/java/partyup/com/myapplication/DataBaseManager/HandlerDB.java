package partyup.com.myapplication.DataBaseManager;

import android.content.Context;
import android.database.Cursor;

import java.sql.SQLException;
import java.util.ArrayList;

import partyup.com.myapplication.utiles.Definitions;

/**
 * Created by user on 12/03/2015.
 */
public class HandlerDB {

    private Context mContext;

    private DatabaseControl mDatabaseDominios;
    private DatabaseControl mDataBaseDATA;


    public HandlerDB(Context context){
        this.mContext=context;
        this.mDatabaseDominios = new DatabaseControl(context, Definitions.POLFA_PATH,Definitions.DOMINIOS);

        //this.mDataBaseDATA= new DatabaseControl(context,context.getAssets().);
    }

/*
    public ArrayList<Dominio> domiplacesComplemVia() throws SQLException {

        ArrayList<Dominio> mDominios = new ArrayList<>();

        try {
            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.select(Definitions.TABLE_DOMINIOS_POLFA,"TIPODOMINIO ","TIPOSITIO",Definitions.KEY_ETIQUETAELEMENTO,"");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {
                Dominio dominio = new Dominio();

                dominio.setETIQUETAELEMENTO(cu.getString(cu.getColumnIndex(Definitions.KEY_ETIQUETAELEMENTO)));
                dominio.setIDELEMENTO(cu.getString(cu.getColumnIndex(Definitions.KEY_IDELEMENTO)));

                mDominios.add(dominio);

            }


                mDatabaseDominios.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return mDominios;
    }

    public ArrayList<Dominio> domiplacesTipoVia() throws SQLException {

        ArrayList<Dominio> mDominios = new ArrayList<>();

        try {
            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.select(Definitions.TABLE_DOMINIOS_POLFA,"TIPODOMINIO ","TIPOVIA");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {
                Dominio dominio = new Dominio();

                dominio.setETIQUETAELEMENTO(cu.getString(cu.getColumnIndex(Definitions.KEY_ETIQUETAELEMENTO)));
                dominio.setIDELEMENTO(cu.getString(cu.getColumnIndex(Definitions.KEY_IDELEMENTO)));
                mDominios.add(dominio);
            }


            mDatabaseDominios.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return mDominios;
    }


    public ArrayList<Dominio> domidispoFinal() throws SQLException {

        ArrayList<Dominio> mDominios = new ArrayList<>();

        try {
            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.select(Definitions.TABLE_DOMINIOS_POLFA,"TIPODOMINIO ","DISFINAL","ETIQUETAELEMENTO","");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {
                Dominio dominio = new Dominio();

                dominio.setETIQUETAELEMENTO(cu.getString(cu.getColumnIndex(Definitions.KEY_ETIQUETAELEMENTO)));
                dominio.setIDELEMENTO(cu.getString(cu.getColumnIndex(Definitions.KEY_IDELEMENTO)));

                mDominios.add(dominio);

            }


            mDatabaseDominios.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return mDominios;
    }


    public ArrayList<String> domiEstadoAccion()throws SQLException {
        ArrayList<String> mEstados= new ArrayList<>();

        try {

            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.select(Definitions.TABLET_ESTADO_ACCION);

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {

                String estado=(cu.getString(cu.getColumnIndex(Definitions.KEY_NOMBREESTADO)));

                mEstados.add(estado);

            }

            mDatabaseDominios.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return mEstados;

    }


    public ArrayList<LugarGeo_Polfa> domLugarGeo_polfas(){
        ArrayList<LugarGeo_Polfa> mLugarGeo_polfas= new ArrayList<>();


        try {

            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.selectOrderby(Definitions.TABLE_LUGGEO_POLFA,"NOMBRE","");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {

                LugarGeo_Polfa mLugarGeo_polfa= new LugarGeo_Polfa();

                mLugarGeo_polfa.setFECHA_CREACION((cu.getString(cu.getColumnIndex(Definitions.KEY_FECHA_CREACION))));
                mLugarGeo_polfa.setNOMBRE((cu.getString(cu.getColumnIndex(Definitions.KEY_NOMBRE))));
                mLugarGeo_polfa.setLUG_GEOID((cu.getInt(cu.getColumnIndex(Definitions.KEY_LUG_GEOID))));
                mLugarGeo_polfa.setVIGENTE((cu.getString(cu.getColumnIndex(Definitions.KEY_VIGENTE))));
                mLugarGeo_polfa.setLUG_GEOID_PARENT((cu.getInt(cu.getColumnIndex(Definitions.KEY_LUG_GEOID_PARENT))));
                mLugarGeo_polfa.setTIPO((cu.getString(cu.getColumnIndex(Definitions.KEY_TIPO))));

                mLugarGeo_polfas.add(mLugarGeo_polfa);

            }

            mDatabaseDominios.close();

        }catch (Exception e){
            e.printStackTrace();
        }



        return mLugarGeo_polfas;
    }


    public ArrayList<Profesiones> domiProfesiones(){

        ArrayList<Profesiones> mStrings=new ArrayList<>();

        try {

            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.select("profesiones");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {

                Profesiones mProfesiones= new Profesiones();
                mProfesiones.setNOMBREPROFESION(cu.getString(cu.getColumnIndex("NOMBREPROFESION")));
                mProfesiones.setID_PROFESION(cu.getString(cu.getColumnIndex("ID_PROFESION")));
                mStrings.add(mProfesiones);
            }

            mDatabaseDominios.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return mStrings;

    }


    public ArrayList<TipoArchivo> domiTipoArchivoImagen(){

        ArrayList<TipoArchivo> mTipoArchivos= new ArrayList<>();
        try {

            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.select("TIPO_ARCHIVO","TIPO_ARCHIVO_TIPOARCHIVOID","1","TIPOARCHIVO","");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {

                TipoArchivo mTipoArchivo= new TipoArchivo();
                mTipoArchivo.setTIPO_ARCHIVO_TIPOARCHIVOID(cu.getInt(cu.getColumnIndex("TIPO_ARCHIVO_TIPOARCHIVOID")));
                mTipoArchivo.setTIPOARCHIVO(cu.getString(cu.getColumnIndex("TIPOARCHIVO")));
                mTipoArchivo.setTIPOARCHIVOID(cu.getInt(cu.getColumnIndex("TIPOARCHIVOID")));
                mTipoArchivos.add(mTipoArchivo);
            }

            mDatabaseDominios.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return mTipoArchivos;
    }

    public ArrayList<TipoArchivo> domiTipoDocumentoAnexar(){

        ArrayList<TipoArchivo> mTipoArchivos= new ArrayList<>();
        try {

            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.select("TIPO_ARCHIVO","TIPO_ARCHIVO_TIPOARCHIVOID","6","TIPOARCHIVO","");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {

                TipoArchivo mTipoArchivo= new TipoArchivo();
                mTipoArchivo.setTIPO_ARCHIVO_TIPOARCHIVOID(cu.getInt(cu.getColumnIndex("TIPO_ARCHIVO_TIPOARCHIVOID")));
                mTipoArchivo.setTIPOARCHIVO(cu.getString(cu.getColumnIndex("TIPOARCHIVO")));
                mTipoArchivo.setTIPOARCHIVOID(cu.getInt(cu.getColumnIndex("TIPOARCHIVOID")));
                mTipoArchivos.add(mTipoArchivo);
            }

            mDatabaseDominios.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return mTipoArchivos;
    }


    public ArrayList<TipoArchivo> domiTipoArchivoDocumento(){

        ArrayList<TipoArchivo> mTipoArchivos= new ArrayList<>();
        try {

            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.select("TIPO_ARCHIVO","TIPOARCHIVO","1");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {

                TipoArchivo mTipoArchivo= new TipoArchivo();
                mTipoArchivo.setTIPO_ARCHIVO_TIPOARCHIVOID(cu.getInt(cu.getColumnIndex("TIPO_ARCHIVO_TIPOARCHIVOID")));
                mTipoArchivo.setTIPOARCHIVO(cu.getString(cu.getColumnIndex("TIPOARCHIVOID")));
                mTipoArchivo.setTIPOARCHIVOID(cu.getInt(cu.getColumnIndex("TIPOARCHIVOID")));
                mTipoArchivos.add(mTipoArchivo);
            }

            mDatabaseDominios.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return mTipoArchivos;
    }

    public ArrayList<TipoVehiculo> domiTipoVehiculo(){

        ArrayList<TipoVehiculo> mTipoVehiculos= new ArrayList<>();

        try {

            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.selectOrderby("TIPOVEHICULO", "NOMBRETIPO","");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {

                TipoVehiculo mTipoVehiculo= new TipoVehiculo();
                mTipoVehiculo.setID_TIPOVEHICULO(cu.getInt(cu.getColumnIndex("ID_TIPOVEHICULO")));

                mTipoVehiculo.setNOMBRETIPO(cu.getString(cu.getColumnIndex("NOMBRETIPO")));
                mTipoVehiculos.add(mTipoVehiculo);
            }
            mDatabaseDominios.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return mTipoVehiculos;
    }


    public ArrayList<Dominio> domiMARCAS() throws SQLException {

        ArrayList<Dominio> mDominios = new ArrayList<>();

        try {
            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.select(Definitions.TABLE_DOMINIOS_POLFA,"TIPODOMINIO ","MARCAS");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {
                Dominio dominio = new Dominio();

                dominio.setETIQUETAELEMENTO(cu.getString(cu.getColumnIndex(Definitions.KEY_ETIQUETAELEMENTO)));
                dominio.setIDELEMENTO(cu.getString(cu.getColumnIndex(Definitions.KEY_IDELEMENTO)));
                mDominios.add(dominio);
            }


            mDatabaseDominios.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return mDominios;
    }

    public ArrayList<VMLugar_geo> dominDepartametos(){
        ArrayList<VMLugar_geo> mVMLugar_geos= new ArrayList<>();

        try {
            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.select("vmlugares_geograficos","TIPO","DE","AND CODIGO_DANE != '1' AND LUGE_CODIGO IS NOT NULL AND codigo_dane!='0' ","DESCRIPCION","");

            //where t.tipo = ''DE'' and t.codigo_dane <> 1 and t.luge_codigo is not null and t.codigo_dane <> 0 order by t.descripcion';

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {
                VMLugar_geo mVmLugar_geo = new VMLugar_geo();

                mVmLugar_geo.setCODIGO(cu.getInt(cu.getColumnIndex("CODIGO")));
                mVmLugar_geo.setDESCRIPCION(cu.getString(cu.getColumnIndex("DESCRIPCION")));
                mVmLugar_geo.setTIPO(cu.getString(cu.getColumnIndex("CODIGO_DANE")));
                mVmLugar_geo.setCODIGO_DANE(cu.getInt(cu.getColumnIndex("CODIGO_DANE")));
                mVmLugar_geo.setLUGE_PAPA(cu.getInt(cu.getColumnIndex("LUGE_PAPA")));
                mVmLugar_geo.setLUGE_CODIGO(cu.getInt(cu.getColumnIndex("LUGE_CODIGO")));
                mVmLugar_geo.setFECHA(cu.getString(cu.getColumnIndex("FECHA")));


                mVMLugar_geos.add(mVmLugar_geo);
            }


            mDatabaseDominios.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        return mVMLugar_geos;
    }

    public ArrayList<VMLugar_geo> dominMunicipios(int LUGE_PAPA){
        ArrayList<VMLugar_geo> mVMLugar_geos= new ArrayList<>();

        try {
            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.select("vmlugares_geograficos","TIPO","CM"," AND "+" LUGE_PAPA = '"+ LUGE_PAPA+"'" + " AND " +
                    "CODIGO_DANE !=1 AND LUGE_CODIGO IS NOT NULL AND CODIGO_DANE != '0' ","DESCRIPCION","");

            // t.luge_papa = t2.codigo and t.tipo = ''CM'' and t.codigo_dane <> 1 and t.luge_codigo is not null and t.codigo_dane <> 0 order by t.descripcion';

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {
                VMLugar_geo mVmLugar_geo = new VMLugar_geo();

                mVmLugar_geo.setCODIGO(cu.getInt(cu.getColumnIndex("CODIGO")));
                mVmLugar_geo.setDESCRIPCION(cu.getString(cu.getColumnIndex("DESCRIPCION")));
                mVmLugar_geo.setTIPO(cu.getString(cu.getColumnIndex("CODIGO_DANE")));
                mVmLugar_geo.setCODIGO_DANE(cu.getInt(cu.getColumnIndex("CODIGO_DANE")));
                mVmLugar_geo.setLUGE_PAPA(cu.getInt(cu.getColumnIndex("LUGE_PAPA")));
                mVmLugar_geo.setLUGE_CODIGO(cu.getInt(cu.getColumnIndex("LUGE_CODIGO")));
                mVmLugar_geo.setFECHA(cu.getString(cu.getColumnIndex("FECHA")));


                mVMLugar_geos.add(mVmLugar_geo);
            }


            mDatabaseDominios.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        return mVMLugar_geos;
    }


    public ArrayList<TipoMercancia> dominTiposMercancia(){

        ArrayList<TipoMercancia> mMercancias= new ArrayList<>();

        try {
            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.select("TIPO_MERCANCIA");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {
                TipoMercancia tipoMercancia = new TipoMercancia();

                tipoMercancia.setIDTIPOMECANCIA(cu.getInt(cu.getColumnIndex("IDTIPOMECANCIA")));
                tipoMercancia.setNOMBRETIPO(cu.getString(cu.getColumnIndex("NOMBRETIPO")));
                tipoMercancia.setPRODUCTOS(cu.getString(cu.getColumnIndex("PRODUCTOS")));

                mMercancias.add(tipoMercancia);
            }


            mDatabaseDominios.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        return mMercancias;

    }

    public ArrayList<Unidades_Mercancia> dominUnidadesMercancia(){
        ArrayList<Unidades_Mercancia> mUnidades_mercancias= new ArrayList<>();


        try {
            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.select("UNIDADES_MERCANCIA ORDER BY UNIDADTEXTO");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {
                Unidades_Mercancia unidades_mercancia = new Unidades_Mercancia();

                unidades_mercancia.setIDUNIDAD(cu.getInt(cu.getColumnIndex("IDUNIDAD")));
                unidades_mercancia.setUNIDADTEXTO(cu.getString(cu.getColumnIndex("UNIDADTEXTO")));
                unidades_mercancia.setABREVUNIDAD(cu.getString(cu.getColumnIndex("ABREVUNIDAD")));

                mUnidades_mercancias.add(unidades_mercancia);
            }


            mDatabaseDominios.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return mUnidades_mercancias ;
    }


    public ArrayList<TipoDocumeto> dominTipoDocumento(){
        ArrayList<TipoDocumeto> mTipoDocumetos= new ArrayList<>();



        try {
            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.selectOrderby("TIPODOCUMENTO", "NOMBRETIPO","");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {
                TipoDocumeto mTipoDocumeto = new TipoDocumeto();

                mTipoDocumeto.setIDTIPODOCUMENTO(cu.getInt(cu.getColumnIndex("IDTIPODOCUMENTO")));
                mTipoDocumeto.setNOMBRETIPO(cu.getString(cu.getColumnIndex("NOMBRETIPO")));

                mTipoDocumetos.add(mTipoDocumeto);
            }


            mDatabaseDominios.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return mTipoDocumetos;
    }


    public ArrayList<Dominio> domiORIENTA() throws SQLException {

        ArrayList<Dominio> mDominios = new ArrayList<>();

        try {
            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.select(Definitions.TABLE_DOMINIOS_POLFA,"TIPODOMINIO ","ORIENTA");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {
                Dominio dominio = new Dominio();

                dominio.setETIQUETAELEMENTO(cu.getString(cu.getColumnIndex(Definitions.KEY_ETIQUETAELEMENTO)));
                dominio.setIDELEMENTO(cu.getString(cu.getColumnIndex(Definitions.KEY_IDELEMENTO)));
                mDominios.add(dominio);
            }


            mDatabaseDominios.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return mDominios;
    }

    public ArrayList<Motivo_Aprehesion> dominMotivoAprehesion(){
        ArrayList<Motivo_Aprehesion> mMotivo_aprehesions= new ArrayList<>();


        try {
            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.selectOrderby("MOTIVOSAPREHENSION", "MOTIVO","");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {
                Motivo_Aprehesion mMotivo_aprehesion = new Motivo_Aprehesion();

                mMotivo_aprehesion.setID_MOTIVO(cu.getInt(cu.getColumnIndex("ID_MOTIVO")));
                mMotivo_aprehesion.setABREVIATURAMOTIVO(cu.getString(cu.getColumnIndex("ABREVIATURAMOTIVO")));
                mMotivo_aprehesion.setMOTIVO(cu.getString(cu.getColumnIndex("MOTIVO")));

                mMotivo_aprehesions.add(mMotivo_aprehesion);
            }
            mDatabaseDominios.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return mMotivo_aprehesions;

    }

    public ArrayList<Rol> dominRolEmpresaAccion(){

        ArrayList<Rol> mRoles= new ArrayList<>();


        try {
            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.select("ROLES","TIPOROL_TIPOROLID","3","ROL","");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {
                Rol mRol = new Rol();

                mRol.setIDROL(cu.getInt(cu.getColumnIndex("IDROL")));
                mRol.setROL(cu.getString(cu.getColumnIndex("ROL")));
                mRol.setTIPOROL_TIPOROLID(cu.getInt(cu.getColumnIndex("TIPOROL_TIPOROLID")));

                mRoles.add(mRol);
            }
            mDatabaseDominios.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        return mRoles;

    }

    public ArrayList<Rol> dominRolPersonaAccion(){

        ArrayList<Rol> mRoles= new ArrayList<>();


        try {
            mDatabaseDominios.open();

            Cursor cu= mDatabaseDominios.select("ROLES","TIPOROL_TIPOROLID","2","ROL","");

            for (cu.moveToFirst(); !cu.isAfterLast(); cu.moveToNext()) {
                Rol mRol = new Rol();

                mRol.setIDROL(cu.getInt(cu.getColumnIndex("IDROL")));
                mRol.setROL(cu.getString(cu.getColumnIndex("ROL")));
                mRol.setTIPOROL_TIPOROLID(cu.getInt(cu.getColumnIndex("TIPOROL_TIPOROLID")));

                mRoles.add(mRol);
            }
            mDatabaseDominios.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        return mRoles;

    }*/













}
