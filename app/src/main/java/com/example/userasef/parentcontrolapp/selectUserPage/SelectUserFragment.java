package com.example.userasef.parentcontrolapp.selectUserPage;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.userasef.parentcontrolapp.R;
import com.example.userasef.parentcontrolapp.data.response.ChildUser;
import com.example.userasef.parentcontrolapp.selectedUserPage.SelectedUserFragment;
import com.example.userasef.parentcontrolapp.utils.ActivityUtil;

import java.util.ArrayList;

/**
 * Created by userAsef on 10/8/2018.
 */

public class SelectUserFragment extends Fragment implements ISelectUserContract.View{

    private RecyclerView recycler;
    private SelectUserAdapter adapter;

    public static SelectUserFragment newInstance(){
        SelectUserFragment fragment = new SelectUserFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public void SelectUserFragment(){
        // default constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.select_user_fragment, container, false);

        initView(view);

        adapter.getAllChildUsers();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().findViewById(R.id.gotoPreviousFragment_btn).setVisibility(View.GONE);
    }

    private void initView(View view) {
        recycler = view.findViewById(R.id.select_user_recycler);
        adapter = new SelectUserAdapter(this);
        adapter.setChildUserList(null);
        recycler.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recycler.setAdapter(adapter);
    }

    @Override
    public void setLoaderVisibility(int visibility) {

    }

    @Override
    public void noInternet(String methodName, Object object) {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setAdapterChildUserList(ArrayList<ChildUser> list) {
        adapter.setChildUserList(list);
    }

    @Override
    public void gotoSelectedUserFragment(ChildUser selectedItem) {
        ActivityUtil.pushFragment(SelectedUserFragment.newInstance(selectedItem), getActivity().getSupportFragmentManager(), R.id.fragment_container_main, true);
    }
}