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

import java.util.UUID;

/**
 * Created by Damon on 3/22/2017.
 */

public class FriendDetailsFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_FRIEND_ID = "id";

    private Button mButton;
    private Friend mFriend;
    private EditText mFirstNameField;
    private EditText mLastNameField;
    private EditText mEmailAddressField;
    private FriendPersistence sFriendPersistance;

    public static FriendDetailsFragment newInstance(UUID friendId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_FRIEND_ID, friendId);

        FriendDetailsFragment fragment = new FriendDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedStateInstance) {
        super.onCreate(savedStateInstance);
        UUID friendId = (UUID) getArguments().getSerializable(ARG_FRIEND_ID);
        mFriend = FriendPersistence.get(getActivity()).getFriend(friendId);
        sFriendPersistance = FriendPersistence.get(getActivity());
    }

    @Override
    public void onPause() {
        super.onPause();
        FriendPersistence.get(getActivity()).updateFriend(mFriend);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedStateInstance) {
        View v = inflater.inflate(R.layout.fragment_friend_details, container, false);
        mButton = (Button) v.findViewById(R.id.friend_details_button);
        mButton.setOnClickListener(this);

        mFirstNameField = (EditText) v.findViewById(R.id.friend_details_first_name);
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

        mLastNameField = (EditText) v.findViewById(R.id.friend_details_last_name);
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

        mEmailAddressField = (EditText) v.findViewById(R.id.friend_details_email_address);
        mEmailAddressField.setText(mFriend.getEmailAddress());
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
        sFriendPersistance.deleteFriend(mFriend);
        getActivity().finish();
    }
}
