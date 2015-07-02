package partyup.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import partyup.com.myapplication.Adapters.RecyclerAdapterCasinos;
import partyup.com.myapplication.Adapters.RecyclerAdapterDiscos;
import partyup.com.myapplication.Interfaces.OnClickBarItem;
import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.Provider.HandlerProvider;
import partyup.com.myapplication.Provider.OnProviderResponse;
import partyup.com.myapplication.Provider.ProviderBase;
import partyup.com.myapplication.utiles.Definitions;
import partyup.com.myapplication.utiles.GsonConverter;

/**
 * Created by juan.ocampo on 02/07/2015.
 */
public class FragmentCasinos  extends Fragment implements OnClickBarItem,View.OnClickListener{
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
    private RecyclerAdapterCasinos mAdapter;
    private ProgressBar mProgressBar;
    private ArrayList<Bar> mBars;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ImageView ImgRefreshUI;
    //private ProgressBar buttonProgressBar;
    //private ArrayList<Bar> mBars= new ArrayList<>();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param category site category.
     * @return A new instance of fragment ElectronicBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCasinos newInstance(String category) {
        FragmentCasinos fragment = new FragmentCasinos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, category);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentCasinos() {
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

        mSwipeRefreshLayout = (SwipeRefreshLayout) mViewContainer.findViewById(R.id.activity_main_swipe_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeColors(R.color.redToolbar, R.color.myPrimaryColor, R.color.purpleToobar, R.color.cyanBStatusBar);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                populateRecyclerView();
            }
        });

        ImgRefreshUI=(ImageView)mViewContainer.findViewById(R.id.img_refresh_ui);
        ImgRefreshUI.setOnClickListener(this);


        populateRecyclerView();

       /* mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                buttonProgressBar.setVisibility(View.GONE);

            }
        });*/



        //}

        // onSaveInstanceState(savedInstanceState);

        return mViewContainer;
    }

    private void populateRecyclerView() {

        mRecyclerView.setVisibility(View.GONE);
        ImgRefreshUI.setVisibility(View.GONE);
        mSwipeRefreshLayout.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
        //ImgRefreshUI.setOnClickListener(null);

        HandlerProvider.getProvider().setmContext(mViewContainer.getContext());

        HandlerProvider.getProvider().getBars(ProviderBase.CasinoCategory, new OnProviderResponse() {
            @Override
            public void onSucessResponse(Object responce) {

                mBars = (ArrayList<Bar>) responce;
                mAdapter = new RecyclerAdapterCasinos(mBars, FragmentCasinos.this, mViewContainer.getContext());
                mRecyclerView.setAdapter(mAdapter);
                mProgressBar.setVisibility(View.GONE);
                mRecyclerView.setVisibility(View.VISIBLE);
                mSwipeRefreshLayout.setVisibility(View.VISIBLE);
                mSwipeRefreshLayout.setRefreshing(false);


            }

            @Override
            public void onFailResponse(String msn) {
                mSwipeRefreshLayout.setRefreshing(false);


                ImgRefreshUI.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
                mSwipeRefreshLayout.setVisibility(View.GONE);

                Log.e("FragmentBar", "onFailResponse" + msn);

                Snackbar
                        .make(mViewContainer, "Sin Conexión", Snackbar.LENGTH_LONG)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                            }
                        })
                        .show(); // Don’t forget to show!
            }
        }, 1);


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

    @Override
    public void onClickBar(int pos) {
        Intent intent = new Intent(mViewContainer.getContext(), ActivitySiteDetails.class);
        intent.putExtra(Definitions.Extra_1, GsonConverter.object2StringGson(mBars.get(pos)));

        startActivityForResult(intent, 0);


    }

    @Override
    public void onLastElement() {

        Log.w("OnLastElement","alright");
        //buttonProgressBar.setVisibility(View.VISIBLE);

        HandlerProvider.getProvider().getBars(ProviderBase.CasinoCategory, new OnProviderResponse() {
            @Override
            public void onSucessResponse(Object responce) {

                ArrayList<Bar> mBarsTemp = (ArrayList<Bar>) responce;

                mBars.addAll((mBars.size()),mBarsTemp);
                //mAdapter = new RecyclerAdapterBar(mBars, FragmentBar.this, mViewContainer.getContext());

                //mRecyclerView.setAdapter(mAdapter);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        getActivity().runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                mAdapter.notifyDataSetChanged();
                                //buttonProgressBar.setVisibility(View.GONE);
                            }
                        });
                    }
                }).start();

                mProgressBar.setVisibility(View.GONE);

                mRecyclerView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailResponse(String msn) {

            }
        }, 2);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.img_refresh_ui:
                populateRecyclerView();
                break;
        }
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
