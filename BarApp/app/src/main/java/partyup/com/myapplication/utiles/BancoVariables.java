package partyup.com.myapplication.utiles;


/**
 * Permite Gestionar el objeto los Datos Mas cumones y establecerlos como variables de seccion
 * @author andres.serrano
 *
 */
public class BancoVariables {

	private static BancoVariables instance;

	private Boolean fragmentDocumento=false; //Contador
	public void setFragmentDocumento(Boolean fragmentDocumento){
		this.fragmentDocumento=fragmentDocumento;
	}
	public Boolean getFragmentDocumento(){
		return this.fragmentDocumento;
	}

    private int TotalDocumentosPaginas; //Contador
    public void setTotalDocumentosPaginas(int TotalDocumentosPaginas){
        this.TotalDocumentosPaginas=TotalDocumentosPaginas;
    }
    public int getTotalDocumentosPaginas(){
        return this.TotalDocumentosPaginas;
    }

    private int Posicion; //Contador
    public void setPosicion(int Posicion){
        this.Posicion=Posicion;
    }
    public int getPosicion(){
        return this.Posicion;
    }


	public static synchronized BancoVariables getInstance(){
		if(instance==null){
			instance=new BancoVariables();
		}
		return instance;
	}
}
