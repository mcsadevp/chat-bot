package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

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

        sendTextMessageAsync("¡ Hola ! \uD83D\uDC4B como estas ? \uD83D\uDE04 en que te puedo ayudar hoy \uD83E\uDD14 ? " );

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}