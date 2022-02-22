package com.company;

import java.awt.*;

public class ListFonts {
    public void getFonts(){
        String fonts[] =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for (int i = 0; i < fonts.length; i++) {
            System.out.println(fonts[i]);
        }

    }

}
