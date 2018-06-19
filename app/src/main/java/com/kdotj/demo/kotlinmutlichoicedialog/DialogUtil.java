package com.kdotj.demo.kotlinmutlichoicedialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;

/**
 * Sample utility class wrapping all the functionality of the Dialog class
 * this provides a way to manage the theme of the dialog in one place as well
 * as all the types of dialogs you choose to display in the application.
 * <p>
 * NOTE: this is a subset of the options available from the Dialog#Builder
 */
public final class DialogUtil {
    private DialogUtil() {
    }

    /**
     * Dialog with multiple options but a single choice
     *
     * @param context          current context
     * @param title            dialog title
     * @param currentSelection dialog current selection
     * @param options          list of options
     * @param optionsListener  listener for when an option is selected
     * @return the AlertDialog
     */
    public static AlertDialog createSingleChoiceDialog(Context context, String title, int currentSelection,
                                                       CharSequence[] options,
                                                       DialogInterface.OnClickListener optionsListener) {

        return new AlertDialog.Builder(context, R.style.AppTheme_Dialog)
                .setTitle(title)
                .setSingleChoiceItems(options, currentSelection, optionsListener)
                .create();

    }

    /**
     * Dialog with one button a title and a message
     *
     * @param context            current context
     * @param title              dialog title
     * @param message            dialog message
     * @param positiveButtonText positive button text
     * @param positiveListener   positive button listener
     * @return the AlertDialog
     */
    public static AlertDialog createAlertDialogWithOneButton(Context context, String title, String message,
                                                             String positiveButtonText,
                                                             DialogInterface.OnClickListener positiveListener) {

        return new AlertDialog.Builder(context, R.style.AppTheme_Dialog)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonText, positiveListener)
                .create();

    }

    /**
     * Dialog with two buttons a title and a message
     *
     * @param context            current context
     * @param title              dialog title
     * @param message            dialog message
     * @param positiveButtonText positive button text
     * @param positiveListener   positive button listener
     * @param negativeButtonText negative button text
     * @param negativeListener   negative button listener
     * @return the AlertDialog
     */
    public static AlertDialog createAlertDialogWithTwoButtons(Context context, String title, String message,
                                                              String positiveButtonText,
                                                              DialogInterface.OnClickListener positiveListener,
                                                              String negativeButtonText,
                                                              DialogInterface.OnClickListener negativeListener) {

        return new AlertDialog.Builder(context, R.style.AppTheme_Dialog)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonText, positiveListener)
                .setNegativeButton(negativeButtonText, negativeListener)
                .create();
    }

    /**
     * Dialog with one button a title and a message that stores a preference
     *
     * @param context            current context
     * @param title              dialog title
     * @param message            dialog message
     * @return the AlertDialog
     */
    public static AlertDialog createTermsOfServiceDialog(final Context context, String title, String message) {

        return new AlertDialog.Builder(context, R.style.AppTheme_Dialog)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(context.getText(R.string.accept), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE);
                        sharedPreferences.edit().putBoolean("accepted_terms_of_service", true).apply();
                    }
                })
                .create();

    }
}
