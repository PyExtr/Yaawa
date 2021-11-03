package com.example.yaawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.content.ClipboardManager;
import android.widget.Toast;

import com.vanniktech.emoji.EmojiPopup;
import com.vanniktech.emoji.EmojiTextView;
import com.vanniktech.emoji.emoji.Emoji;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    ImageView btEmoji,btSend;
    EditText etEmoji;
    LinearLayout linearLayout;
    int[] unicode = {0x1F40C, 0x1F44B, 0x2665};
    int[] unicode2 = {0x2665, 0x1F93C};
    int[] unicode3 = {0x1F609, 0x1F60D,0x1F63B,0x1F9E1,0x1F525,0x1F618,0x1F389,0x1F4A6,0x1F996,0x1F422
            ,0x1F427,0x1F43F,0x1F31A,0x1F31D,0x2764,0x1F4A6,0x1F596,0x1F443,0x1F937	};
    int[] unicodex = {0x1F31A,0x1F31D};
    String layla = "לילה טובו";
//    ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
//    ClipData clip = ClipData.newPlainText("label", "Text to copy");
//    clipboard.setPrimaryClip(clip);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variable
//        btEmoji = findViewById(R.id.bt_emoji);
        btSend = findViewById(R.id.bt_send);
        etEmoji = findViewById(R.id.et_emoji);
        linearLayout = findViewById(R.id.linear_layout);

        //Initialize emoji popup
        EmojiPopup popup = EmojiPopup.Builder.fromRootView(
                findViewById(R.id.root_view)
        ).build(etEmoji);

        //adding all the emojis to layla
        for (int i = 0; i < unicode.length; i++) {
            layla += getEmoji(unicode[i]);
        }


        btSend.setOnClickListener(view -> {
            String temp = etEmoji.getText().toString();
            int ran = 0;
            //toast pop up
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "תרשמי משהו, יפה שכמותך", Toast.LENGTH_SHORT);
            if (temp.isEmpty()) {
                toast.show();
            } else {
                int lenTemp = Integer.parseInt(temp);
                if (lenTemp == 608|lenTemp == 411|lenTemp == 6081998|lenTemp == 60898|
                        lenTemp == 41100|lenTemp == 4112000) {
                    EmojiTextView emojiTextView = (EmojiTextView) LayoutInflater.from(view.getContext())
                            .inflate(R.layout.emoji_text_view, linearLayout, false);
                    layla = "מזל'ט טוב טוב טוב בראיות אושר ועושר והושר";
                    copy(layla);
                    toast = Toast.makeText(context, "יא איזה תאריך יפה", Toast.LENGTH_SHORT);
                    toast.show();
                    emojiTextView.setText(layla);
                    linearLayout.addView(emojiTextView);
                    //Clear  edit text value
                    etEmoji.getText().clear();
                    layla = "לילה טובו";
                    for (int i = 0; i < unicode.length; i++) {
                        layla = layla + getEmoji(unicode[i]);
                    }
                } else if (lenTemp >= 1000) {
                    toast = Toast.makeText(context, "המספר גדול מדי בדיוק כמו המצחיק של דימה", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    EmojiTextView emojiTextView = (EmojiTextView) LayoutInflater.from(view.getContext())
                            .inflate(R.layout.emoji_text_view, linearLayout, false);
                    //Set text on emoji text view
                    //69
                    if (lenTemp == 69) {
                        for (int i = 0; i < lenTemp; i++) {
                            ran = ThreadLocalRandom.current().nextInt(0, 30);
                            if (ran <= 23) {
                                layla += getEmoji(unicode2[1]);
                            } else if (ran >= 24) {
                                layla += getEmoji(unicode2[0]);
                            } else if (ran == 25) {
                                layla += getEmoji(unicodex[0]);
                                layla += getEmoji(unicodex[1]);
                            } else if (ran == 26) {
                                layla += getEmoji(unicodex[0]);
                                layla += getEmoji(unicodex[1]);
                            } else {
                                layla += getEmoji(unicode3[ThreadLocalRandom.current().nextInt(0, unicode3.length)]);
                            }
                        }
                        toast = Toast.makeText(context, "שובבה ;)", Toast.LENGTH_SHORT);
                        toast.show();
                        copy(layla);
                    }
                    //42
                    else if (lenTemp == 42) {
                        layla = getEmoji(0x1F3B5) + "איך אפשר שלא להתאהב בך" + getEmoji(0x1F3B5);
                        toast = Toast.makeText(context, "תשובה להכל", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    //21
                    else if (lenTemp == 21) {
                        layla = getEmoji(0x2764) + "היי תראי את בת 21, מזל טוב ילדה יפה שכמותך" + getEmoji(0x2764);
                        toast = Toast.makeText(context, "את חוקית בארצות הברית קולולולו", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    //23
                    else if (lenTemp == 23) {
                        layla = getEmoji(0x2764) + "היי תראי את בת 23, מזל טוב ילדה יפ.. רגע רגע, זה הגיל של דימה, מה נראה לו שהוא דוחף לכאן את הגיל שלו למתנה של היום הולדת שלך, תני לו גם על זה כאפה ממני" + getEmoji(0x2764);
                        toast = Toast.makeText(context, "את חוקית בארצות הברית קולולולו", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    //0
                    else if (lenTemp == 0) {
                        layla = "מה 0, אין מצב שהמצב רוח שלך הוא 0, תני לי לשמח אותך בשיר : בכל יום אתה פוגש חבר, דומה לך בקצת אחר , כל אחד הוא מיוחד, אז שים לב היי היי איזה יום נפלא היום, לשחק וגם לחלום, יום נפלא להיות עם מצב רוח טוב (ולא 0) - כתבתי לבד נודר";
                        toast = Toast.makeText(context, "תתני לדימה כאפה ממני, מגיע לו על זה שהמצב רוח שלך הוא 0", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    //96
                    else if (lenTemp == 96) {
                        for (int i = 0; i < lenTemp; i++) {
                            ran = ThreadLocalRandom.current().nextInt(0, 30);
                            if (ran <= 23) {
                                layla += getEmoji(unicode2[ThreadLocalRandom.current().nextInt(0, 2)]);
                            } else if (ran == 24) {
                                layla += getEmoji(unicodex[0]);
                                layla += getEmoji(unicodex[1]);
                            } else {
                                layla += getEmoji(unicode3[ThreadLocalRandom.current().nextInt(0, unicode3.length)]);
                            }
                        }
                        toast = Toast.makeText(context, "המספר המצחיק רק הפוך חח", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    //else
                    else {
                        for (int i = 0; i < lenTemp; i++) {
                            ran = ThreadLocalRandom.current().nextInt(0, 30);
                            if (ran <= 23) {
                                layla += getEmoji(unicode2[ThreadLocalRandom.current().nextInt(0, 2)]);
                            } else if (ran == 24) {
                                layla += getEmoji(unicodex[0]);
                                layla += getEmoji(unicodex[1]);
                            } else {
                                layla += getEmoji(unicode3[ThreadLocalRandom.current().nextInt(0, unicode3.length)]);
                            }
                        }
                        toast = Toast.makeText(context, "התוצאה הועתקה", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    copy(layla);
                    emojiTextView.setText(layla);
                    linearLayout.addView(emojiTextView);
                    //Clear  edit text value
                    etEmoji.getText().clear();
                    layla = "לילה טובו";
                    for (int i = 0; i < unicode.length; i++) {
                        layla = layla + getEmoji(unicode[i]);
                    }
                }
            }
        });
    }
    public String getEmoji(int uni)
    {
        return new String(Character.toChars(uni));
    }
    public void copy(String text){
        ClipboardManager clipboard = (ClipboardManager)
                getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("simple text", text);
        clipboard.setPrimaryClip(clip);
    }
}