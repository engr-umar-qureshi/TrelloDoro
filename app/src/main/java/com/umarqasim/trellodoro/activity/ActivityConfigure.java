package com.umarqasim.trellodoro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.umarqasim.trellodoro.R;
import com.umarqasim.trellodoro.presenter.PresenterBaseTrellodoro;
import com.umarqasim.trellodoro.presenter.PresenterConfigure;
import com.umarqasim.trellodoro.view.ViewConfigure;
import com.umarqasim.trellodoroapi.model.ModelUser;
import com.umarqasim.trellodoroapi.prefrences.TrellodoroErrorCodes;
import com.umarqasim.trellodoroapi.realmcontroller.RealmControllerModelUser;

import org.parceler.Parcels;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import icepick.Bundler;
import icepick.State;

/**
 * Created by Umar Qureshi on 4/3/2016.
 */
public class ActivityConfigure extends ActivityBaseTrellodoro implements ViewConfigure {


     private final int REQUEST_TRELLO_AUTH = 1;

    @Bind(R.id.label_info)
    TextView labelInfo;
    @Bind(R.id.btn_connect)
    Button btnConnect;
    @Bind(R.id.txt_welcome)
    TextView txtWelcome;
    @Bind(R.id.lable_board)
    TextView lableBoard;
    @Bind(R.id.spiner_board)
    Spinner spinerBoard;
    @Bind(R.id.lable_todo)
    TextView lableTodo;
    @Bind(R.id.spiner_todo)
    Spinner spinerTodo;
    @Bind(R.id.lable_doing)
    TextView lableDoing;
    @Bind(R.id.spiner_doing)
    Spinner spinerDoing;
    @Bind(R.id.lable_done)
    TextView lableDone;
    @Bind(R.id.spiner_done)
    Spinner spinerDone;
    @Bind(R.id.btn_configure)
    Button btnConfigure;

    PresenterConfigure presenter;
    String tempVar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure);
        tempVar = "Test";
    }

    @Override
    public PresenterBaseTrellodoro initializePresenter() {
        presenter = new PresenterConfigure(this);
        return presenter;
    }

    //----- OnClickListeners -----
    @OnClick(R.id.btn_connect)
    public void onClickConnect(Button btnConnect) {
        startActivityForResult(new Intent(this, ActivityTrelloAuth.class), REQUEST_TRELLO_AUTH);

    }

    @OnClick(R.id.btn_configure)
    public void onClickConfigure(Button btnConfigure) {

    }


    // View Implementations

    @Override
    public void showError(TrellodoroErrorCodes errorCode) {
        showAlertDialog(TrellodoroErrorCodes.translate(errorCode, this));
    }

    @Override
    public void showNetworkLoading() {
        showDialogNetworkProgress();
    }

    @Override
    public void hideNetworkLoading() {
        hideDialogNetworkProgress();
    }

    @Override
    public ModelUser saveUserObject(ModelUser modelUser) {
        return RealmControllerModelUser.saveModelUser(modelUser, this);
    }

    @Override
    public void hideConnectViews() {
        labelInfo.setVisibility(View.GONE);
        btnConnect.setVisibility(View.GONE);
    }

    @Override
    public void showUserWelcomeMessage(String userDisplayName) {
        txtWelcome.setText(userDisplayName+getResources().getString(R.string.act_config_txt_welcome));
    }

    @Override
    public void loadBoardsData(List<String> listBoardTitles, int selected) {
        lableBoard.setVisibility(View.VISIBLE);
        spinerBoard.setVisibility(View.VISIBLE);
        spinerBoard.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listBoardTitles));
        spinerBoard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                presenter.onSelectBoard(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinerBoard.setSelection(selected);
    }

    // Activity Result

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_TRELLO_AUTH) {
            if (resultCode == RESULT_OK) {
                String token = data.getStringExtra(ActivityTrelloAuth.EXTRA_KEY_TOKEN);
                presenter.fetchUserDetail(token);

            } else {
                Toast.makeText(this, getResources().getString(R.string.act_config_error_connect), Toast.LENGTH_LONG).show();
            }
        }
    }


}
