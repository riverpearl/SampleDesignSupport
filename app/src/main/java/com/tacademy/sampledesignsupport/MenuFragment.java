package com.tacademy.sampledesignsupport;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

public class MenuFragment extends Fragment {

    private OnMenuSelectListener mListener;

    public MenuFragment() {
        // Required empty public constructor
    }

    public static final int MENU_MAIN = 100;
    public static final int MENU_MY = 200;
    public static final int MENU_PROFILE = 201;
    public static final int MENU_LOGOUT = 202;
    public static final int MENU_SEARCH = 300;
    public static final int MENU_KEYWORD = 301;
    public static final int MENU_DATE = 302;
    public static final int MENU_SETTING = 400;
    public static final int MENU_PUSH = 401;
    public static final int MENU_ABOUT = 402;

    MenuGroup[] menuList = {
            new MenuGroup("Main", MENU_MAIN)
            , new MenuGroup("My", MENU_MY ,
            new MenuChild("Profile", MENU_PROFILE ),
            new MenuChild("Logout", MENU_LOGOUT))
            , new MenuGroup("Search", MENU_SEARCH ,
            new MenuChild("Keyword", MENU_KEYWORD),
            new MenuChild("Date", MENU_DATE))
            , new MenuGroup("Settings", MENU_SETTING,
            new MenuChild("Push", MENU_PUSH),
            new MenuChild("About", MENU_ABOUT))
    };

    ExpandableListView listView;
    MenuAdapter mAdapter;
    int expandPosition = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new MenuAdapter(menuList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        listView = (ExpandableListView)view.findViewById(R.id.list_menu);
        listView.setAdapter(mAdapter);
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long id) {
                MenuGroup menuGroup = mAdapter.getGroup(groupPosition);
                mListener.onMenuSelected(menuGroup.groupId);
                return false;
            }
        });

        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                int old = expandPosition;
                expandPosition = groupPosition;
                if (old != -1)
                    listView.collapseGroup(old);
            }
        });

        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                if (expandPosition == groupPosition)
                    expandPosition = -1;
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMenuSelectListener) {
            mListener = (OnMenuSelectListener) context;
        } else {
            throw new RuntimeException(context.toString()
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
    public interface OnMenuSelectListener {
        // TODO: Update argument type and name
        void onMenuSelected(int menuId);
    }
}
