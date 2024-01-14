package com.example.soapcountry.util;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import java.util.Objects;

public class AlertDialogMessage extends DialogFragment {

    private String message;
    private ClickOnDialog clickOnDialog;

    public AlertDialogMessage(String message, ClickOnDialog listener) {
        this.message = message;
        clickOnDialog = listener;
    }

    public AlertDialogMessage(String message) {
        this.message = message;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setCancelable(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setMessage(message).setTitle("Error")
                .setPositiveButton("Ok", (dialog, id) -> {
                    dialog.dismiss();
                    if (clickOnDialog != null) {
                        clickOnDialog.clickOnAcept();
                    }
                });
        return builder.create();
    }

    public interface ClickOnDialog {
        void clickOnAcept();
    }


}

