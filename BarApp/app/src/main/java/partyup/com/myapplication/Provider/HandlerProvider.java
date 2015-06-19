package partyup.com.myapplication.Provider;

import android.content.Context;

/**
 * Created by juan.ocampo on 17/06/2015.
 */
public class HandlerProvider {


    public static ProviderBase getProvider(){

        return Provider.getProvider(ProviderType.MOCK);

    }

}
