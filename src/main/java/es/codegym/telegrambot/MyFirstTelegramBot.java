package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    // https://core.telegram.org/bots/api link acceso a chat
    public static final String NAME = "chatbetamcbot";
    public static final String TOKEN = "6636133454:AAETWHTx39ehMvYeyOK6lPLz2XuMwOt7F7s";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí

        if (getMessageText().equals("/start")) {
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera", "step_1_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Tomar una salchicha! + 20 de fama","step_2_btn",
                            "Tomar un pescado! + 20 de fama", "step_2_btn",
                    "Tirar una de pepinillos! + 20 de fama","step_2_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_2_tbn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("hackear al robot aspiradora + 20 de fama","step_3_tbn"));
        }
        if(getCallbackQueryButtonKey().equals("step_3_btn")){
            setUserGlory(30);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robot por algo de comer + 30 de fama","step_4_btn",
                            "Dar un paseo con el robot + 30 de fama ","step_4_btn",
                            "Salir de ahí + 30 de fama","step_4_btn"
                            ));
        }
        if(getCallbackQueryButtonKey().equals("step_4_btn")) {
            setUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Grabaras un stremer + 30 de fama","step_5_btn",
                            "Grabaras al robot + 30 de fama","step_5_btn",
                            "Grabaras por la ventana + 30 de fama","step_5_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_5_btn")) {
            setUserGlory(40);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Has realizado una excelente grabación", "step_6_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_6_btn")) {
            setUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Hackear la contraseña de la computadora", "step_7_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_7_btn")) {
            setUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("¡Has superado la computadora! ¡Ganas +50 de fama!", "step_8_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_8_btn")) {
            setUserGlory(50);
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT,
                    Map.of("El día no pasó en vano: el gato hacker tomó medidas y " +
                            "ganó el respeto de los gatos callejeros locales.", "step_9_btn"));
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}