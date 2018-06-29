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


    private APIService mAPIService;


    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=(EditText) findViewById(R.id.email_etv);
        password=(EditText) findViewById(R.id.password_etv);

        login=(Button) findViewById(R.id.login_bt);


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
//                emailadd="assignment@ikas.com";
//                passwordtext="user_1234*";

//

                mAPIService.login(emailadd,passwordtext).enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        db.openCon();
                        if (response.isSuccessful()){
                            token=response.body();
                            user=token.getUser();

                            db.addToken(token.getToken().toString(),user.getEmail(),user.getFirstName(),user.getLastName());
//                        db.showTokens();
                            db.getLastToken();
                            db.closeCon();

                            System.out.println(user.getRoles().get(0).getPermissionSets().get(0).getName());
                            RetrofitClient.token=token.getToken().toString();
                            Intent myIntent=new Intent(LoginOrRegisterActivity.this,MainActivity.class);
                            myIntent.putExtra("name",user.getFirstName());
                            myIntent.putExtra("surname",user.getLastName());
                            myIntent.putExtra("email",user.getEmail());
                            myIntent.putExtra("token",token.getToken());
                            LoginOrRegisterActivity.this.startActivity(myIntent);
                            Toast.makeText(getApplicationContext(),"SUCCESFULL",Toast.LENGTH_LONG).show();

                        }else {
                            Toast.makeText(getApplicationContext(),"WRONG PASSWORD OR EMAİL",Toast.LENGTH_LONG).show();

                        }




                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"hata",Toast.LENGTH_LONG).show();

                    }
                });

            }
        });




    }
}
