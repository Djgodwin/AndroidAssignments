package damon.assignment4_sqlite;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Damon on 3/24/2017.
 */

public class FriendAddFragment extends Fragment implements View.OnClickListener {

    private Button mButton;
    private FriendPersistence sFriendPersistence;
    private Friend mFriend;
    private EditText mFirstNameField;
    private EditText mLastNameField;
    private EditText mEmailAddressField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFriend = new Friend();
        sFriendPersistence = FriendPersistence.get(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedStateInstance) {
        View v = inflater.inflate(R.layout.fragment_friend_add, container, false);
        mButton = (Button) v.findViewById(R.id.friend_add_button);
        mButton.setOnClickListener(this);

        mFirstNameField = (EditText) v.findViewById(R.id.friend_add_first_name);
        mFirstNameField.setText(mFriend.getFirstName());
        mFirstNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFriend.setFirstName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLastNameField = (EditText) v.findViewById(R.id.friend_add_last_name);
        mLastNameField.setText(mFriend.getLastName());
        mLastNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFriend.setLastName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mEmailAddressField = (EditText) v.findViewById(R.id.friend_add_email_address);
        mEmailAddressField.setText(mFriend.getLastName());
        mEmailAddressField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFriend.setEmailAddress(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return v;
    }

    @Override
    public void onClick(View v) {
        sFriendPersistence.addFriend(mFriend);
        getActivity().finish();
    }
}
