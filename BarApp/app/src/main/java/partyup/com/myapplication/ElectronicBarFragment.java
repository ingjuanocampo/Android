package partyup.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import partyup.com.myapplication.Adapters.RecyclerAdapterBar;
import partyup.com.myapplication.Interfaces.OnClickBarItem;
import partyup.com.myapplication.Objects.Bar;
import partyup.com.myapplication.Objects.Category;
import partyup.com.myapplication.Provider.HandlerProvider;
import partyup.com.myapplication.Provider.OnProviderResponse;
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
public class ElectronicBarFragment extends Fragment implements OnClickBarItem {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View mViewContainer;

    private RecyclerView mRecyclerView;
    private OnFragmentInteractionListener mListener;
    private LinearLayoutManager mLayoutManager;
    private RecyclerAdapterBar mAdapter;
    private ProgressBar mProgressBar;
    private ArrayList<Bar> mBars;
    //private ArrayList<Bar> mBars= new ArrayList<>();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ElectronicBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ElectronicBarFragment newInstance(String param1, String param2) {
        ElectronicBarFragment fragment = new ElectronicBarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if(savedInstanceState==null){
            mViewContainer= inflater.inflate(R.layout.fragment_electronic_bar, container, false);

            mRecyclerView= (RecyclerView)mViewContainer.findViewById(R.id.reyclerview_electronic_bars);
            mProgressBar = (ProgressBar)mViewContainer.findViewById(R.id.progress_bar);

            mRecyclerView.setHasFixedSize(true); //--> SOLO si el tamao no cmabia, mejora mucho el rendimiento.

            mLayoutManager = new LinearLayoutManager(mViewContainer.getContext());

            mRecyclerView.setLayoutManager(mLayoutManager);



            HandlerProvider.getProvider().setmContext(mViewContainer.getContext());

            HandlerProvider.getProvider().getBars(new Category(), new OnProviderResponse() {
                @Override
                public void onSucessResponse(Object responce) {

                   mBars = (ArrayList<Bar>) responce;
                    mAdapter = new RecyclerAdapterBar(mBars, ElectronicBarFragment.this,mViewContainer.getContext());

                    mRecyclerView.setAdapter(mAdapter);
                    mProgressBar.setVisibility(View.GONE);

                    mRecyclerView.setVisibility(View.VISIBLE);
                }
            });
        }

        onSaveInstanceState(savedInstanceState);

        return mViewContainer;
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

        //Toast.makeText(getActivity(),"presiono"+pos,Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(mViewContainer.getContext(),ActivitySiteDetails.class);
        intent.putExtra(Definitions.Extra_1, GsonConverter.object2StringGson(mBars.get(pos)));

        startActivityForResult(intent, 0);

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
