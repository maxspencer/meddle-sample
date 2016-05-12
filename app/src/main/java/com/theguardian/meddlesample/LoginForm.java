package com.theguardian.meddlesample;

import com.theguardian.meddle.Form;
import com.theguardian.meddle.fields.BooleanField;
import com.theguardian.meddle.fields.EmailField;
import com.theguardian.meddle.fields.TextField;

/**
 * Created by max on 24/03/16.
 */
public class LoginForm extends Form {

    public final EmailField email;
    public final TextField password;
    public final BooleanField rememberMe;

    public LoginForm() {
        email = addField(new EmailField(true));
        password = addField(new TextField(true, 8));
        rememberMe = addField(new BooleanField(false));
    }

}
