package partyup.com.myapplication;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.zip.Inflater;

import partyup.com.myapplication.Adapters.PageAdapterHelp;
import partyup.com.myapplication.Interfaces.OnDocHelpChange;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentHelp.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentHelp#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHelp extends Fragment  implements OnDocHelpChange{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ViewPager mViewPager;
    private View mContainerView;
    private int [] SlidersPrestantion= {R.drawable.nightclub,R.drawable.bogota_night};
    private ArrayList<ImageView> imgDocs;
    private ImageView imgViewTemp;



    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHelp.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHelp newInstance(String param1, String param2) {
        FragmentHelp fragment = new FragmentHelp();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentHelp() {
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

        mContainerView=inflater.inflate(R.layout.fragment_help, container, false);

        mViewPager = (ViewPager)mContainerView.findViewById(R.id.viewpager);


        PageAdapterHelp adapter = new PageAdapterHelp(inflater,SlidersPrestantion,this);
        mViewPager.setAdapter(adapter);


        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                imgDocs.get(position).setImageResource(R.drawable.ic_lens_black_24dp);
                if(imgViewTemp!=null)
                    imgViewTemp.setImageResource(R.drawable.ic_panorama_fish_eye_black_24dp);
                imgViewTemp=imgDocs.get(position);


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        setIndicatorDocs(inflater);




        return mContainerView;
    }

    private void setIndicatorDocs(LayoutInflater inflater) {

        LinearLayout mLinearDocs = (LinearLayout)mContainerView.findViewById(R.id.linear_docs);

        imgDocs= new ArrayList<>();
        for (int i=0;i<SlidersPrestantion.length;i++){
            ImageView doc= (ImageView)inflater.inflate(R.layout.view_doc_empty,mLinearDocs,false);

            imgDocs.add(doc);
            mLinearDocs.addView(doc);
        }

        imgDocs.get(0).setImageResource(R.drawable.ic_lens_black_24dp);
        imgViewTemp=imgDocs.get(0);


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
    public void onDockChange(int position) {
       // imgDocs.get(position).setImageResource(R.drawable.ic_lens_black_24dp);
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
