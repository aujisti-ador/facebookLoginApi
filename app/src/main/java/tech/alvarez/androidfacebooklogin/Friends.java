package tech.alvarez.androidfacebooklogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


public class Friends extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        getFriendList("1851679804919281");

    }

//    public void getFriendList(AccessToken currentAccessToken) {
//
//        Log.d("access", AccessToken.getCurrentAccessToken().toString());
//        /* make the API call */
////        new GraphRequest(
////                AccessToken.getCurrentAccessToken(),
////                "/friend-list-id",
////                null,
////                HttpMethod.GET,
////                new GraphRequest.Callback() {
////                    public void onCompleted(GraphResponse response) {
////                        /* handle the result */
////
////                        Log.d("Data", response.toString());
////                    }
////                }
////        ).executeAsync();
//
//
//        new GraphRequest.Callback() {
//            public void onCompleted(GraphResponse response) {
//                Log.e("response", response.toString());
//
//                try {
//                    JSONArray frienArray = ((JSONArray) (response.getJSONObject().get("data")));
//                    Log.d("DDDD", frienArray.toString());
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        };
//    }


    public void getFriendList(String id) { //fbId
        //FbFriends fbFriendsList = new ArrayList<>();

        Log.d("ID", id);
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/" + id + "/friends",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {

                    public void onCompleted(GraphResponse response) {
                        Log.e("response", response.toString());

                        try {
                            JSONArray frienArray = ((JSONArray) (response.getJSONObject().get("data")));
                            for (int i = 0; i < 3; i++) {
//                                FbFriends fbFriends = new FbFriends();
//                                JSONObject jsonObject = frienArray.getJSONObject(i);
//
//                                fbFriends.setFbId(jsonObject.getString("id"));
//                                fbFriendsList.add(fbFriends);
                                Log.d("flist", frienArray.getJSONObject(i).toString());

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        /* handle the result */


                    }

                });
    }
}