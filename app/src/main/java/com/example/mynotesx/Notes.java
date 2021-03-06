package com.example.mynotesx;

import androidx.annotation.StringRes;

public class Notes {

    private String nameNote;
    private String dateNote;
    private String textNote;

    public static Notes[] notes = {
            new Notes("Рязань", "Март 2021", "Поездка на 3 дня"),
            new Notes("Калининград", "Апрель 2021", "Поездка на 10 дней"),
            new Notes("Волгоград", "Август 2021", "Поездка на 3 дня"),
    };


    public Notes(String nameNote, String dateNote, String textNote) {
        this.nameNote = nameNote;
        this.dateNote = dateNote;
        this.textNote = textNote;
    }

    public String getNameNote() {
        return nameNote;
    }

    public String getDateNote() {
        return dateNote;
    }

    public String getTextNote() {
        return textNote;
    }

    public String toString() {
        return this.nameNote;
    }
}
