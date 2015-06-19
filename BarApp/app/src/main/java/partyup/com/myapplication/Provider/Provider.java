package partyup.com.myapplication.Provider;

import android.content.Context;

/**
 * Created by juan.ocampo on 17/06/2015.
 */
public class Provider {

    public static ProviderBase getProvider(ProviderType type){
        switch (type){
            case SERVER:
                return ServerProvider.getInstance();
            case MOCK:
                return MockProvider.getInstance();

            case LOCAL_DB:
            default:
                return MockProvider.getInstance();
        }
    }

}
