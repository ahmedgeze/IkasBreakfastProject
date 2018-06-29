package com.example.ahmetserdargeze.ikasbreakfastproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmetserdargeze.ikasbreakfastproject.db.Database;
import com.example.ahmetserdargeze.ikasbreakfastproject.model.login.PermissionSet;
import com.example.ahmetserdargeze.ikasbreakfastproject.model.login.Role;
import com.example.ahmetserdargeze.ikasbreakfastproject.model.login.Token;
import com.example.ahmetserdargeze.ikasbreakfastproject.model.login.User;
import com.example.ahmetserdargeze.ikasbreakfastproject.model.menu.Variation;
import com.example.ahmetserdargeze.ikasbreakfastproject.retrofit.APIService;
import com.example.ahmetserdargeze.ikasbreakfastproject.retrofit.ApiUtils;
import com.example.ahmetserdargeze.ikasbreakfastproject.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginOrRegisterActivity extends AppCompatActivity {
    Token token;
    User user;


    List<Menu> menuList;
    List<Variation> variations;

    EditText email,password;
    Button login,menu;
    TextView result;

    private APIService mAPIService;
    private APIService authService;

    String tokenskey="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyMywidXNlcm5hbWUiOiJhc3NpZ25tZW50QGlrYXMuY29tIiwiZXhwIjoxNTMwNTczNjc4LCJlbWFpbCI6ImFzc2lnbm1lbnRAaWthcy5jb20iLCJvcmlnX2lhdCI6MTUzMDE0MTY3OH0.JmTamDJMjJ0aazECY0vAevhkGMxam3HkBwjZrrklMzI";

    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=(EditText) findViewById(R.id.email_etv);
        password=(EditText) findViewById(R.id.password_etv);

        login=(Button) findViewById(R.id.login_bt);
        menu=(Button) findViewById(R.id.getMenu_bt);

        result=(TextView) findViewById(R.id.result_tv);

        mAPIService= ApiUtils.getAPIService();


        db=new Database(getApplicationContext());


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                token=new Token();
                user=new User();



                String emailadd,passwordtext;

                emailadd=email.getText().toString().trim();
                passwordtext=password.getText().toString().trim();

//

                mAPIService.login(emailadd,passwordtext).enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        db.openCon();
                        token=response.body();
                        user=token.getUser();
                        result.setText(token.getToken()+"");
                        db.addToken(token.getToken().toString(),user.getEmail(),user.getFirstName(),user.getLastName());
//                        db.showTokens();
                        db.getLastToken();
                        db.closeCon();

                        System.out.println(user.getRoles().get(0).getPermissionSets().get(0).getName());
                        RetrofitClient.token=token.getToken().toString();
                        System.out.println("retrotoken:"+RetrofitClient.token);

                        Intent myIntent=new Intent(LoginOrRegisterActivity.this,MainActivity.class);
                        myIntent.putExtra("name",user.getFirstName());
                        myIntent.putExtra("surname",user.getLastName());
                        myIntent.putExtra("email",user.getEmail());
                        myIntent.putExtra("token",token.getToken());
                        LoginOrRegisterActivity.this.startActivity(myIntent);


                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"hata",Toast.LENGTH_LONG).show();

                    }
                });

            }
        });


        menuList=new ArrayList<>();
        variations=new ArrayList<>();



//        menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mAPIService=ApiUtils.getAPIServicewithAuth();
//                mAPIService.getMenu().enqueue(new Callback<List<com.example.ahmetserdargeze.ikasbreakfastproject.model.menu.Menu>>() {
//                    @Override
//                    public void onResponse(Call<List<com.example.ahmetserdargeze.ikasbreakfastproject.model.menu.Menu>> call, Response<List<com.example.ahmetserdargeze.ikasbreakfastproject.model.menu.Menu>> response) {
//                        for(int i=0;i<response.body().size();i++){
//                            System.out.println(response.body().get(i).getName());
//                           Toast.makeText(getApplicationContext(),"sadasd",Toast.LENGTH_LONG).show();
//
//                    }
//
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<com.example.ahmetserdargeze.ikasbreakfastproject.model.menu.Menu>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(),t.getCause().toString(),Toast.LENGTH_LONG).show();
//                        System.out.println(t.getCause().toString());
//
//                    }
//                });
//
//
//            }
//        });
    }
}
