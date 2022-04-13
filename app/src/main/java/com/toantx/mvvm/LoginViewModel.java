package com.toantx.mvvm;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

public class LoginViewModel extends BaseObservable {
    private String email;
    private String password;

    public ObservableField<String> messageLogin = new ObservableField<>();
    public ObservableField<Boolean> isShowMessage = new ObservableField<>();

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void onClickLogin() {
        isShowMessage.set(true);
        User user = new User(getEmail(), getPassword());
        if (user.isValidEmail() && user.isValidPassword()) {
            messageLogin.set("Login successfully");
        } else {
            messageLogin.set("Please enter valid email/password");
        }
    }
}
