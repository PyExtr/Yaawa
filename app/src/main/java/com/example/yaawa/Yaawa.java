package com.example.yaawa;

import android.app.Application;

import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.google.GoogleEmojiProvider;

public class Yaawa extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //Install emoji manager
        EmojiManager.install(new GoogleEmojiProvider());
    }
}
