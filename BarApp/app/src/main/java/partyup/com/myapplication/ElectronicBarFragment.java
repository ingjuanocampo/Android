package partyup.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import partyup.com.myapplication.Adapters.RecyclerAdapterBar;
import partyup.com.myapplication.Adapters.RecyclerAdapterDiscos;
import partyup.com.myapplication.Interfaces.OnClickBarItem;
import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.Objects.Category;
import partyup.com.myapplication.Provider.HandlerProvider;
import partyup.com.myapplication.Provider.OnProviderResponse;
import partyup.com.myapplication.Provider.ProviderBase;
import partyup.com.myapplication.utiles.Definitions;
import partyup.com.myapplication.utiles.GsonConverter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ElectronicBarFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ElectronicBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ElectronicBarFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "category";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParamCategory;
   // private String mParam2;
    private View mViewContainer;

    private RecyclerView mRecyclerView;
    private OnFragmentInteractionListener mListener;
    private LinearLayoutManager mLayoutManager;
    private RecyclerAdapterDiscos mAdapter;
    private ProgressBar mProgressBar;
    private ArrayList<Bar> mBars;
    //private ArrayList<Bar> mBars= new ArrayList<>();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param category site category.
     * @return A new instance of fragment ElectronicBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ElectronicBarFragment newInstance(String category) {
        ElectronicBarFragment fragment = new ElectronicBarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, category);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ElectronicBarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamCategory = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //if(savedInstanceState==null){
            mViewContainer= inflater.inflate(R.layout.fragment_electronic_bar, container, false);

            mRecyclerView= (RecyclerView)mViewContainer.findViewById(R.id.reyclerview_electronic_bars);
            mProgressBar = (ProgressBar)mViewContainer.findViewById(R.id.progress_bar);

            mRecyclerView.setHasFixedSize(true); //--> SOLO si el tamao no cmabia, mejora mucho el rendimiento.

            mLayoutManager = new LinearLayoutManager(mViewContainer.getContext());

            mRecyclerView.setLayoutManager(mLayoutManager);



            HandlerProvider.getProvider().setmContext(mViewContainer.getContext());

            HandlerProvider.getProvider().getBars(getCategory(), new OnProviderResponse() {
                @Override
                public void onSucessResponse(Object responce) {

                   mBars = (ArrayList<Bar>) responce;
                    mAdapter = new RecyclerAdapterDiscos(mBars, new OnClickBarItem() {
                        @Override
                        public void onClickBar(int pos) {
                            Intent intent = new Intent(mViewContainer.getContext(),ActivitySiteDetails.class);
                            intent.putExtra(Definitions.Extra_1, GsonConverter.object2StringGson(mBars.get(pos)));

                            startActivityForResult(intent, 0);
                        }

                        @Override
                        public void onLastElement() {
                            Log.w("onLastElement", "here");

                        }
                    }, mViewContainer.getContext());

                    mRecyclerView.setAdapter(mAdapter);
                    mProgressBar.setVisibility(View.GONE);

                    mRecyclerView.setVisibility(View.VISIBLE);
                }

                @Override
                public void onFailResponse(String msn) {

                }
            },1);
        //}

       // onSaveInstanceState(savedInstanceState);

        return mViewContainer;
    }

    private Category getCategory() {

        if(ProviderBase.BarCategory.getId().equals(mParamCategory)){
            return ProviderBase.BarCategory;

        }else if(ProviderBase.CasinoCategory.getId().equals(mParamCategory)){
            return ProviderBase.CasinoCategory;

        }else if(ProviderBase.RestauranCategory.getId().equals(mParamCategory)){
            return ProviderBase.RestauranCategory;

        }else if(ProviderBase.DiscoCategory.getId().equals(mParamCategory)){
            return ProviderBase.DiscoCategory;
        }else {
            return new Category("All","6");
        }

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
