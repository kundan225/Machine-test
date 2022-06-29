package com.thebitsolutions.machinetest.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.thebitsolutions.machinetest.MainActivity;
import com.thebitsolutions.machinetest.R;
import com.thebitsolutions.machinetest.databinding.FragmentSignUpBinding;


public class SignUpFragment extends Fragment {
   FragmentSignUpBinding binding;
    private FirebaseAuth mAuth;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        FirebaseApp.initializeApp(getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentSignUpBinding.inflate(inflater, container, false);
          binding.register.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  String email=binding.email.getText().toString();
                  String pass=binding.password.getText().toString();
                  if (email.isEmpty()){
                      binding.email.requestFocus();
                      binding.email.setError("Please Enter Email");
                  }
                  if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                      binding.email.requestFocus();
                      binding.email.setError("Please Enter Valid Email");
                      return;
                  }
                  if (pass.isEmpty()){
                      binding.email.requestFocus();
                      binding.email.setError("Please Enter Password");
                  }
                  mAuth.createUserWithEmailAndPassword(email, pass)
                          .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                              @Override
                              public void onComplete(@NonNull Task<AuthResult> task) {
                                  if (task.isSuccessful()) {
                                      Toast.makeText(getContext(), "Register Successfully", Toast.LENGTH_SHORT).show();
                                      startActivity(new Intent(getContext(), MainActivity.class));

                                  } else {
                                      Toast.makeText(getContext(), "Register Failed", Toast.LENGTH_SHORT).show();

                                  }
                              }
                          });
              }
          });
        return binding.getRoot();
    }

}